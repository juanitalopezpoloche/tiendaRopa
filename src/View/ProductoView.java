package View;
import java.util.Scanner;

import Controller.ProductoController;
import Controller.VentaController;

public class ProductoView {

    private Scanner scanner = new Scanner(System.in);
    private ProductoController camibusoController;

    public ProductoView() {
        this.camibusoController = new ProductoController();
    }

    // Menu principal que indica al usuario las opciones de 1. inventario producto, 2. venta producto
    // Menu de productos disponibles, en el momento se va a mostrar solo 1. Camibusos
    // Menu que saldra para que al seleccionar hacer un inventario de camibusos salgan las opciones de agregar, modificar, eliminar, validar stock, categorias disponibles, modificar solo el valor de un producto(antes de solicitarle al usuario modificar un atributo debo mostrar una lista con los atributos que puede modificar)
    // Menu de la venta: realizar venta, mostrar ventas realizada, mostrar una venta según id, cantidad de ventas realizadas y valor total de ventas realizadas

}
