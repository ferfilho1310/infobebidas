package com.example.mostratodasbebidas.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mostratodasbebidas.Activity.DetalhesBebida;
import com.example.mostratodasbebidas.Model.Bebida;
import com.example.mostratodasbebidas.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class BebidaListAdapter extends RecyclerView.Adapter<BebidaListAdapter.BebidaViewHolder> implements Filterable {

    List<Bebida> listBebidas;
    List<Bebida> listaDeTodasBebidas;
    Context context;

    public BebidaListAdapter(Context context) {
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

        holder.cardBebidas.setOnClickListener(v -> {
            Intent ibebidas = new Intent(context, DetalhesBebida.class);
            ibebidas.putExtra("bebida", bebida);
            context.startActivity(ibebidas);
        });
    }

    @Override
    public int getItemCount() {
        return listBebidas != null ? listBebidas.size() : 0;
    }

    public void adicionarBebidasLista(List<Bebida> lsBebidas) {
        listBebidas.addAll(lsBebidas);
        listaDeTodasBebidas = new ArrayList<>(lsBebidas);
        notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {
        return filtroBebidas;
    }

    private Filter filtroBebidas = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Bebida> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(listaDeTodasBebidas);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Bebida itemBebida : listaDeTodasBebidas) {
                    if (itemBebida.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(itemBebida);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            listBebidas.clear();
            listBebidas.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public class BebidaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgBebida;
        private TextView txtNomeBebida;
        private TextView txtTeorAlcoolicoBebida;
        private CardView cardBebidas;

        public BebidaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBebida = itemView.findViewById(R.id.img_Bebida);
            txtNomeBebida = itemView.findViewById(R.id.txt_nome);
            txtTeorAlcoolicoBebida = itemView.findViewById(R.id.txt_teor_alcoolico);
            cardBebidas = itemView.findViewById(R.id.card_Bebidas);

        }
    }
}
