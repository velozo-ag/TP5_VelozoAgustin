import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Clase Cargo
 * @author Velozo, Agustin
 * @version 1 04/10/2023
 */
public class Cargo{
    private String nombreCargo;
    private double sueldoBasico;
    private int anioIngreso;
    private int horasDeDocencia;

    /**
     * Metodo constructor para instanciar objetos de la clase Cargo
     * @param String p_nombreCargo, double p_sueldoBasico, int p_anioIngreso, int p_horasDocencia 
     */
    public Cargo(String p_nombreCargo, double p_sueldoBasico, int p_anioIngreso, int p_horasDocencia){
        this.setNombreCargo(p_nombreCargo);
        this.setSueldoBasico(p_sueldoBasico);
        this.setAnioIngreso(p_anioIngreso);
        this.setHorasDocencia(p_horasDocencia);
    }
    /**
     * @param String p_nombreCargo, double p_sueldoBasico, int p_anioIngreso 
     */
    public Cargo(String p_nombreCargo, double p_sueldoBasico, int p_anioIngreso){
        this.setNombreCargo(p_nombreCargo);
        this.setSueldoBasico(p_sueldoBasico);
        this.setAnioIngreso(p_anioIngreso);
        this.setHorasDocencia(10);
    }

    /**
     * Setter
     */
    private void setNombreCargo(String p_nombreCargo){
        this.nombreCargo = p_nombreCargo;
    }

    private void setSueldoBasico(double p_sueldoBasico){
        this.sueldoBasico = p_sueldoBasico;
    }

    private void setAnioIngreso(int p_anioIngreso){
        this.anioIngreso = p_anioIngreso;
    }

    private void setHorasDocencia(int p_horasDocencia){
        this.horasDeDocencia = p_horasDocencia;
    }

    /**
     * Getters
     */
    public String getNombreCargo(){
        return this.nombreCargo;
    }

    public double getSueldoBasico(){
        return this.sueldoBasico;
    }
    
    public int getAnioIngreso(){
        return this.anioIngreso;
    }

    public int getHorasDeDocencia(){
        return this.horasDeDocencia;
    }

    /**
     * Calcula la antiguedad de la permanencia en el cargo
     * @return Devuelve la cantidad de anios como int
     */
    public int antiguedad(){
        Calendar hoy = new GregorianCalendar();
        return hoy.get(Calendar.YEAR) - this.getAnioIngreso();
    }

    /**
     * Calcula el adicional a sumar segun la antiguedad
     * @return Devuelve el resultado como double
     */
    private double adicionalXAntiguedad(){
        return this.getSueldoBasico() * .01 * this.antiguedad();
    }

    /**
     * @return Devuelve el sueldo del cargo como double
     */
    public double sueldoDelCargo(){
        return this.getSueldoBasico() + this.adicionalXAntiguedad();
    }

    public void mostrarCargo(){
        System.out.println("\n"+this.getNombreCargo() + " - Sueldo Basico: " + this.getSueldoBasico() + " - Sueldo Cargo: " + this.sueldoDelCargo() + " - Antiguedad: " + this.antiguedad() + " anios");
        System.out.println("Horas Docencia: " + this.getHorasDeDocencia());
    }

}