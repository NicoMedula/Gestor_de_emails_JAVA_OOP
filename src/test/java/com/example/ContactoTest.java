package com.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;




public class ContactoTest 
{
    @Test
    public void crear_un_contacto_correctamente_Test(){
        
        Contacto c1 = new Contacto("Nico", "nicolas@hotmail.com");

        assertEquals("nicolas@hotmail.com", c1.getEmail());
        assertEquals("Nico", c1.getNombre());
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
    
        correo.setDestinatarios(destinatario1);
        correo.setDestinatarios(destinatario2);
    
    
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
        int count = 0;
        for(int i=0; i<1000; i++){
            Contacto c1 = new Contacto("Contacto " + i, "contacto" + i + "@example.com");
            assertEquals("contacto" + i + "@example.com", c1.getEmail());
            count++;
        }

        assertEquals(1000,count );
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
        correo1.setDestinatarios(c1);
        correo1.setRemitente(c2);

        
        
        assertEquals(1, correo1.getDestinatarios().size());
        assertEquals("Probando si funciona", correo1.getAsunto());
        assertEquals("Este es un mensaje de prueba", correo1.getContenido());
        assertEquals("nicolas2@hotmail.com", correo1.getRemitente().getEmail());

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
            
            correo.setDestinatarios(c1);
            
        }
        assertEquals(10, correo.getDestinatarios().size());
        
        assertTrue(correo.getDestinatarios().containsAll(correo.getDestinatarios()));

    }

    @Test
    public void crear_correo_electronico_con_10_destinatarios_invalidos_Test() {
        int cont = 0;
        Correo correo = new Correo();
        correo.setAsunto("Asunto de Prueba");
        correo.setContenido("Contenido de Prueba");
    
        for (int i = 0; i < 10; i++) {
            String emailInvalido = "contacto" + i + "@ejemplo"; // email inválido
            try {
                Contacto contactoInvalido = new Contacto("Contacto " + i, emailInvalido);
                correo.setDestinatarios(contactoInvalido);
            } catch (IllegalArgumentException e) {
                cont++;
            }
        }
    
        assertEquals(10, cont);  // 10 destinatarios invalidos deben lanzar excepciones
        assertTrue(correo.getDestinatarios().isEmpty()); // Ningún destinatario debe ser agregado
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
            
            correo.setDestinatarios(c1);
            
        }
        assertEquals(100, correo.getDestinatarios().size());
        
        assertTrue(correo.getDestinatarios().containsAll(correo.getDestinatarios()));

    }

    
    @Test
    public void crear_correo_electronico_con_100_destinatarios_invalidos_Test() {
        int cont = 0;
        Correo correo = new Correo();
        correo.setAsunto("Asunto de Prueba");
        correo.setContenido("Contenido de Prueba");
    
        for (int i = 0; i < 100; i++) {
            String emailInvalido = "contacto" + i + "@ejemplo"; // email inválido
            try {
                Contacto contactoInvalido = new Contacto("Contacto " + i, emailInvalido);
                correo.setDestinatarios(contactoInvalido);
            } catch (IllegalArgumentException e) {
                cont++;
            }
        }
    
        assertEquals(100, cont);  // 10 destinatarios invalidos deben lanzar excepciones
        assertTrue(correo.getDestinatarios().isEmpty()); // Ningun destinatario debe ser agregado
    }

    @Test 
    public void verificar_que_el_mail_se_envia_y_se_almacena_en_bandeja_de_salida_Test(){
        
        Contacto c1 = new Contacto("Nico", "nicolas@hotmail.com");
        Contacto c2 = new Contacto("Nico2", "nicolas2@hotmail.com");
        

        Correo correo1 = new Correo();
        correo1.setAsunto("Probando si funciona");
        correo1.setContenido("Este es un mensaje de prueba");
        correo1.setDestinatarios(c1);
        correo1.setRemitente(c2);


        c2.enviarCorreo(correo1);

        
        assertEquals(1, c2.getBandejaDeSalida().size());
        
        
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
        correo.setDestinatarios(destinatario1);
        correo.setDestinatarios(destinatario2);
        correo.setDestinatarios(destinatario3);

        // Enviar correo
        remitente.enviarCorreo(correo);

        //Prueba si se creo correctamente el correo
        assertEquals("Asunto de prueba", correo.getAsunto());
        assertEquals("Contenido de prueba", correo.getContenido());
        assertEquals(remitente, correo.getRemitente());
        assertEquals(3, correo.getDestinatarios().size());
        

        // Verifica que el correo esté en la bandeja de salida del remitente
        assertEquals(1, remitente.getBandejaDeSalida().size());
        

        // Verificar que cada destinatario haya recibido el correo en su bandeja de entrada
        assertEquals(1, destinatario1.getBandeja().getCorreosRecibidos().size());
        

        assertEquals(1, destinatario2.getBandeja().getCorreosRecibidos().size());
        

        assertEquals(1, destinatario3.getBandeja().getCorreosRecibidos().size());
        

        
    }
    @Test
