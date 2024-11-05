package com.example.email;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class EmailClient {
    public static void main(String[] args) {
        // Crear el canal y el stub
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
            .usePlaintext()
            .build();
        EmailServiceGrpc.EmailServiceBlockingStub stub = EmailServiceGrpc.newBlockingStub(channel);

        // Simular el envío de un correo de Juan a María
        EmailRequest emailRequest = EmailRequest.newBuilder()
            .setSubject("Hola María")
            .setBody("¿Cómo estás? Te escribo para saludar.")
            .setFrom("juan@example.com")  // Remitente
            .setTo("maria@example.com")   // Destinatario
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

        channel.shutdown();
    }
}