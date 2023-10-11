/**
 * Clase SemiExclusivo
 * @author Velozo, Agustin
 * @version 1 05/10/2023
 */
public class SemiExclusivo extends Cargo{
    private int horasDeInvestigacion;
    private int horasDeExtension;

    /**
     * Metodo constructor para instanciar objetos de la clase Exclusivo
     * @param String p_nombreCargo, double p_sueldoBasico, int p_anioIngreso, int p_horasInvestigacion, int p_horasExtension
     */
    public SemiExclusivo(String p_nombreCargo, double p_sueldoBasico, int p_anioIngreso, int p_horasInvestigacion, int p_horasExtension){
        super(p_nombreCargo, p_sueldoBasico, p_anioIngreso);
        this.setHorasDeInvestigacion(p_horasInvestigacion);
        this.setHorasDeExtension(p_horasExtension);
    }

    /**
     * Setters
     */
    private void setHorasDeInvestigacion(int p_horasInvestigacion){
        this.horasDeInvestigacion = p_horasInvestigacion;
    }

    private void setHorasDeExtension(int p_horasExtension){
        this.horasDeExtension = p_horasExtension;
    }

    /**
     * Getters
     */
    public int getHorasDeInvestigacion(){
        return this.horasDeInvestigacion;
    }

    public int getHorasDeExtension(){
        return this.horasDeExtension;
    }

    public void mostrarCargo(){
        super.mostrarCargo();
        System.out.println("--- Cargo SemiExclusivo");
        System.out.println("Horas investigacion: " + this.getHorasDeInvestigacion());
        System.out.println("Horas extension: " + this.getHorasDeExtension());
    }

}
