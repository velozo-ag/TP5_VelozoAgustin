/**
 * Clase Circulo
 * @author Velozo, Agustin
 * @version 2 04/10/2023
 */
public class Circulo extends Elipse{

    /**
     * Metodo constructor para instanciar objetos de la clase circulo
     * @param Punto p_punto, double p_radio
     */
    public Circulo(Punto p_punto, double p_radio){
        super(p_radio, p_radio, p_punto);
    }

    /**
     * @return Devuelve el nombre de la clase
     */
    public String nombreFigura(){
        return "****** Circulo ******";
    }

}