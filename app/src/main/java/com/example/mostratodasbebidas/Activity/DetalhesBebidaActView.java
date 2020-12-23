package com.example.mostratodasbebidas.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mostratodasbebidas.Model.Bebida;
import com.example.mostratodasbebidas.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

public class DetalhesBebidaActView extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgBebidaDetalhes;
    private TextView txtNomeCervejaBebida;
    private TextView txtTagLine;
    private TextView txtTeorAlcoolico;
    private TextView txtEscalaDeAmargor;
    private TextView txtDescricao;
    private FloatingActionButton fabVoltarListaBebidas;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_bebida);

        imgBebidaDetalhes = findViewById(R.id.img_detalhes_bebidas);
        txtNomeCervejaBebida = findViewById(R.id.txt_nome_cerveja);
        txtTagLine = findViewById(R.id.txt_tagline);
        txtTeorAlcoolico = findViewById(R.id.txt_teor_alcoolico_detalhes);
        txtEscalaDeAmargor = findViewById(R.id.txt_escala_amargor);
        txtDescricao = findViewById(R.id.txt_descricao);
        fabVoltarListaBebidas = findViewById(R.id.fab_back);

        Bebida bedidaDetalhes = getIntent().getExtras().getParcelable("bebida");

        if (bedidaDetalhes != null) {
            Picasso.get()
                    .load(bedidaDetalhes.getImageUrl())
                    .resize(200, 500)
                    .noFade()
                    .into(imgBebidaDetalhes);

            txtNomeCervejaBebida.setText(bedidaDetalhes.getName());
            txtTagLine.setText(bedidaDetalhes.getTagline());
            txtTeorAlcoolico.setText(String.valueOf(bedidaDetalhes.getAbv()));
            txtEscalaDeAmargor.setText(String.valueOf(bedidaDetalhes.getIbu()));
            txtDescricao.setText(bedidaDetalhes.getDescription());
        }

        fabVoltarListaBebidas.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_back:
                voltarParaListaBebidas();
                break;
            default:
                break;
        }
    }

    private void voltarParaListaBebidas() {
        Intent backListaBebidas = new Intent(DetalhesBebidaActView.this, ListaBebidasActView.class);
        startActivity(backListaBebidas);
    }
}