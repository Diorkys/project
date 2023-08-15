/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class CConexion {

    static Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

     // Aqui estamos haciendo la conexion, obteniendo todos los datos de mi bd 
    Connection conectar;
    
    String usuario= "root";
    String contrasenia= "diorkys0204";
    String bd= "almacenitlafinal";
    String ip= "localhost";
    String puerto= "3306";
    
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public Connection estableceConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena,usuario,contrasenia);
          
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Problemas en la conexion"+ e.toString());
        }
        return conectar;
    }

    
    

    
    
    
}
