package com.example;
import java.util.function.Predicate;

public interface IFiltroCorreo {
    Predicate<Correo> filtrarPorAsunto(String keyword);
    Predicate<Correo> filtrarPorRemitente(String email);
    Predicate<Correo> filtrarPorContenido(String keyword);
    Predicate<Correo> filtrarPorDestinatario(String email);
    Predicate<Correo> filtrarPorAsuntoYRemitente(String keyword, String remitenteEmail);
    Predicate<Correo> filtrarPorAsuntoRemitenteYContenido(String keywordAsunto, String remitenteEmail, String keywordContenido);
    Predicate<Correo> filtrarPorAsuntoYDestinatario(String keywordAsunto, String destinatarioEmail);

}
