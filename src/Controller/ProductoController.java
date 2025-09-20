package Controller;

import java.util.HashMap;
import java.util.Map;

import Model.CamibusoModel;
import Model.ProductoModel;


public class ProductoController {
    /* 
        Agregar Producto (Producto)-> Bool
        Buscar Todos los Productos ()-> Lista(Prod)
        Actualizar un producto (ID, Producto) -> Bool
        Eliminar un Producto (ID) -> Bool
        Validad Stock (ID) -> Producto(Stock)
        Filtro por Atributo (Atributo)-> Lista(Productos)
        Modificar un atributo en especifico (ID, Atributo) -> Bool
    */

    Map<Integer, ProductoModel> producto;
    private int id;


    public ProductoController() {
        this.producto = new HashMap<>();
    }

    // Crea un nuevo producto de camibuso
    public Boolean agregarCamibuso(String nombre, String marca, String talla, String color, int categoria, int stock, float precio, String tela){
        // Validacion básica de que los datos sean válidos
        if(nombre == null || nombre.trim().isEmpty() || marca == null || marca.trim().isEmpty() || talla == null || talla.isEmpty() || color == null || color.trim().isEmpty()|| tela == null || tela.trim().isEmpty() || categoria <= 0  || stock < 0 || precio <= 0) return false;

        id++;
        CamibusoModel nuevoCamibuso = new CamibusoModel(id, nombre, marca, talla, color, categoria, stock, precio, tela);

        producto.put(id, nuevoCamibuso);
        return true;
    }

    // Actualiza un camibuso existente, a través de su ID.
    public boolean actualizarCamibuso(int id, String nombre, String marca, String talla, String color, int categoria, int stock, float precio, String tela){
        boolean status = true;

        try{
            // Valida que el ID ingresado sea correcto y corresponda a un registro existente
            if(producto == null || producto.isEmpty() || id <= 0 || !producto.containsKey(id)) return false;

            ProductoModel camibusoExistente = producto.get(id);

            camibusoExistente.setNombre(nombre);
            camibusoExistente.setMarca(marca);
            camibusoExistente.setTalla(talla);
            camibusoExistente.setColor(color);
            camibusoExistente.setCategoria(categoria);
            camibusoExistente.setStock(stock);
            camibusoExistente.setPrecio(precio);
            camibusoExistente.setTela(tela);
        }catch(Exception e){
            status = false;
        }
           
        return status;
    }

    // Elimina un producto existe
    public boolean eliminar(int id){
        boolean status = true;

        try{
            // Valida que el ID ingresado sea correcto y corresponda a un registro existente
            if(producto == null || producto.isEmpty() || id <= 0 || !producto.containsKey(id)) return false;

            producto.remove(id);
        }catch(Exception e){
            status = false;
        }

        return status;
    }

    // Retorna un string con la lista de todos los camibusos disponibles.
    public String buscar(){
        String listaCamibuso = "";

        try{
            if(producto == null || producto.isEmpty()) return "No hay camibusos disponibles";

            for(ProductoModel producto : producto.values()){
                listaCamibuso +=  producto.toString() + "\n";
            }
            
        }catch(Exception e){
            listaCamibuso = "Error inesperado en la busqueda de los productos disponibles de camibuso";
        }

        return listaCamibuso;
    }

    // Retorna la información del producto solo si hay unidades disponibles
    public String validaStock(int id){
        String mensaje = "";
        try{
            // Valida que el ID ingresado sea correcto y corresponda a un registro existente
            if(producto == null || producto.isEmpty() || id <= 0 || !producto.containsKey(id)) return "El " + id + " no es válido.";

            ProductoModel camibusoStock = producto.get(id);

            if(camibusoStock.getStock() == 0) return "El camibuso con referencia " + id + " no tiene unidades disponibles";

            mensaje = camibusoStock.toString();
        }catch(Exception e){
            mensaje = "Ocurrió un error inesperado al validar el stock para la referencia: " + id;
        }

        return mensaje;
    }

    // Modifica un atributo específico de un camibuso identificado por su ID.  El atributo se identifica con un código y se asigna el nuevo valor.
    public boolean modificarAtributo(int id, int identificadorAtributo, String valorAtributo){
        boolean status = true;

        try{
            // Valida que el ID ingresado sea correcto y corresponda a un registro existente
            if(producto == null || producto.isEmpty() || id <= 0 || !producto.containsKey(id)) return false;

            ProductoModel camibusoEncontrado = producto.get(id);

            switch(identificadorAtributo){
                case 1:
                    // nombre
                    camibusoEncontrado.setNombre(valorAtributo);
                    break;        
                case 2:
                    // marca
                    camibusoEncontrado.setMarca(valorAtributo);
                    break;        
                case 3:
                    // talla
                    camibusoEncontrado.setTalla(valorAtributo);
                    break;        
                case 4:
                    // color
                    camibusoEncontrado.setColor(valorAtributo);
                    break;        
                case 5:
                    // categoria
                    camibusoEncontrado.setCategoria(Integer.parseInt(valorAtributo));
                    break;  
                case 7:
                    // stock
                    camibusoEncontrado.setStock(Integer.parseInt(valorAtributo));
                    break;        
                case 8:
                    // precio
                    camibusoEncontrado.setPrecio(Float.parseFloat(valorAtributo));
                    break;        
                case 9:
                    // tela
                    camibusoEncontrado.setTela(valorAtributo);
                    break;        
                default:
                    status = false;
            }
        }catch(Exception e){
            status = false;
        }

        return status;
    }

    // Obtiene y retorna el objeto ProductoModel correspondiente al ID dado.
    public ProductoModel getProductoCamibuso(int id){
        // Valida que el ID ingresado sea correcto y corresponda a un registro existente
        if(producto == null || producto.isEmpty() || id <= 0 || !producto.containsKey(id)) return null;
        
        return producto.get(id);
    }
}
