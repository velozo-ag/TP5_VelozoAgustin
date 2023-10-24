/**
 * Clase CajaDeAhorro
 * 
 * @author Velozo, Agustin
 * @version 1 04/09/2023
 */
public class CajaDeAhorro extends Cuenta {
    private int extraccionesPosibles;

    /**
     * Metodo constructor para instanciar objetos de la clase CajaDeAhorro
     * 
     * @param int p_nroCuenta, Persona p_titular
     */
    public CajaDeAhorro(int p_nroCuenta, Persona p_titular) {
        super(p_nroCuenta, p_titular, 0);
        this.setExtraccionesPosibles(10);
    }
    /**
     * @param int p_nroCuenta, Persona p_titular, double p_saldo
     */
    public CajaDeAhorro(int p_nroCuenta, Persona p_titular, double p_saldo) {
        super(p_nroCuenta, p_titular, p_saldo);
        this.setExtraccionesPosibles(10);
    }

    /**
     * Setters
     */
    private void setExtraccionesPosibles(int p_extraccionesPosibles) {
        this.extraccionesPosibles = p_extraccionesPosibles;
    }

    /**
     * Getters
     */
    public int getExtraccionesPosibles() {
        return this.extraccionesPosibles;
    }

    /**
     * Verifica si se puede realizar o no una extraccion
     * @param double p_importe
     * @return Devuelve si se puede realizar o no la extraccion
     */
    protected boolean puedeExtraer(double p_importe) {
        return (p_importe <= this.getSaldo() && this.getExtraccionesPosibles() != 0);
    }

    /**
     * Realiza la extraccion de dinero
     * @param double p_importe
     */
    protected void realizarExtraccion(double p_importe) {
        if (p_importe > 0) {
            super.realizarExtraccion(p_importe);
            this.setExtraccionesPosibles(this.getExtraccionesPosibles() - 1);
        }
    }

    /**
     * Valida si se puede realizar la extraccion y la hace, caso contrario imprime
     * el motivo por el cual no se puede realizar
     * @param double p_importe
     * @return Devuelve true si se realizo la extraccion
     */
    public boolean extraer(double p_importe) {
        if (this.puedeExtraer(p_importe)) {
            this.realizarExtraccion(p_importe);
        } else {
            System.out.println(this.xQNoPuedeExtraer(p_importe));
        }
        return this.puedeExtraer(p_importe);
    }

    public void mostrar() {
        System.out.println(" -- Caja de Ahorro --");
        super.mostrar();
        System.out.println("Extracciones posibles: " + this.getExtraccionesPosibles());
    }

    /**
     * @param double p_importe
     * @return Devuelve un String con el motivo por el cual no se puede realizar una extraccion
     */
    public String xQNoPuedeExtraer(double p_importe) {
        if (this.getExtraccionesPosibles() == 0) {
            return "No tiene habilitadas mas extracciones!";
        } else {
            return "No puede extraer mas que el saldo!";
        }
    }
}