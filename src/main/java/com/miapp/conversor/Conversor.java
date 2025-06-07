package com.miapp.conversor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Conversor {

    public static double convertir(String base, String destino, double cantidad) {
        try {
            String json = ApiService.obtenerTasaCambio(base, destino);
            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
            JsonObject tasas = jsonObject.getAsJsonObject("rates");

            double tasa = tasas.get(destino).getAsDouble();
            return cantidad * tasa;

        } catch (Exception e) {
            System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
            return 0;
        }
    }
}
