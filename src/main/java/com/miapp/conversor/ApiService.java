package com.miapp.conversor;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiService {

    public static String obtenerTasaCambio(String base, String destino) throws Exception {
        String apiUrl = "https://api.exchangerate-api.com/v4/latest/" + base;
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
        return response.toString();
    }
}
