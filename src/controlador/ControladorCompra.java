package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import modelo.Compra;
import modelo.DetalleCompra;


public class ControladorCompra {

    public void Agregar(Compra p) throws SQLException, ClassNotFoundException, ErrorTienda, ErrorTienda {
        Conexion cn = new Conexion();
        
        try{
        cn.conectar();      
        cn.UID("INSERT INTO compra(IdCompra,Fecha,IdProveedor,Total) VALUES('" + p.getIdCompra() + "','" + p.getFecha() + "','" + p.getPROVEEDOR().getIdProveedor() + "','" + p.getTotal() + "')");
       // cn.desconectar();
        } catch (Exception ex){
            throw new ErrorTienda("Insertar" + ex.getMessage());
        }//finally{cn.desconectar();        }
        
    }

       public Integer ObtenerIdCompra() throws SQLException, ClassNotFoundException, ErrorTienda, ErrorTienda {
            Integer latestId=0;
            Conexion cn = new Conexion();
            try{
            cn.conectar();
            ResultSet rs = null;
            rs=cn.getValores("SELECT MAX(idCompra) FROM compra");
            latestId = Integer.parseInt(rs.toString());

            return latestId;      
            } catch (Exception ex){
                throw new ErrorTienda("Obtener IdCompra" + ex.getMessage());            
            }//finally{ cn.desconectar();} 
        }
       
        public void ActulizarInventario(Compra p) throws SQLException, ClassNotFoundException, ErrorTienda, ErrorTienda {
            Conexion cn = new Conexion();
            try{
            cn.conectar();

            cn.UID("UPDATE detallecompra SET IdCompra='" + p.getIdCompra() + "',producto ='" + p.getArticulos().getCantidad()+"'");
            } catch (Exception ex){
                 throw new ErrorTienda("Actulizar Inventarior" + ex.getMessage());
            }
            //finally{cn.desconectar();}
    }
//  
//    public void ActulizarPrecioPromedioProducto(DetalleCompra p) throws SQLException, ClassNotFoundException, ErrorTienda, ErrorTienda {
//        Conexion cn = new Conexion();
//        try{
//        cn.conectar();
//        cn.UID("UPDATE detallecompra SET CodBarra='" + p.getPRODUCTO().getCodBarra()  + "',Cantidad='" + p.getCantidad() +"',CostoUnitario='"+p.getCostoUnitario()+"'");
//        } catch (Exception ex){
//             throw new ErrorTienda("ActulizarPrecioPromedioProducto" + ex.getMessage());
//        }finally{cn.desconectar();
//        }
//    }
    
  /*  
    //METODOS PARA ACTUALIZAR EL PRECIO
    //metodo para obtener valor actual
    public ResultSet newPrecio(String CodBarra) throws SQLException, ClassNotFoundException, ErrorTienda, ErrorTienda {  
      Conexion cn = new Conexion();
      try{          
        cn.conectar();
        return(cn.getValores("SELECT Precio FROM Producto WHERE CodBarra='"+CodBarra+"'"));          
        } catch (Exception ex){            
            throw new ErrorTienda("Error al actulizar precio" + ex.getMessage());
        } finally{cn.desconectar();
      }      
    }
  // actualizar producto
  public void precio(float newPrecio,String CodBarra) throws SQLException, ClassNotFoundException, ErrorTienda, ErrorTienda {  
      Conexion cn = new Conexion();
      try{          
        cn.conectar();
        
        
        cn.UID("UPDATE Producto SET Precio='"+newPrecio+"'WHERE CodBarra='"+CodBarra+"'");
        } catch (Exception ex){            
            throw new ErrorTienda("Error al actulizar precio" + ex.getMessage());
        }finally{cn.desconectar();
      }          
    }
    
    //METODOS PARA ACTUALIZAR LA CANTIDAD
  
  // metodo para saber el valor actual
    public ResultSet newCantidad(String CodBarra) throws SQLException, ClassNotFoundException, ErrorTienda, ErrorTienda {  
      Conexion cn = new Conexion();
      try{
        cn.conectar();
       return(cn.getValores("SELECT Producto FROM Cantidad WHERE CodBarra='"+CodBarra+"'"));
        
        } catch (Exception ex){
            cn.desconectar();
            throw new ErrorTienda("Error al actulizar la cantidad" + ex.getMessage());
        }finally{cn.desconectar();
      } 
      
      // meto para actualizar la Cantidad
    }
     public void Cantidad(float newCantidad, String CodBarra) throws SQLException, ClassNotFoundException, ErrorTienda, ErrorTienda {  
      Conexion cn = new Conexion();
      try{
        cn.conectar();
       cn.UID("UPDATE Producto SET Cantidad='"+newCantidad+"'WHERE CodBarra='"+CodBarra+"'");
        
        } catch (Exception ex){
            cn.desconectar();
            throw new ErrorTienda("Error al actulizar la cantidad" + ex.getMessage());
        }finally{cn.desconectar();
      } 
    }
    
    
    
    
     

    /*      
    public ResultSet llenarTablaItem() {
        Conexion cn = new Conexion();
        return (cn.getValores("SELECT IdCompra,Fecha,IdProveedor,Total FROM compra"));
    }
    
    public ResultSet contarRegistros() {
       Conexion cn = new Conexion();
       return (cn.getValores("SELECT COUNT(IdCompra) FROM compra"));
    }

    public ResultSet mayorRegistro() {
        Conexion cn = new Conexion();
        return (cn.getValores("SELECT MAX(IdCompra) FROM compra"));
    }
    */
}
