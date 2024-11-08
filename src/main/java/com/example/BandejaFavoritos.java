package com.example;

public class BandejaFavoritos extends BandejaBase {

    public void agregarAFavoritos(Correo correo) {
        if (!correos.contains(correo)) {
            agregarCorreo(correo);
        }
    }

    public void eliminarDeFavoritos(Correo correo) {
        eliminarCorreo(correo);
    }
}
