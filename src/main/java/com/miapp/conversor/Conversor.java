package com.miapp.conversor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Conversor {

    public static double convertir(String base, String destino, double cantidad) {
        try {
            String apiUrl = "https://v6.exchangerate-api.com/v6/8b42af86f71f6469b518c44b/latest/" + base;
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder response = new StringBuilder();
            String linea;

            while ((linea = reader.readLine()) != null) {
                response.append(linea);
            }

            reader.close();

            JsonObject jsonObject = JsonParser.parseString(response.toString()).getAsJsonObject();

            if (jsonObject.get("result").getAsString().equals("success")) {
                JsonObject tasas = jsonObject.getAsJsonObject("conversion_rates");
                double tasa = tasas.get(destino).getAsDouble();
                return cantidad * tasa;
            } else {
                System.out.println("Error al obtener la tasa de cambio desde la API.");
                return 0;
            }

        } catch (Exception e) {
            System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
            return 0;
        }
    }
}
