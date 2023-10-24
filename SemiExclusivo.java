/**
 * Clase SemiExclusivo
 * @author Velozo, Agustin
 * @version 1 05/10/2023
 */
public class SemiExclusivo extends Cargo{
    private int horasDeInvestigacion;

    /**
     * Metodo constructor para instanciar objetos de la clase SemiExclusivo
     * @param String p_nombreCargo, double p_sueldoBasico, int p_anioIngreso,int p_horasDocencia int p_horasInvestigacion
     */
    public SemiExclusivo(String p_nombreCargo, double p_sueldoBasico, int p_anioIngreso, int p_horasInvestigacion, int p_horasDocencia){
        super(p_nombreCargo, p_sueldoBasico, p_anioIngreso, p_horasDocencia + 10);
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
        System.out.println("--- Cargo de caracter SemiExclusivo ---");
        System.out.println("Horas investigacion: " + this.getHorasDeInvestigacion());
    }

}
