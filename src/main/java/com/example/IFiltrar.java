package com.example;

import java.util.List;
import java.util.function.Predicate;

public interface IFiltrar {

    List<Correo> filtrar(Predicate<Correo> criterio);
    
    

    
}
