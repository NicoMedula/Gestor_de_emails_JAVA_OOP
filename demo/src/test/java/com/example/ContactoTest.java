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
    
}
