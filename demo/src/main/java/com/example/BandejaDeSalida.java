package com.example;
import java.util.ArrayList;

public class BandejaDeSalida {
    
    private ArrayList<Correo>correosEnviados = new ArrayList();



    public void setCorreoEnviado(Correo correo){
        correosEnviados.add(correo);
    }

    public ArrayList<Correo> getCorreosEnviados(){
        return correosEnviados;
    }


}
