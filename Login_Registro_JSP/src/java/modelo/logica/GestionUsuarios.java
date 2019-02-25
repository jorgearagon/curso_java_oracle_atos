/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logica;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import modelo.Persona;
import modelo.persistencia.ArrayUsuario;
import modelo.persistencia.JDBCUsuario;

/**
 *
 * @author USUARIO
 */
public class GestionUsuarios {
    private static GestionUsuarios instancia=null;
    private List<Persona> registros;
    private IUsuarioDAO daoUsuarioDAO = new JDBCUsuario();

    private GestionUsuarios() {
    }
    
    public static GestionUsuarios getInstancia(){
        if(instancia==null)
        {
            instancia=new GestionUsuarios();
        }
        return instancia;
    }
    
    public enum TipoResultado{OK, NOM_MAL, EDAD_MAL, ERR_IO, EMAIL_MAL, PASS_MAL, SIN_VALORES, USU_NOEXISTE};
    
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
        Pattern pc=Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,15}");
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
        try
        {
            int iEdad = Integer.parseInt(edad);
            if(validarNombre(nombre))
            {
                if(validarEdad(edad) && iEdad >= 18)
                {
                    if(validarEmail(email))
                    {
                        if(validarPass(pass))
                        {
                            //return TipoResultado.OK;

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
        }catch(NumberFormatException nfe){
            System.out.println(nfe.getMessage());
            return TipoResultado.EDAD_MAL;
        }
        
    }
    
    private boolean validarDatosUsuario(String email, String pass){
        //return !nombre.equals("") && !edad.equals("");
        if(email.equals("") || pass.equals(""))
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public TipoResultado leerUsuario(String email, String pass){
        if(validarDatosUsuario(email, pass))
        {
            if (daoUsuarioDAO.leerUsuarios(email, pass))
            {
                return TipoResultado.OK;
            }
            else
            {
                return TipoResultado.USU_NOEXISTE;
            }
        }
        else
        {
            return TipoResultado.SIN_VALORES;
        }
    }
    
    public TipoResultado actualizarUsuario(String nombre, String edad, String email, String pass, String email_actual){
//        if(validarDatosUsuario(email, pass))
//        {
        try
        {
            int iEdad2 = Integer.parseInt(edad);
            if(validarNombre(nombre))
            {
                if(validarEdad(edad) && iEdad2 >= 18)
                {
                    if(validarEmail(email))
                    {
                        if(validarPass(pass))
                        {
                            
                            if (daoUsuarioDAO.actualizarUsuario(new Persona(nombre, iEdad2, email, pass), email_actual))
                            {
                                return TipoResultado.OK;
                            }
                            else
                            {
                                return TipoResultado.USU_NOEXISTE;
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
        }catch(NumberFormatException nfe){
            System.out.println(nfe.getMessage());
            return TipoResultado.EDAD_MAL;
        }
//        }
//        else
//        {
//            return TipoResultado.SIN_VALORES;
//        }
    }
    
    public TipoResultado eliminarUsuario(String email){
        if (daoUsuarioDAO.eliminarUsuario(email))
        {
            return TipoResultado.OK;
        }
        else
        {
            return TipoResultado.ERR_IO;
        }
    }
    
    public List<Persona> listarUsuarios(){
        registros=daoUsuarioDAO.listarUsuarios();
        return registros;
    }
            
}
