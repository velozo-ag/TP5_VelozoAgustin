import java.util.ArrayList;

/**
 * Clase Cabaña
 * @author Velozo, Agustin
 * @version 1 19/10/2023
 */
public class Cabaña extends Alojamiento{
    private int nroHabitaciones;

    /**
     * Metodo constructor para instanciar objetos de la clase Cabaña
     * @param String p_nombre, double p_precioBase, int p_diasAlquiler, ArrayList p_servicios, int p_nroHabitacioness
     */
    public Cabaña(String p_nombre, double p_precioBase, int p_diasAlquiler, ArrayList<Servicio> p_servicios, int p_nroHabitaciones){
        super(p_nombre, p_precioBase, p_diasAlquiler, p_servicios);
        this.setNroHabitaciones(p_nroHabitaciones);
    }
    public Cabaña(String p_nombre, double p_precioBase, int p_diasAlquiler, int p_nroHabitaciones){
        super(p_nombre, p_precioBase, p_diasAlquiler);
        this.setNroHabitaciones(p_nroHabitaciones);
    }

    /**
     * Setter
     */
    private void setNroHabitaciones(int p_nroHabitaciones){
        this.nroHabitaciones = p_nroHabitaciones;
    }

    /**
     * Getter
     */
    public int getNroHabitaciones(){
        return this.nroHabitaciones;
    }

    /**
     * Calcula el costo del alquiler en base al precio base y los dias de alquiler mas un costo adicional segun la cantidad de habitaciones
     * @return Devuelve el costo total del alquiler
     */
    public double costo(){
        return super.costo() + (this.getDiasAlquiler() * 30 * this.getNroHabitaciones());
    }

    /**
     * Verifica si el alojamiento es del tipo ingresado por parametro
     * @param String p_alojamiento
     * @return Devulve 1 si es el tipo de alojamiento solicitado
     */
    public int contar(String p_alojamiento){
        if(p_alojamiento.equals("Cabaña")){
            return 1;
        }else{
            return 0;
        }
    }

    public void liquidar(){
        super.liquidar();
        System.out.println("Cabaña con " + this.getNroHabitaciones() + " habitaciones ");
        this.listarServicios();
        System.out.println("Total: ------> $" + (this.costo() + this.costoServicios()));
    }


}