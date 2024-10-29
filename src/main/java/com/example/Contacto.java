package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contacto {

    private String nombre;
    private String email;
    private Casilla casilla;
    private List<GrupoContactos> grupos;
   
   

    //Expresion regular para verificar el email
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-z]{2,6}$";
    
    public Contacto(String nombre, String email){

        if (!esEmailValido(email)) {
            throw new IllegalArgumentException("El email ingresado no es válido");
        }
        this.nombre=nombre;
        this.email=email;
        this.casilla =  new Casilla();
        this.grupos = new ArrayList<GrupoContactos>();
        
    }

    //Retorna la lista de mail recibidos
    public Bandeja getBandeja(){
        return casilla.getBandeja();
    }

    public void enviarCorreo(Correo correo){

        // Clonar el correo antes de enviarlo para que no se vean afectados por cambios posteriores
        Correo correoClon = correo.clonar();

        // Agregar el correo a la bandeja de salida del remitente
        casilla.getBandeja().agregarCorreoEnviado(correoClon);

        // Agregar el correo a la bandeja de entrada de cada destinatario
        for (Contacto destinatario : correoClon.getDestinatarios()) {
            destinatario.getBandeja().agregarCorreoRecibido(correoClon);
        }

    }

    public List<GrupoContactos> getGrupos() {
        return new ArrayList<>(grupos);
    }

    public void agregarAFavoritos(Correo correo) {
        
        // Verificar si el usuario es remitente o destinatario del correo
        if (correo.getRemitente().equals(this) || correo.getDestinatarios().contains(this)) {
            casilla.getBandeja().agregarAFavoritos(correo);
        } else {
            throw new IllegalStateException("No puedes agregar a favoritos un correo del que no eres remitente ni destinatario");
        }
    }
    
    //Metodo que valida el email
    private boolean esEmailValido(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public String getNombre(){
        return nombre;
    }

    public String getEmail(){
        return email;
    }
    
}


