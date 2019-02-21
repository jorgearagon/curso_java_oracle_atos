/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logica;

import modelo.Persona;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class ListadoUsuarios {
    private List<Persona> registros;
    private static ListadoUsuarios instancia=null;

    private ListadoUsuarios() {
        registros=new ArrayList<>();
    }
    
//    public static void setRegistros(Persona p) {
//        registros.add(p);
//    }
    
    public void add(Persona p) {
        registros.add(p);
    }

    public static ListadoUsuarios getInstance() {
        if(instancia==null)
        {
             instancia=new ListadoUsuarios();
        }
        return instancia;
    }

    public List<Persona> getRegistros() {
        return registros;
    }
    
    public boolean existe(String email,String pass){
        boolean compr=false;
        for(Persona per:registros)
        {
            if(email.equals(per.getEmail()) && pass.equals(per.getPassword()))
            {
                compr=true;
            }
        }
        if(compr==true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
