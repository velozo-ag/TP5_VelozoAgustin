/**
 * Clase ArtefactoHogar
 * @author Velozo, Agustin
 * @version 1 18/10/2023
 */
public abstract class ArtefactoHogar{
    private String marca;
    private float precio;
    private int stock;

    /**
     * Metodo constructor pqra instanciar objetos de la clase ArtefactoHogar
     * @param String p_marca, float p_precio, int p_stock
     */
    public ArtefactoHogar(String p_marca, float p_precio, int p_stock){
        this.setMarca(p_marca);
        this.setPrecio(p_precio);
        this.setStock(p_stock);
    }

    /**
     * Setters
     */
    private void setMarca(String p_marca){
        this.marca = p_marca;
    }

    private void setPrecio(float p_precio){
        this.precio = p_precio;
    }

    private void setStock(int p_stock){
        this.stock = p_stock;
    }

    /**
     * Getters
     */
    public String getMarca(){
        return this.marca;
    }

    public float getPrecio(){
        return this.precio;
    }

    public int getStock(){
        return this.stock;
    }

    /**
     * Muestra por pantalla los atributos del objeto
     */
    public void imprimir(){
        System.out.println("Marca: " + this.getMarca() + " - Precio: " + this.getPrecio() + " - Stock: " + this.getStock());
    }

    /**
     * Calcula el valor de cada cuota al solicitar un credito
     * @param int p_cuotas, float p_interes
     * @return Devuelve el valor de una cuota como float
     */
    public float cuotaCredito(int p_cuotas, float p_interes){
        return ((this.getPrecio() * ((p_cuotas * p_interes) / 100)) + this.getPrecio()) / 6;
    }

    /**
     * Segun el artefacto, se le agrega un adicional a cada cuota segun las propiedades de este
     * @param int p_cuotas, float p_interes
     * @return Devuelve el valor de una cuota como float
     */
    public abstract float creditoConAdicional(int p_cuotas, float p_interes);

}