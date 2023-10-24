import java.util.ArrayList;

/**
 * Clase Alojamiento
 * @author Velozo, Agustin
 * @version 1 19/10/2023
 */
public abstract class Alojamiento{
    private String nombre;
    private double precioBase;
    private int diasAlquilar;
    private ArrayList<Servicio> servicios;

    /**
     * Metodo constructor para instanciar objetos de la clase Alojamiento
     * @param String p_nombre, double p_precioBase, int p_diasAlquiler, ArrayList p_servicios
     */
    public Alojamiento(String p_nombre, double p_precioBase, int p_diasAlquiler, ArrayList<Servicio> p_servicios){
        this.setNombre(p_nombre);
        this.setPrecioBase(p_precioBase);
        this.setDiasAlquilar(p_diasAlquiler);
        this.setServicios(p_servicios);
    }
    /**
     * @param String p_nombre, double p_precioBase, int p_diasAlquiler
     */
    public Alojamiento(String p_nombre, double p_precioBase, int p_diasAlquiler){
        this.setNombre(p_nombre);
        this.setPrecioBase(p_precioBase);
        this.setDiasAlquilar(p_diasAlquiler);
        this.setServicios(new ArrayList<Servicio>());
    }

    /**
     * Setters
     */
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }

    private void setPrecioBase(double p_precioBase){
        this.precioBase = p_precioBase;
    }

    private void setDiasAlquilar(int p_dias){
        this.diasAlquilar = p_dias;
    }

    private void setServicios(ArrayList<Servicio> p_servicios){
        this.servicios = p_servicios;
    }

    /**
     * Getters
     */
    public String getNombre(){
        return this.nombre;
    }

    public double getPrecioBase(){
        return this.precioBase;
    }

    public int getDiasAlquiler(){
        return this.diasAlquilar;
    }

    public ArrayList<Servicio> getServicios(){
        return this.servicios;
    }

    /**
     * Modifica el valor del atributo servicios agregando un elemento
     * @param Servicio p_servicio
     */
    public boolean agregarServicio(Servicio p_servicio){
        return this.getServicios().add(p_servicio);
    }

    /**
     * Modifica el valor del atributo servicios quitando un elemento
     * @param Servicio p_servicio
     */
    public boolean quitarServicio(Servicio p_servicio){
        return this.getServicios().remove(p_servicio);
    }

    /**
     * Verifica si el alojamiento es del tipo ingresado por parametro
     * @param String p_alojamiento
     * @return Devulve 1 si es el tipo de alojamiento solicitado
     */
    public abstract int contar(String p_alojamiento);

    /**
     * Calcula el costo del alquiler en base al precio base y los dias de alquiler
     * @return Devuelve el costo total del alquiler
     */
    public double costo(){
        return this.getPrecioBase() * this.getDiasAlquiler();
    }

    public void listarServicios(){
        for(Servicio serv : this.getServicios()){
            System.out.println("  " + serv.getDescripcion() + ": $" + serv.getPrecio());
        }    
    }

    /**
     * Calcula la suma del costo de todos los servicios ocupados
     * @return Devuelve el costo total de los servicios utilizados
     */
    public double costoServicios(){
        double acum = 0;
        for(Servicio serv : this.getServicios()){
            acum += serv.getPrecio();
        }

        return acum;
    }

    /**
     * Muestra la liquidacion de la estadia, mostrando los datos del alquiler junto a los servicios
     */
    public void liquidar(){
        System.out.println("Alojamiento: " + this.getNombre());
        System.out.println("Costo por " + this.getDiasAlquiler() + " dias: $" + this.costo());
    }
}