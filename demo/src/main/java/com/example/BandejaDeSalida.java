package com.example;
import java.util.ArrayList;
import java.util.List;

public class BandejaDeSalida {
    private static List<Correo> correosEnviados = new ArrayList<>();

<<<<<<< HEAD
    public static void agregarCorreo(Correo correo) {
        correosEnviados.add(correo);
    }

    public static List<Correo> getCorreosEnviados() {
        return correosEnviados;
    }
=======


    public void setCorreoEnviado(Correo correo){
        correosEnviados.add(correo);
    }

    public ArrayList<Correo> getCorreosEnviados(){
        return correosEnviados;
    }


>>>>>>> d7f5900906ee10f7e10754be68660a1d10041376
}

