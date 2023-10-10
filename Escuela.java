import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Clase ejecutable Escuela
 * 
 * @author Velozo, Agustin
 * @version 1 28/09/2023
 */
public class Escuela {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in).useDelimiter("\n");

        int contAlum = 0, contPers = 0;
        int op, dni, dia, mes, anio, lu;
        double n1, n2;
        String nombre, apellido;
        Calendar nacimiento;
        Persona persona;
        Alumno alumno;

        ArrayList<Persona> personas = new ArrayList<Persona>();

        do {
            System.out.println("\n ---- Escuela ----");
            System.out.println("1 - Crear persona");
            System.out.println("2 - Inscribir alumno");
            System.out.println("3 - Eliminar persona");
            System.out.println("4 - Listar personas no alumnos");
            System.out.println("5 - Listar alumnos");
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

                    System.out.println("\n -- Crear Alumno");
                    System.out.print("DNI: ");
                    dni = input.nextInt();
                    System.out.print("LU: ");
                    lu = input.nextInt();
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
                    System.out.print("Nota 1: ");
                    n1 = input.nextDouble();
                    System.out.print("Nota 2: ");
                    n2 = input.nextDouble();

                    nacimiento = new GregorianCalendar(anio, mes, dia);
                    alumno = new Alumno(dni, lu, nombre, apellido, nacimiento);
                    alumno.setNota1(n1);
                    alumno.setNota2(n2);

                    personas.add(alumno);
                    contAlum++;
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

                            if (personas.get(i) instanceof Alumno) {
                                contAlum--;
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
                            if (!(per instanceof Alumno)) {
                                System.out.println("");
                                per.mostrar();
                            }
                        }
                    } else {
                        System.out.println("\n -- No hay personas inscriptas");
                    }

                    break;
                case 5:

                    if (contAlum != 0) {
                        for (Persona per : personas) {
                            if (per instanceof Alumno) {
                                System.out.println("");
                                per.mostrar();
                            }
                        }
                    }else{
                        System.out.println("\n -- No hay alumnos inscriptos ");
                    }

                    break;
                default:
                    break;
            }

        } while (op != 0);

    }
}