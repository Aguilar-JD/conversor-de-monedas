package io.github.aguilarjd.principal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.aguilarjd.model.Moneda;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeneradorDeArchivos {
    public void guardarJson(List <Moneda> listaDeMonedas) throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileWriter escritura = new FileWriter("HistorialDeConsultas"+".json");
        escritura.write( gson.toJson(listaDeMonedas));
        escritura.close();

    }
}
