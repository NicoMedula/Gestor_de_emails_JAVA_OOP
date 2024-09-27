package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



import java.util.List;




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
    
        Correo correo = new Correo();

        correo.setAsunto("Probando");
        correo.setRemitente(remitente);
        correo.setContenido("Este es un correo de prueba.");
    
        correo.agregarDestinatario(destinatario1);
        correo.agregarDestinatario(destinatario2);
    
    
        assertEquals(2, correo.getDestinatarios().size());
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
    public void crear_10_contactos_invalidos_Test(){
        int count = 0;

        for(int i=0; i<10; i++){
            try {
                new Contacto("Contacto " + i, "contacto" + i + "@ejemplo");//".com" como no esta tira la excepcion
            }catch (IllegalArgumentException e) {
                count++;
            }
        }
        assertEquals(10,count);  // 10 emails invalidos
    }


    @Test
    public void crear_100_contactos_invalidos_Test(){
        int count = 0;

        for(int i=0; i<100; i++){
            try {
                new Contacto("Contacto " + i, "contacto" + i + "@ejemplo");//".com" como no esta tira la excepcion
            }catch (IllegalArgumentException e) {
                count++;
            }
        }
        assertEquals(100,count);  // 100 emails invalidos
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

       

        
        
        assertEquals(1, correo1.getDestinatarios().size());

    }

    @Test
    public void crear_correo_electronico_con_10_destinatario_Test(){
        
        Correo correo = new Correo();

        Contacto c2 = new Contacto("Uriel","urielsabugo@gmail.com");

        correo.setAsunto("Asunto de Prueba");
        correo.setContenido("Contenido de Prueba");
        correo.setRemitente(c2);

        for(int i=0; i<10; i++){

            Contacto c1 = new Contacto("Contacto " + i, "contacto" + i + "@example.com");
            
            correo.setDestinatario(c1);
            
        }
        assertEquals(10, correo.getDestinatarios().size());
        
        assertTrue(correo.getDestinatarios().containsAll(correo.getDestinatarios()));

    }

    @Test
    public void crear_correo_electronico_con_100_destinatarios_Test(){
        Correo correo = new Correo();

        Contacto c2 = new Contacto("Uriel","urielsabugo@gmail.com");

        correo.setAsunto("Asunto de Prueba");
        correo.setContenido("Contenido de Prueba");
        correo.setRemitente(c2);

        for(int i=0; i<100; i++){

            Contacto c1 = new Contacto("Contacto " + i, "contacto" + i + "@example.com");
            
            correo.setDestinatario(c1);
            
        }
        assertEquals(100, correo.getDestinatarios().size());
        
        assertTrue(correo.getDestinatarios().containsAll(correo.getDestinatarios()));

    }

    @Test 
    public void verificar_que_el_mail_se_envia_y_se_almacena_en_bandeja_de_salida_Test(){

        Contacto c1 = new Contacto("Nico", "nicolas@hotmail.com");
        Contacto c2 = new Contacto("Nico2", "nicolas2@hotmail.com");
        

        Correo correo1 = new Correo();
        correo1.setAsunto("Probando si funciona");
        correo1.setContenido("Este es un mensaje de prueba");
        correo1.setDestinatario(c1);
        correo1.setRemitente(c2);

        Usuario u1 = new Usuario();

        u1.enviarCorreo(correo1);
        
        assertEquals(1, u1.getBandejaDeSalida().size());
        
    }

    @Test
    public void varios_destinatarios_reciben_el_correo_en_bandeja_de_entrada_Test() {
        // Crear remitente
        Contacto remitente = new Contacto("Remitente", "remitente@example.com");

        // Crear destinatarios
        Contacto destinatario1 = new Contacto("Destinatario 1", "destinatario1@example.com");
        Contacto destinatario2 = new Contacto("Destinatario 2", "destinatario2@example.com");
        Contacto destinatario3 = new Contacto("Destinatario 3", "destinatario3@example.com");

        // Crear correo
        Correo correo = new Correo();
        correo.setAsunto("Asunto de prueba");
        correo.setContenido("Contenido de prueba");
        correo.setRemitente(remitente);

        // Agregar destinatarios al correo
        correo.agregarDestinatario(destinatario1);
        correo.agregarDestinatario(destinatario2);
        correo.agregarDestinatario(destinatario3);

        // Enviar correo
        Usuario usuarioRemitente = new Usuario();
        usuarioRemitente.enviarCorreo(correo);

        //Prueba si se creo correctamente el correo
        assertEquals("Asunto de prueba", correo.getAsunto());
        assertEquals("Contenido de prueba", correo.getContenido());
        assertEquals(remitente, correo.getRemitente());
        assertEquals(3, correo.getDestinatarios().size());
        

        // Verifica que el correo esté en la bandeja de salida del remitente
        assertEquals(1, usuarioRemitente.getBandejaDeSalida().size());
        assertEquals(correo, usuarioRemitente.getBandejaDeSalida().get(0));

        // Verificar que cada destinatario haya recibido el correo en su bandeja de entrada
        assertEquals(1, destinatario1.getBandejaDeEntrada().getCorreosRecibidos().size());
        assertEquals(correo, destinatario1.getBandejaDeEntrada().getCorreosRecibidos().get(0));

        assertEquals(1, destinatario2.getBandejaDeEntrada().getCorreosRecibidos().size());
        assertEquals(correo, destinatario2.getBandejaDeEntrada().getCorreosRecibidos().get(0));

        assertEquals(1, destinatario3.getBandejaDeEntrada().getCorreosRecibidos().size());
        assertEquals(correo, destinatario3.getBandejaDeEntrada().getCorreosRecibidos().get(0));

        
    }

    @Test
    public void enviar_mas_de_un_correo_y_que_se_almacene_bandeja_de_entrada_del_destinatario_y_bandeja_de_salida_del_remitente_Test() {
        // Crear remitente
        Contacto remitente = new Contacto("Remitente", "remitente@example.com");

        // Crear destinatarios
        Contacto destinatario1 = new Contacto("Destinatario 1", "destinatario1@example.com");
        Contacto destinatario2 = new Contacto("Destinatario 2", "destinatario2@example.com");

        // Crear primer correo
        Correo correo1 = new Correo();
        correo1.setAsunto("Asunto 1");
        correo1.setContenido("Contenido del primer correo");
        correo1.setRemitente(remitente);
        correo1.agregarDestinatario(destinatario1);
        correo1.agregarDestinatario(destinatario2);

        // Crear segundo correo
        Correo correo2 = new Correo();
        correo2.setAsunto("Asunto 2");
        correo2.setContenido("Contenido del segundo correo");
        correo2.setRemitente(remitente);
        correo2.agregarDestinatario(destinatario1);
        correo2.agregarDestinatario(destinatario2);

        // Enviar correos
        Usuario usuarioRemitente = new Usuario();
        usuarioRemitente.enviarCorreo(correo1);
        usuarioRemitente.enviarCorreo(correo2);

        // Verificar que ambos correos estén en la bandeja de salida del remitente
        List<Correo> correosEnviados = usuarioRemitente.getBandejaDeSalida();
        assertEquals(2, correosEnviados.size());
        assertEquals(correo1, correosEnviados.get(0));
        assertEquals(correo2, correosEnviados.get(1));

        // Verificar que los destinatarios hayan recibido ambos correos en su bandeja de entrada
        assertEquals(2, destinatario1.getBandejaDeEntrada().getCorreosRecibidos().size());
        assertEquals(correo1, destinatario1.getBandejaDeEntrada().getCorreosRecibidos().get(0));
        assertEquals(correo2, destinatario1.getBandejaDeEntrada().getCorreosRecibidos().get(1));

        assertEquals(2, destinatario2.getBandejaDeEntrada().getCorreosRecibidos().size());
        assertEquals(correo1, destinatario2.getBandejaDeEntrada().getCorreosRecibidos().get(0));
        assertEquals(correo2, destinatario2.getBandejaDeEntrada().getCorreosRecibidos().get(1));
    }

    @Test
    public void filtrar_por_asunto_Test() {

        BandejaDeEntrada bandeja = new BandejaDeEntrada();
    
        Correo correo1 = new Correo();
        correo1.setAsunto("Oferta importante");
        Correo correo2 = new Correo();
        correo2.setAsunto("Notificación");

        bandeja.agregarCorreoRecibido(correo1);
        bandeja.agregarCorreoRecibido(correo2);

        List<Correo> resultado = bandeja.filtrarCorreos(Filtro.filtrarPorAsunto("Oferta"));
    
        assertEquals(1, resultado.size());
        assertEquals(correo1, resultado.get(0));
    }

    @Test
    public void filtrar_por_remitente_Test() {
        BandejaDeEntrada bandeja = new BandejaDeEntrada();

        Contacto remitente1 = new Contacto("Nicolas","nicolas@hotmail.com");
        Contacto remitente2 = new Contacto("Uriel","uriel@hotmail.com");

        Correo correo1 = new Correo();
        correo1.setRemitente(remitente1);

        Correo correo2 = new Correo();
        correo2.setRemitente(remitente2);

        bandeja.agregarCorreoRecibido(correo1);
        bandeja.agregarCorreoRecibido(correo2);

        assertEquals(1, bandeja.filtrarCorreos(Filtro.filtrarPorRemitente("nicolas@hotmail.com")).size());
        assertEquals(correo1, bandeja.filtrarCorreos(Filtro.filtrarPorRemitente("nicolas@hotmail.com")).get(0));

    }

    @Test
    public void filtrar_por_contenido_Test() {
        BandejaDeEntrada bandeja = new BandejaDeEntrada();

        // Crear correos con diferentes contenidos
        Correo correo1 = new Correo();
        correo1.setAsunto("Asunto 1");
        correo1.setContenido("Este es un correo importante sobre ofertas");
    
        Correo correo2 = new Correo();
        correo2.setAsunto("Asunto 2");
        correo2.setContenido("Este es un correo informativo");

        Correo correo3 = new Correo();
        correo3.setAsunto("Asunto 3");
        correo3.setContenido("Este es un correo de notificación importante");

        bandeja.agregarCorreoRecibido(correo1);
        bandeja.agregarCorreoRecibido(correo2);
        bandeja.agregarCorreoRecibido(correo3);

        // Filtrar por contenido
        List<Correo> resultado = bandeja.filtrarCorreos(Filtro.filtrarPorContenido("importante"));
    
        // Comprobar que solo se devuelve los correo con el contenido "importante"
        //Hay dos correos con la palabra clave "importante" (correo 1 y correo3)
        assertEquals(2, resultado.size());
        assertEquals(correo1, resultado.get(0));
    }

    @Test
    public void filtrar_por_destinatario_Test() {
        BandejaDeEntrada bandeja = new BandejaDeEntrada();

        // Crear contactos destinatarios
        Contacto destinatario1 = new Contacto("desti1","destinatario1@ejemplo.com");
        Contacto destinatario2 = new Contacto("desti2","destinatario2@ejemplo.com");

        // Crear correos con diferentes destinatarios
        Correo correo1 = new Correo();
        correo1.setAsunto("Correo 1");
        correo1.agregarDestinatario(destinatario1);

        Correo correo2 = new Correo();
        correo2.setAsunto("Correo 2");
        correo2.agregarDestinatario(destinatario2);

        bandeja.agregarCorreoRecibido(correo1);
        bandeja.agregarCorreoRecibido(correo2);
   
    
        // Comprobar que solo se devuelve el correo dirigido a destinatario1
        assertEquals(1, bandeja.filtrarCorreos(Filtro.filtrarPorDestinatario("destinatario1@ejemplo.com")).size());
        assertEquals(correo1, bandeja.filtrarCorreos(Filtro.filtrarPorDestinatario("destinatario1@ejemplo.com")).get(0));

    }


    @Test
    public void filtro_complejo_asunto_y_remitente_Test() {
        BandejaDeEntrada bandeja = new BandejaDeEntrada();

        // Crear remitente
        Contacto remitente1 = new Contacto("remi1","remitente1@ejemplo.com");

        // Crear correos con el mismo remitente pero diferentes asuntos
        Correo correo1 = new Correo();
        correo1.setAsunto("Oferta importante");
        correo1.setRemitente(remitente1);

        Correo correo2 = new Correo();
        correo2.setAsunto("Notificación");
        correo2.setRemitente(remitente1);

        bandeja.agregarCorreoRecibido(correo1);
        bandeja.agregarCorreoRecibido(correo2);

        // Filtrar por asunto y remitente
        List<Correo> resultado = bandeja.filtrarCorreos(Filtro.filtrarPorAsuntoYRemitente("Oferta", "remitente1@ejemplo.com"));
    
        // Comprobar que solo se devuelve el correo con el asunto "Oferta importante" del remitente1
        assertEquals(1, resultado.size());
        assertEquals(correo1, resultado.get(0));



    }


}
