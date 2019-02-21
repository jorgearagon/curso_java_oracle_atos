/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logica;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author USUARIO
 */
public class ComprobarParametros {
    public static boolean comprEmail(String em){
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
    
    public static boolean comprPass(String pass){
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
}
