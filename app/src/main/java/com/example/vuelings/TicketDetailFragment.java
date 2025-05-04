package com.example.vuelings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TicketDetailFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ticket_detail, container, false);
        Bundle args = getArguments();

        if (args != null) {
            ImageButton btnBack = view.findViewById(R.id.btnBack);
            btnBack.setOnClickListener(v -> requireActivity().getSupportFragmentManager().popBackStack()); // Retrocede a TicketsFragment

            String origen = args.getString("origen");
            String destino = args.getString("destino");

            ((TextView) view.findViewById(R.id.textTituloVuelo)).setText(origen + " - " + destino);
            ((TextView) view.findViewById(R.id.textVuelo)).setText("Flight: " + args.getString("numero"));
            ((TextView) view.findViewById(R.id.textFecha)).setText("Date: " + args.getString("fecha"));
            ((TextView) view.findViewById(R.id.textHora)).setText("Time: " + args.getString("hora"));
            ((TextView) view.findViewById(R.id.textPuerta)).setText("Gate: " + args.getString("puerta"));
            ((TextView) view.findViewById(R.id.textAsiento)).setText("Seat: " + args.getString("asiento"));
            ((TextView) view.findViewById(R.id.textTipo)).setText("Ticket: " + args.getString("tipo"));
            ((TextView) view.findViewById(R.id.textPasajero)).setText("Passenger: " + args.getString("pasajero"));
        }

        return view;
    }
}
