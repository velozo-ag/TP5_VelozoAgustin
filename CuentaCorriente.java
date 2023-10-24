/**
 * Clase CuentaCorriente
 * 
 * @author Velozo, Agustin
 * @version 1 03/09/2023
 */
public class CuentaCorriente extends Cuenta {
    private double limiteDescubierto;

    /**
     * Metodos constructores para instanciar objetos de la clase CajaDeAhorro
     * 
     * @param int p_nroCuenta, Persona p_titular
     */
    public CuentaCorriente(int p_nroCuenta, Persona p_titular) {
        super(p_nroCuenta, p_titular, 0);
        this.setLimiteDescubierto(500);
    }

    /**
     * @param int p_nroCuenta, Persona p_titular, double p_saldo
     */
    public CuentaCorriente(int p_nroCuenta, Persona p_titular, double p_saldo) {
        super(p_nroCuenta, p_titular, p_saldo);
        this.setLimiteDescubierto(500);
    }

    /**
     * Setters
     */
    private void setLimiteDescubierto(double p_limite) {
        this.limiteDescubierto = p_limite;
    }

    /**
     * Getters
     */
    public double getLimiteDescubierto() {
        return this.limiteDescubierto;
    }

    /**
     * Verifica si se puede realizar o no una extraccion
     * 
     * @param double p_importe
     * @return Devuelve si se puede realizar o no la extraccion
     */
    protected boolean puedeExtraer(double p_importe) {
        return (p_importe <= (this.getLimiteDescubierto() + this.getSaldo()));
    }

    /**
     * Si se puede extraer, realiza la accion, de lo contrario, imprime el motivo
     * por el cual no se puede extraer dinero
     * 
     * @param double p_importe
     */
    public boolean extraer(double p_importe) {

        if (this.puedeExtraer(p_importe)) {
            this.realizarExtraccion(p_importe);
        } else {
            System.out.println(this.xQNoPuedeExtraer(p_importe));
        }
        return puedeExtraer(p_importe);
    }

    public void mostrar() {
        System.out.println(" - Cuenta Corriente - ");
        super.mostrar();
        System.out.println("Descubierto: " + this.getLimiteDescubierto());
    }

    /**
     * @param double p_importe
     * @return Devuelve un String con el motivo por el cual no se puede realizar una extraccion
     */
    public String xQNoPuedeExtraer(double p_importe) {
        return "El importe de extraccion sobrepasa el limite de descubierto!";
    }
}