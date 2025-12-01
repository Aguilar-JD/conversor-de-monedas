package io.github.aguilarjd.principal;

import io.github.aguilarjd.service.ConsultarMoneda;
import io.github.aguilarjd.model.Moneda;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LecturaDeDatos lectura = new LecturaDeDatos();
        ConsultarMoneda consulta = new ConsultarMoneda();

        List<String> historial = new ArrayList<>();
        List<Moneda> listaDeConsultas = new ArrayList<>();

        int opcion = 0;

        while (opcion != 9) {
            System.out.println("*************************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Dólar => Real brasileño");
            System.out.println("4) Real brasileño => Dólar");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dólar");
            System.out.println("7) Ver Historial de Conversiones");
            System.out.println("9) Salir");
            System.out.println("Elija una opción válida:");
            System.out.println("*************************************************");

            opcion = lectura.leerOpcion();

            if (opcion == 9) {
                System.out.println("Cerrando programa...");
                break;
            }

            if (opcion == 7) {
                System.out.println("--- HISTORIAL DE CONVERSIONES ---");
                if (historial.isEmpty()) {
                    System.out.println("No hay conversiones registradas aún.");
                } else {
                    for (String registro : historial) {
                        System.out.println(registro);
                    }
                }
                System.out.println("---------------------------------");
                continue;
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

            System.out.println("Ingrese el valor que desea convertir:");

            double cantidad = lectura.leerCantidad();


            try {
                System.out.println("🔄 Consultando API, por favor espere...");
                Moneda moneda = consulta.buscarMoneda(base, target);

                double resultado = cantidad * moneda.conversion_rate();

                LocalDateTime ahora = LocalDateTime.now();
                DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String fechaFormateada = ahora.format(formateador);

                String mensajeFinal = String.format("El valor %.2f [%s] corresponde al valor final de =>>> %.2f [%s]",
                        cantidad, base, resultado, target);

                System.out.println("✅ " + mensajeFinal);

                historial.add(fechaFormateada + " - " + mensajeFinal);
                listaDeConsultas.add(moneda);

                GeneradorDeArchivos generador = new GeneradorDeArchivos();
                generador.guardarJson(listaDeConsultas);

            } catch (Exception e) {
                System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
            }

        }
    }
}