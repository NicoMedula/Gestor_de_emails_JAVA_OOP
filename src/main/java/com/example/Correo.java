package com.example;
import java.util.ArrayList;



public class Correo {
    
    private String asunto;
    private String contenido;
    private Contacto remitente;
    private ArrayList<Contacto> destinatarios = new ArrayList<>();



    

    // Agrega un nuevo destinatario al correo
    
     public ArrayList<Contacto> getDestinatarios(){
        return destinatarios; // Devuelve la lista de destinatarios
    }

   public void agregarDestinatarios(Contacto destinatario){
        this.destinatarios.add(destinatario);
   }

    public String getContenido(){
        return contenido;
    }

    public void setContenido(String contenido){
        this.contenido = contenido;
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
        correoNuevo.destinatarios = new ArrayList<>(this.destinatarios);
        
        return correoNuevo;
    }
    
    
}
