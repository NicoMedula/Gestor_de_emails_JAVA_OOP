package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Bandeja {
    
    private List<Correo> correosRecibidos = new ArrayList<>();
    private List<Correo> correosEnviados = new ArrayList<>();

    // Métodos para agregar correos
    public void agregarCorreoRecibido(Correo correo) {
        correosRecibidos.add(correo);
    }

    public void agregarCorreoEnviado(Correo correo) {
        correosEnviados.add(correo);
    }

    // Métodos para obtener correos
    public List<Correo> getCorreosRecibidos() {
        return correosRecibidos;
    }

    public List<Correo> getCorreosEnviados() {
        return correosEnviados;
    }

    // Método para aplicar filtros
    public List<Correo> filtrarRecibidos(Predicate<Correo> criterio) {
        return correosRecibidos.stream()
                .filter(criterio)
                .collect(Collectors.toList());
    }

    public List<Correo> filtrarEnviados(Predicate<Correo> criterio) {
        return correosEnviados.stream()
                .filter(criterio)
                .collect(Collectors.toList());
    }

    // Método para borrar correos
    public void borrarCorreoRecibido(Correo correo) {
        correosRecibidos.remove(correo);
    }

    public void borrarCorreoEnviado(Correo correo) {
        correosEnviados.remove(correo);
    }
}
