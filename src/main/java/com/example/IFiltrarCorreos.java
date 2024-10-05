package com.example;

import java.util.List;
import java.util.function.Predicate;

public interface IFiltrarCorreos {

    List<Correo> filtrar(Predicate<Correo> criterio);
    
    

    
}
