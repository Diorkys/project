
package Clases;

import com.mycompany.login4.Registrar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SqlUsuarios extends CConexion {
    
    public boolean registrar(usuarios usr)
    {
        PreparedStatement ps= null;
        Connection conecta = estableceConexion();
         // esta es la consulta sql que inserta los datos
        String sql =  "insert into usuarios (usuario, nombre, apellido, telefono, correo, contraseña) values (?,?,?,?,?,?)";
        try{
        ps = conecta.prepareStatement(sql);
        ps.setString(1, usr.getUsuario());
        ps.setString(2, usr.getNombre());
        ps.setString(3, usr.getApellido());
        ps.setString(4, usr.getTelefono());
        ps.setString(5, usr.getCorreo());
        ps.setString(6, usr.getConraseña());
        ps.execute();
        
        return true;
        
        
            }
        catch (SQLException ex){
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            
            return false;
        }
    }
    public void EliminarUsuario(String id)
            
    {
        String sql = "delete from usuarios where idProducto = " + id;
        Statement st;
        Connection conecta = estableceConexion();
        try 
        {
            st = conecta.createStatement();
            int rs = st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
            
            
        }catch (SQLException e)
        {
            System.out.println(e);
        }
        
        
    }

    public void FormMenuPrincipal(String usuarios, JTable jtDatos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    // metodo para actualizar el usuario
    public void ActualizarUsuario (JTextField usuario, JTextField nombre, JTextField apellido, JTextField telefono, JTextField correo, JTextField contraseña, String id){
        // consulta sql para actulizarlo
            String sql = "update usuarios set usuario= '"+ usuario.getText() +"', nombre= '"+ nombre.getText() +"', apellido = '" +apellido.getText() +"', telefono = '" +telefono.getText() +"', correo = '" +correo.getText() +"', contraseña = '" +contraseña.getText() +"' where id =" + id;
            Statement st;
            Connection conecta = estableceConexion();
        
             try 
        {
            st = conecta.createStatement();
            int rs = st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente");
            
        }catch (SQLException e)
        {
            System.out.println(e);
        }
        
        
    }
    
    
    
    
    public void RellenarTablaUsuario (String usuarios, JTable jtDatos){
           String sql = "Select * from " + usuarios;
           Statement st;
           CConexion con = new CConexion();
           Connection conexion = con.estableceConexion();
             // esto nos va servir para escribir las columnas de las tablas del jtable del form 
            DefaultTableModel modelo = new DefaultTableModel();
              modelo.addColumn("ID");
              modelo.addColumn("Nombre");
              modelo.addColumn("Usuario");
              modelo.addColumn("Apellido");
              modelo.addColumn("Telefono");
              modelo.addColumn("Correo");
              modelo.addColumn("Contraseña");
               jtDatos.setModel(modelo);
               String [] dato = new String[7];
               
               try {
               
               st = conexion.createStatement();
               ResultSet rs = st.executeQuery(sql);
               
               while(rs.next()) {
               dato[0] = rs.getString(1);
               dato[1] = rs.getString(2);
               dato[2] = rs.getString(3);
               dato[3] = rs.getString(4);
               dato[4] = rs.getString(5);
               dato[5] = rs.getString(6);
               dato[6] = rs.getString(7);

               modelo.addRow(dato);
               } 
                }
               catch (SQLException e){
                       e.printStackTrace();
                       }
               
                   
       }
    
    

    
    }
    

