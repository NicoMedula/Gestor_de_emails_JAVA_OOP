package com.example.email;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

//mvn exec:java -Dexec.mainClass="com.example.email.EmailClient"

public class EmailClient {
    public static void main(String[] args) {
        // Crear el canal y el stub
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
            .usePlaintext()
            .build();
        EmailServiceGrpc.EmailServiceBlockingStub stub = EmailServiceGrpc.newBlockingStub(channel);

        // Simular el envío de un correo de Juan a María
        EmailRequest emailRequest = EmailRequest.newBuilder()
            .setSubject("Hola equipo")
            .setBody("Este es un mensaje para todos.")
            .setFrom("juan@example.com")
            .addTo("maria@example.com")     // Añadir destinatarios individuales
            .addTo("jose@example.com")
            .addTo("ana@example.com")
            .build();


        // Enviar el correo
        System.out.println("\n=== ENVIANDO CORREO ===");
        EmailResponse response = stub.sendEmail(emailRequest);
        System.out.println(response.getMessage());

        // Consultar correos recibidos por María
        System.out.println("\n=== CONSULTANDO BANDEJA DE MARÍA ===");
        GetEmailsRequest getEmailsRequest = GetEmailsRequest.newBuilder()
            .setUser("maria@example.com")
            .build();
        
        stub.getEmails(getEmailsRequest).forEachRemaining(emailResponse -> {
            System.out.println("\nCorreo recibido:");
            System.out.println("De: " + emailResponse.getFrom());
            System.out.println("Asunto: " + emailResponse.getSubject());
            System.out.println("Contenido: " + emailResponse.getBody());

            
        });

        // Consultar correos recibidos por Jose
        System.out.println("\n=== CONSULTANDO BANDEJA DE JOSÉ ===");
        GetEmailsRequest getEmailsRequest2 = GetEmailsRequest.newBuilder()
            .setUser("jose@example.com")
            .build();
        
        stub.getEmails(getEmailsRequest2).forEachRemaining(emailResponse -> {
            System.out.println("\nCorreo recibido:");
            System.out.println("De: " + emailResponse.getFrom());
            System.out.println("Asunto: " + emailResponse.getSubject());
            System.out.println("Contenido: " + emailResponse.getBody());

            
        });

        // Consultar correos recibidos por Ana
        System.out.println("\n=== CONSULTANDO BANDEJA DE ANA ===");
        GetEmailsRequest getEmailsRequest3 = GetEmailsRequest.newBuilder()
            .setUser("ana@example.com")
            .build();
        
        stub.getEmails(getEmailsRequest3).forEachRemaining(emailResponse -> {
            System.out.println("\nCorreo recibido:");
            System.out.println("De: " + emailResponse.getFrom());
            System.out.println("Asunto: " + emailResponse.getSubject());
            System.out.println("Contenido: " + emailResponse.getBody());

            
        });


        channel.shutdown();
    }
}