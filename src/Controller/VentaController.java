package Controller;

import java.util.HashMap;
import java.util.Map;

import Model.CamibusoModel;
import Model.ProductoModel;
import Model.VentaModel;

public class VentaController{

    private Map<Integer, VentaModel> historialVenta;
    private ProductoController productoController;
    private int idVenta;

    public VentaController(ProductoController productoController){
        this.productoController = productoController;
        this.historialVenta = new HashMap<>();
        this.idVenta = 0;
    }

    // Genera le venta de un producto existente, actualiza stock del producto
    public boolean realizarVenta(String nombreComprador, int idProducto, int cantidad) {
    boolean status = true;

    try {
        // Obtiene el producto desde el controlador
        ProductoModel producto = productoController.getProducto(idProducto);

        // Valida que el producto exista, que la cantidad solicitada sea mayor a cero y Validar stock disponible
        if(producto == null || cantidad <= 0 || producto.getStock() < cantidad) return false;

        String nombreProducto = producto.getNombre();
        float precioProducto = producto.getPrecio();
        float valorTotal = precioProducto * cantidad;

        // Genera ID y crea venta
        idVenta++;
        VentaModel venta = new VentaModel(idVenta, idProducto, nombreComprador, nombreProducto, cantidad, precioProducto, valorTotal);

        // Guarda venta
        historialVenta.put(idVenta, venta);
        System.out.println("Venta creada: " + venta.toString());

        // Actualiza stock
        producto.setStock(producto.getStock() - cantidad);

    }catch(Exception e){
        status = false;
    }

    return status;
}

    // Retorna la información de una venta especifica por su ID
    public String obtenerVenta(int idVenta){
        String mensaje = "";

        try{
            if(historialVenta == null || historialVenta.isEmpty()){
                mensaje = "No hay ventas registradas en el sistema";
            }else if(idVenta <= 0 || !historialVenta.containsKey(idVenta)){
                mensaje = "El id " + idVenta + " no es válido";
            }else{
                VentaModel venta = historialVenta.get(idVenta);
                mensaje = venta.toString();
            }            
        }catch(Exception e){
            mensaje = "Error inesperado al buscar la venta con el identificador " + idVenta;
        }
        return mensaje;
    }

    // Retorna la información de todas las venta realizadas
    public String obtenerVentaRealizada(){
        String mensaje = "";

        try{
            if(historialVenta == null || historialVenta.isEmpty()) return "No hay ventas registradas en el sistema";

            for(VentaModel venta : historialVenta.values()){
                mensaje +=  venta.toString() + "\n";
            }
        }catch(Exception e){
            mensaje = "Error inesperado al obtener las ventas realizadas";
        }

        return mensaje;
    }

    public float valorTotalVentaRealizada(){
        float valorTotalVentaRealizada = 0;

        try{
            if(historialVenta == null || historialVenta.isEmpty()) return valorTotalVentaRealizada;

            for(VentaModel venta : historialVenta.values()){
                valorTotalVentaRealizada += venta.getValorTotal();
            }
        }catch(Exception e){
            valorTotalVentaRealizada = 0;
        }

        return valorTotalVentaRealizada;
    }

    public int cantidadVentaRealizada(){
        int cantidadVentaRealizada = 0;

        try{
            if(historialVenta == null || historialVenta.isEmpty()) return cantidadVentaRealizada;

            for(VentaModel venta : historialVenta.values()){
                cantidadVentaRealizada += 1;
            }
        }catch(Exception e){
            cantidadVentaRealizada = 0;
        }

        return cantidadVentaRealizada;
    }

}
