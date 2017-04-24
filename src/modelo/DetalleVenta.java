package modelo;

import controlador.Conexion;
import controlador.ErrorTienda;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class DetalleVenta {
    //OBJETOS

    private int Cantidad;
    private double PrecioUnitario;
    private Producto Producto;

    //CONTROLADORES
    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    
    public double getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(double PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }

    public Producto getProducto() {
        return Producto;
    }

    public void setProducto(Producto Producto) {
        this.Producto = Producto;
    }

  

    //METODOS
    DecimalFormat df = new DecimalFormat("#.##");

    public DetalleVenta() {
    }

    public DetalleVenta(int Cantidad, double PrecioUnitario, Producto Producto) {
        this.Cantidad = Cantidad;
        this.PrecioUnitario = PrecioUnitario;
        this.Producto = Producto;
    }

    public void New(String CodBarra, int Cantidad) {
        this.Cantidad = Cantidad;
        Producto pr = new Producto();
        pr.setCodBarra(CodBarra);
    }
    

    public double CalcularPrecio() throws SQLException, ClassNotFoundException, ErrorTienda, ErrorTienda, Exception {

        Parametro pa = new Parametro();
        try {
//            Conexion cn = new Conexion();
            df.setRoundingMode(RoundingMode.CEILING);
            return Double.parseDouble(df.format(Producto.getCosto() / (1 - (Double.parseDouble(pa.obtenerUtilidad().getValor()) / 100))));

        } catch (ArithmeticException ex) {
            throw new ErrorTienda("Error de Calculo" + ex.getMessage());

        }
    }

}
