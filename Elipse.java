/**
 * Clase Elipse
 * @author Velozo, Agustin
 * @version 1 04/10/2023
 */
public class Elipse{
    private double sEjeMayor;
    private double sEjeMenor;
    private Punto centro;

    /**
     * Metodo constructor para instanciar objetos de la clase Elipse
     * @param double p_ejeMayor, double p_ejeMenor, Punto p_centro
     */
    public Elipse(double p_ejeMayor, double p_ejeMenor, Punto p_centro){
        this.setSEjeMayor(p_ejeMayor);
        this.setSEjeMenor(p_ejeMenor);
        this.setCentro(p_centro);
    }

    /**
     * Setters
     */
    private void setSEjeMayor(double p_ejeMayor){
        this.sEjeMayor = p_ejeMayor;
    }

    private void setSEjeMenor(double p_ejeMenor){
        this.sEjeMenor = p_ejeMenor;
    }

    private void setCentro(Punto p_centro){
        this.centro = p_centro;
    }

    /**
     * Getters
     */
    public double getSEjeMayor(){
        return this.sEjeMayor;
    }

    public double getSEjeMenor(){
        return this.sEjeMenor;
    }

    public Punto getCentro(){
        return this.centro;
    }

    /**
     * @return Devuelve el nombre de la figura como String
     */
    public String nombreFigura(){
        return "****** Elipse ******";
    }

    /**
     * Muestra caracteristicas del elipse
     */
    public void caracteristicas(){
        System.out.println(this.nombreFigura());;
        System.out.println("Centro: " + this.getCentro().coordenadas() + " - Semieje Mayor: " + this.getSEjeMayor() + " - Semieje Menor: " + this.getSEjeMenor());
        System.out.println("Superficie: " + this.superficie());
    }

    /**
     * Calcula la superficie del elipse
     * @return Devuelve la superficie del elipse como Double
     */
    public double superficie(){
        return Math.PI * this.getSEjeMayor() * this.getSEjeMenor();
    }

    /**
     * Desplaza el centro del elipse
     * @param double p_x, double p_y
     */
    public void desplazar(double p_x, double p_y){
        this.getCentro().desplazar(p_x, p_y);
    }

    /**
     * Calcula la distancia entre los centros de dos elipses
     * @param Elipse p_otraElipse
     */
    public double distanciaA(Elipse otraElipse){
        return this.getCentro().distanciaA(otraElipse.getCentro());
    }

    /**
     * Calcula cual es el elipse mayor entre dos elipses
     * @param Elipse otraElipse
     * @return Devuelve el elipse mayor
     */
    public Elipse elMayor(Elipse otraElipse){
        if(this.superficie() > otraElipse.superficie()){
            return this;
        }else{
            return otraElipse;
        }
    }

}