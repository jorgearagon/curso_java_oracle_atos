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
public interface IUsuarioDAO {
    boolean guardarUsuario(Persona per);
    
    boolean leerUsuarios(String em, String pass);
    
    boolean actualizarUsuario(Persona per, String em_actual);
    
    boolean eliminarUsuario(String em);
}
