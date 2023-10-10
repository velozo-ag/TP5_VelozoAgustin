/**
 * Clase Punto
 * @author Velozo, Agustin
 * @version 2 2023
 * 
   */
public class Punto{
    private double x = 0;
    private double y = 0;
    
    /**
     * Metodos constructores para instanciar objetos de la clase Punto
     * @param double p_x, double p_y
     */
    public Punto(double p_x, double p_y){
        this.setX(p_x);
        this.setY(p_y);
    }
    public Punto(){
        this.x = 0;
        this.y = 0;
    }
    
    /**
     * Setters
     */
    private void setX(double p_x){
        this.x = p_x;
    }
    
    private void setY(double p_y){
        this.y = p_y;
    }
    
    /**
     * Getters
     */
    public double getX(){
        return this.x;
    }
    
    public double getY(){
        return this.y;
    }
    
    /**
     * Desplaza el punto modificando los valores de las coordenadas
     * @param double p_x, double p_y
     * @throws No dispara ninguna excepcion
     */
    public void desplazar(double p_x, double p_y){
        this.setX(this.getX() + p_x);
        this.setY(this.getY() + p_y);
    }
    
    /**
     * Concatena las coordenadas en un String
     * @return Devuelve las coordenadas concatenadas en un String
     * @throws No dispara ninguna excepcion
     */
    public String coordenadas(){
        return ("(" + this.getX() + ", " + this.getY() + ")");
    }
    
    public void mostrar(){
        System.out.println("Punto. X: " + this.getX() + ", Y: " + this.getY());
    }
    
    /**
     * Calcula y retorna la distancia entre este punto y otro
     * @param Punto p_ptoDistante
     * @return Devuelve la distancia hacia otro punto como double
     */
    public double distanciaA(Punto p_ptoDistante){
        double difX = p_ptoDistante.getX() - this.getX();
        
        double difY = p_ptoDistante.getY() - this.getY();
        
        return Math.sqrt(Math.pow(difX,2) + Math.pow(difY,2));
    }
}