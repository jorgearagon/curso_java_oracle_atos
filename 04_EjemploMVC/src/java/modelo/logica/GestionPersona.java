/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logica;

import modelo.Persona;
import modelo.persistencia.FicheroPersona;
import modelo.persistencia.JavaJDPersona;

/**
 *
 * @author USUARIO
 */
public class GestionPersona {
    //private Persona per;
    
    private static GestionPersona instancia;
    //private IPersonaDAO daoPersona = FicheroPersona.getInstancia();
    private IPersonaDAO daoPersona = new JavaJDPersona();
    private GestionPersona() {
    }
    public static GestionPersona getInstacia(){
        if(instancia==null)
        {
            instancia = new GestionPersona();
        }
        return instancia;
    }
    
    public enum TipoResultado{OK, SIN_VALORES, EDAD_MAL, ERR_IO};
    private boolean validarDatosPersona(String nombre, String edad){
        //return !nombre.equals("") && !edad.equals("");
        if(nombre.equals("") || edad.equals(""))
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    private boolean validarEdad(String edad){
        return edad.matches("^[1-9][0-9]*$");
    }
    
    public TipoResultado guardarPersona(String nombre, String edad){
        if(validarDatosPersona(nombre, edad))
        {
            if(validarEdad(edad))
            {
                int iEdad = Integer.parseInt(edad);
                //this.per = new Persona(nombre, iEdad);
                if (daoPersona.guardarPersona(new Persona(nombre, iEdad)))
                {
                    return TipoResultado.OK;
                }
                else
                {
                    return TipoResultado.ERR_IO;
                }
                
            }
            else
            {
                return TipoResultado.EDAD_MAL;
            }
        }
        else
        {
            return TipoResultado.SIN_VALORES;
        }
        
    }
    
    public Persona getPersona(){
        return daoPersona.leerPersona();
    }
}
