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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Parametro;
import frame.JFRPrincipal;


/**
 *
 * @author JOSHUA
 */
public class ControladorProducto {
   Conexion cn= new Conexion();

    public ControladorProducto() {
       List  Lista = new ArrayList<>();
    }

    public ControladorProducto(int codigo, String inv, Double cos, String n){
    
    }
    
public class ProductoControlador {
 
        
 
}
    
   public List Obtener(String codigoBarra ) throws Exception {
    Conexion cn = new Conexion();
     List Lista = new ArrayList<>();
        try{
        cn.conectar();  
             ResultSet rs=null;
             rs = cn.getValores("SELECT * FROM productos where CodBarra="+codigoBarra+";");
            while (rs.next()) {
               String id = rs.getString("CodBarra");
                String inventario = rs.getString("Inventario");
                String costo= rs.getString("Costo");
                String nombre = rs.getString("nombre");        
                Object producto[]= {id, inventario, costo, nombre};
                Lista.add(producto);
            }
            System.out.println("Exito en productos");
        } catch (SQLException e){
             throw new ErrorTienda("no logra obtener");
        }finally{cn.desconectar();}
       return Lista; 
    }
   
   public List Buscar(String codigo) throws Exception{   
        Conexion cn = new Conexion();
        List Lista = new ArrayList<>();
        try{
        cn.conectar();           
            ResultSet rs = cn.getValores("SELECT * FROM productos  where CodBarra='"+codigo+"'");
            while (rs.next()) {
                int id = rs.getInt("CodBarra");
                String inventario = rs.getString("Inventario");
                Double costo= rs.getDouble("Costo");
                String nombre = rs.getString("nombre");        
                ControladorProducto producto = new ControladorProducto(id, inventario, costo, nombre);
                Lista.add(producto);
            }
        } catch (SQLException e){throw new ErrorTienda("se pordujo un error al obtener el producto");
        }finally{cn.desconectar();}
        return Lista; }
   
   public void Agregar(Object P[]) throws SQLException, ClassNotFoundException, ErrorTienda, ErrorTienda {
        Conexion cn = new Conexion();
        try{
        cn.conectar();  
        cn.UID("INSERT INTO productos(CodBarra,Inventario,Costo,nombre) VALUES(" +P[0]+ "," + P[1] + ",'" + P[2] + "','" + P[3]+ "')");
        System.out.println("se agrego con exito");
        } catch (Exception ex){
            throw new ErrorTienda("Insertar" + ex.getMessage());
        }finally{cn.desconectar();}
        
    }
   
    public void eliminar(Object P) throws SQLException, ClassNotFoundException, ErrorTienda, ErrorTienda {
        Conexion cn = new Conexion();
        try{
        cn.conectar();  
        cn.UID("DELETE FROM productos WHERE CodBarra='" + P + "'");
        System.out.println("se elimino con exito");
        } catch (Exception ex){
            throw new ErrorTienda("Eliminar" + ex.getMessage());
        }finally{cn.desconectar();}
        
    }
    
     public void modificar(Object P[]) throws SQLException, ClassNotFoundException, ErrorTienda, ErrorTienda {
        Conexion cn = new Conexion();
        try{
        cn.conectar();  
        cn.UID("UPDATE productos SET Inventario='" + P[1] + "',Costo='" + P[2]+ "',nombre='" + P[3] + "' WHERE CodBarra='" + P[0]+ "'");
    
        System.out.println("se modifico con exito");
        } catch (Exception ex){
            throw new ErrorTienda("Insertar" + ex.getMessage());
        }finally{cn.desconectar();}
        
    }
     
     
     
     
     //VIZCARRA//
     //tuve que crear este metodo XD
     public ResultSet buscarPrecio(String CodBarra) throws SQLException, ClassNotFoundException, ErrorTienda, ErrorTienda {
         Conexion cn = new Conexion();
        try{
            return (cn.getValores("SELECT * FROM productos WHERE CodBarra = '" + CodBarra + "'"));
        } catch (Exception ex){
            throw new ErrorTienda("Insertar" + ex.getMessage());
        }        
    }
     public ResultSet buscarNombre(String CodBarra) throws SQLException, ClassNotFoundException, ErrorTienda, ErrorTienda {
         Conexion cn = new Conexion();
        try{
            return (cn.getValores("SELECT * FROM productos WHERE CodBarra = '" + CodBarra + "'"));
        } catch (Exception ex){
            throw new ErrorTienda("Insertar" + ex.getMessage());
        }        
    }
     //VIZCARRA//
}

    

