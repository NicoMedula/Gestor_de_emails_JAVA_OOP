package com.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 

S - Principio de Responsabilidad Única (Single Responsibility Principle)
    Cada clase debería tener una única responsabilidad.

O - Principio de Abierto/Cerrado (Open/Closed Principle)
    El código debería estar abierto a la extensión pero cerrado a la modificación.

L - Principio de Sustitución de Liskov (Liskov Substitution Principle)
    Los objetos de una subclase deben poder reemplazar a los de su clase base sin alterar el comportamiento del programa.

I - Principio de Segregación de Interfaces (Interface Segregation Principle)
    Las interfaces deben ser específicas para cada cliente, y no obligar a implementar métodos que no se necesiten.
    
D - Principio de Inversión de Dependencias (Dependency Inversion Principle)
    Las clases deberían depender de abstracciones (interfaces) y no de implementaciones concretas.

*/ 

public class Contacto extends Casilla {

    private String nombre;
    private String email;
    private BandejaDeEntrada bandejaDeEntrada;
   

    //Expresion regular para verificar el email
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-z]{2,6}$";
    
    public Contacto(String nombre, String email){

        if (!esEmailValido(email)) {
            throw new IllegalArgumentException("El email ingresado no es válido");
        }
        this.nombre=nombre;
        this.email=email;
        this.bandejaDeEntrada = new BandejaDeEntrada();
        
    }

    //Retorna la lista de mail recibidos
    public BandejaDeEntrada getBandejaDeEntrada(){
        return bandejaDeEntrada;
    }

    
    //Metodo que valida el email
    private boolean esEmailValido(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public String getNombre(){
        return nombre;
    }

    public String getEmail(){
        return email;
    }
    
}


