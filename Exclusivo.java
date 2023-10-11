/**
 * Clase Exclusivo
 * @author Velozo, Agustin
 * @version 1 05/10/2023
 */
public class Exclusivo extends Cargo{
    private int horasDeInvestigacion;

    /**
     * Metodo constructor para instanciar objetos de la clase Exclusivo
     * @param String p_nombreCargo, double p_sueldoBasico, int p_anioIngreso,int p_horasDocencia int p_horasInvestigacion
     */
    public Exclusivo(String p_nombreCargo, double p_sueldoBasico, int p_anioIngreso, int p_horasInvestigacion, int p_horasDocencia, int p_horasExtension){
        super(p_nombreCargo, p_sueldoBasico, p_anioIngreso, p_horasDocencia);
        this.setHorasDeInvestigacion(p_horasInvestigacion);
    }

    /**
     * Setters
     */
    private void setHorasDeInvestigacion(int p_horasInvestigacion){
        this.horasDeInvestigacion = p_horasInvestigacion;
    }

    /**
     * Getters
     */
    public int getHorasDeInvestigacion(){
        return this.horasDeInvestigacion;
    }

    public void mostrarCargo(){
        super.mostrarCargo();
        System.out.println("--- Cargo Exclusivo");
        System.out.println("Horas investigacion: " + this.getHorasDeInvestigacion());
    }

}
