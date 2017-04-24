package modelo;
 // @author sigfrid
public class Producto {
    private String CodBarra;
    private String Nombre;
    private Integer inventario;
    private double costo;

public Producto(){

}    
    public String getCodBarra() {
        return CodBarra;
    }
    public void setCodBarra(String CodBarra) {
        this.CodBarra = CodBarra;
    }
    public String getNombre() {
        return Nombre;
    } 
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    public int getInventario() {
        return inventario;
    }
    public void setInventario(int inventario) {
        this.inventario = inventario;
    }
    public double getCosto() {
        return costo;
    } 
    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    
    
    
}
