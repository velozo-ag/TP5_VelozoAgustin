/**
 * Clase Etiqueta
 * @author Velozo, Agustin
 * @version 1 21/10/2023
 */
public abstract class Etiqueta{
    private double costo;

    /**
     * Metodo constructor para instanciar objetos de la clase Etiqueta
     * @param double p_costo
     */
    public Etiqueta(double p_costo){
        this.setCosto(p_costo);
    }

    /**
     * Setter
     */
    private void setCosto(double p_costo){
        this.costo = p_costo;
    }

    /**
     * Getter
     */
    public double getCosto(){
        return this.costo;
    }

    /**
     * Calcula el precio de la etiqueta segun su tipo y cantidad
     * @param q
     * @return Devuelve el precio de la etiqueta
     */
    public abstract double precio(int q);

    /**
     * Convierte los atributos de la etiqueta en String
     * @return 
     */
    public String toString(){
        return "Costo: $" + this.getCosto();
    }

    /**
     * @return Devuelve el tipo de etiqueta (Premium o Comun)
     */
    protected abstract String tipo();
}