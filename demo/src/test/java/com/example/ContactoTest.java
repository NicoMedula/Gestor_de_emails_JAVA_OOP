package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class ContactoTest 
{
    @Test
    public void el_usuario_puede_crear_un_mail_Test(){
        Usuario u1 = new Usuario();
        u1.crearCorreo(null, null, null, null);
    }
    
}
