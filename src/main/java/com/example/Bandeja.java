package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Bandeja {
    
    private List<Correo> correosRecibidos;
    private  List<Correo> correosEnviados = new ArrayList<>();

    public Bandeja() {
        correosRecibidos = new ArrayList<>();
        
    }

    public void agregarCorreoRecibido(Correo correo) {
        correosRecibidos.add(correo);
    }

    public List<Correo> getCorreosRecibidos() {
        return correosRecibidos;
    }


}
