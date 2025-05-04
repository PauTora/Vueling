package com.example.vuelings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.vuelings.Vuelo;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;


public class VueloAdapter extends RecyclerView.Adapter<VueloAdapter.VueloViewHolder> {

    public interface OnVueloClickListener {
        void onVueloClick(Vuelo vuelo);
    }

    private List<Vuelo> listaVuelos;
    private OnVueloClickListener listener;

    public VueloAdapter(List<Vuelo> listaVuelos, OnVueloClickListener listener) {
        this.listaVuelos = listaVuelos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public VueloViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vuelo, parent, false);
        return new VueloViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull VueloViewHolder holder, int position) {
        Vuelo vuelo = listaVuelos.get(position);
        holder.textVuelo.setText(vuelo.getOrigen() + " - " + vuelo.getDestino());
        holder.itemView.setOnClickListener(v -> listener.onVueloClick(vuelo));
    }

    @Override
    public int getItemCount() {
        return listaVuelos.size();
    }

    static class VueloViewHolder extends RecyclerView.ViewHolder {
        TextView textVuelo;

        public VueloViewHolder(@NonNull View itemView) {
            super(itemView);
            textVuelo = itemView.findViewById(R.id.textVuelo);
        }
    }
}
