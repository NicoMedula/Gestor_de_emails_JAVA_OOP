package com.example;

import java.util.ArrayList;
import java.util.List;

public class Contacto extends EntidadCorreo {

    private Casilla casilla;
    private List<GrupoContactos> grupos;

    public Contacto(String nombre, String email) {
        super(nombre, email);
        this.casilla = new Casilla();
        this.grupos = new ArrayList<>();
    }

    public Bandeja getBandeja() {
        return casilla.getBandeja();
    }

    public void enviarCorreo(Correo correo) {
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
}
