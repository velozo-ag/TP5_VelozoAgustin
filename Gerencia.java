import java.util.ArrayList;

/**
 * Clase Gerencia
 * @author Velozo, Agustin
 * @version 1 19/10/2023
 */
public class Gerencia{
    private String nombre;
    private ArrayList<Alojamiento> alojamientosAlquilados;

    /**
     * Metodo constructor para instanciar objetos de la clase Gerencia
     * @param String p_nombre, ArrayList<Alojamiento> p_alojamientos
     */
    public Gerencia(String p_nombre, ArrayList<Alojamiento> p_alojamientos){
        this.setNombre(p_nombre);
        this.setAlojamientosAlquilados(p_alojamientos);
    }
    /**
     * @param String p_nombre
     */
    public Gerencia(String p_nombre){
        this.setNombre(p_nombre);
        this.setAlojamientosAlquilados(new ArrayList<Alojamiento>());
    }

    /**
     * Setters
     */
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }

    private void setAlojamientosAlquilados(ArrayList<Alojamiento> p_alojamientos){
        this.alojamientosAlquilados = p_alojamientos;
    }

    /**
     * Getters
     */
    public String getNombre(){
        return this.nombre;
    }

    public ArrayList<Alojamiento> getAlojamientosAlquilados(){
        return this.alojamientosAlquilados;
    }

    /**
     * Modifica el valor del atributo alojamientosAlquilados agregando un elemento
     * @param Alojamiento p_alojamiento
     */
    public boolean agregarAlojamiento(Alojamiento p_alojamiento){
        return this.getAlojamientosAlquilados().add(p_alojamiento);
    }

    /**
     * Modifica el valor del atributo alojamientosAlquilados quitando un elemento
     * @param Alojamiento p_alojamiento
     */
    public boolean quitarAlojamiento(Alojamiento p_alojamiento){
        return this.getAlojamientosAlquilados().remove(p_alojamiento);
    }

    /**
     * Cuenta la cantidad de alojamientos alquilados de cierto tipo
     * @param String tipoAlojamiento
     * @return Devuelve la cantidad de alojamientos alquilados de cierto tipo
     */
    public int contarAlojamiento(String tipoAlojamiento){
        int acum = 0;
        for(Alojamiento alojamiento : this.getAlojamientosAlquilados()){
            acum += alojamiento.contar(tipoAlojamiento);
        }
        return acum;
    }

    public void liquidar(){
        if(this.getAlojamientosAlquilados().size() > 0){
            for(Alojamiento alojamiento : this.getAlojamientosAlquilados()){
                alojamiento.liquidar();
            }
        }else{
            System.out.println("No se ha alquilado aun");
        }
    }

    public void mostrarLiquidacion(){
        System.out.println("Gerencia " + this.getNombre());
        System.out.println("Liquidacion ------------------ \n");
        this.liquidar();
        System.out.println("\nAlojamiento tipo Cabaña ----> " + this.contarAlojamiento("Cabaña"));
        System.out.println("Alojamiento tipo Hotel -----> " + this.contarAlojamiento("Hotel"));
        
    }

}