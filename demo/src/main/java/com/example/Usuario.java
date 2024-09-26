package com.example;
import java.util.ArrayList;

public class Usuario {
    
    private BandejaDeSalida bandejaEnviado;

    public Usuario() {
        this.bandejaEnviado = new BandejaDeSalida();
    }

    public void setCorreo(String asunto, 
                                String contenido,               
                                    Contacto remitente, ArrayList<Contacto>destinatarios){

    }

    public void enviarCorreo(Correo correo){
        bandejaEnviado.setCorreoEnviado(correo);
    }

    public ArrayList<Correo> getBandejaDeSalida(){
        return bandejaEnviado.getCorreosEnviados();
    }
}
