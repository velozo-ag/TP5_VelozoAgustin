import java.util.Calendar;

/**
 * Clase Individuo
 * 
 * @author Velozo, Agustin
 * @version 1 20/10/2023
 */
public class Individuo extends Visitante {
    private Persona persona;

    /**
     * Metodo constructor para instanciar objetos de la clase Individuio
     * 
     * @param String p_nombre, Calendar p_fechaVisita, Persona p_persona
     */
    public Individuo(String p_nombre, Calendar p_fechaVisita, Persona p_persona) {
        super(p_nombre, p_fechaVisita);
        this.setPersona(p_persona);
    };

    /**
     * Setter
     */
    private void setPersona(Persona p_persona) {
        this.persona = p_persona;
    }

    /**
     * Getter
     */
    public Persona getPersona() {
        return this.persona;
    }

    /**
     * Calcula el valor total de la entrada
     * 
     * @return Devuelve el valor de la entrada como double
     */
    public double entrada() {
        return 10;
    }

    public void mostrar() {
        this.getPersona().mostrar();
    }

    /**
     * Muestra el visitante si coincide con la fecha de visita y el tipo de visitante
     * @param Calendar p_fecha, String p_visitante
     */
    public void listarPorFecha(Calendar p_fecha, String p_visitante){
        boolean mismoDia = this.getFechaVisita().get(Calendar.DAY_OF_MONTH) == p_fecha.get(Calendar.DATE) && 
                        this.getFechaVisita().get(Calendar.MONTH) == p_fecha.get(Calendar.MONTH) && 
                        this.getFechaVisita().get(Calendar.YEAR) == p_fecha.get(Calendar.YEAR);

        if(mismoDia && p_visitante.equalsIgnoreCase(this.tipoVisitante())){
            this.mostrar();
        }
    }

    /**
     * @return Devuelve el tipo de visitante que es como String
     */
    public String tipoVisitante(){
        return "Individuo";
    }

}