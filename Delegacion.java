import java.util.ArrayList;
import java.util.Calendar;

/**
 * Clase Delegacion
 * 
 * @author Velozo, Agustin
 * @version 1 20/10/2023
 */
public class Delegacion extends Visitante {
    private ArrayList<Individuo> integrantes;

    /**
     * Metodo constructor para instanciar objetos de la clase Delegacion
     * 
     * @param String p_nombre, Calendar p_fechaVisita, ArrayList<Individuo>
     *               p_integrantes
     */
    public Delegacion(String p_nombre, Calendar p_fechaVisita, ArrayList<Individuo> p_integrantes) {
        super(p_nombre, p_fechaVisita);
        this.setIntegrantes(p_integrantes);
    };

    /**
     * @param String p_nombre, Calendar p_fechaVisita, Individuo p_integrante
     */
    public Delegacion(String p_nombre, Calendar p_fechaVisita, Individuo p_integrante) {
        super(p_nombre, p_fechaVisita);
        this.setIntegrantes(new ArrayList<Individuo>());
        this.inscribirIndividuo(p_integrante);
    };

    /**
     * Setter
     */
    private void setIntegrantes(ArrayList<Individuo> p_integrantes) {
        this.integrantes = p_integrantes;
    }

    /**
     * Getter
     */
    public ArrayList<Individuo> getIntegrantes() {
        return this.integrantes;
    }

    public void inscribirIndividuo(Individuo p_individuo) {
        this.getIntegrantes().add(p_individuo);
    }

    public void eliminarIndividuo(Individuo p_individuo) {
        this.getIntegrantes().remove(p_individuo);
    }

    /**
     * @return Devuelve la cantidad de integrantes de la delegacion
     */
    public int cantidadDeIntegrantes() {
        return this.getIntegrantes().size();
    }

    /**
     * Calcula el valor total de la entrada
     * 
     * @return Devuelve el valor de la entrada como double, multiplicando el valor
     *         de un individuo por la cantidad de integrantes y dandole 10% de
     *         descuento
     */
    public double entrada() {
        return (this.cantidadDeIntegrantes() * 10) * .90;
    }

    public void mostrar() {

        System.out.println("--------------------------------------");
        System.out.println("Delegacion: " + this.getNombre());

        System.out.println("\nIntegrantes");
        for (Individuo ind : this.getIntegrantes()) {
            ind.mostrar();
        }

        System.out.println("\nCantidad de Integrantes: " + this.cantidadDeIntegrantes());
        System.out.println("--------------------------------------");

    }

    /**
     * Muestra el visitante si coincide con la fecha de visita y el tipo de
     * visitante
     * 
     * @param Calendar p_fecha, String p_visitante
     */
    public void listarPorFecha(Calendar p_fecha, String p_visitante) {
        boolean mismoDia = this.getFechaVisita().get(Calendar.DAY_OF_MONTH) == p_fecha.get(Calendar.DATE) && 
                        this.getFechaVisita().get(Calendar.MONTH) == p_fecha.get(Calendar.MONTH) && 
                        this.getFechaVisita().get(Calendar.YEAR) == p_fecha.get(Calendar.YEAR);

        if (mismoDia && p_visitante.equalsIgnoreCase(this.tipoVisitante())) {
            this.mostrar();
        }
    }

    /**
     * @return Devuelve el tipo de visitante que es como String
     */
    public String tipoVisitante() {
        return "Delegacion";
    }

}