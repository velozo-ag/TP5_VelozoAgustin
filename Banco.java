import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Clase ejecutable Banco
 * 
 * @author Velozo, Agustin
 * @version 1 04/09/2023
 */
public class Banco {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String nombre, apellido;
        int dni, op, monto, anio, dia, mes;
        Calendar fecha;

        Persona persona;
        CajaDeAhorro miCajaDeAhorro;
        CuentaCorriente miCuentaCorriente;

        System.out.print("Ingrese su nombre: \n> ");
        nombre = input.next();
        System.out.print("Ingrese su apellido: \n> ");
        apellido = input.next();
        System.out.print("Ingrese su DNI: \n> ");
        dni = input.nextInt();
        System.out.print("Ingrese su dia de nacimiento: \n> ");
        dia = input.nextInt();
        System.out.print("Ingrese su mes de nacimiento: \n> ");
        mes = input.nextInt();
        System.out.print("Ingrese su anio de nacimiento: \n> ");
        anio = input.nextInt();

        fecha = new GregorianCalendar(anio, mes, dia);

        persona = new Persona(dni, nombre, apellido, fecha);
        miCajaDeAhorro = new CajaDeAhorro(1, persona, 500);
        miCuentaCorriente = new CuentaCorriente(1, persona, 500);

        System.out.println("\nSe le asigno una Caja de Ahorro y una Cuenta Corriente con $500 c/u al titular: ");
        persona.mostrar();

        if(persona.esCumpleaños()){
            System.out.println("\n ---- Feliz Cumpleaños!!! ----");
        }

        do {

            System.out.println("\n ------------ Menu ------------ ");
            System.out.println(" ------ Cuenta Corriente ------ ");
            System.out.println("1 - Mostrar Cuenta Corriente");
            System.out.println("2 - Extraer dinero de CC");
            System.out.println("3 - Depositar dinero en CC");
            System.out.println("\n ------- Caja de Ahorro ------- ");
            System.out.println("4 - Mostrar Caja de Ahorro");
            System.out.println("5 - Extraer dinero de CA");
            System.out.println("6 - Depositar dinero en CA");
            System.out.print("0 - Salir \n> ");
            op = input.nextInt();

            System.out.println(" ");

            switch (op) {
                case 1:
                    miCuentaCorriente.mostrar();
                    break;
                case 2:
                    System.out.print("Ingrese el monto a extraer de su CC: \n> ");
                    monto = input.nextInt();

                    miCuentaCorriente.extraer(monto);
                    break;
                case 3:
                    System.out.print("Ingrese el monto a depositar en su CC: \n> ");
                    monto = input.nextInt();

                    miCuentaCorriente.depositar(monto);
                    break;
                case 4:
                    miCajaDeAhorro.mostrar();

                    break;
                case 5:
                    System.out.print("Ingrese el monto a extraer de su CA: \n> ");
                    monto = input.nextInt();

                    miCajaDeAhorro.extraer(monto);
                    break;
                case 6:
                    System.out.print("Ingrese el monto a depositar en su CA: \n> ");
                    monto = input.nextInt();

                    miCajaDeAhorro.depositar(monto);
                    break;
                default:
                    break;
            }

        } while (op != 0);

    }
}