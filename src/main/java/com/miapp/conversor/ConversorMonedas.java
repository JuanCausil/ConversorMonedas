package com.miapp.conversor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ConversorMonedas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Conversor de Monedas ===");
        System.out.print("Moneda base (por ej. USD): ");
        String monedaBase = scanner.nextLine().toUpperCase();

        System.out.print("Moneda destino (por ej. COP): ");
        String monedaDestino = scanner.nextLine().toUpperCase();

        System.out.print("Cantidad a convertir: ");
        double cantidad = scanner.nextDouble();

        try {
            String apiKey = "8b42af86f71f6469b518c44b";
            String urlStr = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + monedaBase;

            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            Reader reader = new InputStreamReader(conn.getInputStream());
            JsonObject json = JsonParser.parseReader(reader).getAsJsonObject();

            if (json.get("result").getAsString().equals("success")) {
                JsonObject rates = json.getAsJsonObject("conversion_rates");
                double tasa = rates.get(monedaDestino).getAsDouble();
                double resultado = cantidad * tasa;

                System.out.println("=======================================");
                System.out.printf("%.2f %s = %.2f %s\n", cantidad, monedaBase, resultado, monedaDestino);
                System.out.println("Tasa actual: " + tasa);
                System.out.println("=======================================");
            } else {
                System.out.println("Error al obtener tasas de cambio.");
            }

            conn.disconnect();
        } catch (Exception e) {
            System.out.println("Error al conectarse a la API: " + e.getMessage());
        }

        scanner.close();
    }
}
