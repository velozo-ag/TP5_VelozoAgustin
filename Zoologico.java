import java.util.ArrayList;
import java.util.Calendar;

/**
 * Clase Zoologico
 * @author Velozo, Agustin
 * @version 1 20/10/2023
 */
public class Zoologico{
    private String nombre;
    private ArrayList<Visitante> visitantes;

    /**
     * Metodo constructor para instanciar objetos de la clase Zoologico
     * @param String p_nombre, ArrayList<Visitante> p_visitantes
     */
    public Zoologico(String p_nombre, ArrayList<Visitante> p_visitantes){
        this.setNombre(p_nombre);
        this.setVisitantes(p_visitantes);
    }
    /**
     * @param String p_nombre
     */
    public Zoologico(String p_nombre){
        this.setNombre(p_nombre);
        this.setVisitantes(new ArrayList<Visitante>());
    }

    /**
     * Setters
     */
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }

    private void setVisitantes(ArrayList<Visitante> p_visitantes){
        this.visitantes = p_visitantes;
    }

    /**
     * Getters
     */
    public String getNombre(){
        return this.nombre;
    }

    public ArrayList<Visitante> getVisitantes(){
        return this.visitantes;
    }

    /**
     * Agrega un nuevo visitante al ArrayList de visitantes
     * @param Visitante p_visitante
     */
    public void nuevoVisitante(Visitante p_visitante){
        this.getVisitantes().add(p_visitante);
    }

    public void quitarVisitante(Visitante p_visitante){
        this.getVisitantes().remove(p_visitante);
    }

    /**
     * Muestra todos los visitantes de una fecha y de un tipo en especifico
     * @param Calendar p_fecha, String p_tipoVisitante
     */
    public void listaTipoVisitantePorFecha(Calendar p_fecha, String p_tipoVisitante){
        System.out.println("\n ----- Visitantes " + p_tipoVisitante + " el " + p_fecha.get(Calendar.DATE) + "/" + (p_fecha.get(Calendar.MONTH) + 1) + "/" + p_fecha.get(Calendar.YEAR) + " -----");
        for(Visitante visit : this.getVisitantes()){
            visit.listarPorFecha(p_fecha, p_tipoVisitante);
        }
    }

    /**
     * Muestra todos los visitantes de una fcha especifica
     * @param Calendar p_fecha
     */
    public void listaVisitantePorFecha(Calendar p_fecha){
        System.out.println("\n ----- Visitantes el " + p_fecha.get(Calendar.DATE) + "/" + (p_fecha.get(Calendar.MONTH) + 1) + "/" + p_fecha.get(Calendar.YEAR) + " -----");
        for(Visitante visit: this.getVisitantes()){
            visit.listarPorFecha(p_fecha, visit.tipoVisitante());
        }
    }

    /**
     * Calcula lo recaudado de las visitas que se dieron entre p_fechaDesde y p_fechaHasta
     * @param p_fechaDesde
     * @param p_fechaHasta
     * @return Devuelve el costo acumulado de las visitas en un lapso de tiempo como double
     */
    public double recaudacion(Calendar p_fechaDesde, Calendar p_fechaHasta){
        double costoAcum = 0;
        Calendar fecha;
        for(Visitante visit : this.getVisitantes()){
            fecha =  visit.getFechaVisita();
            if(fecha.after(p_fechaDesde) && fecha.before(p_fechaHasta)){
                costoAcum += visit.entrada();
            }
        }
        return costoAcum;
    }

}