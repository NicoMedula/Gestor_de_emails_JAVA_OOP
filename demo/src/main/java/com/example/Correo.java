package com.example;
import java.util.ArrayList;
import java.util.List;

public class Correo {
    
    private String asunto;
    private String contenido;
    private Contacto remitente;
    private ArrayList<Contacto> destinatario = new ArrayList<>();
    private List<Contacto>para;
    private boolean enviado;

    /* CREACION DE CORREO CON SUS PROPIEDADES */
    public Correo(String asunto, String contenido, Contacto remitente){
    this.asunto = asunto;
    this.contenido = contenido;
    this.remitente = remitente;
    this.para = para;
    }
    
    public String getAsunto(String asunto){
        return asunto;
    }


    public String getContenido(String contenido){
        return contenido;
    }

    public Contacto getRemitente(Contacto remitente){
        return remitente;
    }

    
    public List<Contacto> getPara(){
        return para;
    }
    public boolean isEnviado(boolean enviado){
        return enviado;
    }

    /* UN USUARIO PUEDE ENVIAR CORREO A CONTACTOS Y AGREGAR VARIOS CONTACTOS EN EL PARA */
    public void agregarDestinatario(Contacto destinatario){
        if (para == null) {
            para = new ArrayList<>();
        }
        para.add(destinatario);
    }

    public boolean isEnviado() {
        return enviado;
    }

    public void setEnviado(boolean enviado) {
        this.enviado = enviado;
    }

    public void enviarCorreo(boolean enviado) {
        if (enviado) {
            this.enviado = true;
            BandejaDeSalida.agregarCorreo(this);
        } else {
            this.enviado = false;
        }
    }

    public void setDestinatario(Contacto contacto){
        destinatario.add(contacto);
    }

    public ArrayList<Contacto> getDestinatarios(){
        return destinatario; // Devuelve la lista de destinatarios
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
