/**
 * Clase etiqueta Premium
 * @author Velozo, Agustin
 * @version 1 21/10/2023
 */
public class Premium extends Etiqueta{
    private int colores;

    /**
     * Metodo constructor para instanciar objetos de la clase Premium
     * @param double p_costo, int p_colores
     */
    public Premium(double p_costo, int p_colores){
        super(p_costo);
        this.setColores(p_colores);
    }

    /**
     * Setter
     */
    private void setColores(int p_colores){
        this.colores = p_colores;
    }

    /**
     * Getter
     */
    public int getColores(){
        return this.colores;
    }

    /**
     * Calcula el precio de la etiqueta segun su tipo y cantidad
     * @param q
     * @return Devuelve el precio de la etiqueta
     */
    public double precio(int q){
        return (this.getCosto() * q) + (q * this.getCosto() * this.adicional());
    }

    /**
     * Calcula el valor adicional a agregar segun la cantidad de colores
     * @return Devuelve el porcentaje a adicionar como decimal double
     */
    public double adicional(){
        double adicional;
        switch(this.getColores()){
            case 1:
                adicional = 0;
                break;
            case 2:
                adicional = 0.05;
                break;
            case 3:
                adicional = 0.07;
                break;
            default:
                adicional = 0.03 * this.getColores();
                break;
        }
        return adicional;
    }

    /**
     * Convierte los atributos de la etiqueta en String
     * @return 
     */
    public String toString(){
        return "tipo " + this.tipo() + " - " + super.toString() + " - Colores: " + this.getColores();
    }

    /**
     * @return Devuelve el tipo de etiqueta (Premium o Comun)
     */
    protected String tipo(){
        return "Premium";
    }
}