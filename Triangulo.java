/**
 * Clase Triangulo
 * @author Velozo, Agustin
 * @version 1 16/10/2023
 */
public class Triangulo extends FiguraGeometrica{
    private double base;
    private double altura;

    /**
     * Metodo constructor para instanciar objetos de la clase Triangulo
     * @param double p_base, double p_altura, Punto p_origen
     */
    public Triangulo(double p_base, double p_altura, Punto p_origen){
        super(p_origen);
        this.setBase(p_base);
        this.setAltura(p_altura);
    }
    /**
     * @param double p_base, double p_altura
     */
    public Triangulo(double p_base, double p_altura){
        this.setBase(p_base);
        this.setAltura(p_altura);
    }

    /**
     * Setters
     */
    private void setBase(double p_base){
        this.base = p_base;
    }

    private void setAltura(double p_altura){
        this.altura = p_altura;
    }

    /**
     * Getters
     */
    public double getBase(){
        return this.base;
    }

    public double getAltura(){
        return this.altura;
    }

    /**
     * Calcula la superficie de la figura Triangulo
     * @return Devuelve como double la superficie del Triangulo
     */
    public double superficie(){
        return (this.getBase() * this.getAltura()) / 2;
    }

    public String nombreFigura(){
        return "****** Triangulo ******";
    }
}