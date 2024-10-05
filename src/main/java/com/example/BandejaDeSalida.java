package com.example;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BandejaDeSalida extends Bandeja 
                implements IFiltrarCorreos,IBorrarCorreo{
                    
    private  List<Correo> correosEnviados = new ArrayList<>();


    /* retorna la lista de correos enviados */
    public List<Correo> getCorreosEnviados() {
        return correosEnviados;
    }

    //Metodo para aplicar filtros
    public List<Correo> filtrar(Predicate<Correo> criterio) {
        return correosEnviados.stream()
                .filter(criterio)
                .collect(Collectors.toList());
    }

    public void borrarCorreo(Correo correo){
        correosEnviados.remove(correo);
    }

}

