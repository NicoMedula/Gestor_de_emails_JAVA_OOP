package com.example;

import java.util.ArrayList;
import java.util.List;

public class GrupoContactos {
    private String nombre;
    private List<Contacto> miembros;
    private Contacto propietario;

    public GrupoContactos(String nombre, Contacto propietario) {
        this.nombre = nombre;
        this.propietario = propietario;
        this.miembros = new ArrayList<>();
    }

    public void agregarMiembro(Contacto contacto) {
        if (!miembros.contains(contacto)) {
            miembros.add(contacto);
        }
    }

    public void eliminarMiembro(Contacto contacto) {
        miembros.remove(contacto);
    }

    public List<Contacto> getMiembros() {
        return new ArrayList<>(miembros);
    }

    public String getNombre() {
        return nombre;
    }

    public Contacto getPropietario() {
        return propietario;
    }

}
