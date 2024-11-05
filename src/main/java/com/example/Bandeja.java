package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Bandeja {

    private List<Correo> correosRecibidos = new ArrayList<>();
    private List<Correo> correosEnviados = new ArrayList<>();
    private List<Correo> correosFavoritos = new ArrayList<>();

    // Métodos para agregar correos favoritos
    public void agregarAFavoritos(Correo correo) {
        if (!correosFavoritos.contains(correo)) {
            correosFavoritos.add(correo);
        }
    }

    public void eliminarDeFavoritos(Correo correo) {
        correosFavoritos.remove(correo);
    }

    public List<Correo> getCorreosFavoritos() {
        return new ArrayList<>(correosFavoritos);
    }

    // Métodos para agregar correos
    public void agregarCorreoRecibido(Correo correo) {
        correosRecibidos.add(correo);
    }

    public void agregarCorreoEnviado(Correo correo) {
        correosEnviados.add(correo);
    }

    // Métodos para obtener correos
    public List<Correo> getCorreosRecibidos() {
        return new ArrayList<>(correosRecibidos);
    }

    public List<Correo> getCorreosEnviados() {
        return new ArrayList<>(correosEnviados);
    }

    // Métodos para aplicar filtros
    public List<Correo> filtrarRecibidos(Predicate<Correo> criterio) {
        return filtrarCorreos(correosRecibidos, criterio);
    }

    public List<Correo> filtrarEnviados(Predicate<Correo> criterio) {
        return filtrarCorreos(correosEnviados, criterio);
    }

    // Método genérico para filtrar correos
    private List<Correo> filtrarCorreos(List<Correo> correos, Predicate<Correo> criterio) {
        return correos.stream()
                .filter(criterio)
                .collect(Collectors.toList());
    }

    // Métodos para borrar correos
    public void borrarCorreoRecibido(Correo correo) {
        correosRecibidos.remove(correo);
    }

    public void borrarCorreoEnviado(Correo correo) {
        correosEnviados.remove(correo);
    }
}