import java.util.ArrayList;
import java.util.Calendar;

/**
 * Clase Profesor
 * 
 * @author Velozo, Agustin
 * @version 1 05/10/2023
 */
public class Profesor extends Persona {
    private String titulo;
    private ArrayList<Cargo> cargos;

    /**
     * Metodo constructor para instanciar objetos de la clase Profesor
     * 
     * @param int p_nroDni, String p_nombre, String p_apellido, Calendar
     *            p_fechaNacimiento, String p_titulo, ArrayList<Cargo> p_cargos
     */
    public Profesor(int p_nroDni, String p_nombre, String p_apellido, Calendar p_fechaNacimiento, String p_titulo,
            ArrayList<Cargo> p_cargos) {
        super(p_nroDni, p_nombre, p_apellido, p_fechaNacimiento);
        this.setTitulo(p_titulo);
        this.setCargos(p_cargos);
    }

    /**
     * @param int p_nroDni, String p_nombre, String p_apellido, Calendar
     *            p_fechaNacimiento, String p_titulo, Cargo p_cargo
     */
    public Profesor(int p_nroDni, String p_nombre, String p_apellido, Calendar p_fechaNacimiento, String p_titulo,
            Cargo p_cargo) {
        super(p_nroDni, p_nombre, p_apellido, p_fechaNacimiento);
        this.setTitulo(p_titulo);
        this.setCargos(new ArrayList<Cargo>());
        this.agregarCargo(p_cargo);
    }

    /**
     * Setters
     */
    private void setTitulo(String p_titulo){
        this.titulo = p_titulo;
    }

    private void setCargos(ArrayList<Cargo> p_cargos){
        this.cargos = p_cargos;
    }

    /**
     * Getters
     */
    public String getTitulo(){
        return this.titulo;
    }

    public ArrayList<Cargo> getCargos(){
        return this.cargos;
    }

    /**
     * Modifica el valor del atributo cargos agregando un cargo
     * @param Cargo p_cargo
     */
    public void agregarCargo(Cargo p_cargo){
        this.getCargos().add(p_cargo);
    }

    /**
     * Modifica el valor del atributo cargos eliminando un cargo
     * @param Cargo p_cargo
     */
    public void quitarCargo(Cargo p_cargo){
        this.getCargos().add(p_cargo);
    }

    /**
    * Muestra los cargos que posee por pantalla
    */
    public void listarCargos(){
        for(Cargo cargo : this.getCargos()){
            cargo.mostrar();
        }
    }

    /**
    * Calcula el total de todos los sueldos segun sus cargos
    * @return Devuelve la suma total de los sueldos como double
    */
    public double sueldoTotal(){
        double total = 0;
        for(Cargo cargo : this.getCargos()){
            total += cargo.sueldoDelCargo();
        }
    }

    public void mostrar(){
        super.mostrar();
        System.out.println("Titulo: " + this.getTitulo());
        System.out.println("****** Cargos Asignados ******");
        System.out.println("------------------------------");
        this.listarCargos();
        System.out.println("\n** Sueldo Total: " + this.sueldoTotal());
    }

    
