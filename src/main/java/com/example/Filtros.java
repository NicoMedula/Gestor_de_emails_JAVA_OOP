package com.example;


import java.util.function.Predicate;


public class Filtros {

    // Filtrar por asunto
    public static Predicate<Correo> filtrarPorAsunto(String keyword) {
        return correo -> correo.getAsunto().contains(keyword);
    }

    // Filtrar por remitente
    public static Predicate<Correo> filtrarPorRemitente(String email) {
        return correo -> correo.getRemitente().getEmail().equals(email);
    }

    //Filtrar por contenido
    public static Predicate<Correo> filtrarPorContenido(String keyword) {
        return correo -> correo.getContenido().contains(keyword);
    }

    //Filtrar por destinatario (busca si alguno de los destinatarios tiene el mail especificado)
    public static Predicate<Correo> filtrarPorDestinatario(String email) {
        return correo -> correo.getDestinatarios().stream()
                .anyMatch(destinatario -> destinatario.getEmail().equals(email));
    }
    
    //Filtro complejo: se combinan dos campos en la busqueda "&&"
    public Predicate<Correo> filtrarPorAsuntoYRemitente(String keyword, String remitenteEmail) {
        
        return correo -> correo.getAsunto().contains(keyword) && 
                         correo.getRemitente().getEmail().equals(remitenteEmail);
    }

    // Filtro complejo: Filtrar por asunto, remitente y contenido
    public static Predicate<Correo> filtrarPorAsuntoRemitenteYContenido(String keywordAsunto, String remitenteEmail, String keywordContenido) {
        return correo -> correo.getAsunto().contains(keywordAsunto) &&
                     correo.getRemitente().getEmail().equals(remitenteEmail) &&
                     correo.getContenido().contains(keywordContenido);
    }

    // Filtro complejo: Filtrar por asunto y destinatario
    public static Predicate<Correo> filtrarPorAsuntoYDestinatario(String keywordAsunto, String destinatarioEmail) {
        return correo -> correo.getAsunto().contains(keywordAsunto) &&
                     correo.getDestinatarios().stream().anyMatch(destinatario -> destinatario.getEmail().equals(destinatarioEmail));
    }

    

}
