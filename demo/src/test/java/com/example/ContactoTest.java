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
        assert(count == 1000);  // 1000 emails invalidos
    }

    @Test
    public void crear_correo_electronico_con_las_propiedades_Test(){

        Correo correo1 = new Correo();

        Contacto c1 = new Contacto("Nico", "nicolas@hotmail.com");
        

        correo1.setDestinatario(c1);

        Usuario u1 = new Usuario();

        u1.crearCorreo("Asunto de prueba", "Se esta probando poder crear un correo", c1, correo1.getDestinatarios());
        
        assertEquals(1, correo1.getDestinatarios().size());
    }


    
}
