/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logica;

import modelo.Persona;

/**
 *
 * @author USUARIO
 */
public class GestionPersona {
    private Persona per;
    public boolean validarDatosPersona(String nombre, String edad){
        return nombre.equals("") || edad.equals("");
    }
    
    public boolean validarEdad(String edad){
        return edad.matches("^[0-9]+$");
    }
    
//    public TipoResultado guardarPersona(String nombre, String edad){
//        if(validarDatosPersona(nombre, edad))
//        {
//            if(validarEdad(edad))
//            {
//                
//            }
//        }
//        this.per = p;
//    }
    
    public Persona getPersona(){
        return per;
    }
}
