import java.util.ArrayList;
/**
 * Clase Facultad
 * 
 * @author Velozo, Agustin 
 * @version 1 11/10/2023
 */
public class Facultad{
    private String nombre;
    private ArrayList<Profesor> profesores;
    
    /**
    * Metodo constructor para instanciar objetos de la clase Facultad
    * @param String p_nombre, ArrayList<Profesor> p_profesores
    */
    public Facultad(String p_nombre, ArrayList<Profesor> p_profesores){
       this.setNombre(p_nombre);
       this.setProfesores(p_profesores);
    }
    /**
    * @param String p_nombre, Profesor p_profesor
    */
    public Facultad(String p_nombre, Profesor p_profesor){
        this.setNombre(p_nombre);
        this.setProfesores(new ArrayList<Profesor>());
        this.agregarProfesor(p_profesor);
    }
    
    /**
     * Setters
     */
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }
    
    private void setProfesores(ArrayList<Profesor> p_profesores){
        this.profesores = p_profesores;
    }
    
    /**
     * Getters
     */
    public String getNombre(){
        return this.nombre;
    }
    
    public ArrayList<Profesor> getProfesores(){
        return this.profesores;
    }
    
    /**
     * Agrega un nuevo profesor al ArrayList de profesores
     * @param Profesor p_profesor
     */
    public boolean agregarProfesor(Profesor p_profesor){
        return this.getProfesores().add(p_profesor);
    }
    
    /**
     * Remueve un profesor del ArrayList de profesores
     * @param Profesor p_profesor
     */
    public boolean quitarProfesor(Profesor p_profesor){
        return this.getProfesores().remove(p_profesor);
    }
    
    /**
     * Imprime una nomina con la informacion de todos los profesores de la facultad
     */
    public void nominaProfesores(){
        System.out.println("********* Nomina Facultad: " + this.getNombre());
        System.out.println("-----------------------------------------------");
        for(Profesor profe : this.getProfesores()){
            System.out.println(profe.mostrarLinea());
        }
        System.out.println("-----------------------------------------------");
        System.out.println(" Total a Pagar: " + this.totalAPagar());
    } 
    
    /**
     * Calcula el total a pagar a todos los profesores
     * @return Devuelve el valor acumulado de todos los sueldos de los profesores como double
     */
    public double totalAPagar(){
        double total = 0;
        for(Profesor profe : this.getProfesores()){
            total += profe.sueldoTotal();
        }
        return total;
    }
    
    /**
     * Lista a todos los profesores junto a sus cargos
     */
    public void listarProfesorCargos(){
        System.out.println("*** Detalle de Profesores y cargos de la Facultad: " + this.getNombre());
        for(Profesor profe : this.getProfesores()){
            profe.mostrar();
        }
        System.out.println("-----------------------------------------------");
        System.out.println("Hay " + this.getProfesores().size() + " profesores");
    }
}
