package modelo;

/**
 *
 * @author ronal
 */
public class DetalleCompra {

    private Integer Cantidad;
    private double CostoUnitario;
    private Producto PRODUCTO;

    public DetalleCompra(Integer Cantidad, double CostoUnitario, Producto PRODUCTO) {
        this.Cantidad = Cantidad;
        this.CostoUnitario = CostoUnitario;
        this.PRODUCTO = PRODUCTO;
    }

    public DetalleCompra() {
    }
    
    
    
    

    public Producto getPRODUCTO() {
        return PRODUCTO;
    }

    public void setPRODUCTO(Producto PRODUCTO) {
        this.PRODUCTO = PRODUCTO;
    }

    // para el campo del identificador de la venta
 
    // para el campo del identificador de la cantidad
    public Integer Cantidad() {
        return Cantidad;
    }    
    public int getCantidad() {
        return Cantidad;
    }    
    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
    // para el campo codigo de barra
    // para el campo de el precio
 
    //finalizacion.
    //inicio metodos
    
    //inicio metodos

    public double getCostoUnitario() {
        return CostoUnitario;
    }

    public void setCostoUnitario(double CostoUnitario) {
        this.CostoUnitario = CostoUnitario;
    }
}
