/**
 * Clase etiqueta Comun
 * @author Velozo, Agustin
 * @version 1 21/10/2023
 */
public class Comun extends Etiqueta{
    private double plus;

    /**
     * Metodo constructor para instanciar objetos de la clase Comun
     * @param double p_plus
     */
    public Comun(double p_plus){
        super(100);
        this.setPlus(p_plus);
    }

    /**
     * Setter
     */
    private void setPlus(double p_plus){
        this.plus = p_plus;
    }

    /**
     * Getter
     */
    public double getPlus(){
        return this.plus;
    }

    /**
     * Calcula el precio de la etiqueta segun su tipo y cantidad 
     * @param q
     * @return Devuelve el precio de la etiqueta
     */
    public double precio(int q){// 5800 - 290
        double sinDescuento = (this.getCosto() * q) + this.getPlus();
        return sinDescuento - (sinDescuento * descuento(q));
    }

    /**
     * Calcula el descuento segun la cantidad de etiquetas
     * @param int q
     * @return Devuelve el descuento como porcentaje
     */
    private double descuento(int q){
        double desc = 0;

        if(q > 100){
            desc = Math.floor(q / 10) / 100;
        }else if(q > 50){
            desc = .05;
        }else if(q > 10){
            desc = .02;
        }

        return desc;
    }

    /**
     * Convierte los atributos de la etiqueta en String
     * @return 
     */
    public String toString(){
        return "tipo " + this.tipo() + " - " + super.toString() + " - Diseño: $" + this.getPlus();
    }

    /**
     * @return Devuelve el tipo de etiqueta (Premium o Comun)
     */
    protected String tipo(){
        return "Comun";
    }
}