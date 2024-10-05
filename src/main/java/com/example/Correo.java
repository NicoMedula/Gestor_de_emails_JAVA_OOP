package com.example;
import java.util.ArrayList;


public class Correo {
    
    private String asunto;
    private String contenido;
    private Contacto remitente;
    private ArrayList<Contacto> destinatario = new ArrayList<>();

    public void agregarDestinatario(Contacto destinatario){
        // Agrega un nuevo destinatario al correo
        this.destinatario.add(destinatario);
        
    }
    

    public String getContenido(){
        return contenido;
    }

    public void setContenido(String contenido){
        this.contenido = contenido;
    }

    public void setDestinatario(Contacto contacto){
        destinatario.add(contacto);
    }

    public ArrayList<Contacto> getDestinatarios(){
        return destinatario; // Devuelve la lista de destinatarios
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


    public Correo clonar() {
        var correoNuevo = new Correo();

        correoNuevo.setAsunto(this.getAsunto());
        correoNuevo.setContenido(this.getContenido());
        correoNuevo.setRemitente(this.getRemitente());

        return correoNuevo;
    }
    
}
