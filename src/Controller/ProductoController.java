package Controller;

import java.util.HashMap;
import java.util.Map;

import Model.*;

public class ProductoController{

    Map<Integer, ProductoModel> producto;
    private int id;

    public ProductoController(){
        this.producto = new HashMap<>();
    }

    public boolean agregarProducto(int tipoProducto, String nombre, String marca, String talla, String color, int categoria, int stock, float precio, int estado, String extra){

        if(nombre == null || nombre.trim().isEmpty() || marca == null || marca.trim().isEmpty() || talla == null || talla.isEmpty() || color == null || color.trim().isEmpty() || categoria <= 0 || estado <= 0 || stock < 0 || precio <= 0){
            return false;
        }

        id++;
        ProductoModel nuevoProducto = ProductoModel.crearProducto(tipoProducto, id, nombre, marca, talla, color, categoria, stock, precio, estado, extra);

        if(nuevoProducto == null) return false;

        producto.put(id, nuevoProducto);
        return true;
    }

    public boolean actualizarProducto(int id, String nombre, String marca, String talla, String color, int categoria, int stock, float precio, int estado, String extra){
        if(!producto.containsKey(id)) return false;

        ProductoModel productoExistente = producto.get(id);

        productoExistente.setNombre(nombre);
        productoExistente.setMarca(marca);
        productoExistente.setTalla(talla);
        productoExistente.setColor(color);
        productoExistente.setCategoria(categoria);
        productoExistente.setStock(stock);
        productoExistente.setPrecio(precio);
        productoExistente.setStock(estado);

        if(productoExistente instanceof CamibusoModel){
            ((CamibusoModel) productoExistente).setTela(extra);
        }

        return true;
    }

    public boolean eliminar(int id){
        if(!producto.containsKey(id)) return false;

        producto.remove(id);
        
        return true;
    }

    public String buscar(){
        if(producto == null || producto.isEmpty()) return "No hay productos disponibles";

        String infoProducto = "";
        for(ProductoModel productoIndivdual : producto.values()){
            infoProducto += productoIndivdual.toString() + "\n";
        }

        return infoProducto;
    }

    public String validaStock(int id){
        if(!producto.containsKey(id)) return "El ID " + id + " no es válido.";

        ProductoModel productoEncontrado = producto.get(id);
        if(productoEncontrado.getStock() == 0) return "El producto con referencia " + id + " no tiene unidades disponibles";

        return productoEncontrado.toString();
    }

    public boolean modificarAtributo(int id, int atributo, String valor){
        if(!producto.containsKey(id)) return false;

        ProductoModel productoEncontrado = producto.get(id);

        try{
            switch(atributo){
                case 1: 
                    productoEncontrado.setNombre(valor);
                    break;
                case 2: 
                    productoEncontrado.setMarca(valor);
                    break;
                case 3: 
                    productoEncontrado.setTalla(valor);
                    break;
                case 4: 
                    productoEncontrado.setColor(valor);
                    break;
                case 5: 
                    productoEncontrado.setCategoria(Integer.parseInt(valor));
                    break;
                case 7: 
                    productoEncontrado.setStock(Integer.parseInt(valor));
                    break;
                case 8: 
                    productoEncontrado.setPrecio(Float.parseFloat(valor));
                    break;
                case 9: 
                    productoEncontrado.setEstado(Integer.parseInt(valor));
                    break;
                case 10:
                    if(productoEncontrado instanceof CamibusoModel){
                        ((CamibusoModel) productoEncontrado).setTela(valor);
                    }else{
                        return false;
                    }
                    break;
                default: 
                    return false;
            }
        }catch(Exception e){
            return false;
        }

        return true;
    }

    public ProductoModel getProducto(int id){
        if(!producto.containsKey(id)) return null;
        return producto.get(id);
    }
}
