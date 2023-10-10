import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Clase ejecutable Empresa
 * 
 * @author Velozo, Agustin
 * @version 1 28/09/2023
 */
public class Empresa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in).useDelimiter("\n");

        int contEmp = 0, contPers = 0;
        long cuil;
        double sueldoBasico;
        int op, dni, dia, mes, anio, anioIngreso;
        String nombre, apellido;
        Calendar nacimiento;
        Persona persona;
        Empleado empleado;

        ArrayList<Persona> personas = new ArrayList<Persona>();

        do {
            System.out.println("\n ---- Empresa ----");
            System.out.println("1 - Crear persona");
            System.out.println("2 - Contratar empleado");
            System.out.println("3 - Eliminar persona");
            System.out.println("4 - Listar personas no empleadas");
            System.out.println("5 - Listar empleados");
            System.out.print("0 - Salir \n> ");
            op = input.nextInt();

            switch (op) {
                case 1:

                    System.out.println("\n -- Crear Persona");
                    System.out.print("DNI: ");
                    dni = input.nextInt();
                    System.out.print("Nombre: ");
                    nombre = input.next();
                    System.out.print("Apellido: ");
                    apellido = input.next();
                    System.out.print("Dia Nacimiento: ");
                    dia = input.nextInt();
                    System.out.print("Mes Nacimiento: ");
                    mes = input.nextInt();
                    System.out.print("Anio Nacimiento: ");
                    anio = input.nextInt();

                    nacimiento = new GregorianCalendar(anio, mes, dia);
                    persona = new Persona(dni, nombre, apellido, nacimiento);
                    personas.add(persona);
                    contPers++;
                    break;
                case 2:

                    System.out.println("\n -- Crear Empleado");
                    System.out.print("DNI: ");
                    dni = input.nextInt();
                    System.out.print("Cuil: ");
                    cuil = input.nextLong();
                    System.out.print("Nombre: ");
                    nombre = input.next();
                    System.out.print("Apellido: ");
                    apellido = input.next();
                    System.out.print("Dia Nacimiento: ");
                    dia = input.nextInt();
                    System.out.print("Mes Nacimiento: ");
                    mes = input.nextInt();
                    System.out.print("Anio Nacimiento: ");
                    anio = input.nextInt();
                    System.out.print("Anio Ingreso: ");
                    anioIngreso = input.nextInt();
                    System.out.print("Sueldo Basico: ");
                    sueldoBasico = input.nextDouble();


                    nacimiento = new GregorianCalendar(anio, mes, dia);
                    empleado = new Empleado(dni, nombre, apellido, nacimiento, cuil, sueldoBasico, anioIngreso);

                    personas.add(empleado);
                    contEmp++;
                    break;
                case 3:

                    if (personas.size() == 0) {
                        System.out.println("\n -- No hay personas");
                        break;
                    }

                         System.out.println("\n -- Eliminar Persona");
                    System.out.print("DNI: ");
                    dni = input.nextInt();

                    for (int i = 0; i < personas.size(); i++) {
                        if (personas.get(i).getNroDni() == dni) {

                            if (personas.get(i) instanceof Empleado) {
                                contEmp--;
                            } else {
                                contPers--;
                            }

                            personas.remove(i);
                            System.out.println(" ** Persona eliminada");

                            break;
                        }
                    }

                    break;
                case 4:

                    if (contPers != 0) {
                        for (Persona per : personas) {
                            if (!(per instanceof Empleado)) {
                                System.out.println("");
                                per.mostrar();
                            }
                        }
                    } else {
                        System.out.println("\n -- No hay personas desempleadas");
                    }

                    break;
                case 5:

                    if (contEmp != 0) {
                        for (Persona per : personas) {
                            if (per instanceof Empleado) {
                                System.out.println("");
                                per.mostrar();
                            }
                        }
                    }else{
                        System.out.println("\n -- No hay empleados contratados ");
                    }

                    break;
                default:
                    break;
            }

        } while (op != 0);

    }
}
