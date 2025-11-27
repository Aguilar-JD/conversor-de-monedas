package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultarMoneda consulta = new ConsultarMoneda();

        int opcion = 0;
        while (opcion != 7) {
            System.out.println("*************************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Dólar => Real brasileño");
            System.out.println("4) Real brasileño => Dólar");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dólar");
            System.out.println("7) Salir");
            System.out.println("Elija una opción válida:");
            System.out.println("*************************************************");

            opcion = lectura.nextInt();

            if (opcion == 7) {
                System.out.println("Cerrando programa...");
                break;
            }

            String base = "";
            String target = "";

            switch (opcion) {
                case 1:
                    base = "USD";
                    target = "ARS";
                    break;
                case 2:
                    base = "ARS";
                    target = "USD";
                    break;
                case 3:
                    base = "USD";
                    target = "BRL";
                    break;
                case 4:
                    base = "BRL";
                    target = "USD";
                    break;
                case 5:
                    base = "USD";
                    target = "COP";
                    break;
                case 6:
                    base = "COP";
                    target = "USD";
                    break;
                default:
                    System.out.println("Opción no válida");
                    continue;
            }

            try {
                Moneda moneda = consulta.buscarMoneda(base, target);
                System.out.println("Ingrese el valor que desea convertir:");
                double cantidad = lectura.nextDouble();
                double resultado = cantidad * moneda.conversion_rate();

                System.out.printf("El valor %.2f [%s] corresponde al valor final de =>>> %.2f [%s]\n",
                        cantidad, base, resultado, target);
            } catch (Exception e) {
                System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
            }
        }
    }
}