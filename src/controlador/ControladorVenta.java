
package controlador;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.DetalleVenta;
import modelo.Venta;


public class ControladorVenta {
   
   public void Agregar(Venta v) throws SQLException, ClassNotFoundException, ErrorTienda, ErrorTienda {
        Conexion cn = new Conexion();
        try{
        cn.conectar();
        cn.UID("INSERT INTO venta(IdVenta,Fecha,Cliente,Total) VALUES('" + v.getIdVenta() + "','" + v.getFecha()+ "','" + v.getCliente()+ "','" + v.getTotal() + "')");
        cn.desconectar();
        } catch (Exception ex){
            throw new ErrorTienda("Insercion" + ex.getMessage());
        }finally {
             cn.desconectar();
        }
        
    }
    
        public Integer ObtenerIdVenta() throws SQLException, ClassNotFoundException, ErrorTienda, ErrorTienda {
        Integer latestId=0;
        Conexion cn = new Conexion();
        try{
        cn.conectar();
        ResultSet rs = null;
        rs=cn.getValores("SELECT MAX(idVenta) FROM venta");
        latestId = Integer.parseInt(rs.toString());
        
        return latestId;      
        } catch (Exception ex){
            throw new ErrorTienda("Obtener IdVenta" + ex.getMessage());            
        }finally{
            cn.desconectar();
            } 
        }

    
    public void ActulizarInventario(DetalleVenta[] ARTICULO) throws SQLException, ClassNotFoundException, ErrorTienda, ErrorTienda {
        
        Conexion cn = new Conexion();
        try{
        cn.conectar();

        for(int i=0;i<ARTICULO.length;i++){
          //se resta la cantidad de la BD - la cantidad  del detalle venta
          ResultSet rsProducto = null;
          rsProducto = cn.getValores("SELECT Inventario FROM producto WHERE CodBarra = '"+ARTICULO[i].getProducto().getCodBarra() +"'");
          int cantidad = Integer.parseInt(rsProducto.toString());
          cantidad = cantidad - ARTICULO[i].getCantidad();
          
          //se actuliza la cantidad 
          cn.UID("UPDATE producto SET Inventario='" + cantidad +"' WHERE CodBarra= '" + ARTICULO[i].getProducto().getCodBarra() + "'");
         
        }
      
        } catch (Exception ex){
            throw new ErrorTienda("Actualizar" + ex.getMessage()); 
        
        }finally{
            cn.desconectar();
        }
    } 

    //VIZCARRA//
    //ni modo otro metodo XD
    public ResultSet contarRegistros() throws SQLException, ClassNotFoundException, ErrorTienda, ErrorTienda, Exception {
//                    Conexion cn = new Conexion();
        try {
            Conexion cn = new Conexion();
           return (cn.getValores("SELECT COUNT(IdVenta) FROM venta"));
        } catch (ArithmeticException ex) {
            throw new ErrorTienda("Error de Calculo" + ex.getMessage());           
        }
    }
    public ResultSet mayorRegistro() throws SQLException, ClassNotFoundException, ErrorTienda, ErrorTienda, Exception {
//                    Conexion cn = new Conexion();
        try {
            Conexion cn = new Conexion();
           return (cn.getValores("SELECT COUNT(IdVenta) FROM venta"));
        } catch (ArithmeticException ex) {
            throw new ErrorTienda("Error de Calculo" + ex.getMessage());           
        }
    }
    public void insertarVenta(int IdVenta, String Fecha, String Cliente, double Total) throws ErrorTienda{
        
         try {         
             Conexion cn = new Conexion();
        cn.UID("INSERT INTO venta(IdVenta,Fecha,Cliente,Total) VALUES('" + IdVenta + "','" + Fecha + "','" + Cliente + "','" + Total + "')");
       } catch (ArithmeticException ex) {
            throw new ErrorTienda("Error de Calculo" + ex.getMessage());           
        } 
         
         }
    //VIZCARRA//
    
}
