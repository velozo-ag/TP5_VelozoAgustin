import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Clase Persona
 * @author Velozo, Agustin
 * @version 2023
 * 
   */
public class Persona {
    // Atributos
    private int nroDni = 0;
    private String nombre = "";  
    private String apellido = "";
    private Calendar fechaNacimiento;

    // Constructores
    /** 
     * Metodo constructor de la clase, utilizado para instanciar un objeto de la clase Persona
     * @param int p_nroDni, String p_nombre, String p_apellido, int p_anioNacimiento
       */
    public Persona(int p_nroDni, String p_nombre, String p_apellido, Calendar p_fechaNacimiento) {
        this.setNroDni(p_nroDni);
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setFechaNacimiento(p_fechaNacimiento);
    }

    /**
     * Getters
       */
    public int getNroDni() {
        return this.nroDni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public Calendar getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    /**
     * Setters
       */
    private void setNroDni(int p_nroDni) {
        this.nroDni = p_nroDni;
    }

    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    private void setApellido(String p_apellido) {
        this.apellido = p_apellido;
    }

    private void setFechaNacimiento(Calendar p_fechaNacimiento) {
        this.fechaNacimiento = p_fechaNacimiento;
    }

    // Metodos
    /** 
     * Calcula y devuelve la cantidad de anios cumplidos a la fecha
     * @param No recibe parametros
     * @return Devuelve un valor de tipo int que hace referencia a la edad
     * @throws No dispara ninguna excepcion
       */
    public int edad(){
        Calendar fechaHoy = new GregorianCalendar();
        int anio = fechaHoy.get(Calendar.YEAR);

        return (anio - this.getFechaNacimiento().get(Calendar.YEAR));
    }

    /** 
     * Concatena el nombre y apellido
     * @param No recibe parametros
     * @return Devuelve un valor de tipo String
     * @throws No dispara ninguna excepcion
       */
    public String nobmreYApe(){
        return (this.getNombre() + " " + this.getApellido());
    }

    /** 
     * Concatena el apellido y nombre
     * @param No recibe parametros
     * @return Devuelve un valor de tipo String
     * @throws No dispara ninguna excepcion
       */
    public String apeYNom(){
        return (this.getApellido() + ", " + this.getNombre()); 
    }

    /** 
     * Muestra por consola los datos de la Persona
     * @param No recibe parametros
     * @return No devuelve ningun valor
     * @throws No dispara ninguna excepcion
       */
    public void mostrar(){
        System.out.println("Nombre y Apellido: " + this.nobmreYApe());
        System.out.println("DNI: " + this.getNroDni() + " Edad: " + this.edad() + " años");
    }

    /**
     * Compara la fecha actual y la de nacimiento y calcula si es cumpleaños o no
     * @return Devuelve true si es el dia de cumpleaños de la persona
     */
    public boolean esCumpleaños(){
        Calendar fechaHoy = new GregorianCalendar();

        return (fechaHoy.get(Calendar.DATE) == this.getFechaNacimiento().get(Calendar.DATE));
    }
}
