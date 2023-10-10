/**
 * Clase Cuadrado
 * @author Velozo, Agustin
 * @version 1 04/10/2023
 */
public class Cuadrado extends Rectangulo{

    /**
     * Metodo constructor para instanciar objetos de la clase Cuadrado
     * @param Punto p_origen, double p_lado
     */
    public Cuadrado(Punto p_origen, double p_lado){
        super(p_origen, p_lado, p_lado);
    }

    /**
     * @return Devuelve el nombre de la figura como String 
     */
    public String nombreFigura(){
        return "****** Cuadrado ******";
    }

}