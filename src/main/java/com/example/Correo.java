package com.example;
import java.util.ArrayList;
import java.util.Objects; // Para utilizar Objects.hash en hashCode()
   



public class Correo {
    
    private String asunto;
    private String contenido;
    private Contacto remitente;
    private ArrayList<Contacto> destinatarios = new ArrayList<>();

    /*
    Método equals(Object obj)

    Este método compara si dos objetos son iguales en términos de contenido,
    no solo si son la misma instancia en memoria. En este caso,
    la comparación se hace entre dos objetos de tipo Correo.
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; //verifica si this y obj son el mismo objeto en memoria
        if (obj == null || getClass() != obj.getClass()) return false; //Verifica si el objeto obj es null o de una clase diferente
        Correo correo = (Correo) obj;
            return Objects.equals(asunto, correo.asunto) && /*se comparan los atributos que definen si los correos son iguales. 
                                                            En este caso, estás comparando los atributos asunto, contenido, remitente,
                                                             y destinatarios. Usas Objects.equals() para comparar cada uno de estos atributos */

                Objects.equals(contenido, correo.contenido) &&
                Objects.equals(remitente, correo.remitente) &&
                Objects.equals(destinatarios, correo.destinatarios);
}
    //El método hashCode() devuelve un valor numérico (un código hash) que representa de manera única el objeto
    
    /*El método estático Objects.hash() genera un valor hash basado en los valores de los atributos
     que le pasas (asunto, contenido, remitente, y destinatarios).
      Esto garantiza que si dos correos tienen los mismos valores para estos atributos, tendrán el mismo código hash. */
    @Override
    public int hashCode() {
        return Objects.hash(asunto, contenido, remitente, destinatarios);
    }

    

    // Agrega un nuevo destinatario al correo
    
     public ArrayList<Contacto> getDestinatarios(){
        return destinatarios; // Devuelve la lista de destinatarios
    }

   public void agregarDestinatarios(Contacto destinatario){
        this.destinatarios.add(destinatario);
   }

    public String getContenido(){
        return contenido;
    }

    public void setContenido(String contenido){
        this.contenido = contenido;
    }

    public void setAsunto(String asunto){
        this.asunto = asunto;
    }
    public String getAsunto(){
        return asunto;
    }
    
    public void setRemitente(Contacto remitente){
        this.remitente = remitente;
    }

    public Contacto getRemitente(){
        return remitente;
    }


    public Correo clonar() {
        var correoNuevo = new Correo();

        correoNuevo.setAsunto(this.getAsunto());
        correoNuevo.setContenido(this.getContenido());
        correoNuevo.setRemitente(this.getRemitente());
        correoNuevo.destinatarios = new ArrayList<>(this.destinatarios);
        
        return correoNuevo;
    }
    
    
}
