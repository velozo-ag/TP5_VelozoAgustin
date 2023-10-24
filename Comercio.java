import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase ejecutable Comercio
 * 
 * @author Velozo, Agustin
 * @version 1 19/10/2023
 */
public class Comercio {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        ArrayList<ArtefactoHogar> productos = new ArrayList<ArtefactoHogar>();
        ArtefactoHogar artefacto;

        int op;

        do {
            System.out.println("\n ----- Comercio ----- ");
            System.out.println("1 - Comprar artefacto");
            System.out.println("2 - Mostrar artefactos vendidos");
            System.out.print("0 - Salir \n> ");
            op = input.nextInt();       

            switch (op) {
                case 1:
                    int cuotas;
                    float interes;

                    artefacto = crearArtefacto();
                    if(artefacto != null){
                        productos.add(artefacto);
                    }

                    System.out.print("Cuotas a pagar: ");
                    cuotas = input.nextInt();
                    System.out.print("Porcentaje de interes mensual: ");
                    interes = input.nextFloat();

                    System.out.println("");
                    artefacto.imprimir();
                    System.out.println("Cuotas: " + cuotas + " - Interes: " + interes + "%");
                    System.out.println("Valor Cuota: " + artefacto.cuotaCredito(cuotas, interes));
                    System.out.println("Valor Cuota Con Adicionales: " + artefacto.creditoConAdicional(cuotas, interes));

                    break;
                case 2:
                    System.out.println("\n --- Productos Vendidos");
                    if(productos.size() >= 1){
                        for(ArtefactoHogar art : productos){
                            art.imprimir();
                        }
                    }else{
                        System.out.println("No se vendieron productos");
                    }
                    break;
            }

        } while (op != 0);
    }

    public static ArtefactoHogar crearArtefacto() {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        ArtefactoHogar artefacto;
        int op, stock;
        String marca;
        float precio;

        System.out.println(" --- Creando Artefacto");
        System.out.print("Tipo (1- Cocina | 2- Heladera | 3- Lavarropas): ");
        do {
            op = input.nextInt();
        } while (op < 1 || op > 3);

        System.out.print("Marca: ");
        marca = input.next();
        System.out.print("Precio: ");
        do {
            precio = input.nextFloat();
        } while (precio < 1);
        System.out.print("Stock: ");
        do {
            stock = input.nextInt();
        } while (stock < 0);

        switch (op) {
            case 1:
                int hornallas, calorias;
                String dimensiones;

                System.out.print("Hornallas: ");
                hornallas = input.nextInt();
                System.out.print("Calorias: ");
                calorias = input.nextInt();
                System.out.print("Dimensiones: ");
                dimensiones = input.next();

                artefacto = new Cocina(marca, precio, stock, hornallas, calorias, dimensiones);

                break;
            case 2:
                int pies, puertas;
                boolean compresor;

                System.out.print("Pies: ");
                pies = input.nextInt();
                System.out.print("Puertas: ");
                puertas = input.nextInt();
                System.out.print("Compresor (1- Si | 2- No): ");
                if(input.nextInt() == 1){
                    compresor = true;
                }else{
                    compresor = false;
                }

                artefacto = new Heladera(marca, precio, stock, pies, puertas, compresor);

                break;
            case 3:
                int programas;
                float kilos;
                boolean automatico;

                System.out.print("Programas: ");
                programas = input.nextInt();
                System.out.print("Kilos: ");
                kilos = input.nextFloat();
                System.out.print("Automatico (1- Si | 2- No): ");
                if(input.nextInt() == 1){
                    automatico = true;
                }else{
                    automatico = false;
                }

                artefacto = new Lavarropas(marca, precio, stock, programas, kilos, automatico);

                break;
            default:
                artefacto = null;
                break;
        }

        return artefacto;
    }
}