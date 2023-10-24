import java.util.ArrayList;

/**
 * Clase Jardin
 * @author Velozo, Agustin
 * @version 1 16/10/2023
 */
public class Jardin{
    private String nombre;
    private ArrayList<FiguraGeometrica> figuras;

    /**
     * Metodo constructor para instanciar objetos de la clase Jardin
     * @param String p_nombre, ArrayList<FiguraGeometrica> p_figuras
     */
    public Jardin(String p_nombre, ArrayList<FiguraGeometrica> p_figuras){
        this.setNombre(p_nombre);
        this.setFiguras(p_figuras);
    }
    /**
     * @param String p_nombre
     */
    public Jardin(String p_nombre){
        this.setNombre(p_nombre);
        this.setFiguras(new ArrayList<FiguraGeometrica>());
    }

    /**
     * Setters
     */
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }

    private void setFiguras(ArrayList<FiguraGeometrica> p_figuras){
        this.figuras = p_figuras;
    }

    /**
     * Getters
     */
    public String getNombre(){
        return this.nombre;
    }

    public ArrayList<FiguraGeometrica> getFiguras(){
        return this.figuras;
    }

    /**
     * Modifica el valor del atributo Figuras agregando un elemento
     * @param FiguraGeometrica p_figura
     */
    public void agregarFigura(FiguraGeometrica p_figura){
        this.getFiguras().add(p_figura);
    }
 
    /**
     * Modifica el valor del atributo Figuras quitando un elemento
     * @param FiguraGeometrica p_figura
     */
    public void quitarFigura(FiguraGeometrica p_figura){
        this.getFiguras().remove(p_figura);
    }

    /**
     * Calcula cuantos metros cuadrados abarcan todas las figuras
     * @return Devuelve la cantidad de metros cuadrados como double
     */
    public double cuantosMetros(){
        double acum = 0;
        for(FiguraGeometrica figura : this.getFiguras()){
            acum += figura.superficie();
        }
        return acum;
    }

    /**
     * Calcula cuantos litros de pintura se necesitan para cubrir los metros cuadrados de figuras
     * @return Devuelve la cantidad de litros necesarios como double
     */
    private double cuantosLitros(){
        return (this.cuantosMetros() * 4) / 20;
    }

    /**
     * Calcula la cantidad de latas que se necesitan en base a los litros de pintura
     * @return Devuelve la cantidad de latas necesarias como int
     */
    public int cuantasLatas(){
        return (int)Math.ceil(this.cuantosLitros() / 4);
    }

    public void detalleFiguras(){
        System.out.println("Presupuesto: " + this.getNombre() + "\n");
        for(FiguraGeometrica figura : this.getFiguras()){
            figura.mostrarSuperficie();
        }
        System.out.println("-----------------------");
        System.out.println("  Total a cubrir: " + this.cuantosMetros());
        System.out.println("  Comprar " + this.cuantasLatas() + " latas");
    }
    
}