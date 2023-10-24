import java.util.ArrayList;

/**
 * Clase Hotel
 * @author Velozo, Agustin
 * @version 1 19/10/2023
 */
public class Hotel extends Alojamiento{
    private String tipoHabitacion;

    /**
     * Metodo constructor para instanciar objetos de la clase Hotel
     * @param p_nombre
     * @param p_precioBase
     * @param p_diasAlquiler
     * @param p_servicios
     * @param p_tipoHabitacion
     */
    public Hotel(String p_nombre, double p_precioBase, int p_diasAlquiler, ArrayList<Servicio> p_servicios, String p_tipoHabitacion){
        super(p_nombre, p_precioBase, p_diasAlquiler, p_servicios);
        this.setTipoHabitacion(p_tipoHabitacion);
    }
    /**
     * 
     * @param p_nombre
     * @param p_precioBase
     * @param p_diasAlquiler
     * @param p_tipoHabitacion
     */
    public Hotel(String p_nombre, double p_precioBase, int p_diasAlquiler, String p_tipoHabitacion){
        super(p_nombre, p_precioBase, p_diasAlquiler);
        this.setTipoHabitacion(p_tipoHabitacion);
    }

    /**
     * Setter
     */
    private void setTipoHabitacion(String p_tipoHabitacion){
        this.tipoHabitacion = p_tipoHabitacion;
    }

    /**
     * Getter
     */
    public String getTipoHabitacion(){
        return this.tipoHabitacion;
    }

    /**
     * Calcula el costo del alquiler en base al precio base y los dias de alquiler mas un adicional segun el tipo de habitacion
     * @return Devuelve el costo total del alquiler
     */
    public double costo(){
        double adicional;

        if(this.getTipoHabitacion().equals("Single")){
            adicional = this.getDiasAlquiler() * 20;
        }else{
            adicional = this.getDiasAlquiler() * 35;
        }

        return super.costo() + adicional;
    }

    /**
     * Verifica si el alojamiento es del tipo ingresado por parametro
     * @param String p_alojamiento
     * @return Devulve 1 si es el tipo de alojamiento solicitado
     */
    public int contar(String p_alojamiento){
        if(p_alojamiento.equals("Hotel")){
            return 1;
        }else{
            return 0;
        }
    }

    public void liquidar(){
        super.liquidar();
        System.out.println("Habitacion " + this.getTipoHabitacion());
        this.listarServicios();
        System.out.println("Total: ------> $" + (this.costo() + this.costoServicios()));
    }
}