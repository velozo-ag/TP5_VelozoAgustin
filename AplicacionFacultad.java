import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Clase Ejecutabl AplicacionFacultad
 * 
 * @author Velozo, Agustin
 * @version 1 11/10/2023
 */
public class AplicacionFacultad {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int op, cant;
        Facultad facu;
        ArrayList<Profesor> profes = new ArrayList<Profesor>();
        String nombreFacu;

        System.out.println(" --- Creando facultad ---");
        System.out.print("Nombre: ");
        nombreFacu = input.next();
        System.out.print(" -- Cuantos profesores posee la facultad \n > ");
        do{
            cant = input.nextInt();
        }while(cant < 1);

        for(int j = 0; j < cant; j++){
            profes.add(crearProfesor());
        }

        facu = new Facultad(nombreFacu, profes);

        do {
            System.out.println("\n ----- Institucion " + facu.getNombre() + " ----- ");
            System.out.println("1 - Contratar Profesor");
            System.out.println("2 - Despedir Profesor");
            System.out.println("3 - Nomina Profesores");
            System.out.println("4 - Listar Profesores");
            System.out.println("0 - Salir");
            op = input.nextInt();

            switch(op){
                case 1:
                    Profesor profe;
                    profe = crearProfesor();
                    facu.agregarProfesor(profe);
                    break;
                case 2:
                    int opcion;
                    cant = 0;
                    if(facu.getProfesores().size() > 1){

                        System.out.println(" -- Seleccione profesor");
                        for(Profesor profesor : facu.getProfesores()){
                            System.out.println(cant + " - " + profesor.mostrarLinea());
                            cant ++;
                        }
                        do{
                            opcion = input.nextInt();
                        }while(opcion < 0 || opcion >= facu.getProfesores().size());

                        facu.quitarProfesor(facu.getProfesores().get(opcion));

                    }else{
                        System.out.println("Al menos debe haber un profesor en la facultad");
                    }
                    break;
                case 3:
                    facu.nominaProfesores();
                    break;
                case 4:
                    facu.listarProfesorCargos();
                    break;
                default:
                    break;
            }

        } while (op != 0);
    }

    public static Profesor crearProfesor() {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        Profesor profe;

        int nroDni, dia, mes, anio, cargos;
        String nombre, apellido, titulo;
        Calendar fechaNacimiento;
        ArrayList<Cargo> listaCargos = new ArrayList<Cargo>();

        System.out.println("\n --- Contratando Profesor --- ");
        System.out.print("Dni: ");
        nroDni = input.nextInt();
        System.out.print("Nombre: ");
        nombre = input.next();
        System.out.print("Apellido: ");
        apellido = input.next();
        System.out.print("Titulo: ");
        titulo = input.next();
        System.out.print("Dia Nacimiento: ");
        dia = input.nextInt();
        System.out.print("Mes Nacimiento: ");
        mes = input.nextInt();
        System.out.print("Anio Nacimiento: ");
        anio = input.nextInt();

        System.out.print("Cantidad de cargos: ");
        do{
            cargos = input.nextInt();
        }while(cargos < 1 || cargos > 3);

        for(int i = 0; i < cargos; i++){
            System.out.println(" --- Cargo " + (i +1) + " ---");
            listaCargos.add(crearCargo());
        }

        fechaNacimiento = new GregorianCalendar(anio, mes, dia);
        profe = new Profesor(nroDni, nombre, apellido, fechaNacimiento, titulo, listaCargos);

        return profe;
    }

    public static Cargo crearCargo() {
        Scanner input = new Scanner(System.in);
        Cargo cargo;
        String nombre;
        double sueldo;
        int op, docencia, investigacion, ingreso, extension;

        System.out.print(" -- Ingrese que tipo de cargo posee: \n1 - Simple\n2 - SemiExclusivo\n3 - Exclusivo\n> ");

        do {
            op = input.nextInt();
        } while (op < 1 || op > 3);

        System.out.print("Nombre Cargo: ");
        nombre = input.next();
        System.out.print("Sueldo: ");
        sueldo = input.nextDouble();
        System.out.print("Anio ingreso: ");
        ingreso = input.nextInt();

        switch (op) {
            case 1:
                cargo = new Cargo(nombre, sueldo, ingreso);
                return cargo;
            case 2:
                do {
                    System.out.println("- Deben ser un total de 10 horas -");
                    System.out.print("Horas extension docencia: ");
                    docencia = input.nextInt();
                    System.out.print("Horas investigacion: ");
                    investigacion = input.nextInt();
                } while ((docencia + investigacion) != 10);

                cargo = new SemiExclusivo(nombre, sueldo, ingreso, investigacion, docencia);
                return cargo;
            case 3:
                do {
                    System.out.print("Horas docencia: ");
                    docencia = input.nextInt();
                    System.out.print("Horas extension docencia: ");
                    extension = input.nextInt();
                    System.out.print("Horas investigacion: ");
                    investigacion = input.nextInt();
                } while (docencia < 0 || investigacion < 0 || extension < 0);

                cargo = new Exclusivo(nombre, sueldo, ingreso, investigacion, extension, docencia);
                return cargo;
            default:
                return null;
        }

    }
}
