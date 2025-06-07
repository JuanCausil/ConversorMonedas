package com.miapp.conversor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Conversor de Monedas");
        System.out.print("Moneda base (ej. USD): ");
        String base = scanner.nextLine().toUpperCase();

        System.out.print("Moneda destino (ej. COP): ");
        String destino = scanner.nextLine().toUpperCase();

        System.out.print("Cantidad a convertir: ");
        double cantidad = scanner.nextDouble();

        double resultado = Conversor.convertir(base, destino, cantidad);
        System.out.printf("Resultado: %.2f %s = %.2f %s%n", cantidad, base, resultado, destino);
    }
}
