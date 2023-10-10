/**
 * Clase Rectangulo
 * @author Velozo, Agustin
 * @version 2 04/10/2023
 */
public class Rectangulo{
    private Punto origen;
    private double ancho;
    private double alto;
    
    /**
     * Metodo constructor para instanciar objetos de la clase Rectangulo
     * @param Punto p_origen, double p_ancho, double p_alto
     */
    public Rectangulo(Punto p_origen, double p_ancho, double p_alto){
        this.setOrigen(p_origen);
        this.setAncho(p_ancho);
        this.setAlto(p_alto);
    }
    /**
     * @param double p_ancho, double p_altof
     */
    public Rectangulo(double p_ancho, double p_alto){
        Punto p1 = new Punto(0,0);
        this.setOrigen(p1);
        this.setAncho(p_ancho);
        this.setAlto(p_alto);
    }
    
    /**
     * Setters
     */
    private void setOrigen(Punto p_origen){
        this.origen = p_origen;
    }
    
    private void setAncho(double p_ancho){
        this.ancho = p_ancho;
    }
    
    private void setAlto(double p_alto){
        this.alto = p_alto;
    }
    
    /**
     * Getters
     */
    public Punto getOrigen(){
        return this.origen;
    }
    
    public double getAncho(){
        return this.ancho;
    }
    
    public double getAlto(){
        return this.alto;
    }
    
    /**
     * Desplaza la posicion del origen del rectangulo
     * @param double p_x, double p_y
     */
    public void desplazar(double p_x, double p_y){
        this.getOrigen().desplazar(p_x, p_y);
    }
    
    /**
     * Calcula el perimetro del rectangulo
     * @return Devuelve la suma de todos los lados del rectangulo como double
     */
    public double perimetro(){
        return (this.getAncho() * 2) + (this.getAlto() * 2);
    }
    
    /**
     * Calcula la superficie del rectangulo
     * @return Devuelve el producto entre el ancho y el alto del rectangulo como double
     */
    public double superficie(){
        return this.getAncho() * this.getAlto();
    }
    
    /**
     * Calcula la distancia entre los puntos de origen de dos rectangulos
     * @param Rectangulo otroRectangulo
     * @return Devuelve la distancia entre dos rectangulos como double
     */
    public double distanciaA(Rectangulo otroRectangulo){
        return this.getOrigen().distanciaA(otroRectangulo.getOrigen());
    }
    
    /**
     * Compara cual es el rectangulo de mayor superficie entre dos rectangulos
     * @param Rectangulo otroRectangulo
     * @return Devuelve el Rectangulo de mayor superficie
     */
    public Rectangulo elMayor(Rectangulo otroRectangulo){
        if(this.superficie() > otroRectangulo.superficie()){
            return this;
        }
        return otroRectangulo;
    }
    
    /**
     * Muestra una leyenda de todas las caracteristicas del rectangulo
     */
    public void caracteristicas(){
        System.out.println(this.nombreFigura());
        System.out.println("Origen: " + this.getOrigen().coordenadas() + " - Alto: " + this.getAlto() + " - Ancho: " + this.getAncho());
        System.out.println("Superficie: " + this.superficie() + " - Perimetro: " + this.perimetro());
    }
    
    /**
     * @return Devuelve el nombre de la figura como String 
     */
    public String nombreFigura(){
        return "****** Rectangulo ******";
    }
}