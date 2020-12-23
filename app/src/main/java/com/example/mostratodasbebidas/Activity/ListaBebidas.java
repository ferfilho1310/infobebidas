package com.example.mostratodasbebidas.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;

import com.example.mostratodasbebidas.Adapter.BebidaListAdapter;
import com.example.mostratodasbebidas.Model.Bebida;
import com.example.mostratodasbebidas.R;
import com.example.mostratodasbebidas.Retrofit.IBebidasService;
import com.example.mostratodasbebidas.Retrofit.InitRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaBebidas extends AppCompatActivity {

    private RecyclerView rcBebidas;
    private GridLayoutManager llmBebidas;
    private BebidaListAdapter bebidaListAdapter;
    private ProgressBar pgrBebidas;
    private SearchView schListaBebidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_bebidas);

        rcBebidas = findViewById(R.id.rc_mostra_bebidas);
        pgrBebidas = findViewById(R.id.prg_bebida);
        schListaBebidas = findViewById(R.id.sch_bebidas);

        llmBebidas = new GridLayoutManager(this, 2);
        bebidaListAdapter = new BebidaListAdapter(this);
        rcBebidas.setAdapter(bebidaListAdapter);
        rcBebidas.setHasFixedSize(true);
        rcBebidas.setLayoutManager(llmBebidas);
        rcBebidas.setItemAnimator(new DefaultItemAnimator());
        pgrBebidas.setVisibility(View.VISIBLE);

        obterListaBebidas();
        buscaBebidas();
    }

    private void obterListaBebidas() {
        StringBuilder stbUrl = new StringBuilder();
        stbUrl.append(InitRetrofit.URL_PADRAO)
                .append(InitRetrofit.END_POINT);

        IBebidasService iBebidasService = InitRetrofit.init().create(IBebidasService.class);
        Call<List<Bebida>> callLsBebidas = iBebidasService.getBebidas(stbUrl.toString());

        callLsBebidas.enqueue(new Callback<List<Bebida>>() {
            @Override
            public void onResponse(Call<List<Bebida>> call, Response<List<Bebida>> response) {
                if (response.isSuccessful()) {
                    pgrBebidas.setVisibility(View.GONE);
                    List<Bebida> lsBebidas = response.body();
                    bebidaListAdapter.adicionarBebidasLista(lsBebidas);
                }
            }

            @Override
            public void onFailure(Call<List<Bebida>> call, Throwable t) {
                pgrBebidas.setVisibility(View.GONE);
            }
        });
    }

    private void buscaBebidas(){
        schListaBebidas.setIconifiedByDefault(false);
        schListaBebidas.setQueryHint("Digite o nome da Bebida");
        schListaBebidas.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String nomeCerveja) {
                bebidaListAdapter.getFilter().filter(nomeCerveja);
                return false;
            }
        });
    }

}