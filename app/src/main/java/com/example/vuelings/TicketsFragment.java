package com.example.vuelings;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class TicketsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tickets, container, false);

        // Botón de retroceso para volver a HomeFragment
        ImageButton btnBack = view.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager().popBackStack(); // Retrocede al fragment anterior
        });

        RecyclerView recycler = view.findViewById(R.id.recyclerVuelos);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        String json = JsonUtils.leerJSON(getContext(), "vuelos.json");
        if (json == null) {
            return view;
        }

        try {
            List<Vuelo> vuelos = new Gson().fromJson(json, new TypeToken<List<Vuelo>>() {}.getType());

            VueloAdapter adapter = new VueloAdapter(vuelos, vuelo -> {
                Bundle args = new Bundle();
                args.putString("origen", vuelo.getOrigen());
                args.putString("destino", vuelo.getDestino());
                args.putString("numero", vuelo.getNumeroVuelo());
                args.putString("fecha", vuelo.getFecha());
                args.putString("hora", vuelo.getHora());
                args.putString("puerta", vuelo.getPuerta());
                args.putString("asiento", vuelo.getAsiento());
                args.putString("tipo", vuelo.getTipoBillete());
                args.putString("pasajero", vuelo.getNombrePasajero());

                TicketDetailFragment detalle = new TicketDetailFragment();
                detalle.setArguments(args);

                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, detalle)
                        .addToBackStack(null) // Agrega el fragment a la pila de retroceso
                        .commit();
            });

            recycler.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "Error al procesar vuelos", Toast.LENGTH_SHORT).show();
        }

        return view;
    }
}
