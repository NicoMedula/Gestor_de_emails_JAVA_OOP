package com.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class EntidadCorreo {

    private String nombre;
    private String email;
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-z]{2,6}$";

    public EntidadCorreo(String nombre, String email) {
        if (!esEmailValido(email)) {
            throw new IllegalArgumentException("El email ingresado no es válido");
        }
        this.nombre = nombre;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    // Método para validar el email
    private boolean esEmailValido(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
