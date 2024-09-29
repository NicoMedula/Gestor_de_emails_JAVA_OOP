package com.example;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BandejaDeSalida implements IBandeja{
    private  List<Correo> correosEnviados = new ArrayList<>();

    /* agrega el correo enviado */
    public void enviarCorreo(Correo correo) {
        correosEnviados.add(correo);
    }

    /* retorna la lista de correos enviados */
    public List<Correo> getCorreosEnviados() {
        return correosEnviados;
    }

    //Metodo para aplicar filtros
    public List<Correo> filtrarCorreos(Predicate<Correo> criterio) {
        return correosEnviados.stream()
                .filter(criterio)
                .collect(Collectors.toList());
    }
   
}

