package com.example;
import java.util.ArrayList;
import java.util.List;

public class BandejaDeSalida {
    private static List<Correo> correosEnviados = new ArrayList<>();

    /* agrega el correo enviado */
    public static void agregarCorreo(Correo correo) {
        correosEnviados.add(correo);
    }

    /* retorna la lista de correos enviados */
    public static List<Correo> getCorreosEnviados() {
        return correosEnviados;
    }

    /* setea los correos enviados*/
    public void setCorreoEnviado(Correo correo) {
        this.correosEnviados.add(correo);
    }
}

