/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logica;

import java.util.ArrayList;
import java.util.List;
import modelo.Usuarios;

/**
 *
 * @author USUARIO
 */
public interface IUsuarioDAO {
//    boolean crear(Usuarios usuario);
//    ArrayList<Usuarios> obtenerTodos();
//    Usuarios obtenerUno(Long id);
//    Usuarios obtenerUno(String email) ;
//    boolean eliminar(String email);
//    boolean modificar(Usuarios usuario);
    boolean guardarUsuario(Usuarios usu);
    
    boolean leerUsuarios(String em, String pass);
    
    boolean actualizarUsuario(Usuarios per, String em_actual);
    
    boolean eliminarUsuario(String em);
    
    List<Usuarios> listarUsuarios();
}
