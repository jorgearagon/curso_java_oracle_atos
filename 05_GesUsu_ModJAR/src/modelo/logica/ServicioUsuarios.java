/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logica;

import java.util.ArrayList;
import modelo.Usuario;
import modelo.persistencia.DerbyDBUsuario;

/**
 *
 * @author USUARIO
 */
public class ServicioUsuarios {

    IUsuarioDAO persistencia = new DerbyDBUsuario();
    public enum Resultado { Ok, CamposMal, NoLogin, ErrorDB };
    private static final ServicioUsuarios instancia = new ServicioUsuarios();
    private ServicioUsuarios() {
        persistencia = new DerbyDBUsuario();
    }

    public static ServicioUsuarios getInstancia() {
        return instancia;
    }
    
    public Usuario crearUsuarioValido(int id, String nom, String strEdad, String email, String password){
        if(!nom.isEmpty() && !strEdad.isEmpty() && !email.isEmpty() && !password.isEmpty())
        {
            if(strEdad.matches("^[1-9][0-9]*$"))
            {
                try{
                    int iEdad = 0;
                    iEdad = Integer.parseInt(strEdad);
                    if(iEdad>18)
                    {
                        if(email.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$"))
                        {
                            return new Usuario(id, nom, iEdad, email, password);
                        }
                    }
                }catch(NumberFormatException nfe){
                    return null;
                }
            }
        }
        return null;
    }

    public Resultado add(String nom, String strEdad, String email, String passwd) {
        Usuario nuevoUsu = crearUsuarioValido(0, nom, strEdad, email, passwd);
        if (nuevoUsu!=null) 
        {
            if(this.persistencia.crear(nuevoUsu))
            {
                return Resultado.Ok;
            }
            else
            {
                return Resultado.ErrorDB;
            }
        }
        else
        {
            return Resultado.CamposMal;
        }
        
    }
    
    public ArrayList<Usuario> obtenerTodos() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        listaUsuarios=this.persistencia.obtenerTodos();
        return listaUsuarios;
    }
    
    public Usuario obtenerUno(String email){
        if(!email.isEmpty())
        {
            return this.persistencia.obtenerUno(email);
        }
        return null;
    }
    
    public Resultado modificar(int id, String nom, String strEdad, String email, String passwd){
        Usuario nuevoUsu = crearUsuarioValido(id, nom, strEdad, email, passwd);
        if (nuevoUsu!=null) 
        {
            if(this.persistencia.modificar(nuevoUsu))
            {
                return Resultado.Ok;
            }
            else
            {
                return Resultado.ErrorDB;
            }
        }
        else
        {
            return Resultado.CamposMal;
        }
    }
    
    public Resultado eliminar(String email){
        if(!email.isEmpty())
        {
            if(this.persistencia.eliminar(email))
            {
                return Resultado.Ok;
            }
            else
            {
                return Resultado.ErrorDB;
            }
        }
        else
        {
            return Resultado.CamposMal;
        }   
    }
    
    public Resultado validaLoginUsuario(String email, String password){
        if(!email.isEmpty() && !password.isEmpty())
        {
            for(Usuario usu : obtenerTodos())
            {
                if (usu.getEmail().equals(email) && usu.getPassword().equals(password)) 
                {
                    return Resultado.Ok;
                }
            }
            return Resultado.NoLogin;
        }
        else
        {
            return Resultado.CamposMal;
        }
        
    }

   /* public Resultado add(String nom, int edad, String email, String passwd) {

        if ( !nom.isEmpty() && edad > 18 && email != "" && passwd != "") {
            Usuario nuevoUsu = new Usuario(0, nom, edad, email, passwd);
            this.persistencia.crear(nuevoUsu);
            return Resultado.Ok;
        } else {
            return Resultado.CamposMal;
        }
    }*/
//    public ArrayList<Usuario> listar() {
//        return persistencia.obtenerTodos();
//    }

//    public Usuario validacionPasswd(String email, String passwd) {
//        ArrayList<Usuario> todosUsuarios = persistencia.obtenerTodos();
//        for (Usuario usuario : todosUsuarios) {
//            if (usuario.getEmail().equals(email) && usuario.getPassword().equals(passwd)) {
//                return usuario;
//            }
//        }
//        return null;
//    }
}
