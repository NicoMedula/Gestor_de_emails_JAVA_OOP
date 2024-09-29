package com.example;

import java.util.List;

public class Usuario {
    
    private BandejaDeSalida bandejaEnviado;

    public Usuario() {
        this.bandejaEnviado = new BandejaDeSalida();
    }

    public void enviarCorreo(Correo correo){
        //Agrega el correo a la lista de correos enviados del remitente
        bandejaEnviado.enviarCorreo(correo);

        //Agrega los correos a la bandeja de entrada de los destinatarios
        for (Contacto destinatario : correo.getDestinatarios()) {
            destinatario.getBandejaDeEntrada().agregarCorreoRecibido(correo);
        }

    }

    public List<Correo> getBandejaDeSalida(){
        return bandejaEnviado.getCorreosEnviados();
    }
    
}
