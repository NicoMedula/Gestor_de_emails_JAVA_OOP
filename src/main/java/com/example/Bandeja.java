package com.example;

import java.util.List;
import java.util.function.Predicate;

public class Bandeja {
    private BandejaRecibidos correosRecibidos = new BandejaRecibidos();
    private BandejaEnviados correosEnviados = new BandejaEnviados();
    private BandejaFavoritos correosFavoritos = new BandejaFavoritos();

    // Métodos para favoritos
    public void agregarAFavoritos(Correo correo) {
        correosFavoritos.agregarAFavoritos(correo);
    }

    public void eliminarDeFavoritos(Correo correo) {
        correosFavoritos.eliminarDeFavoritos(correo);
    }

    public List<Correo> getCorreosFavoritos() {
        return correosFavoritos.obtenerCorreos();
    }

    // Métodos para correos recibidos
    public void agregarCorreoRecibido(Correo correo) {
        correosRecibidos.agregarCorreoRecibido(correo);
    }

    public List<Correo> getCorreosRecibidos() {
        return correosRecibidos.obtenerCorreos();
    }

    public void borrarCorreoRecibido(Correo correo) {
        correosRecibidos.borrarCorreoRecibido(correo);
    }

    // Métodos para correos enviados
    public void agregarCorreoEnviado(Correo correo) {
        correosEnviados.agregarCorreoEnviado(correo);
    }

    public List<Correo> getCorreosEnviados() {
        return correosEnviados.obtenerCorreos();
    }

    public void borrarCorreoEnviado(Correo correo) {
        correosEnviados.borrarCorreoEnviado(correo);
    }

    // Métodos para aplicar filtros
    public List<Correo> filtrarRecibidos(Predicate<Correo> criterio) {
        return correosRecibidos.filtrarCorreos(criterio);
    }

    public List<Correo> filtrarEnviados(Predicate<Correo> criterio) {
        return correosEnviados.filtrarCorreos(criterio);
    }
}
