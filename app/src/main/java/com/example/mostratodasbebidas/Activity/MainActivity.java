package com.example.mostratodasbebidas.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import com.example.mostratodasbebidas.Adapter.BebidaListPrinpcialAdapter;
import com.example.mostratodasbebidas.Controller.RequestBebidasController;
import com.example.mostratodasbebidas.Model.Bebida;
import com.example.mostratodasbebidas.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcBebidas;
    private GridLayoutManager llmBebidas;
    private BebidaListPrinpcialAdapter bebidaListPrinpcialAdapter;
    private ProgressBar pgrBebidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcBebidas = findViewById(R.id.rc_mostra_bebidas);
        pgrBebidas = findViewById(R.id.prg_bebida);

        llmBebidas = new GridLayoutManager(this, 2);
        bebidaListPrinpcialAdapter = new BebidaListPrinpcialAdapter(this);
        rcBebidas.setAdapter(bebidaListPrinpcialAdapter);
        rcBebidas.setHasFixedSize(true);
        rcBebidas.setLayoutManager(llmBebidas);
        rcBebidas.setItemAnimator(new DefaultItemAnimator());

        List<Bebida> lsBebidas = RequestBebidasController.getInstance().getListBebidas();
        Log.i("Fernando",String.format("Bebidas: %s",lsBebidas));

    }
}