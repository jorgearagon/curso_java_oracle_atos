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
import modelo.logica.IUsuarioDAO;

/**
 *
 * @author USUARIO
 */
public class JDBCUsuario implements IUsuarioDAO{
    
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
            String query = "SELECT COUNT(Id) as ultId FROM Usuarios";
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs=pstmt.executeQuery();
            int ultId;
            if (rs.next()) {
                ultId = rs.getInt("ultId");
                ultId++;
            }
            else
            {
                ultId = 1;
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
    public Persona leerUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
