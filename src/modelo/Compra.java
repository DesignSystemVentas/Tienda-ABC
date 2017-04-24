package modelo;

import controlador.Conexion;
import controlador.ErrorTienda;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ronal
 */
public class Compra {

    private Integer IdCompra;
    private Date Fecha;
    private Proveedor PROVEEDOR;
    private Double Total;
    private DetalleCompra[] ARTICULOS;

    public Compra() {
    }
    

    public Compra(Integer IdCompra, Date Fecha, Proveedor PROVEEDOR, Double Total, DetalleCompra[] ARTICULOS) {
        this.IdCompra = IdCompra;
        this.Fecha = Fecha;
        this.PROVEEDOR = PROVEEDOR;
        this.Total = Total;
        this.ARTICULOS = ARTICULOS;
    }
    
    private DetalleCompra articulos;
    
    
 public DetalleCompra getArticulos() {
        return articulos;
    }
    public Integer getIdCompra() {
        return IdCompra;
    }

    public void setIdCompra(Integer IdCompra) {
        this.IdCompra = IdCompra;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public Proveedor getPROVEEDOR() {
        return PROVEEDOR;
    }

    public void setPROVEEDOR(Proveedor PROVEEDOR) {
        this.PROVEEDOR = PROVEEDOR;
    }

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double Total) {
        this.Total = Total;
    }

    public DetalleCompra[] getARTICULOS() {
        return ARTICULOS;
    }

    public void setARTICULOS(DetalleCompra[] ARTICULOS) {
        this.ARTICULOS = ARTICULOS;
    }

    public void CalcularTotal() throws ErrorTienda {
       try{
           for (int item = 0; item < ARTICULOS.length; item++) {
            this.Total = this.Total + ((ARTICULOS[item].getCostoUnitario())*(ARTICULOS[item].getCantidad()));
          }
       }catch(ArithmeticException ae){
          throw new ErrorTienda("Calcular total-Controlador.Compra.CalcularTotal()"+ae.getMessage());
       }catch (ArrayIndexOutOfBoundsException e) {
          throw new ErrorTienda("Calcular total-Controlador.Compra.CalcularTotal()"+e.getMessage());
        }
        

    }

    public void AgregarItem(DetalleCompra dc) throws ErrorTienda {
   
          //Falta que el item autoincremente
        int item=0;
                                
            try {
        ARTICULOS[item] = new DetalleCompra(dc.getCantidad(),dc.getCostoUnitario(),dc.getPRODUCTO());  
        CalcularTotal();
        item++;
        } catch (Exception e) {
        throw new ErrorTienda("Agregar item-Controlador.Venta.AgregarItem()"+e.getMessage());
        }
       
       
       
       
    }

   

}
