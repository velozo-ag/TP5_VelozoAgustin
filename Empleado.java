import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Clase Empleado
 * @author Velozo, Agustin
 * @version 2 2023
 * 
   */
public class Empleado extends Persona{

    private long cuil = 0;
    private double sueldoBasico = 0;
    private Calendar fechaIngreso;

    /**
     * Metodos constructores que sirven para instanciar objetos de la clase Empleado
     * @param int p_nroDni, String p_nombre, String p_apellido, Calendar p_fechaNacimiento, long p_cuil, double p_sueldoBasico, int p_anioIngreso
     */
    public Empleado(int p_nroDni, String p_nombre, String p_apellido, Calendar p_fechaNacimiento, long p_cuil, double p_sueldoBasico, int p_anioIngreso) {
        super(p_nroDni, p_nombre, p_apellido, p_fechaNacimiento);
        this.setCuil(p_cuil);
        this.setSueldoBasico(p_sueldoBasico);
        this.setAnioIngreso(p_anioIngreso);
    }
    /**
     * @param int p_nroDni, String p_nombre, String p_apellido, Calendar p_fechaNacimiento, long p_cuil, double p_sueldoBasico, Calendar p_fecha
     */
    public Empleado(int p_nroDni, String p_nombre, String p_apellido, Calendar p_fechaNacimiento, long p_cuil, double p_sueldoBasico, Calendar p_fecha) {
        super(p_nroDni, p_nombre, p_apellido, p_fechaNacimiento);
        this.setCuil(p_cuil);
        this.setSueldoBasico(p_sueldoBasico);
        this.setFechaIngreso(p_fecha);
    }

    /**
     * Setters
     */
    private void setCuil(long p_cuil) {
        this.cuil = p_cuil;
    }

    private void setSueldoBasico(double p_sueldoBasico) {
        this.sueldoBasico = p_sueldoBasico;
    }

    private void setAnioIngreso(int p_fecha) {
        Calendar anio = new GregorianCalendar(p_fecha, 1, 1);
        this.fechaIngreso = anio;
    }

    private void setFechaIngreso(Calendar p_fecha){
        this.fechaIngreso = p_fecha;
    }

    /**
     * Getters
     */
    public long getCuil(){
        return this.cuil;
    }

    public double getSueldoBasico(){
        return this.sueldoBasico;
    }

    public Calendar getFechaIngreso(){
        return this.fechaIngreso;
    }

    /**
     * Calcula y retorna la antiguedad del empleado
     * @return Devuelve la resta entre el anio actual y el de ingreso como int
     * @throws No dispara ninguna excepcion
     */
    public int antiguedad() {
        Calendar fechaHoy = new GregorianCalendar();
        int anioHoy = fechaHoy.get(Calendar.YEAR);
        return (anioHoy - this.getFechaIngreso().get(Calendar.YEAR));
    }

    /**
     * Calcula y retorna un descuento respecto al sueldo basico
     * @return Devuelve el valor del descuento como double
     * @throws No dispara ninguna excepcion
     */
    private double descuento(){
        return (this.getSueldoBasico() * .02) + 1500;
    }

    /**
     * Calcula y retorna el adicional al sueldo basico dependiendo de la cantidad de anios de servicio
     * @return Devuelve el sueldo adicional como double
     * @throws No dispara ninguna excepcion
     */
    private double adicional(){
        double sueldoAdicional = this.getSueldoBasico();
        int anios = this.antiguedad();

        if(anios >= 10){
            sueldoAdicional *= .06;
        }else if(anios >= 2){
            sueldoAdicional *= .04;
        }else{
            sueldoAdicional *= .02;
        }

        return sueldoAdicional;
    }

    /**
     * Calcula y devuelve el sueldo neto del empleado
     * @return Devuelve el calculo del sueldo neto como double
     * @throws No dispara ninguna excepcion
     */
    public double sueldoNeto(){
        return (this.getSueldoBasico() + this.adicional() - this.descuento());
    }

    /**
     * Concatenan y devuelven un String con el apellido y nombre o viceversa
     * @return Devuelve un el nombre y apellido concatenados en un String
     * @throws No disparan ninguna excepcion
       */
    public String apeYnom() {
        return (this.getApellido() + ", " + this.getNombre());
    }
    public String nomYape() {
        return (this.getNombre() + " " + this.getApellido());
    }

    /**
     * Imprimen leyendas mostrando la informacion del empleado
     */
    public void mostrar(){
        super.mostrar();
        System.out.println("CUIL: " + this.getCuil() + " Antiguedad: " + this.antiguedad() + " años de servicio");
        System.out.println("Sueldo neto: $" + this.sueldoNeto());
    }

    public void mostrarLinea(){
        System.out.println(this.getCuil() + "   " + this.apeYnom() + "  .......... $ " + this.sueldoNeto() + "\n");
    }

    /**
     * 
     */
    public boolean esAniversario(){
        Calendar hoy = new GregorianCalendar();
        return (hoy.get(Calendar.DATE) == this.getFechaIngreso().get(Calendar.DATE));
    }
}