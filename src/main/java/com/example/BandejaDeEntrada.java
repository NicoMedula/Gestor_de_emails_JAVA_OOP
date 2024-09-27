package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BandejaDeEntrada {

    private ArrayList<Correo> correosRecibidos;

    public BandejaDeEntrada() {
        this.correosRecibidos = new ArrayList<>();
    }

    public void agregarCorreoRecibido(Correo correo){
        correosRecibidos.add(correo);
    }

    public ArrayList<Correo> getCorreosRecibidos(){
        return correosRecibidos;
    }

    //Metodo para aplicar filtros
    public List<Correo> filtrarCorreos(Predicate<Correo> criterio) {
        return correosRecibidos.stream()
                .filter(criterio)
                .collect(Collectors.toList());
    }

    

}
