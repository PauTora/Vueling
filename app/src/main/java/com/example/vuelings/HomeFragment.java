package com.example.vuelings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ((ImageView) view.findViewById(R.id.logoVueling)).setImageResource(R.drawable.vueling);
        ((TextView) view.findViewById(R.id.textoInfo)).setText(
                "This mode will give you all the indispensable information during this situation."
        );

        ImageButton btnExit = view.findViewById(R.id.btnExitBlackout);
        btnExit.setImageResource(R.drawable.backpanel);
        btnExit.setOnClickListener(v -> Toast.makeText(getContext(), "Exiting BLACKOUT mode", Toast.LENGTH_SHORT).show());

        return view;
    }
}
