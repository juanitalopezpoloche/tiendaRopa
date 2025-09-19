import Controller.CamibusoController;

public class App {
    public static void main(String[] args) throws Exception {
        CamibusoController controladorProducto = new CamibusoController();
        
        boolean productoAgregado = controladorProducto.agregar("Camibuso ABC", "ASD", "M", "Blanco", 1, 50, 35000, "algodon");

        if(!productoAgregado){
            System.out.println("Error al crear el producto");
            return;
        }

        System.out.println("Producto creado correctamente");
        System.out.println("------ Productos Disponibles ------");
        System.out.println(controladorProducto.buscar());

        boolean actualizarProducto = controladorProducto.actualizar(1, "Camibuso ABCD", "ASDF", "L", "Blanco", 1, 55, 32000, "algodon");

        System.out.println(actualizarProducto ? "Producto actualizado correctamente" : "Error al actualizar el producto");

        System.out.println("------ Productos Disponibles ------");
        System.out.println(controladorProducto.buscar());

        System.out.println("--------- Stock ---------");
        System.out.println(controladorProducto.validaStock(1));

        boolean segundoProductoAgregado = controladorProducto.agregar("Camibuso ABC", "ASD", "M", "Blanco", 1, 50, 35000, "algodon");

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
    }
}
