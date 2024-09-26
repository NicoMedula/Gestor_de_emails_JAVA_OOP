package com.example;
import java.util.ArrayList;
import java.util.List;

public class BandejaDeSalida {
    private static List<Correo> correosEnviados = new ArrayList<>();

    public static void agregarCorreo(Correo correo) {
        correosEnviados.add(correo);
    }

    public static List<Correo> getCorreosEnviados() {
        return correosEnviados;
    }
}