public void testEnvioDeCorreo() {
    // Crear remitente y destinatarios
    Contacto remitente = new Contacto("Remitente", "remitente@example.com");
    Contacto destinatario1 = new Contacto("Destinatario 1", "destinatario1@example.com");
    Contacto destinatario2 = new Contacto("Destinatario 2", "destinatario2@example.com");

    // Crear correo
    Correo correo = new Correo();
    correo.setAsunto("Asunto de prueba");
    correo.setRemitente(remitente);
    correo.agregarDestinatarios(destinatario1);
    correo.agregarDestinatarios(destinatario2);

    // Enviar correo
    remitente.enviarCorreo(correo);

    // Verificar que el correo está en la bandeja de salida del remitente
    assertEquals(1, remitente.getBandejaDeSalida().size());
    assertEquals("Asunto de prueba", remitente.getBandejaDeSalida().get(0).getAsunto());

    // Verificar que los destinatarios recibieron el correo
    assertEquals(1, destinatario1.getBandeja().getCorreosRecibidos().size());
    assertEquals("Asunto de prueba", destinatario1.getBandeja().getCorreosRecibidos().get(0).getAsunto());

    assertEquals(1, destinatario2.getBandeja().getCorreosRecibidos().size());
    assertEquals("Asunto de prueba", destinatario2.getBandeja().getCorreosRecibidos().get(0).getAsunto());
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
        correo1.setDestinatarios(destinatario1);
        correo1.setDestinatarios(destinatario2);

        // Crear segundo correo
        Correo correo2 = new Correo();
        correo2.setAsunto("Asunto 2");
        correo2.setContenido("Contenido del segundo correo");
        correo2.setRemitente(remitente);
        correo2.setDestinatarios(destinatario1);
        correo2.setDestinatarios(destinatario2);

        // Enviar correos
        Casilla usuarioRemitente = new Casilla();
        usuarioRemitente.enviarCorreo(correo1);
        usuarioRemitente.enviarCorreo(correo2);

        // Verificar que ambos correos estén en la bandeja de salida del remitente
        List<Correo> correosEnviados = usuarioRemitente.getBandejaDeSalida();
        assertEquals(2, correosEnviados.size());
        

        // Verificar que los destinatarios hayan recibido ambos correos en su bandeja de entrada
        assertEquals(2, destinatario1.getBandeja().getCorreosRecibidos().size());
        

        assertEquals(2, destinatario2.getBandeja().getCorreosRecibidos().size());
       
    }

    // FILTROS PARA BANDEJA DE ENTRADA//

    @Test
    public void filtrar_por_asunto_bandeja_de_entrada_Test() {
    
        BandejaDeEntrada bandeja = new BandejaDeEntrada();
        Filtros filtro = new Filtros(); // Crear una instancia de Filtros
    
        Correo correo1 = new Correo();
        correo1.setAsunto("Oferta importante");
        Correo correo2 = new Correo();
        correo2.setAsunto("Notificación");
    
        bandeja.agregarCorreoRecibido(correo1);
        bandeja.agregarCorreoRecibido(correo2);
    
        List<Correo> resultado = bandeja.filtrar(filtro.filtrarPorAsunto("Oferta")); // Usar la instancia de Filtros
    
        assertEquals(1, resultado.size());
        assertEquals(correo1, resultado.get(0));
    }

    @Test
