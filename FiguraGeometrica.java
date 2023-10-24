/**
 * Clase FiguraGeometrica
 * @author Velozo, Agustin
 * @version 1 16/10/2023
 */
public abstract class FiguraGeometrica{
    private Punto origen;

    /**
     * Metodo Constructor para instanciar objetos de la clase FiguraGeometrica
     * @param Punto p_origen
     */
    public FiguraGeometrica(Punto p_origen){
        this.setOrigen(p_origen);
    }
    public FiguraGeometrica(){
        this.setOrigen(new Punto());
    }

    /**
     * Setter
     */
    private void setOrigen(Punto p_origen){
        this.origen = p_origen;
    }

    /**
     * Getter
     */
    public Punto getOrigen(){
        return this.origen;
    }

    /**
     * @return Devuelve un String del nombre de la figura geometrica
     */
    public abstract String nombreFigura();

    /**
     * Calcula la superficie de la figura
     * @return Devuelve la superficie como double
     */
    public abstract double superficie();

    /**
     * Muestra la superficie junto al nombre de la figura
     */
    public void mostrarSuperficie(){
        System.out.println(this.nombreFigura());
        System.out.println("Superficie: " + this.superficie());
    }
}