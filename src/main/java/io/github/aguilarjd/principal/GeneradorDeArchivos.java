package io.github.aguilarjd.principal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.aguilarjd.model.Moneda;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorDeArchivos {
    public void guardarJson(Moneda moneda) throws IOException {
         Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura = new FileWriter(moneda.target_code() +".json");
        escritura.write( gson.toJson(moneda));
        escritura.close();

    }
}
