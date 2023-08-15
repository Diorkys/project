/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;


import com.mycompany.login4.FormLogin;
import com.mycompany.login4.FormPrincipalGestion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author admin
 */
public class Clogin {
    public void validarUsuario (JTextField usuario, JPasswordField contrasenia){
        
        try {
            ResultSet rs = null;
            PreparedStatement ps = null;
            
            Clases.CConexion objetoConexion = new Clases.CConexion ();
             // Esto es una consulta sql, que me va a obtener (seleccionar) e usuario y contraseña
            String consulta = "select * from usuarios where usuarios.usuario = (?) and usuarios.contraseña = (?);";
            ps= objetoConexion.estableceConexion().prepareStatement(consulta);
            
            
            String contra = String.valueOf(contrasenia.getPassword ());
            
            ps.setString(1, usuario.getText ());
            ps.setString(2, contra);
        
            rs = ps.executeQuery();
            
              // Y luego me va a validar si es correcto o incorrecto
            if (rs.next()){
            JOptionPane.showMessageDialog(null, "El usuario es Correcto, Bienvenid@");
            // Esto es para que una vez yo ingrese me salga el formulario principal

            FormPrincipalGestion objetoMenu =  new FormPrincipalGestion();
            objetoMenu.setVisible(true);
            
            
           
            }
            else {
            JOptionPane.showMessageDialog(null, "El usuario es Incorrecto");
            FormLogin objetoLogin =  new FormLogin();
            objetoLogin.setVisible(true);
            }
    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " +  e.toString());  
        }
    }
}
