
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
    
     
   /* public ResultSet ObtenerIdVenta(int IdVenta) throws SQLException, ClassNotFoundException, ErrorTienda, ErrorTienda {
        Conexion cn = new Conexion();
        try{
        cn.conectar();
        return( cn.getValores("SELECT IdVenta, Total FROM venta WHERE IdVenta= '"+IdVenta+"'"));
        
        } catch (Exception ex){
            throw new ErrorTienda("Obtener IdVenta" + ex.getMessage());             
        }finally{
            cn.desconectar();
            }
    }*/
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

    
    public void ActulizarInventario(DetalleVenta v) throws SQLException, ClassNotFoundException, ErrorTienda, ErrorTienda {
        
        Conexion cn = new Conexion();
        try{
        cn.conectar();
        cn.UID("UPDATE producto SET codBarra='" + v.getProducto().getCodBarra() + "',Cantidadr='" + v.getCantidad() + "',PrecioUnitario='" + v.getPrecioUnitario()+"'");
        cn.desconectar();
        } catch (Exception ex){
            throw new ErrorTienda("Actulizar" + ex.getMessage()); 
        
        }finally{
            cn.desconectar();
        }
    } 

}
