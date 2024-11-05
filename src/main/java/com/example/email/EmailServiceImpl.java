package com.example.email;

import io.grpc.stub.StreamObserver;
import java.util.HashMap;
import java.util.Map;
import com.example.Bandeja;
import com.example.Correo;
import com.example.Contacto;

public class EmailServiceImpl extends EmailServiceGrpc.EmailServiceImplBase {

    // Mapa que asocia emails de contacto con sus bandejas
    private final Map<String, Bandeja> bandejas = new HashMap<>();

    public void registrarContacto(Contacto contacto) {
        // Registrar bandeja para el contacto si no existe
        bandejas.putIfAbsent(contacto.getEmail(), new Bandeja());
    }

    @Override
    public void sendEmail(EmailRequest request, StreamObserver<EmailResponse> responseObserver) {
        System.out.println("\n====== NUEVO CORREO A ENVIAR ======");
        System.out.println("Remitente: " + request.getFrom());
        System.out.println("Asunto: " + request.getSubject());
        System.out.println("Contenido: " + request.getBody());
        System.out.println("Destinatario: " + request.getTo());

        // Crea el remitente y el correo
        Contacto remitente = new Contacto("Remitente", request.getFrom());
        Correo correo = new Correo();
        correo.setAsunto(request.getSubject());
        correo.setContenido(request.getBody());
        correo.setRemitente(remitente);

        // Obtiene o crea la bandeja del destinatario
        Bandeja bandejaDestinatario = bandejas.computeIfAbsent(request.getTo(), k -> new Bandeja());
        bandejaDestinatario.agregarCorreoRecibido(correo); // Añade el correo a la bandeja del destinatario

        // Responder que el correo se envió exitosamente
        EmailResponse response = EmailResponse.newBuilder()
                .setSuccess(true)
                .setMessage("Correo enviado exitosamente a " + request.getTo())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getEmails(GetEmailsRequest request, StreamObserver<EmailResponse> responseObserver) {
        System.out.println("\n====== CONSULTANDO BANDEJA DE CORREOS ======");
        System.out.println("Usuario consultando: " + request.getUser());

        // Recupera la bandeja del usuario
        Bandeja bandeja = bandejas.get(request.getUser());
        
        if (bandeja != null) {
            // Envia cada correo en la bandeja como respuesta
            for (Correo correo : bandeja.getCorreosRecibidos()) {
                EmailResponse emailResponse = EmailResponse.newBuilder()
                        .setFrom(correo.getRemitente().getEmail())
                        .setSubject(correo.getAsunto())
                        .setBody(correo.getContenido())
                        .build();
                responseObserver.onNext(emailResponse);
            }
        } else {
            System.out.println("No hay correos para el usuario: " + request.getUser());
        }

        responseObserver.onCompleted();
        System.out.println("====== FIN DE CONSULTA ======");
    }
}
