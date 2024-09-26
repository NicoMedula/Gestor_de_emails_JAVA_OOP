package com.example;
import java.util.ArrayList;

public class Correo {
    
    private String asunto;
    private String contenido;
    private Contacto remitente;

    private ArrayList<Contacto>destinatario = new ArrayList();

    public void setDestinatario(Contacto contacto){
        destinatario.add(contacto);
    }

    public ArrayList<Contacto> getDestinatarios(){
        return destinatario;
    }
    
}
