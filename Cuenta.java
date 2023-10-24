/**
 * Clase Cuenta
 * @author Velozo, Agustin
 * @version 1 16/10/2023
 */
public abstract class Cuenta{
    private int nroCuenta;
    private Persona titular;
    private double saldo;

    /**
     * Metodo constructor para instanciar objetos de la clase Cuenta
     * @param int p_nroCuenta, Persona p_titular, double p_saldo
     */
    public Cuenta(int p_nroCuenta, Persona p_titular, double p_saldo){
        this.setNroCuenta(p_nroCuenta);
        this.setSaldo(p_saldo);
        this.setTitular(p_titular);
    }

    /**
     * Setters
     */
    private void setNroCuenta(int p_nroCuenta){
        this.nroCuenta = p_nroCuenta;
    }

    private void setSaldo(double p_saldo){
        this.saldo = p_saldo;
    }

    private void setTitular(Persona p_titular){
        this.titular = p_titular;
    }

    /**
     * Getters
     */
    public int getNroCuenta(){
        return this.nroCuenta;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public Persona getTitular(){
        return this.titular;
    }

    /**
     * Verifica si se puede realizar o no una extraccion
     * @param double p_importe
     * @return Devuelve si se puede realizar o no la extraccion
     */
    protected abstract boolean puedeExtraer(double p_importe);

    /**
     * Valida si se puede realizar la extraccion y la hace, caso contrario imprime el motivo por el cual no se puede realizar
     * @param double p_importe
     * @return Devuelve true si se realizo la extraccion
     */
    public abstract boolean extraer(double p_importe);

    /**
     * Modifica el valor del atributo saldo, extrayendo dinero
     * @param double p_importe
     */
    protected void realizarExtraccion(double p_importe){
        this.setSaldo(this.getSaldo() - p_importe);
    }

    /**
     * @param double p_importe
     * @return Devuelve un String con el motivo por el cual no se puede realizar una extraccion
     */
    public abstract String xQNoPuedeExtraer(double p_importe);

    /**
     * Modifica el valor del saldo depositando dinero
     * @param double p_importe
     * @return Devuelve el saldo restante
     */
    public double depositar(double p_importe){
        this.setSaldo(this.getSaldo() + p_importe);
        return this.getSaldo();
    }

    public void mostrar(){
        System.out.println("Nro. Cuenta: " + this.getNroCuenta() + " - Saldo: " + this.getSaldo());
        System.out.println("Titular: " + this.getTitular().nomYApe());
    }
}