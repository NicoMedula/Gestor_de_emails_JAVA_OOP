package com.example;

import java.util.List;
import java.util.function.Predicate;


public class Filtro {

    // Filtrar por asunto
    public static Predicate<Correo> filtrarPorAsunto(String keyword) {
        return correo -> correo.getAsunto().contains(keyword);
    }

    // Filtrar por remitente
    public static Predicate<Correo> filtrarPorRemitente(Contacto remitente) {
        return correo -> correo.getRemitente().equals(remitente);
    }

    //Filtrar por contenido
    public static Predicate<Correo> filtrarPorContenido(String keyword) {
        return correo -> correo.getContenido().contains(keyword);
    }
    
    //Filtro complejo: se combinan dos campos en la busqueda "&&"
    public static Predicate<Correo> filtrarPorAsuntoYRemitente(String keyword, String remitenteEmail) {
        
        return correo -> correo.getAsunto().contains(keyword) && 
                         correo.getRemitente().getEmail().equals(remitenteEmail);
    }
}
