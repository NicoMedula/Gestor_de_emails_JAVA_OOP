package com.example;
import java.util.ArrayList;

public class BandejaDeSalida {
    
    private ArrayList<Correo>correosEnviados = new ArrayList();



    public void agregarCorreoEnviado(Correo correo){
        correosEnviados.add(correo);
    }


}
