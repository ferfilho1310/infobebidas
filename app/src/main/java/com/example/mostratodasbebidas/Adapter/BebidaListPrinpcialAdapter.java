package com.example.mostratodasbebidas.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mostratodasbebidas.Model.Bebida;
import com.example.mostratodasbebidas.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class BebidaListPrinpcialAdapter extends RecyclerView.Adapter<BebidaListPrinpcialAdapter.BebidaViewHolder> {

    List<Bebida> listBebidas;
    List<Bebida> listBebidasCompleto;
    Context context;

    public BebidaListPrinpcialAdapter(Context context) {
        this.listBebidas = new ArrayList<>();
        this.context = context;
    }

    @NonNull
    @Override
    public BebidaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bebida_item, parent, false);
        return new BebidaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BebidaViewHolder holder, int position) {

        Bebida bebida = listBebidas.get(position);

        holder.txtNomeBebida.setText(bebida.getName());
        holder.txtTeorAlcoolicoBebida.setText(String.valueOf(bebida.getAbv()));

        Picasso.get()
                .load(bebida.getImageUrl())
                .resize(200, 500)
                .into(holder.imgBebida);
    }

    @Override
    public int getItemCount() {
        return listBebidas != null ? listBebidas.size() : 0;
    }

    public void adicionarBebidasLista(List<Bebida> lsBebidas) {
        listBebidas.addAll(lsBebidas);
        listBebidasCompleto = new ArrayList<>(lsBebidas);
        notifyDataSetChanged();
    }

    public static class BebidaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgBebida;
        private TextView txtNomeBebida;
        private TextView txtTeorAlcoolicoBebida;

        public BebidaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBebida = itemView.findViewById(R.id.img_Bebida);
            txtNomeBebida = itemView.findViewById(R.id.txt_nome);
            txtTeorAlcoolicoBebida = itemView.findViewById(R.id.txt_teor_alcoolico);
        }
    }
}
