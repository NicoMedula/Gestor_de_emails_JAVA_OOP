package com.example;

public class BandejaEnviados extends BandejaBase {

    public void agregarCorreoEnviado(Correo correo) {
        agregarCorreo(correo);
    }

    public void borrarCorreoEnviado(Correo correo) {
        eliminarCorreo(correo);
    }
}
