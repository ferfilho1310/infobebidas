package com.example.mostratodasbebidas.Dao;

import com.example.mostratodasbebidas.Model.Bebida;
import com.example.mostratodasbebidas.Retrofit.IBebidasService;
import com.example.mostratodasbebidas.Retrofit.InitRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestDaoBebidas implements IRequestDaoBebidas {

    List<Bebida> lsBebidas;

    @Override
    public List<Bebida> obterListaBebidas() {

        StringBuilder sbUrl = new StringBuilder();
        sbUrl.append(InitRetrofit.URL_PADRAO)
                .append(InitRetrofit.END_POINT);

        IBebidasService iBebidasService = InitRetrofit.init().create(IBebidasService.class);
        Call<List<Bebida>> callListBebidas = iBebidasService.getBebidas(sbUrl.toString());

        callListBebidas.enqueue(new Callback<List<Bebida>>() {
            @Override
            public void onResponse(Call<List<Bebida>> call, Response<List<Bebida>> response) {
                lsBebidas.addAll(response.body());
            }

            @Override
            public void onFailure(Call<List<Bebida>> call, Throwable t) {

            }
        });
        return lsBebidas;
    }
}
