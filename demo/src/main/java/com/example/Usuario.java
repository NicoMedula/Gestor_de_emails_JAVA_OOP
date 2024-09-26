package com.example;
import java.util.ArrayList;
import java.util.List;

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

    public List<Correo> getBandejaDeSalida(){
        return BandejaDeSalida.getCorreosEnviados();
    }
}
