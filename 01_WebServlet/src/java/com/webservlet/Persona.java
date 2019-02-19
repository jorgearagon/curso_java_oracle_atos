/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservlet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class Persona {
    private String nombre;
    private int edad;
    private String email;
    private String password;
    List<Persona> registros = new ArrayList<>();

    public Persona(String nombre, int edad, String email, String password) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
        this.password = password;
    }

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    
    
    
}
