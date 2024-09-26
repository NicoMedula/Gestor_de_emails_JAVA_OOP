package com.example;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class ContactoTest 
{
    @Test
    public void crear_un_contacto_correctamente_Test(){
        
        Contacto c1 = new Contacto("Nico", "nicolas@hotmail.com");

        assertEquals("nicolas@hotmail.com", c1.getEmail());
    }

    @Test
    public void crear_un_contacto_invalido_Test(){

        try {
            new Contacto("Uriel", "uriel@ejemplo");
                fail("Se esperaba una IllegalArgumentException");
            }catch (IllegalArgumentException e) {
                assertEquals("El email ingresado no es válido", e.getMessage());
        }
    
    }

    @Test
    public void agregar_destinatario_test() {
        Contacto remitente = new Contacto("Uriel Sabugo", "uriel@gmail.com");
        Contacto destinatario1 = new Contacto("Nico Medula", "nico@gmail.com");
        Contacto destinatario2 = new Contacto("Jose Fernandez", "josef@gmail.com");
    
        Correo correo = new Correo("probando", "capo.", remitente);
    
        correo.agregarDestinatario(destinatario1);
        correo.agregarDestinatario(destinatario2);
    
        List<Contacto> destinatariosEsperados = new ArrayList<>();
        destinatariosEsperados.add(destinatario1);
        destinatariosEsperados.add(destinatario2);
    
        assertEquals(destinatariosEsperados, correo.getPara());
    }
    
}
