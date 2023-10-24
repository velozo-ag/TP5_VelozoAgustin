/**
 * Clase Circulo
 * @author Velozo, Agustin
 * @version 2 04/10/2023
 */
public class Circulo extends Elipse{
    private double radio;
    /**
     * Metodo constructor para instanciar objetos de la clase circulo
     * @param Punto p_punto, double p_radio
     */
    public Circulo(Punto p_punto, double p_radio){
        super(p_radio, p_radio, p_punto);
        this.setRadio(p_radio);
    }

    /**
     * Setter
     */
    private void setRadio(double p_radio){
        this.radio = p_radio;
    }

    /**
     * Getter
     */
    public double getRadio(){
        return this.radio;
    }

    /**
     * @return Devuelve el nombre de la clase
     */
    public String nombreFigura(){
        return "****** Circulo ******";
    }

    /**
     * Muestra caracteristicas del elipse
     */
    public void caracteristicas(){
        System.out.println(this.nombreFigura());;
        System.out.println("Centro: " + this.getCentro().coordenadas() + " - Radio: " + this.getRadio());
        System.out.println("Superficie: " + this.superficie());
    }

    /**
     * Calcula la superficie del elipse
     * @return Devuelve la superficie del elipse como Double
     */
    public double superficie(){
        return Math.PI * Math.pow(this.getRadio(), 2);
    }

}