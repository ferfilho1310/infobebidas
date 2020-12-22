package com.example.mostratodasbebidas.Controller;

import com.example.mostratodasbebidas.Dao.IRequestDaoBebidas;
import com.example.mostratodasbebidas.Dao.RequestDaoBebidas;
import com.example.mostratodasbebidas.Model.Bebida;

import java.util.List;

public class RequestBebidasController implements IBebidaController {

    private static RequestBebidasController requestBebidasController;
    private static IRequestDaoBebidas iRequestDaoBebidas;


    public synchronized static RequestBebidasController getInstance(){
        if(requestBebidasController == null){
            requestBebidasController = new RequestBebidasController();
        }
        iRequestDaoBebidas = new RequestDaoBebidas();
        return requestBebidasController;
    }

    @Override
    public List<Bebida> getListBebidas() {
        return iRequestDaoBebidas.obterListaBebidas();
    }
}
