/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modpruebas;

import java.util.ArrayList;
import modelo.Usuario;
import modelo.logica.ServicioUsuarios;

/**
 *
 * @author USUARIO
 */
public class Main {
    
    static void mostrarResultado(ServicioUsuarios.Resultado res, String nombre){
        System.out.print(" - Prueba "+nombre);
        switch (res){
            case CamposMal:
                System.out.println("Campos Mal");
                break;
            case ErrorDB:
                System.out.println("Error DB");
                break;
            case NoLogin:
                System.out.println("Error No Login");
                break;
            case Ok:
                System.out.println("PRUEBA CORRECTA");
                break;
        }
    }
    
    static void listar(){
        ArrayList<Usuario> todos = ServicioUsuarios.getInstancia().obtenerTodos();
        
        System.out.println("ServicioUsuarios.getInsancia().obtenerTodos():");
        todos.stream().forEach((u) -> {
            System.out.println(" - "+u.getId()
                    + ", " + u.getNombre()
                    + ", " + u.getEdad()
                    + ", " + u.getEmail()
                    + ", " + u.getPassword());
        });
                
                
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Probando modulo modelo:");
        System.out.println("DATOS NO VALIDOS");
        mostrarResultado(ServicioUsuarios.getInstancia().add("Aaaa Aaaa", "10", "", ""),
                "Usuario no válido");
        mostrarResultado(ServicioUsuarios.getInstancia().add("Aaaa Aaaa", "20", "xx@xx", ""),
                "Usuario no válido");
        mostrarResultado(ServicioUsuarios.getInstancia().add("Aaaa Aaaa", "22", "aaa@aaa.com", ""),
                "Usuario no válido");
        System.out.println("DATOS VALIDOS");
        mostrarResultado(ServicioUsuarios.getInstancia().add("Aaaa Aaaa", "22", "aaa@aaa.com", "aaa"),
                "Usuario válido");
        mostrarResultado(ServicioUsuarios.getInstancia().add("Bbbb Bbbb", "33", "bbb@bbb.com", "bbb"),
                "Usuario válido");
        mostrarResultado(ServicioUsuarios.getInstancia().add("Cccc Cccc", "44", "ccc@ccc.com", "ccc"),
                "Usuario válido");
        listar();
        mostrarResultado(ServicioUsuarios.getInstancia().add("Cccc Cccc", "44", "ccc@ccc.com", "ccc"),
                "Usuario REPETIDO");
        Usuario usu = ServicioUsuarios.getInstancia().obtenerUno("ccc@ccc.com");
        mostrarResultado(ServicioUsuarios.getInstancia().modificar(usu.getId(),"CcccMM CcccMM", "55", "ccc@ccc.com", "ccc"),
                "modificar CcccMM CcccMM");
        mostrarResultado(ServicioUsuarios.getInstancia().eliminar("bbb@bbb.com"),
                "eliminar bbb");
        mostrarResultado(ServicioUsuarios.getInstancia().validaLoginUsuario("aaa@aaa.com", "aaa"),
                "validaLoginUsuario aaa");
        listar();
        mostrarResultado(ServicioUsuarios.getInstancia().eliminar("ccc@ccc.com"),
                "eliminar ccc");
        mostrarResultado(ServicioUsuarios.getInstancia().eliminar("aaa@aaa.com"),
                "eliminar aaa");
    }
    
}
