import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Clase ejecutable VentadeEntradas
 * 
 * @author Velozo, Agustin
 * @version 1 21/10/2023
 */
public class VentadeEntradas {
    static Scanner input = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args) {

        Zoologico zoo = new Zoologico("El Caribu");
        Visitante visitante;
        int op, dia, mes, anio;
        String tipoVisit;
        Calendar fecha;

        do {

            System.out.println("\n ------- Zoo 'El Caribu' -------");
            System.out.println("1 - Nuevo Visitante");
            System.out.println("2 - Borrar Visitante");
            System.out.println("3 - Visitantes por Fecha");
            System.out.println("4 - Visitantes por Tipo y Fecha");
            System.out.println("5 - Recaudacion lo que va del mes");
            System.out.print("0 - Salir \n> ");
            op = input.nextInt();

            switch (op) {
                case 1:
                    visitante = nuevoVisitante();
                    if (visitante != null) {
                        zoo.nuevoVisitante(visitante);
                    }
                    break;
                case 2:
                    int borrar, iter = 0;

                    if (zoo.getVisitantes().size() < 1) {
                        System.out.println("\nNo hubieron visitantes aun");
                        break;
                    }

                    System.out.println("\nSeleccione visitante a borrar");

                    for (Visitante visit : zoo.getVisitantes()) {
                        System.out.println(iter + " - " + visit.getNombre());
                        iter++;
                    }

                    borrar = input.nextInt();

                    zoo.quitarVisitante(zoo.getVisitantes().get(borrar));

                    break;
                case 3:

                    if (zoo.getVisitantes().size() < 1) {
                        System.out.println("\nNo hubieron visitantes aun");
                        break;
                    }

                    System.out.println("\nIngrese la fecha: ");
                    System.out.print("Dia: ");
                    dia = input.nextInt();
                    System.out.print("Mes: ");
                    mes = input.nextInt();
                    System.out.print("Anio: ");
                    anio = input.nextInt();

                    fecha = new GregorianCalendar(anio, mes -1 , dia);

                    zoo.listaVisitantePorFecha(fecha);

                    break;
                case 4:

                    if (zoo.getVisitantes().size() < 1) {
                        System.out.println("\nNo hubieron visitantes aun");
                        break;
                    }

                    System.out.print("\nIngrese Tipo Visitante (Individuo | Delegacion): ");
                    tipoVisit = input.next();
                    System.out.println("Ingrese la fecha: ");
                    System.out.print("Dia: ");
                    dia = input.nextInt();
                    System.out.print("Mes: ");
                    mes = input.nextInt();
                    System.out.print("Anio: ");
                    anio = input.nextInt();

                    fecha = new GregorianCalendar(anio, mes -1 , dia);

                    zoo.listaTipoVisitantePorFecha(fecha, tipoVisit);

                    break;
                case 5:

                    Calendar fechaHasta = new GregorianCalendar();
                    Calendar fechaDesde = new GregorianCalendar(fechaHasta.get(Calendar.YEAR), fechaHasta.get(Calendar.MONTH), 1);
                    double recaudado = zoo.recaudacion(fechaDesde, fechaHasta);

                    if(recaudado == 0){
                        System.out.println("\n -- No han habido visitas en lo que va del mes");
                    }else{
                        System.out.println("\n -- Se han recaudado $" + recaudado + " en lo que va del mes");
                    }
                    
                    break;
            }

        } while (op != 0);

    }

    public static Visitante nuevoVisitante() {
        Visitante visitante;
        int op;

        System.out.print("Tipo Visitante (1- Individuo | 2- Delegacion): ");
        do {
            op = input.nextInt();
        } while (op < 1 || op > 2);

        switch (op) {
            case 1:
                visitante = crearIndividuo();
                break;

            case 2:
                visitante = crearDelegacion();
                break;

            default:
                visitante = null;
                break;
        }

        return visitante;

    }

    public static Persona crearPersona() {

        Persona pers;
        Calendar fecha;
        int dni, dia, mes, anio;
        String nombre, apellido;

        System.out.println("\n -- Creando Persona");
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

        fecha = new GregorianCalendar(anio, mes, dia);
        pers = new Persona(dni, nombre, apellido, fecha);

        return pers;

    }

    public static Individuo crearIndividuo() {

        Individuo visitante;
        Calendar fecha;
        int dia, mes, anio;

        Persona persona = crearPersona();

        System.out.print("Dia de Visita: ");
        dia = input.nextInt();
        System.out.print("Mes de Visita: ");
        mes = input.nextInt();
        System.out.print("Anio de Visita: ");
        anio = input.nextInt();

        fecha = new GregorianCalendar(anio, mes - 1, dia);

        visitante = new Individuo(persona.getNombre(), fecha, persona);

        return visitante;

    }

    public static Delegacion crearDelegacion() {

        Delegacion visitante;
        Persona pers;
        Individuo individuo;
        Calendar fecha;

        String nombre;
        int dia, mes, anio, otro = 1;

        System.out.print("Nombre Delegacion: ");
        nombre = input.next();
        System.out.print("Dia de Visita: ");
        dia = input.nextInt();
        System.out.print("Mes de Visita: ");
        mes = input.nextInt();
        System.out.print("Anio de Visita: ");
        anio = input.nextInt();
        fecha = new GregorianCalendar(anio, mes - 1, dia);

        System.out.println(" -- Inscribiendo individuos");
        // Crea al menos un Individuo
        pers = crearPersona();
        individuo = new Individuo(pers.getNombre(), fecha, pers);
        // Crea la Delegacionw
        visitante = new Delegacion(nombre, fecha, individuo);

        System.out.print("Desea agregar otro individuo (1- Si): ");
        otro = input.nextInt();

        // Crea el resto de Individuos
        while (otro == 1) {

            pers = crearPersona();
            individuo = new Individuo(pers.getNombre(), fecha, pers);

            visitante.inscribirIndividuo(individuo);

            System.out.print("Desea agregar otro individuo (1- Si): ");
            otro = input.nextInt();

        }
        ;

        return visitante;

    }

}