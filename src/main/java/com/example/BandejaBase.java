package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class BandejaBase {
    protected List<Correo> correos;

    public BandejaBase() {
        this.correos = new ArrayList<>();
    }

    public void agregarCorreo(Correo correo) {
        correos.add(correo);
    }

    public void eliminarCorreo(Correo correo) {
        correos.remove(correo);
    }

    public List<Correo> obtenerCorreos() {
        return new ArrayList<>(correos);
    }

    public List<Correo> filtrarCorreos(Predicate<Correo> criterio) {
        return correos.stream()
                .filter(criterio)
                .collect(Collectors.toList());
    }
}
