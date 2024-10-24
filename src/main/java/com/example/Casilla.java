package com.example;

import java.util.List;

public class Casilla {
    
    private Bandeja bandeja;
    

    public Casilla() {
        this.bandeja = new Bandeja();
    }

    public void enviarCorreo(Correo correo){

         // Clonar el correo antes de enviarlo para que no se vean afectados por cambios posteriores
         Correo correoClon = correo.clonar();

         // Agregar el correo a la bandeja de salida del remitente
         this.bandeja.agregarCorreoEnviado(correoClon);
 
         // Agregar el correo a la bandeja de entrada de cada destinatario
         for (Contacto destinatario : correoClon.getDestinatarios()) {
             destinatario.getBandeja().agregarCorreoRecibido(correoClon);
         }

    }

    public List<Correo> getBandejaDeSalida(){
        return bandeja.getCorreosEnviados();
    }
    
}
