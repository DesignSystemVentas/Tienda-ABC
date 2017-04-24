/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

 import sql.cnMYSQL;
import modelo.Producto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JOSHUA
 */
public class ControladorProducto {
   

public class ProductoD {
    public void agregar(Producto to) throws SQLException, Exception{
          Connection connection=cnMYSQL.getIntance().getConnection();
          CallableStatement cs=connection.prepareCall("CALL Producto_insert(?,?,?,?)");
          cs.setString(1, to.getCodBarra());
          cs.setString(2, to.getNombre());
          cs.setInt(3, to.getInventario());
          cs.setDouble(4, to.getCosto());
          
    }
    public void modificar(Producto to) throws SQLException, Exception{
          Connection connection=cnMYSQL.getIntance().getConnection();
          CallableStatement cs=connection.prepareCall("CALL Producto_update(?,?,?,?)");
          cs.setString(1, to.getCodBarra());
          cs.setString(2, to.getNombre());
          cs.execute();
    }
        public void eliminar(Producto to) throws SQLException, Exception{
          Connection connection=cnMYSQL.getIntance().getConnection();
          CallableStatement cs=connection.prepareCall("CALL Producto_Eliminar(?)");
          cs.setString(1, to.getCodBarra());
          cs.execute();
    }
        public ResultSet buscar(String nombre) throws  SQLException, Exception{
             nombre='%'+nombre+'%';
             Connection connection=cnMYSQL.getIntance().getConnection();
             PreparedStatement ps=connection.prepareStatement("SELECT * FROM producto where nombre like  ?");
             ps.setString(1, nombre);
             ResultSet rs=ps.executeQuery();
             return rs;             
        }
         public ResultSet obtener() throws  Exception{
             Connection connection=cnMYSQL.getIntance().getConnection();
             PreparedStatement ps=connection.prepareStatement("SELECT * FROM producto ");
             ResultSet rs=ps.executeQuery();
             return rs;             
        }
}

    
}

    

