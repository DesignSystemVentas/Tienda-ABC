/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import sql.cnMYSQL;
import modelo.Proveedor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JOSHUA
 */
public class ControladorProveedor {
Conexion cn= new Conexion();

    public ControladorProveedor() {
       List  Lista = new ArrayList<>();
    }

    public ControladorProveedor(int id, String nombre, String telefono, String direccion, String nit){
    
    }
    
public class ProveedorControlador {
 
}
       public List BuscarP(String codigo) throws Exception{   
        Conexion cn = new Conexion();
        List Lista = new ArrayList<>();
        try{
        cn.conectar();           
            ResultSet rs = cn.getValores("SELECT * FROM proveedor  where IdProveedor='"+codigo+"'");
            while (rs.next()) {
                int id = rs.getInt("IdProveedor");
                String nombre = rs.getString("Nombre");
                String telefono= rs.getString("Telefono");
                String direccion = rs.getString("Direccion");  
                String nit = rs.getString("NIT");       
                ControladorProveedor proveedor = new ControladorProveedor(id, nombre, telefono, direccion, nit);
                Lista.add(proveedor);
            }
        } catch (SQLException e){throw new ErrorTienda("se pordujo un error al obtener el proveedor");
        }finally{cn.desconectar();}
        return Lista; 

    }
       public ResultSet obtenerProveedor() throws Exception {
        Connection connection = cnMYSQL.getIntance().getConnection();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM proveedor ");
        ResultSet rs = ps.executeQuery();
        return rs;

    }

    
       public void AgregarP(Object P[]) throws SQLException, ClassNotFoundException, ErrorTienda, ErrorTienda {
        Conexion cn = new Conexion();
        try{
        cn.conectar();  
        cn.UID("INSERT INTO proveedor(IdProveedor,Nombre,Telefono,Direccion,NIT) VALUES(" +P[0]+ "," + P[1] + ",'" + P[2] + "','" + P[3]+ "')");
        System.out.println("se agrego con exito");
        } catch (Exception ex){
            throw new ErrorTienda("Insertar" + ex.getMessage());
        }
        finally{cn.desconectar();}
//        
    }

    public void eliminarProveedor(Object P) throws SQLException, ClassNotFoundException, ErrorTienda, ErrorTienda {
        Conexion cn = new Conexion();
        try{
        cn.conectar();  
        cn.UID("DELETE FROM proveedor WHERE IdProveedor='" + P + "'");
        System.out.println("se elimino con exito");
        } catch (Exception ex){
            throw new ErrorTienda("Eliminar" + ex.getMessage());
        }finally{cn.desconectar();}
        
    }
    
    public void modificarP(Object P[]) throws SQLException, ClassNotFoundException, ErrorTienda, ErrorTienda {
        Conexion cn = new Conexion();
        try{
        cn.conectar();  
        cn.UID("UPDATE proveedor SET Nombre='" + P[1] + "',Telefono='" + P[2]+ "',Direccion='" + P[3] + "',NIT='" + P[4] + "' WHERE IdProveedor='" + P[0]+ "'");
    
        System.out.println("se modifico con exito");
        } catch (Exception ex){
            throw new ErrorTienda("Insertar" + ex.getMessage());
        }finally{cn.desconectar();}
        
    }
}



    


