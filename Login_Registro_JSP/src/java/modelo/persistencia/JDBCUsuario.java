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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Persona;
import modelo.logica.IUsuarioDAO;

/**
 *
 * @author USUARIO
 */
public class JDBCUsuario implements IUsuarioDAO{
    private List<Persona> lp = new ArrayList();
    
    public JDBCUsuario() {
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        }catch (Exception ex){
            Logger.getLogger(JDBCUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean guardarUsuario(Persona per) {
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/UsuariosDB", "test", "test")) {
            String query = "SELECT Id FROM Usuarios order by Id asc";
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs=pstmt.executeQuery();
            int ultId=1;
            while (rs.next()) {
                ultId = rs.getInt("Id");
                ultId++;
            }
            query = "Insert into Usuarios values(?,?,?,?,?)";
            //PreparedStatement pstmt = con.prepareStatement(query);
            PreparedStatement pstmt2 = con.prepareStatement(query);
            pstmt2.setInt(1, ultId);
            pstmt2.setString(2, per.getNombre());
            pstmt2.setInt(3, per.getEdad());
            pstmt2.setString(4, per.getEmail());
            pstmt2.setString(5, per.getPassword());
            pstmt2.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean leerUsuarios(String em, String pass) {
        String url = "jdbc:derby://localhost:1527/UsuariosDB";
        String username = "test";
        String password = "test";
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT email,pass FROM Usuarios";
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next())
            {
                if(em.equals(rs.getString(1)) && pass.equals(rs.getString(2)))
                {
                    return true;
                }
            }
            return false;
        }catch(SQLException e){
            return false;
        }
    }
    
    @Override
    public boolean actualizarUsuario(Persona per, String em_actual) {
        
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/UsuariosDB", "test", "test")) {
            int id=0;
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("SELECT id FROM Usuarios where email='"+em_actual+"'");
            while(rs.next())
            {
                id=rs.getInt(1);
            }
            //Actualizo
            PreparedStatement pstmt2 = con.prepareStatement("Update Usuarios set nombre=?, edad=?, email=?, pass=? where id=?");
            pstmt2.setString(1, per.getNombre());
            pstmt2.setInt(2, per.getEdad());
            pstmt2.setString(3, per.getEmail());
            pstmt2.setString(4, per.getPassword());
            pstmt2.setInt(5, id);
            pstmt2.executeUpdate();
            return true;
        }catch(SQLException e){
            return false;
        }        
    }
    
    @Override
    public boolean eliminarUsuario(String em) {
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/UsuariosDB", "test", "test")) {
            PreparedStatement pstmt2 = con.prepareStatement("Delete from Usuarios where email=?");
            pstmt2.setString(1, em);
            pstmt2.executeUpdate();
            return true;
        }catch(SQLException e){
            return false;
        }
    }

    @Override
    public List<Persona> listarUsuarios() {
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/UsuariosDB", "test", "test")) {
            lp.clear();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM Usuarios");
            String nombre, email, pass="";
            int edad=0;
            while(rs.next())
            {
                nombre=rs.getString(2);
                edad=rs.getInt(3);
                email=rs.getString(4);
                pass=rs.getString(5);
                lp.add(new Persona(nombre, edad, email, pass));
            }
            return lp;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return lp;
        } 
    }
    
}
