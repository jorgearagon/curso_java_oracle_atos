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
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Persona;
import modelo.logica.IPersonaDAO;

/**
 *
 * @author USUARIO
 */
public class JavaJDPersona implements IPersonaDAO{

    public JavaJDPersona() {
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        }catch (Exception ex){
            Logger.getLogger(JavaJDPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    @Override
    public boolean guardarPersona(Persona per) {
         try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/PersonasDB", "usuario", "usuario")) {
            String query = "SELECT COUNT(Id) as ultId FROM Persona";
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs=pstmt.executeQuery();
            if (rs.next()) {
                int ultId = rs.getInt("ultId");
                ultId++;
                query = "Insert into Persona values(?,?,?)";
                //PreparedStatement pstmt = con.prepareStatement(query);
                PreparedStatement pstmt2 = con.prepareStatement(query);
                pstmt2.setString(1, per.getNombre());
                pstmt2.setInt(2, per.getEdad());
                pstmt2.setInt(3, ultId);
                pstmt2.executeUpdate();
                return true;
            }
            return true;
        } catch (SQLException e) {
            return false;
        }
//         
//        String url = "jdbc:derby://localhost:1527/PersonasDB";
//        String username = "usuario";
//        String password = "usuario";
//        String query = "Insert into Persona values(?,?)";
//        try (Connection con = DriverManager.getConnection(url, username, password)) {
//            PreparedStatement pstmt = con.prepareStatement(query);
//            pstmt.setString(1, per.getNombre());
//            pstmt.setInt(2, per.getEdad());
//            pstmt.executeUpdate();
//            return true;
//        } catch (SQLException e) {
//            return false;
//        }
    }

    @Override
    public Persona leerPersona() {
        String query = "SELECT * FROM Persona";
        // A try-with-resources example
        // Connection and Statement implement java.lan.AutoCloseable
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/PersonasDB", "usuario", "usuario")) {
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs=pstmt.executeQuery();
            if (rs.next()) {
                String nombre= rs.getString("nombre");
                int edad = rs.getInt("edad");
                Persona p = new Persona(nombre, edad);
                return p;
            }
            else
            {
                return null;
            }
            
        } catch (SQLException e) {
            return null;
        }
        
    }
    
}
