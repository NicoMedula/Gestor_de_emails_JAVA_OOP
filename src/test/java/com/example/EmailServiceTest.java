package com.example;

import com.example.email.EmailServiceGrpc;
import com.example.email.EmailServiceImpl;
import com.example.email.EmailRequest;
import com.example.email.EmailResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

class EmailServiceTest {

    private static ManagedChannel channel;
    private static EmailServiceGrpc.EmailServiceBlockingStub blockingStub;

    @BeforeAll
    static void setup() {
       
        channel = ManagedChannelBuilder.forAddress("localhost", 50051) 
                .usePlaintext() 
                .build();

        blockingStub = EmailServiceGrpc.newBlockingStub(channel);
    }

    @AfterAll
    static void teardown() {
        // Cerrar el canal después de las pruebas
        channel.shutdownNow();
    }

    @Test
    void enviar_mail_con_gRPC_Test() {
        EmailServiceImpl emailService = new EmailServiceImpl();
        
        String subject = "Asunto del correo";
        String body = "Contenido del correo";
        String to = "nicolas@gmail.com";
        String from = "urielsab@gmail.com";

       
        Contacto destinatario = new Contacto("Nicolas",to); 
        Contacto remitente = new Contacto("Uriel",from);
        emailService.registrarContacto(remitente);
        emailService.registrarContacto(destinatario);
        
        Correo correo = new Correo(); 
        correo.setRemitente(remitente);
        correo.agregarDestinatarios(destinatario);
        correo.setAsunto(subject);
        correo.setContenido(body);

      

        // Enviar el correo utilizando el servicio gRPC
        EmailRequest request = EmailRequest.newBuilder()
                .setSubject(correo.getAsunto()) // Método para obtener el asunto
                .setBody(correo.getContenido())   // Método para obtener el contenido
                .setTo(correo.getDestinatarios().get(0).getEmail()) // Método para obtener el email del destinatario
                .setFrom(correo.getRemitente().getEmail()) // Método para obtener el email del remitente
                .build();

        // Enviar la solicitud gRPC
        EmailResponse response = blockingStub.sendEmail(request);

        // Verificar la respuesta
        assertEquals(true, response.getSuccess());
        assertEquals("Correo enviado exitosamente a " + to, response.getMessage());

        //List<Correo> correosRecibidos = destinatario.getBandeja().getCorreosRecibidos();
        //assertEquals(1, correosRecibidos.size());
        //assertEquals(correo.getAsunto(), correosRecibidos.get(0).getAsunto());
        //assertEquals(correo.getContenido(), correosRecibidos.get(0).getContenido());

        
    }

    
}
