import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase ejecutable AdministracionGerencia
 * 
 * @author Velozo, Agustin
 * @version 1 19/10/2023
 */
public class AdministracionGerencia {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        int op;

        Alojamiento alquiler;
        Gerencia gerencia = new Gerencia("Los Arroyos");

        do {
            System.out.println("\n ---- Gerencia " + gerencia.getNombre() + " ----");
            System.out.println("1 - Alquilar");
            System.out.println("2 - Despachar");
            System.out.println("3 - Liquidar alojamientos");
            System.out.print("0 - Salir\n> ");
            op = input.nextInt();

            switch (op) {
                case 1:
                    alquiler = alquilar();
                    if (alquiler != null) {
                        gerencia.agregarAlojamiento(alquiler);
                    }
                    break;
                case 2:
                    int i = 0, opAlojamiento;

                    if (gerencia.getAlojamientosAlquilados().size() > 0) {

                        System.out.println("\n ---- Seleccione alquiler a despachar ");
                        for (Alojamiento alojamiento : gerencia.getAlojamientosAlquilados()) {
                            System.out.println(i + " - " + alojamiento.getNombre());
                            i ++;
                        }

                        do {
                            opAlojamiento = input.nextInt();
                        } while (opAlojamiento < 0 || opAlojamiento >= gerencia.getAlojamientosAlquilados().size());

                        gerencia.quitarAlojamiento(gerencia.getAlojamientosAlquilados().get(opAlojamiento));

                    }else{
                        System.out.println("\n No hay alojamientos alquilados aun");
                    }

                    break;
                case 3:
                    System.out.println("");
                    gerencia.mostrarLiquidacion();
                    break;
            }

        } while (op != 0);
    }

    public static Alojamiento alquilar() {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        Alojamiento alquiler;

        String nombre;
        double precioBase;
        int op, opAux, diasAlquiler;
        ArrayList<Servicio> servicios = new ArrayList<Servicio>();

        System.out.println("\n ---- Alquilando");
        System.out.print("Tipo de Alojamiento (1- Cabaña | 2- Hotel): ");
        do {
            op = input.nextInt();
        } while (op < 1 || op > 2);

        System.out.print("Nombre: ");
        nombre = input.next();
        System.out.print("Precio Base: ");
        precioBase = input.nextDouble();
        System.out.print("Dias de Alquiler: ");
        diasAlquiler = input.nextInt();

        System.out.print("Desea contratar un servicio (1- Si | 2- No): ");
        opAux = input.nextInt();
        while (opAux == 1) {
            servicios.add(contratarServicio());
            System.out.print("\nDesea contratar otro servicio (1- Si): ");
            opAux = input.nextInt();
        }

        switch (op) {
            case 1:
                int nroHabitaciones;

                System.out.print("Nro de Habitaciones: ");
                do{
                    nroHabitaciones = input.nextInt();
                }while(nroHabitaciones < 1);

                alquiler = new Cabaña(nombre, precioBase, diasAlquiler, servicios, nroHabitaciones);
                break;
            case 2:

                System.out.print("Tipo de Habitacion (1- Single | 2- Double): ");
                opAux = input.nextInt();

                if (opAux == 1) {
                    alquiler = new Hotel(nombre, precioBase, diasAlquiler, servicios, "Single");
                } else {
                    alquiler = new Hotel(nombre, precioBase, diasAlquiler, servicios, "Double");
                }
                break;
            default:
                alquiler = null;
                break;
        }

        return alquiler;

    }

    public static Servicio contratarServicio() {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        String descripcion;
        double precio;

        System.out.print("Descripcion: ");
        descripcion = input.next();
        System.out.print("Percio: ");
        precio = input.nextDouble();

        return new Servicio(descripcion, precio);
    }
}