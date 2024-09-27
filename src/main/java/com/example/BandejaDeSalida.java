package com.example;
import java.util.ArrayList;
import java.util.List;

public class BandejaDeSalida {
    private  List<Correo> correosEnviados = new ArrayList<>();

    /* agrega el correo enviado */
    public void agregarCorreo(Correo correo) {
        correosEnviados.add(correo);
    }

    /* retorna la lista de correos enviados */
    public List<Correo> getCorreosEnviados() {
        return correosEnviados;
    }

   
}

