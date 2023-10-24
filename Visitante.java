import java.util.Calendar;

/**
 * Clase Visitante
 * 
 * @author Velozo, Agustin
 * @version 1 20/10/2023
 */
public abstract class Visitante {
    private String nombre;
    private Calendar fechaVisita;

    /**
     * Metodo constructor para instanciar objetos de la clase Visitante
     * 
     * @param String p_nombre, Calendar p_fechaVisita
     */
    public Visitante(String p_nombre, Calendar p_fechaVisita) {
        this.setNombre(p_nombre);
        this.setFechaVisita(p_fechaVisita);
    }

    /**
     * Setter
     */
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    private void setFechaVisita(Calendar p_fecha) {
        this.fechaVisita = p_fecha;
    }

    /**
     * Getters
     */
    public String getNombre() {
        return this.nombre;
    }

    public Calendar getFechaVisita() {
        return this.fechaVisita;
    }

    /**
     * Calcula el valor total de la entrada
     * 
     * @return Devuelve el valor de la entrada como double
     */
    public abstract double entrada();

    public abstract void mostrar();

    /**
     * Muestra el visitante si coincide con la fecha de visita y el tipo de
     * visitante
     * 
     * @param Calendar p_fecha, String p_visitante
     */
    public abstract void listarPorFecha(Calendar p_fecha, String p_visitante);

    public abstract String tipoVisitante();
}