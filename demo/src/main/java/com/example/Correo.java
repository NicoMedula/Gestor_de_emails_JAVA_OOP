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

    public void setContenido(String contenido){
        this.contenido = contenido;
    }

    public String getContenido(){
        return contenido;
    }

    public void setAsunto(String asunto){
        this.asunto = asunto;
    }
    public String getAsunto(){
        return asunto;
    }

    
    public void setRemitente(Contacto remitente){
        this.remitente = remitente;
    }

    public Contacto getRemitente(){
        return remitente;
    }
    
}
