package com.example;

import java.util.List;

public class Casilla {
    
    private Bandeja bandeja;
    

    public Casilla() {
        this.bandeja = new Bandeja();
    }

    public Bandeja getBandeja(){
        return bandeja;
    }

    public List<Correo> getBandejaDeSalida(){
        return bandeja.getCorreosEnviados();
    }
    
}
