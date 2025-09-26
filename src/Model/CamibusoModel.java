package Model;

public class CamibusoModel extends ProductoModel{

    private String tela;

    public CamibusoModel() {
    }

    public CamibusoModel(int id, String nombre, String marca, String talla, String color, int categoria, int stock, float precio, int estado, String tela) {
        super(id, nombre, marca, talla, color, categoria, stock, precio, estado);
        this.tela = tela;
    }

    public String getTela() {
        return tela;
    }

    public void setTela(String tela) {
        this.tela = tela;
    }

    @Override
    public String toString() {
        return "Referencia: " + this.getId() + ", Nombre: " + this.getNombre() + ", marca: " + this.getMarca() + ", talla: " + this.getTalla() + ", color: " + this.getColor() + ", categoria: " + this.getCategoria() + ", stock: " + this.getStock() + ", precio: " + this.getPrecio() + ", tela: " + tela + "\n";
        
    }

}
