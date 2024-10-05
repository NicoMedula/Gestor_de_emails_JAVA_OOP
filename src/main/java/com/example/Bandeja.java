package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Bandeja {
    
    private List<Correo> correosRecibidos = new ArrayList<>();
    private  List<Correo> correosEnviados = new ArrayList<>();

     /* agrega el correo enviado */
     public void setCorreoEnviado(Correo correo) {
        correosEnviados.add(correo);
    }

    public void setCorreoRecibido(Correo correo) {
        correosRecibidos.add(correo);
    }

    public void borrarCorreo(Correo correo) {
        correosRecibidos.remove(correo);
    }

    


}
