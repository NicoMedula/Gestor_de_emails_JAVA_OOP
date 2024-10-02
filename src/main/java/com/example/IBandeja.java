package com.example;

import java.util.List;
import java.util.function.Predicate;

public interface IBandeja {

    public List<Correo> filtrarCorreos(Predicate<Correo> criterio);

    public boolean borrarCorreo(Correo correo);
    List<Correo> getCorreos();/* Metodo para obtener los correos */
}
