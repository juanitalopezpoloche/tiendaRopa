import Controller.ProductoController;
import Controller.VentaController;

public class App {
    public static void main(String[] args) throws Exception {
        ProductoController controladorProducto = new ProductoController();
        
        boolean productoAgregado = controladorProducto.agregarProducto(1, "Camibuso ABC", "ASD", "M", "Blanco", 1, 50, 35000, 1, "algodon");

        if(!productoAgregado){
            System.out.println("Error al crear el producto");
            return;
        }

        System.out.println("Producto creado correctamente");
        System.out.println("------ Productos Disponibles ------");
        System.out.println(controladorProducto.buscar());

        boolean actualizarProducto = controladorProducto.actualizarProducto(1, "Camibuso ABCD", "ASDF", "L", "Blanco", 1, 55, 32000, 1, "algodon");

        System.out.println(actualizarProducto ? "Producto actualizado correctamente" : "Error al actualizar el producto");

        System.out.println("------ Productos Disponibles ------");
        System.out.println(controladorProducto.buscar());

        System.out.println("--------- Stock ---------");
        System.out.println(controladorProducto.validaStock(1));

        boolean segundoProductoAgregado = controladorProducto.agregarProducto(1, "Camibuso ABC", "ASD", "M", "Blanco", 1, 50, 35000, 1,  "algodon");

        if(!segundoProductoAgregado){
            System.out.println("Error al agregar el segundo producto");
            return;
        }

        System.out.println("------ Productos Disponibles ------");
        System.out.println(controladorProducto.buscar());


        boolean eliminarSegundoProducto = controladorProducto.eliminar(2);
        System.out.println(eliminarSegundoProducto ? "Producto eliminado correctamente" : "Error al eliminar el producto");

        System.out.println("------ Productos Disponibles ------");
        System.out.println(controladorProducto.buscar());

        boolean modificaAtributoProducto = controladorProducto.modificarAtributo(1, 8, "40000");
        System.out.println(modificaAtributoProducto ? "Atributo modificado correctamente" : "Error al modificar el atributo");

        System.out.println("------ Productos Disponibles ------");
        System.out.println(controladorProducto.buscar());

         VentaController ventaProducto = new VentaController(controladorProducto);
        boolean ventaRealizada = ventaProducto.realizarVenta("Juanita", 1, 100);

        System.out.println(ventaRealizada ? "Venta realizada" : "Error al realizar la venta");

        boolean segundaVentaRealizada = ventaProducto.realizarVenta("Felipe", 1, 1);

        System.out.println(segundaVentaRealizada ? "Venta realizada" : "Error al realizar la venta");

        boolean terceraVentaRealizada = ventaProducto.realizarVenta("Pepito", 1, 4);

        System.out.println(terceraVentaRealizada ? "Venta realizada" : "Error al realizar la venta");

        System.out.println("--------- Ventas realizada -----------");
        System.out.println(ventaProducto.obtenerVentaRealizada());
        
        System.out.println("--------- Segunda venta realizada -----------");
        System.out.println(ventaProducto.obtenerVenta(2));

        System.out.println("------ Productos Disponibles ------");
        System.out.println(controladorProducto.buscar());

        System.out.println("Número de ventas realizadas: " + ventaProducto.cantidadVentaRealizada());

        System.out.println("Valor total de ventas realizadas: " + ventaProducto.valorTotalVentaRealizada());
    }
}
