package Model;

import java.time.LocalDateTime;

public class VentaModel {
    private int idVenta;
    private int idProducto;
    private String nombreComprador;
    private String nombreProducto;
    private int cantidadProducto;
    private float precioUnitario;
    private float valorTotal;
    private LocalDateTime fecha;

    public VentaModel() {
    }

    public VentaModel(int idVenta, int idProducto, String nombreComprador, String nombreProducto, int cantidadProducto, float precioUnitario, float valorTotal) {
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.nombreComprador = nombreComprador;
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.precioUnitario = precioUnitario;
        this.valorTotal = valorTotal;
        this.fecha = LocalDateTime.now();
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreComprador() {
        return nombreComprador;
    }
    
    public void setNombreComprador(String nombreComprador) {
        this.nombreComprador = nombreComprador;
    }
    
    public String getNombreProducto() {
        return nombreProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public float getprecioUnitario() {
        return precioUnitario;
    }

    public void setprecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String toString() {
        return "Id venta: " + idVenta + ", referencia producto: " + idProducto + ", nombre producto: " + nombreProducto +  ", nombre comprador: " + nombreComprador + ", cantidad: " + cantidadProducto + ", precio unitario: " + precioUnitario + ", valor total: " + valorTotal + ", fecha: " + fecha + "\n";
    }    
}
