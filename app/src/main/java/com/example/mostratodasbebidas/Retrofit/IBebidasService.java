package com.example.mostratodasbebidas.Retrofit;

import com.example.mostratodasbebidas.Model.Bebida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface IBebidasService {

    @GET()
    Call<List<Bebida>> getBebidas(@Url String urlPunk);

}
