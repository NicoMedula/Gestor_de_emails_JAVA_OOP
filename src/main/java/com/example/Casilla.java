package com.example;

import java.util.List;

public class Casilla {
    
    private BandejaDeSalida bandejaEnviado;
    private BandejaDeEntrada bandejaRecibido;
    

    public Casilla() {
        this.bandejaEnviado = new BandejaDeSalida();
    }

    public void enviarCorreo(Correo correo){

        Correo correoClon = correo.clonar();

        //Agrega el correo a la lista de correos enviados del remitente
        bandejaEnviado.setCorreoEnviado(correoClon);

        //Agrega los correos a la bandeja de entrada de los destinatarios
        for (Contacto destinatario : correo.getDestinatarios()) {
            destinatario.getBandejaDeEntrada().setCorreoRecibido(correoClon);
        }

    }

    public List<Correo> getBandejaDeSalida(){
        return bandejaEnviado.getCorreosEnviados();
    }
    
}
