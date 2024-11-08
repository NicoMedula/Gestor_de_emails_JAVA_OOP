package com.example;

import java.util.function.Predicate;

public class FiltrosCorreo implements IFiltroCorreo {

    @Override
    public Predicate<Correo> filtrarPorAsunto(String keyword) {
        return correo -> correo.getAsunto().contains(keyword);
    }

    @Override
    public Predicate<Correo> filtrarPorRemitente(String email) {
        return correo -> correo.getRemitente().getEmail().equals(email);
    }

    @Override
    public Predicate<Correo> filtrarPorContenido(String keyword) {
        return correo -> correo.getContenido().contains(keyword);
    }

    @Override
    public Predicate<Correo> filtrarPorDestinatario(String email) {
        return correo -> correo.getDestinatarios().stream()
                .anyMatch(destinatario -> destinatario.getEmail().equals(email));
    }

    @Override
    public Predicate<Correo> filtrarPorAsuntoYRemitente(String keyword, String remitenteEmail) {
        return correo -> correo.getAsunto().contains(keyword) &&
                correo.getRemitente().getEmail().equals(remitenteEmail);
    }

    @Override
    public Predicate<Correo> filtrarPorAsuntoRemitenteYContenido(String keywordAsunto, String remitenteEmail, String keywordContenido) {
        return correo -> correo.getAsunto().contains(keywordAsunto) &&
                correo.getRemitente().getEmail().equals(remitenteEmail) &&
                correo.getContenido().contains(keywordContenido);
    }

    @Override
    public Predicate<Correo> filtrarPorAsuntoYDestinatario(String keywordAsunto, String destinatarioEmail) {
        return correo -> correo.getAsunto().contains(keywordAsunto) &&
                correo.getDestinatarios().stream()
                        .anyMatch(destinatario -> destinatario.getEmail().equals(destinatarioEmail));
    }
}
