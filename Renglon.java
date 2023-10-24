/**
 * Clase Renglon
 * @author Velozo, Agustin
 * @version 1 21/10/2023
 */
public class Renglon{
    private int cantidad;
    private double importe;
    private Etiqueta item;

    /**
     * Metodo constructor para instanciar objetos de la clase Renglon
     * @param p_cantidad
     * @param p_item
     */
    public Renglon(int p_cantidad, Etiqueta p_item){
        this.setCantidad(p_cantidad);
        this.setItem(p_item);
        this.setImporte(this.getItem().precio(p_cantidad));
    }

    /**
     * Setters
     */
    private void setCantidad(int p_cantidad){
        this.cantidad = p_cantidad;
    }
    
    private void setImporte(double p_importe){
        this.importe = p_importe;
    }
    
    private void setItem(Etiqueta p_item){
        this.item = p_item;
    }

    /**
     * Getters
     */
    public int getCantidad(){
        return this.cantidad;
    }

    public double getImporte(){
        return this.importe;
    }

    public Etiqueta getItem(){
        return this.item;
    }

    public void mostrar(){
        System.out.println(this.getCantidad() + " Etiquetas de " + item.toString());
        System.out.println("Precio: $" + this.getImporte());
    }

}