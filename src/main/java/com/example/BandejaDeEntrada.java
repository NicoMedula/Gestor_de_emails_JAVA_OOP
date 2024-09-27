package com.example;

import java.util.ArrayList;

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

    

}
