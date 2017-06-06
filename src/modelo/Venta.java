package modelo;

import controlador.Conexion;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import controlador.ErrorTienda;
import java.sql.ResultSet;

/**
 *
 * @author ronal
 */
public class Venta {

    private Integer IdVenta;
    private Date Fecha;
    private String Cliente;
    private double Total;
    private DetalleVenta[] ARTICULO;

    public Venta() {
    }

    public Venta(Integer IdVenta, Date Fecha, String Cliente, double Total, DetalleVenta[] ARTICULO) {
        this.IdVenta = IdVenta;
        this.Fecha = Fecha;
        this.Cliente = Cliente;
        this.Total = Total;
        this.ARTICULO = ARTICULO;
    }

    
    // private List<DetalleVenta> ARTICULO = new ArrayList();
    public Integer getIdVenta() {
        return IdVenta;
    }

    public void setIdVenta(Integer IdVenta) {
        this.IdVenta = IdVenta;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public DetalleVenta[] getARTICULO() {
        return ARTICULO;
    }

    public void setARTICULO(DetalleVenta[] ARTICULO) {
        this.ARTICULO = ARTICULO;
    }

    /*
    public List<DetalleVenta> getARTICULO() {
        return ARTICULO;
    }

    public void setARTICULO(List<DetalleVenta> ARTICULO) {
        this.ARTICULO = ARTICULO;
    }*/
    public void AgregarItem(DetalleVenta dv) throws ErrorTienda {
    
        //Falta que el item autoincremente
          int item=0;
                      
            try {
        ARTICULO[item] = new DetalleVenta(dv.getCantidad(),dv.getPrecioUnitario(),dv.getProducto());  
        CalcularTotal();
        item++;
        } catch (Exception e) {
        throw new ErrorTienda("Agregar item-Controlador.Venta.AgregarItem()"+e.getMessage());
        }
       
            
    }

    public void CalcularTotal() throws ErrorTienda{

        try{
                       
            for (int item = 0; item < ARTICULO.length; item++) {
            this.Total = this.Total + ((ARTICULO[item].getPrecioUnitario())*(ARTICULO[item].getCantidad()));
                        
        }
         }catch(ArithmeticException ae){
         throw new ErrorTienda("Calcular total-Controlador.Venta.CalcularTotal()"+ae.getMessage());
         }catch (ArrayIndexOutOfBoundsException e) {
         throw new ErrorTienda("Calcular total-Controlador.Venta.CalcularTotal()"+e.getMessage());
         }
                
    }
    
}