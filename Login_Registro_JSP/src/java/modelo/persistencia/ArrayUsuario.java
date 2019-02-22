/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.persistencia;

import java.util.ArrayList;
import java.util.List;
import modelo.Persona;
import modelo.logica.GestionUsuarios;
import modelo.logica.IUsuarioDAO;

/**
 *
 * @author USUARIO
 */
public class ArrayUsuario implements IUsuarioDAO{
    private List<Persona> registros;
    private static ArrayUsuario instancia=null;
    
    private ArrayUsuario() {
        registros=new ArrayList<>();
    }
    
    public static ArrayUsuario getInstancia(){
        if(instancia==null)
        {
            instancia=new ArrayUsuario();
        }
        return instancia;
    }
    
    public List<Persona> getRegistros() {
        return registros;
    }
    
//    public void add(Persona p) {
//        registros.add(p);
//    }

    @Override
    public boolean guardarUsuario(Persona per) {
        registros.add(per);
        return true;
    }

////    @Override
////    public Persona leerUsuarios() {
////        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
////    }
    
//    public List<Persona> getRegistros() {
//        return registros;
//    }
//    
//    public boolean existe(String email,String pass){
//        boolean compr=false;
//        for(Persona per:registros)
//        {
//            if(email.equals(per.getEmail()) && pass.equals(per.getPassword()))
//            {
//                compr=true;
//            }
//        }
//        if(compr==true)
//        {
//            return true;
//        }
//        else
//        {
//            return false;
//        }
//    }

    @Override
    public boolean leerUsuarios(String em, String pass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