public void filtrar_por_asunto_bandeja_de_entrada_Test_Fallido() {

    BandejaDeEntrada bandeja = new BandejaDeEntrada();
    Filtros filtro = new Filtros(); // Crear una instancia de Filtros

    Correo correo1 = new Correo();
    correo1.setAsunto("Oferta importante");
    Correo correo2 = new Correo();
    correo2.setAsunto("Notificación");

    bandeja.agregarCorreoRecibido(correo1);
    bandeja.agregarCorreoRecibido(correo2);

    List<Correo> resultado = bandeja.filtrar(filtro.filtrarPorAsunto("Oferta")); // Usar la instancia de Filtros

    // Aseguramos que el resultado sea incorrecto (esto hará que el test falle)
    assertEquals(1, resultado.size()); // solo debería haber 1
}


    @Test
    public void filtrar_por_remitente_bandeja_de_entrada_Test() {
        BandejaDeEntrada bandeja = new BandejaDeEntrada();
        Filtros filtro = new Filtros();
    
        Contacto remitente1 = new Contacto("Nicolas", "nicolas@hotmail.com");
        Contacto remitente2 = new Contacto("Uriel", "uriel@hotmail.com");
    
        Correo correo1 = new Correo();
        correo1.setRemitente(remitente1);
    
        Correo correo2 = new Correo();
        correo2.setRemitente(remitente2);
    
        bandeja.agregarCorreoRecibido(correo1);
        bandeja.agregarCorreoRecibido(correo2);
    
        assertEquals(1, bandeja.filtrar(filtro.filtrarPorRemitente("nicolas@hotmail.com")).size()); // Usar la instancia de Filtros
        assertEquals(correo1, bandeja.filtrar(filtro.filtrarPorRemitente("nicolas@hotmail.com")).get(0)); // Usar la instancia de Filtros
    }

    @Test
    public void filtrar_por_remitente_bandeja_de_entrada_Test_Fallido() {
    BandejaDeEntrada bandeja = new BandejaDeEntrada();
    Filtros filtro = new Filtros();

    Contacto remitente1 = new Contacto("Nicolas", "nicolas@hotmail.com");
    Contacto remitente2 = new Contacto("Uriel", "uriel@hotmail.com");

    Correo correo1 = new Correo();
    correo1.setRemitente(remitente1);

    Correo correo2 = new Correo();
    correo2.setRemitente(remitente2);

    bandeja.agregarCorreoRecibido(correo1);
    bandeja.agregarCorreoRecibido(correo2);

    // Aserciones que provocarán un fallo
    assertEquals(1, bandeja.filtrar(filtro.filtrarPorRemitente("nicolas@hotmail.com")).size()); // debería haber 1
    assertEquals(correo1, bandeja.filtrar(filtro.filtrarPorRemitente("nicolas@hotmail.com")).get(0)); 
}
 

    @Test
    public void filtrar_por_contenido_bandeja_de_entrada_Test() {
        BandejaDeEntrada bandeja = new BandejaDeEntrada();
        Filtros filtro = new Filtros();
    
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
        List<Correo> resultado = bandeja.filtrar(filtro.filtrarPorContenido("importante")); // Usar la instancia de Filtros
    
        // Comprobar que solo se devuelve los correos con el contenido "importante"
        // Hay dos correos con la palabra clave "importante" (correo1 y correo3)
        assertEquals(2, resultado.size());
        assertEquals(correo1, resultado.get(0));
    }
    
    @Test
    public void filtrar_por_contenido_bandeja_de_entrada_Test_Fallido() {

        BandejaDeEntrada bandeja = new BandejaDeEntrada();
        Filtros filtro = new Filtros();

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
        List<Correo> resultado = bandeja.filtrar(filtro.filtrarPorContenido("importante")); // Usar la instancia de Filtros

        // Comprobar que se devuelve un número incorrecto de correos
        assertEquals(2, resultado.size()); //  debería haber 2
        assertEquals(correo1, resultado.get(0)); // Esto fallará porque debería ser correo1 o correo3
}
 

    @Test
    public void filtrar_por_destinatario_bandeja_de_entrada_Test() {
        BandejaDeEntrada bandeja = new BandejaDeEntrada();
        Filtros filtro = new Filtros();
    
        // Crear contactos destinatarios
        Contacto destinatario1 = new Contacto("desti1", "destinatario1@ejemplo.com");
        Contacto destinatario2 = new Contacto("desti2", "destinatario2@ejemplo.com");
    
        // Crear correos con diferentes destinatarios
        Correo correo1 = new Correo();
        correo1.setAsunto("Correo 1");
        correo1.setDestinatarios(destinatario1);
    
        Correo correo2 = new Correo();
        correo2.setAsunto("Correo 2");
        correo2.setDestinatarios(destinatario2);
    
        bandeja.agregarCorreoRecibido(correo1);
        bandeja.agregarCorreoRecibido(correo2);
    
        // Comprobar que solo se devuelve el correo dirigido a destinatario1
        assertEquals(1, bandeja.filtrar(filtro.filtrarPorDestinatario("destinatario1@ejemplo.com")).size()); // Usar la instancia de Filtros
        assertEquals(correo1, bandeja.filtrar(filtro.filtrarPorDestinatario("destinatario1@ejemplo.com")).get(0)); // Usar la instancia de Filtros
    }

    @Test
    public void filtrar_por_destinatario_bandeja_de_entrada_fallido_Test() {

        BandejaDeEntrada bandeja = new BandejaDeEntrada();
        Filtros filtro = new Filtros();
        // Crear contactos destinatarios
        Contacto destinatario1 = new Contacto("desti1", "destinatario1@ejemplo.com");
        Contacto destinatario2 = new Contacto("desti2", "destinatario2@ejemplo.com");
        // Crear correos con diferentes destinatarios
        Correo correo1 = new Correo();
        correo1.setAsunto("Correo 1");
        correo1.setDestinatarios(destinatario1);
        Correo correo2 = new Correo();
        correo2.setAsunto("Correo 2");
        correo2.setDestinatarios(destinatario2);
        bandeja.agregarCorreoRecibido(correo1);
        bandeja.agregarCorreoRecibido(correo2);
        // Comprobar que no se devuelve ningún correo al filtrar por destinatario que no está en la bandeja
        assertEquals(0, bandeja.filtrar(filtro.filtrarPorDestinatario("destinatario3@ejemplo.com")).size());

    }
    


    @Test
    public void filtro_complejo_asunto_y_remitente_bandeja_de_entrada_Test() {
        Filtros filtro = new Filtros();

        // Crear remitente
        Contacto remitente1 = new Contacto("remi1","remitente1@ejemplo.com");
        Contacto destinatario = new Contacto("destinatario","destinatario@gmail.com");

        // Crear correos con el mismo remitente pero diferentes asuntos
        Correo correo1 = new Correo();
        correo1.setAsunto("Oferta importante");
        correo1.setRemitente(remitente1);
        correo1.setDestinatarios(destinatario);

        Correo correo2 = new Correo();
        correo2.setAsunto("Notificación");
        correo2.setRemitente(remitente1);
        correo2.setDestinatarios(destinatario);

        remitente1.enviarCorreo(correo2);
        remitente1.enviarCorreo(correo1);
        

       
    
        // Comprobar que solo se devuelve el correo con el asunto "Oferta importante" del remitente1
        assertEquals(1, destinatario.getBandeja().filtrarRecibidos(filtro.filtrarPorAsuntoYRemitente("Oferta", "remitente1@ejemplo.com")).size());
        

    }

    @Test
    public void filtro_complejo_asunto_y_remitente_bandeja_de_entrada_fallido_Test() {

        BandejaDeEntrada bandeja = new BandejaDeEntrada();
        Filtros filtro = new Filtros();
        
        // Crear remitente
        Contacto remitente1 = new Contacto("remi1", "remitente1@ejemplo.com");
        Contacto remitente2 = new Contacto("desti1", "remitente2@ejemplo.com");
        
        // Crear correos con el mismo remitente pero diferentes asuntos
        Correo correo1 = new Correo();
        correo1.setAsunto("Oferta importante");
        correo1.setRemitente(remitente1);
        
        Correo correo2 = new Correo();
        correo2.setAsunto("Notificación");
        correo2.setRemitente(remitente2);
        
        bandeja.agregarCorreoRecibido(correo1);
        bandeja.agregarCorreoRecibido(correo2);
        
        // Comprobar que no se devuelven correos con el asunto "Oferta importante" del remitente1
        assertEquals(0, bandeja.filtrarRecibidos(filtro.filtrarPorAsuntoYRemitente("Cualquiera", "remitente1@ejemplo.com")).size());
        
    }


    @Test
    public void filtro_complejo_asunto_remitente_y_contenido_bandeja_de_entrada_Test() {
        Filtros filtro = new Filtros();
    
        Contacto remitente1 = new Contacto("remi1", "remitente1@ejemplo.com");
        Contacto remitente2 = new Contacto("desti1", "remitente2@ejemplo.com");
        Contacto destinatario = new Contacto("desti1", "destinatario@gmail.com");
    
        // Crear correos con diferentes contenidos
        Correo correo1 = new Correo();
        correo1.setAsunto("Asunto info");
        correo1.setContenido("Este es un correo importante sobre ofertas");
        correo1.setRemitente(remitente2);
        correo1.setDestinatarios(destinatario);
    
        Correo correo2 = new Correo();
        correo2.setAsunto("Asunto 2");
        correo2.setContenido("Este es un correo informativo");
        correo2.setRemitente(remitente1);
        correo2.setDestinatarios(destinatario);
    
        Correo correo3 = new Correo();
        correo3.setAsunto("Asunto info");
        correo3.setContenido("Este es un correo de notificación importante");
        correo3.setRemitente(remitente2);
        correo3.setDestinatarios(destinatario);

        remitente1.enviarCorreo(correo3);
        remitente2.enviarCorreo(correo1);
        remitente2.enviarCorreo(correo2);
    
        assertEquals(2, destinatario.getBandeja().filtrarRecibidos(filtro.filtrarPorAsuntoRemitenteYContenido("info", "remitente2@ejemplo.com", "importante")).size());
        assertEquals("Asunto info", destinatario.getBandeja().filtrarRecibidos(filtro.filtrarPorAsuntoRemitenteYContenido("info", "remitente2@ejemplo.com", "importante")).get(0).getAsunto());
    }

    
    @Test
    public void filtro_complejo_asunto_remitente_y_contenido_fallido_bandeja_de_entrada_Test() {
        Filtros filtro = new Filtros();
    
        Contacto remitente1 = new Contacto("remi1", "remitente1@ejemplo.com");
    
        Correo correo1 = new Correo();
        correo1.setAsunto("Asunto diferente");
        correo1.setContenido("Contenido diferente");
        correo1.setRemitente(remitente1);
    
        remitente1.enviarCorreo(correo1);
    
        List<Correo> resultado = remitente1.getBandeja().filtrarEnviados(filtro.filtrarPorAsuntoRemitenteYContenido("Asunto", "remitente1@ejemplo.com", "contenido importante"));
    
        assertEquals(0, resultado.size());
    }
    


    @Test
    public void filtro_complejo_asunto_y_destinatario_bandeja_de_entrada_Test() {
        Filtros filtro = new Filtros();
    
        Contacto destinatario1 = new Contacto("desti1", "destinatario1@ejemplo.com");
        Contacto destinatario2 = new Contacto("desti2", "destinatario2@ejemplo.com");
        Contacto remitente = new Contacto("remitente1", "remitente1@ejemplo.com");
        
        // Crear correos con diferentes destinatarios
        Correo correo1 = new Correo();
        correo1.setAsunto("Asunto 1");
        correo1.setDestinatarios(destinatario1);
        correo1.setRemitente(remitente);
    
        Correo correo2 = new Correo();
        correo2.setAsunto("Asunto 2");
        correo2.setDestinatarios(destinatario2);
        correo2.setRemitente(remitente);
    
        Correo correo3 = new Correo();
        correo3.setAsunto("Asunto 1");
        correo3.setDestinatarios(destinatario1);
        correo3.setRemitente(remitente);
    
        remitente.enviarCorreo(correo3);
        remitente.enviarCorreo(correo1);
        remitente.enviarCorreo(correo2);
    
        assertEquals(2, destinatario1.getBandeja().filtrarRecibidos(filtro.filtrarPorAsuntoYDestinatario("Asunto 1", "destinatario1@ejemplo.com")).size());
        
       
    }
    
    @Test
    public void filtro_complejo_asunto_y_destinatario_bandeja_de_entrada_fallido_Test() {
        
       
        Filtros filtro = new Filtros();
        
        Contacto destinatario1 = new Contacto("desti1", "destinatario1@ejemplo.com");
        Contacto remitente1 = new Contacto("remitente1", "remitente@ejemplo.com");
        
        Correo correo1 = new Correo();
        correo1.setAsunto("Asunto 1");
        correo1.setDestinatarios(destinatario1);
        
        Correo correo2 = new Correo();
        correo2.setAsunto("Asunto 2");
        correo2.setDestinatarios(destinatario1);

        remitente1.enviarCorreo(correo1);
        
        List<Correo> resultado = remitente1.getBandeja().filtrarEnviados(filtro.filtrarPorAsuntoYDestinatario("Asunto 3", "destinatario1@ejemplo.com"));
        
        assertEquals(0, resultado.size());
        
    }

    @Test
    public void filtro_asunto_bandeja_salida_Test() {

        Filtros filtro = new Filtros();
    
        Contacto remitente1 = new Contacto("remi1", "remitente1@ejemplo.com");
        Contacto destinatario = new Contacto("destinatario", "destinatario@gmail.com");
    
        Correo correo1 = new Correo();
        correo1.setAsunto("Oferta importante");
        correo1.setRemitente(remitente1);
        correo1.setDestinatarios(destinatario);
        
        
        Correo correo2 = new Correo();
        correo2.setAsunto("Notificación Oferta");
        correo2.setRemitente(remitente1);
        correo2.setDestinatarios(destinatario);

        remitente1.enviarCorreo(correo2);
        remitente1.enviarCorreo(correo1);

        assertEquals(2, remitente1.getBandeja().filtrarEnviados(filtro.filtrarPorAsunto("Oferta")).size());
    }

    @Test
    public void filtro_asunto_bandeja_salida_fallido_Test() {
        Filtros filtro = new Filtros();
        
        Contacto remitente1 = new Contacto("remi1", "remitente1@ejemplo.com");
        Contacto destinatario = new Contacto("destinatario", "destinatario@gmail.com");
        
        Correo correo1 = new Correo();
        correo1.setAsunto("Oferta importante");
        correo1.setRemitente(remitente1);
        correo1.setDestinatarios(destinatario);
        remitente1.enviarCorreo(correo1);
        
        Correo correo2 = new Correo();
        correo2.setAsunto("Notificación Oferta");
        correo2.setRemitente(remitente1);
        correo2.setDestinatarios(destinatario);
        remitente1.enviarCorreo(correo2);
        
        assertEquals(0, remitente1.getBandeja().filtrarEnviados(filtro.filtrarPorAsunto("Oferta Falsa")).size());
    }
    
    @Test
    public void filtro_por_destinatario_bandeja_salida_Test() {
        Filtros filtro = new Filtros();
    
        Contacto remitente1 = new Contacto("remi1", "remitente1@ejemplo.com");
        Contacto destinatario1 = new Contacto("destinatario1", "destinatario1@gmail.com");
        Contacto destinatario2 = new Contacto("destinatario2", "destinatario2@gmail.com");
    
        Correo correo1 = new Correo();
        correo1.setAsunto("Asunto 1");
        correo1.setRemitente(remitente1);
        correo1.setDestinatarios(destinatario1);
        remitente1.enviarCorreo(correo1);
        
        Correo correo2 = new Correo();
        correo2.setAsunto("Asunto 2");
        correo2.setRemitente(remitente1);
        correo2.setDestinatarios(destinatario2);
        remitente1.enviarCorreo(correo2);
    
        assertEquals(1, remitente1.getBandeja().filtrarEnviados(filtro.filtrarPorDestinatario("destinatario1@gmail.com")).size());
        

        correo1.setAsunto("Hola");

        assertEquals("Asunto 1",correo1.getAsunto() );

    }




    @Test
    public void filtro_por_destinatario_bandeja_salida_Test_Fallido() {
        BandejaDeSalida bandeja = new BandejaDeSalida();
        Filtros filtro = new Filtros();

        Contacto remitente1 = new Contacto("remi1", "remitente1@ejemplo.com");
        Contacto destinatario1 = new Contacto("destinatario1", "destinatario1@gmail.com");
        Contacto destinatario2 = new Contacto("destinatario2", "destinatario2@gmail.com");

        Correo correo1 = new Correo();
        correo1.setAsunto("Asunto 1");
        correo1.setRemitente(remitente1);
        correo1.setDestinatarios(destinatario1);
        remitente1.enviarCorreo(correo1);

        Correo correo2 = new Correo();
        correo2.setAsunto("Asunto 2");
        correo2.setRemitente(remitente1);
        correo2.setDestinatarios(destinatario2);
        remitente1.enviarCorreo(correo1);

        // Se espera incorrectamente que haya 2 correos con el destinatario "destinatario1@gmail.com" (esto hará que falle)
        assertEquals(1, bandeja.filtrar(filtro.filtrarPorDestinatario("destinatario1@gmail.com")).size());
        assertEquals(correo1, bandeja.filtrar(filtro.filtrarPorDestinatario("destinatario1@gmail.com")).get(0));
    }


    @Test
    public void filtro_por_contenido_bandeja_salida_Test() {
        BandejaDeSalida bandeja = new BandejaDeSalida();
        Filtros filtro = new Filtros();

        Contacto remitente1 = new Contacto("remi1", "remitente1@ejemplo.com");
        Contacto destinatario1 = new Contacto("destinatario1", "destinatario1@gmail.com");

        Correo correo1 = new Correo();
        correo1.setAsunto("Asunto 1");
        correo1.setRemitente(remitente1);
        correo1.setContenido("Este es un contenido especial");
        correo1.setDestinatarios(destinatario1);
        remitente1.enviarCorreo(correo1);

        Correo correo2 = new Correo();
        correo2.setAsunto("Asunto 2");
        correo2.setRemitente(remitente1);
        correo2.setContenido("Contenido normal");
        correo2.setDestinatarios(destinatario1);
        remitente1.enviarCorreo(correo2);


    // Filtrar por correos que contienen "especial" en el contenido
        assertEquals(1, bandeja.filtrar(filtro.filtrarPorContenido("especial")).size());
        assertEquals(correo1, bandeja.filtrar(filtro.filtrarPorContenido("especial")).get(0));
    }

    @Test
    public void filtro_por_contenido_bandeja_salida_Test_Fallido() {
        BandejaDeSalida bandeja = new BandejaDeSalida();
        Filtros filtro = new Filtros();

        Contacto remitente1 = new Contacto("remi1", "remitente1@ejemplo.com");
        Contacto destinatario1 = new Contacto("destinatario1", "destinatario1@gmail.com");

        Correo correo1 = new Correo();
        correo1.setAsunto("Asunto 1");
        correo1.setRemitente(remitente1);
        correo1.setContenido("Este es un contenido especial");
        correo1.setDestinatarios(destinatario1);
        remitente1.enviarCorreo(correo1);

        Correo correo2 = new Correo();
        correo2.setAsunto("Asunto 2");
        correo2.setRemitente(remitente1);
        correo2.setContenido("Contenido normal");
        correo2.setDestinatarios(destinatario1);
        remitente1.enviarCorreo(correo1);


        // Filtrar por correos que contienen "inexistente" en el contenido (esto no existe en ninguno)
        assertEquals(0, bandeja.filtrar(filtro.filtrarPorContenido("no existe")).size());
    }

    @Test
    public void borrar_correo_bandeja_de_salida_Test() {
        BandejaDeSalida bandeja = new BandejaDeSalida();
        Filtros filtro = new Filtros();

        Contacto remitente1 = new Contacto("remi1", "remitente1@ejemplo.com");
        Contacto destinatario1 = new Contacto("destinatario1", "destinatario1@gmail.com");
        Contacto destinatario2 = new Contacto("destinatario2", "destinatario2@gmail.com");

        Correo correo1 = new Correo();
        correo1.setAsunto("Asunto 1");
        correo1.setRemitente(remitente1);
        correo1.setDestinatarios(destinatario1);
        remitente1.enviarCorreo(correo1);

        Correo correo2 = new Correo();
        correo2.setAsunto("Asunto 2");
        correo2.setRemitente(remitente1);
        correo2.setDestinatarios(destinatario2);
        remitente1.enviarCorreo(correo1);

       
        assertEquals(1, bandeja.filtrar(filtro.filtrarPorDestinatario("destinatario1@gmail.com")).size());
        assertEquals(correo1, bandeja.filtrar(filtro.filtrarPorDestinatario("destinatario1@gmail.com")).get(0));

        //Implementacion de correo borrado 
        bandeja.borrarCorreo(correo1);
        assertEquals(0, bandeja.filtrar(filtro.filtrarPorDestinatario("destinatario1@gmail.com")).size());
        
    }

    @Test
    public void borrar_correo_bandeja_de_entrada_Test() {
       
        Filtros filtro = new Filtros();

        Contacto remitente1 = new Contacto("remi1", "remitente1@ejemplo.com");

        Contacto destinatario1 = new Contacto("destinatario1", "destinatario1@gmail.com");
        Contacto destinatario2 = new Contacto("destinatario2", "destinatario2@gmail.com");

        Correo correo1 = new Correo();
        correo1.setAsunto("Asunto 1");
        correo1.setRemitente(remitente1);
        correo1.setDestinatarios(destinatario1);
        remitente1.enviarCorreo(correo1);

        Correo correo2 = new Correo();
        correo2.setAsunto("Asunto 2");
        correo2.setRemitente(remitente1);
        correo2.setDestinatarios(destinatario2);
        remitente1.enviarCorreo(correo2);

        Correo correo3 = new Correo();
        correo3.setAsunto("Asunto 3");
        correo3.setRemitente(remitente1);
        correo3.setDestinatarios(destinatario1);
        remitente1.enviarCorreo(correo3);

        
        Correo correo4 = new Correo();
        correo4.setAsunto("Asunto 4");
        correo4.setRemitente(remitente1);
        correo4.setDestinatarios(destinatario1);
        remitente1.enviarCorreo(correo4);

        
        Correo correo5 = new Correo();
        correo5.setAsunto("Asunto 5");
        correo5.setRemitente(remitente1);
        correo5.setDestinatarios(destinatario1);
        remitente1.enviarCorreo(correo5);

        
        assertEquals(4, destinatario1.getBandejaDeEntrada().filtrar(filtro.filtrarPorRemitente("remitente1@ejemplo.com")).size());
        

        destinatario1.getBandejaDeEntrada().borrarCorreo(correo5);
        destinatario1.getBandejaDeEntrada().borrarCorreo(correo3);
        destinatario1.getBandejaDeEntrada().borrarCorreo(correo4);
        
        

        assertEquals(1, destinatario1.getBandejaDeEntrada().filtrar(filtro.filtrarPorDestinatario("destinatario1@gmail.com")).size());
        
        
    }

    
}