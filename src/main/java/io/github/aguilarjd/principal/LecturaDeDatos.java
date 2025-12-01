package io.github.aguilarjd.principal;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LecturaDeDatos {
    public double leerCantidad() {
        Scanner lectura = new Scanner(System.in);

        while (true) {
            try {
                // Intentamos leer un decimal
                return lectura.nextDouble();
            } catch (InputMismatchException e) {
                // Si escriben letras, caemos aquí
                System.out.println("❌ Error: Ingresa un valor numérico válido (ej. 100.50).");
                lectura.next(); // Limpiamos el buffer
            }
        }
    }
    public int leerOpcion() {
        Scanner lectura = new Scanner(System.in);

        while (true) {
            try {
                int opcion = lectura.nextInt();

                if (opcion >= 1 && opcion <= 7 || opcion == 9) {
                    return opcion;
                } else {
                    System.out.println("⚠\uFE0F Opción inválida: Ingresa un número del 1 al 7 o el 9.");
                }

            } catch (InputMismatchException e) {

                System.out.println("❌ Error: Por favor ingrese un número válido.");
                lectura.next();
                continue;
            }
        }
    }
}