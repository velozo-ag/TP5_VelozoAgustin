import java.util.Calendar;

/**
 * Clase Alumno
 * @author Velozo, Agustin
 * @version 2 2023 
*/
public class Alumno extends Persona{
    int lu = 0;
    double nota1 = 0;
    double nota2 = 0;

    /**
     * Metodo constructor utilizado para instanciar un objeto de la clase Alumno
     * @param int p_dni, int p_lu, String p_nombre, String p_apellido, Calendar p_fechaNacimiento
     */
    public Alumno(int p_dni, int p_lu, String p_nombre, String p_apellido, Calendar p_fechaNacimiento){
        super(p_dni, p_nombre, p_apellido, p_fechaNacimiento);
        this.setLu(p_lu);
        this.setNota1(0);
        this.setNota2(0);
    }

    /**
     * Getters
     */
    public int getLu(){
        return this.lu;
    }

    public double getNota1(){
        return this.nota1;
    }

    public double getNota2(){
        return this.nota2;
    }

    /**
     * Setters
     */
    private void setLu(int p_lu){
        this.lu = p_lu;
    }

    public void setNota1(double p_nota){
        this.nota1 = p_nota;
    }

    public void setNota2(double p_nota){
        this.nota2 = p_nota;
    }

    /**
     * Metodo que calcula y devuelve el promedio entre las dos notas del alumno 
     * @return Devuelve el promedio del alumno como double
     * @throws No dispara ninguna excepcion
     */
    public double promedio(){
        return ((this.getNota1() + this.getNota2()) / 2);
    }

    /**
     * Calcula si el alumno cumple las condiciones de aprobar la materia y devuelve un valor booleano
     * @return Devuelve un valor booleano true si el alumno esta en condiciones de aprobar o false en caso contrario
     * @throws No dispara ninguna excepcion
     */
    private boolean aprueba(){
        return (this.promedio() > 7 && (this.getNota1() >= 6) && (this.getNota2() >= 6)); 
        // si promedio mayor a 7 y ambas notas son mayores o iguales a 6 da true
    }

    /**
     * Devuelve un String dependiendo si el alumno aprueba o no
     * @return Retorna un String "APROBADO" si el alumno aprueba o "DESAPROBADO" en caso contrario
     */
    private String leyendaAprueba(){
        if(this.aprueba()){
            return "APROBADO";
        }
        return "DESAPROBADO";
    }

    /**
     * Concatenan y devuelven un String con el apellido y nombre o viceversa
     * @return Devuelve un el nombre y apellido concatenados en un String
     * @throws No disparan ninguna excepcion
       */
    public String apeYnom(){
        return (this.getApellido() + " " + this.getNombre());
    }
    public String nomYape(){
        return (this.getNombre() + " " + this.getApellido());
    }

    public void mostrar(){
        super.mostrar();
        System.out.println("LU: " + this.getLu() + "  Notas:" + this.getNota1() + " - " + this.getNota2());
        System.out.println("Promedio: " + this.promedio() + " - " + this.leyendaAprueba());
    }
}