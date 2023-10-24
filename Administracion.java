import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase ejecutable Administracion
 * @author Velozo, Agustin
 * @version 1 16/10/2023
 */
public class Administracion{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in).useDelimiter("\n");
        Jardin jardin;
        Punto punto = new Punto();

        ArrayList<FiguraGeometrica> figuras = new ArrayList<FiguraGeometrica>();
        figuras.add(new Cuadrado(punto, 6));
        figuras.add(new Triangulo(3, 4, punto));
        figuras.add(new Circulo(punto, 3));
        
        jardin = new Jardin("Bichito de Luz", figuras);

        jardin.detalleFiguras();

    }
}