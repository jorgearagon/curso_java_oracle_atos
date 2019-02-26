/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;
import modelo.logica.IUsuarioDAO;
import util.Constantes;

/**
 *
 * @author USUARIO
 */
public class DerbyDBUsuario implements IUsuarioDAO {

    public DerbyDBUsuario() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        } catch (Exception ex) {
            Logger.getLogger(DerbyDBUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean crear(Usuario persona) {

        try (Connection con = DriverManager.getConnection(
                Constantes.CONEX_DERBY_DB,Constantes.USUARIO_DERBY_DB,Constantes.PASSWD_DERBY_DB )) {
            
            String squery  = "INSERT INTO usuarios (Nombre, Edad, email, pass) VALUES(" 
                        + "'" + persona.getNombre() + "', "
                        + persona.getEdad() + ", '" + persona.getEmail() + "', '" + persona.getPassword() + "')";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(squery);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public ArrayList<Usuario> obtenerTodos() {
        try (Connection con = DriverManager.getConnection(
                Constantes.CONEX_DERBY_DB,Constantes.USUARIO_DERBY_DB,Constantes.PASSWD_DERBY_DB )) {
            
            ArrayList<Usuario> listaUsuarios = new ArrayList<>();
            String squery = "SELECT id, nombre, edad, email, pass FROM Usuarios";
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(squery);
            while (res.next()) { 
                int id = res.getInt("id");
                String nombre = res.getString("nombre");
                int edad = res.getInt("edad");
                String email = res.getString("email");
                String password = res.getString("pass");
                Usuario usu = new Usuario(id, nombre, edad, email, password);
                listaUsuarios.add(usu);
            }
            return listaUsuarios;
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public Usuario obtenerUno(Integer id) {
        try (Connection con = DriverManager.getConnection(
                Constantes.CONEX_DERBY_DB,Constantes.USUARIO_DERBY_DB,Constantes.PASSWD_DERBY_DB )) {
            
            Usuario usu = null;
            String squery = "SELECT nombre, edad, email, pass FROM Usuarios WHERE Id=" + id;
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(squery);
            if (res.next()) { 
                String nombre = res.getString("nombre");
                int edad = res.getInt("edad");
                String email = res.getString("email");
                String password = res.getString("pass");
                usu = new Usuario(id, nombre, edad, email, password);
            }
            return usu;
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public Usuario obtenerUno(String email) {
        try (Connection con = DriverManager.getConnection(
                Constantes.CONEX_DERBY_DB,Constantes.USUARIO_DERBY_DB,Constantes.PASSWD_DERBY_DB )) {
            
            Usuario usu = null;
            String squery = "SELECT id, nombre, edad, email, pass FROM Usuarios WHERE email='"+email+"'";
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(squery);
            if (res.next()) { 
                int id= res.getInt("id");
                String nombre = res.getString("nombre");
                int edad = res.getInt("edad");
                //String email = res.getString("email");
                String password = res.getString("pass");
                usu = new Usuario(id, nombre, edad, email, password);
            }
            return usu;
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public boolean eliminar(String email) {
        try (Connection con = DriverManager.getConnection(
                Constantes.CONEX_DERBY_DB,Constantes.USUARIO_DERBY_DB,Constantes.PASSWD_DERBY_DB )) {
            String squery = "DELETE FROM usuarios WHERE email=?";
            PreparedStatement pstmt = con.prepareStatement(squery);
            pstmt.setString(1, email);
            pstmt.executeUpdate();
            return true;
        }catch(SQLException ex){
            return false;
        }
    }

    @Override
    public boolean modificar(Usuario usuario) {
        try (Connection con = DriverManager.getConnection(
                Constantes.CONEX_DERBY_DB,Constantes.USUARIO_DERBY_DB,Constantes.PASSWD_DERBY_DB )) {
            String squery = "UPDATE usuarios SET nombre=?, edad=?, email=?, pass=? WHERE id=?";
            PreparedStatement pstmt = con.prepareStatement(squery);
            pstmt.setString(1, usuario.getNombre());
            pstmt.setInt(2, usuario.getEdad());
            pstmt.setString(3, usuario.getEmail());
            pstmt.setString(4, usuario.getPassword());
            pstmt.setInt(5, usuario.getId());
            pstmt.executeUpdate();
            return true;
        }catch(SQLException ex){
            return false;
        }
    }

}
