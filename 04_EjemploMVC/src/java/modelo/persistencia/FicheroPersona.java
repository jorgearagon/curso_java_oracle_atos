/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import modelo.Persona;
import modelo.logica.IPersonaDAO;

/**
 *
 * @author USUARIO
 */
public class FicheroPersona implements IPersonaDAO{
    private static final String dir = "C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\curso_java_oracle_atos.git\\04_EjemploMVC";
    private static FicheroPersona instancia = new FicheroPersona();

    private FicheroPersona() {
    }
    public static FicheroPersona getInstancia (){
        return instancia;
    }
    
    @Override
    public boolean guardarPersona(Persona per){
        try(ObjectOutputStream escribFich = new ObjectOutputStream(
            new FileOutputStream(dir+"\\persona.dat")))
        {
            escribFich.writeObject(per);
            return true;
            //escribFich.close();
        }catch(Exception ex){
            return false;
        }
    }
    
    @Override
    public Persona leerPersona(){
        try(ObjectInputStream escribFich = new ObjectInputStream(
            new FileInputStream(dir+"\\persona.dat")))
        {
            Persona p =(Persona) escribFich.readObject();
            return p;
            //escribFich.close();
        }catch(Exception ex){
            return null;
        }
    }
}
