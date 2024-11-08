package com.example;

public class BandejaRecibidos extends BandejaBase {

    public void agregarCorreoRecibido(Correo correo) {
        agregarCorreo(correo);
    }

    public void borrarCorreoRecibido(Correo correo) {
        eliminarCorreo(correo);
    }
}
