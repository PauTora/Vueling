package com.example.vuelings;

import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnHome, btnTickets, btnFAQ, btnMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Cargar el fragmento por defecto
        loadFragment(new HomeFragment(), false); // Al iniciar carga HomeFragment

        // Vincular botones
        btnHome = findViewById(R.id.btnHome);
        btnTickets = findViewById(R.id.btnTickets);
        btnFAQ = findViewById(R.id.btnFAQ);
        btnMap = findViewById(R.id.btnMap);

        // Listeners de los botones
        btnHome.setOnClickListener(v -> loadFragment(new HomeFragment(), false)); // Cargar HomeFragment
        btnTickets.setOnClickListener(v -> loadFragment(new TicketsFragment(), true)); // Cargar TicketsFragment
        btnFAQ.setOnClickListener(v -> loadFragment(new FAQFragment(), true)); // Cargar FAQFragment
        btnMap.setOnClickListener(v -> loadFragment(new MapFragment(), true)); // Cargar MapFragment
    }

    private void loadFragment(Fragment fragment, boolean addToBackstack) {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment);

        if (addToBackstack) {
            transaction.addToBackStack(null);
        }

        transaction.commit();
    }
}
