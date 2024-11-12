package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GrupoYFavoritoTest {
    
    @Test
    public void crear_grupo_y_enviar_correo_Test(){

        Contacto remitente = new Contacto("Juan", "juan@mail.com");
        Contacto destinatario1 = new Contacto("Ana", "ana@mail.com");
        Contacto destinatario2 = new Contacto("Pedro", "pedro@mail.com");

        GrupoContactos grupo = new GrupoContactos("Trabajo", remitente);

        grupo.agregarMiembro(destinatario1);
        grupo.agregarMiembro(destinatario2);
        
        

        Correo correoGrupal = new Correo();
        correoGrupal.setAsunto("Correo grupal");
        correoGrupal.setContenido("Contenido para el grupo");
        correoGrupal.setRemitente(remitente);
        correoGrupal.agregarDestinatarios(grupo);

        remitente.enviarCorreo(correoGrupal);

        assertEquals(1, destinatario1.getBandeja().getCorreosRecibidos().size());
        assertEquals(1, destinatario2.getBandeja().getCorreosRecibidos().size());
        
        assertEquals(1, grupo.getPropietario().getBandeja().getCorreosEnviados().size());
        assertEquals("Correo grupal", grupo.getPropietario().getBandeja().getCorreosEnviados().get(0).getAsunto());
        assertEquals("Contenido para el grupo", grupo.getPropietario().getBandeja().getCorreosEnviados().get(0).getContenido());
        assertEquals(remitente, grupo.getPropietario().getBandeja().getCorreosEnviados().get(0).getRemitente());
        assertEquals("Trabajo", grupo.getNombre());
    }

    @Test
    public void agregar_correo_a_favoritos_Test(){
        Contacto remitente = new Contacto("Juan", "juan@mail.com");
        Contacto destinatario = new Contacto("Ana", "ana@mail.com");

        Correo correo1 = new Correo();
        correo1.setAsunto("Correo 1");
        correo1.setContenido("Contenido 1");
        correo1.setRemitente(remitente);
        correo1.agregarDestinatarios(destinatario);

        remitente.enviarCorreo(correo1);

        remitente.verificarYAgergarFavorito(correo1);

        assertEquals(1, remitente.getBandeja().getCorreosFavoritos().size());
        assertEquals("Correo 1", remitente.getBandeja().getCorreosFavoritos().get(0).getAsunto());

        remitente.getBandeja().eliminarDeFavoritos(correo1);
        assertEquals(0, remitente.getBandeja().getCorreosFavoritos().size());

        assertEquals(1, destinatario.getBandeja().getCorreosRecibidos().size());
        assertEquals(0, destinatario.getBandeja().getCorreosFavoritos().size());


        destinatario.getBandeja().agregarAFavoritos(correo1);

        assertEquals(1, destinatario.getBandeja().getCorreosFavoritos().size());

        
    }

}
