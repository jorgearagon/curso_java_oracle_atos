/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logica;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import modelo.Persona;
import modelo.persistencia.ArrayUsuario;

/**
 *
 * @author USUARIO
 */
public class GestionUsuarios {
    private static GestionUsuarios instancia=null;
    private IUsuarioDAO daoUsuarioDAO = ArrayUsuario.getInstancia();

    private GestionUsuarios() {
    }
    
    public static GestionUsuarios getInstancia(){
        if(instancia==null)
        {
            instancia=new GestionUsuarios();
        }
        return instancia;
    }
    
    public enum TipoResultado{OK, NOM_MAL, EDAD_MAL, ERR_IO, EMAIL_MAL, PASS_MAL};
    
    private boolean validarEmail(String em){
        Pattern pc=Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@" +
        "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$");
        Matcher m=pc.matcher(em);
        if(m.matches())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    private boolean validarPass(String pass){
        Pattern pc=Pattern.compile("^[A-Za-z\\d$@$!%*?&]{8,15}$");
        Matcher m=pc.matcher(pass);
        if(m.matches())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    private boolean validarEdad(String edad){
        return edad.matches("^[1-9][0-9]*$");
    }
    
    private boolean validarNombre(String nom){
        return nom.matches("^[A-Z][A-Za-z]*$");
    }
    
    public TipoResultado guardarUsuario(String nombre, String edad, String email, String pass){
        if(validarNombre(nombre))
        {
            if(validarEdad(edad))
            {
                if(validarEmail(email))
                {
                    if(validarPass(pass))
                    {
                        //return TipoResultado.OK;
                        int iEdad = Integer.parseInt(edad);
//                        //this.per = new Persona(nombre, iEdad);
                        if (daoUsuarioDAO.guardarUsuario(new Persona(nombre, iEdad, email, pass)))
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
                        return TipoResultado.PASS_MAL;
                    }
                }
                else
                {
                    return TipoResultado.EMAIL_MAL;
                }
                
            }
            else
            {
                return TipoResultado.EDAD_MAL;
            }
        }
        else
        {
            return TipoResultado.NOM_MAL;
        }
        
    }
}
