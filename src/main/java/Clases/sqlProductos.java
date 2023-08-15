
package Clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class sqlProductos extends CConexion{
  
     // aqui creamos una consulta para insertar un producto
    public void InsertarProducto (JTextField nombre, JTextField marca, JTextField categoria, JTextField precio, JTextField stock){
           
    
        try{
            
             // aqui se establece la conexion
            Connection conecta = estableceConexion();
            // esta es la consulta sql para insertar los productos
            CallableStatement prod = conecta.prepareCall("insert into productos (NombreProducto, MarcaProducto, CategoriaProducto, PrecioProducto, StockProducto) values (?,?,?,?,?)");
            prod.setString(1, nombre.getText());
            prod.setString(2, marca.getText());
            prod.setString(3, categoria.getText());
            prod.setString(4, precio.getText());
            prod.setString(5, stock.getText());
            prod.execute();
            JOptionPane.showMessageDialog(null, "Se ha insertado correctamente");
            
        }catch (Exception e){
        System.out.println(e);
        }
    
    
    }
    // este es el metodo publico que me permite eliminar los productos
    public void EliminarProducto(String id)
            
    {
        
   // esta es la consulta sql para eliminar los productos
        String sql = "delete from productos where idProducto = " + id;
        Statement st;
        Connection conecta = estableceConexion();
        try 
        {
            st = conecta.createStatement();
            int rs = st.executeUpdate(sql);
            
            
        }catch (SQLException e)
        {
            System.out.println(e);
        }
        
        
    }
    
    
    
    
    public void ActualizarProducto(JTextField nombre, JTextField marca, JTextField categoria, JTextField precio, JTextField stock, String id){
           // esta es la consulta sql para actualizar los productos
            String sql = "update productos set NombreProducto= '"+ nombre.getText() +"', MarcaProducto= '"+ marca.getText() +"', CategoriaProducto = '" +categoria.getText() +"', PrecioProducto = '" +precio.getText() +"', StockProducto = '" +stock.getText() +"' where idProducto =" + id;
            Statement st;
            Connection conecta = estableceConexion();
        
             try 
        {
            st = conecta.createStatement();
            int rs = st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Producto Actualizado");
            
            
        }catch (SQLException e)
        {
            System.out.println(e);
        }
        
        
    }
    
    
    public void RellenarTablaProductos (String productos, JTable jtProducto){
           String sql = "Select * from " + productos;
           Statement st;
           CConexion con = new CConexion();
           Connection conexion = con.estableceConexion();
             // esto nos va servir para escribir las columnas de las tablas del jtable del form 
            DefaultTableModel modelo = new DefaultTableModel();
              modelo.addColumn("ID");
              modelo.addColumn("Nombre");
              modelo.addColumn("Marca");
              modelo.addColumn("Categoria");
              modelo.addColumn("Precio ($)");
              modelo.addColumn("Stock");
               jtProducto.setModel(modelo);
               String [] dato = new String[6];
               
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
               modelo.addRow(dato);
               } 
                }
               catch (SQLException e){
                       e.printStackTrace();
                       }
               
                   
       }
    
    
       
}


