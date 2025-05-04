package com.example.vuelings;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class DataProvider {
    public static List<Vuelo> cargarVuelos(Context context) {
        try {
            InputStream is = context.getAssets().open("vuelos.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, StandardCharsets.UTF_8);

            Gson gson = new Gson();
            Type listType = new TypeToken<List<Vuelo>>() {}.getType();
            return gson.fromJson(json, listType);

        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
