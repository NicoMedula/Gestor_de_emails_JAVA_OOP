package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
            new Contacto("Maria", "maria@ejemplo");
                fail("Se esperaba una IllegalArgumentException");
            }catch (IllegalArgumentException e) {
                assertEquals("El email ingresado no es válido", e.getMessage());
        }
    

    }

    @Test
    public void crear_10_contactos_validados_correctamente_Test(){
        for(int i=0; i<10; i++){
            Contacto c1 = new Contacto("Contacto " + i, "contacto" + i + "@example.com");
            assertEquals("contacto" + i + "@example.com", c1.getEmail());
        }
    } 

    @Test
    public void crear_100_contactos_validos_Test(){

        for(int i=0; i<100; i++){
            Contacto c1 = new Contacto("Contacto " + i, "contacto" + i + "@example.com");
            assertEquals("contacto" + i + "@example.com", c1.getEmail());
        }
    }

    @Test public void crear_1000_contactos_validos_Test(){

        for(int i=0; i<1000; i++){
            Contacto c1 = new Contacto("Contacto " + i, "contacto" + i + "@example.com");
            assertEquals("contacto" + i + "@example.com", c1.getEmail());
        }

    }

    @Test
    public void crear_1000_contactos_invalidos_Test(){
        int count = 0;

        for(int i=0; i<1000; i++){
            try {
                new Contacto("Contacto " + i, "contacto" + i + "@ejemplo");//".com" como no esta tira la excepcion
            }catch (IllegalArgumentException e) {
                count++;
            }
        }
        assertEquals(1000,count);  // 1000 emails invalidos
    }

    @Test
    public void crear_correo_electronico_con_las_propiedades_Test(){
        Contacto c1 = new Contacto("Nico", "nicolas@hotmail.com");
        Contacto c2 = new Contacto("Nico2", "nicolas2@hotmail.com");


        Correo correo1 = new Correo();
        correo1.setAsunto("Probando si funciona");
        correo1.setContenido("Este es un mensaje de prueba");
        correo1.setDestinatario(c1);
        correo1.setRemitente(c2);

        Usuario u1 = new Usuario();

        u1.crearCorreo(correo1.getAsunto(), correo1.getContenido(), correo1.getRemitente(), correo1.getDestinatarios());
        
        assertEquals(1, correo1.getDestinatarios().size());

    }

    @Test
    public void crear_correo_electronico_con_10_destinatario_Test(){
        
        Correo correo = new Correo();


        for(int i=0; i<10; i++){

            Contacto c1 = new Contacto("Contacto " + i, "contacto" + i + "@example.com");

            correo.setDestinatario(c1);
            correo.setAsunto("Asunto"+i);
            correo.setContenido("Contenido"+i);
            correo.setRemitente(c1);

        }
        assertEquals(10, correo.getDestinatarios().size());
        
        assertTrue(correo.getDestinatarios().containsAll(correo.getDestinatarios()));
        
    }


    
}
