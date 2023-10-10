/**
 * Clase ejecutable EjecutableCuadrado
 * @author Velozo, Agustin
 * @version 1 04/10/2023
 */
public class EjecutableCuadradoYCirculo{
    public static void main(String[] args){
        Rectangulo cuadrado = new Cuadrado(new Punto(), 5);
        Rectangulo rectangulo = new Rectangulo(4, 5);

        cuadrado.caracteristicas();
        System.out.println("");
        rectangulo.caracteristicas();

        System.out.println("\nDistancia entre ambos: " + rectangulo.distanciaA(cuadrado));

        System.out.println("\nEl mayor es: " + rectangulo.elMayor(cuadrado).nombreFigura());
    
        System.out.println(" ---------------------------------");
        
        Elipse elipse = new Elipse(2, 4, new Punto());
        Elipse circulo = new Circulo(new Punto(2, 2), 5);
        
        elipse.caracteristicas();
        System.out.println("");
        circulo.caracteristicas();
    
    }
}