package com.example.vuelings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.chrisbanes.photoview.PhotoView;

public class MapFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_map, container, false);

        // Botón de retroceso
        ImageButton btnBack = view.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v ->
                requireActivity().getSupportFragmentManager().popBackStack()
        );

        // Mapa
        PhotoView imgMapa = view.findViewById(R.id.imgMapa);
        imgMapa.post(() -> {
            imgMapa.setScale(1.3f, true);
        });

        return view;
    }
}
