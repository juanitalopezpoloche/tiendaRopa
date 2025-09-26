package Model;

public abstract class ProductoModel {
    private int id;
    private String nombre;
    private String marca;
    private String talla;
    private String color;
    private int categoria;
    private int stock;
    private float precio;
    private int estado;

    public ProductoModel(int id, String nombre, String marca, String talla, String color, int categoria, int stock, float precio, int estado) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.talla = talla;
        this.color = color;
        this.categoria = categoria;
        this.stock = stock;
        this.precio = precio;
        this.estado = estado;
    }

    public ProductoModel() {
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public static ProductoModel crearProducto(int tipoProducto, int id, String nombre, String marca, String talla, String color, int categoria, int stock, float precio, int estado, String extra){
        switch(tipoProducto) {
            case 1:
                return new CamibusoModel(id, nombre, marca, talla, color, categoria, stock, precio, estado, extra);
            default:
                return null;
        }
    }
    
    public String toString() {
        return "ProductoModel []";
    }

    
}
