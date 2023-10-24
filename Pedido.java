import java.util.ArrayList;

/**
 * Clase Pedido
 * @author Velozo, Agustin
 * @version 1 21/10/2023
 */
public class Pedido{
    private ArrayList<Renglon> renglones;

    /**
     * Metodo constructor para instanciar un objeto de la clase Pedido
     * @param ArrayList<Renglon> p_renglones
     */
    public Pedido(ArrayList<Renglon> p_renglones){
        this.setRenglones(p_renglones);
    }
    /**
     * @param Renglon p_renglon
     */
    public Pedido(Renglon p_renglon){
        this.setRenglones(new ArrayList<Renglon>());
        this.agregarRenglon(p_renglon);
    }

    /**
     * Setter
     */
    private void setRenglones(ArrayList<Renglon> p_renglones){
        this.renglones = p_renglones;
    }

    /**
     * Getter
     */
    public ArrayList<Renglon> getRenglones(){
        return this.renglones;
    }

    public void agregarRenglon(Renglon p_renglon){
        this.getRenglones().add(p_renglon);
    }

    public void quitarRenglon(Renglon p_renglon){
        this.getRenglones().remove(p_renglon);
    }

    public void mostrar(){
        int i = 1;
        double acum = 0;
        int cant = 0;
        System.out.println("Pedido:");
        System.out.println("Cantidad de items: " + this.getRenglones().size());
        for(Renglon renglon : this.getRenglones()){
            System.out.print("Item " + i + ": ");
            renglon.mostrar();
            acum += renglon.getImporte();
            cant += renglon.getCantidad();
            i++;
        }
        System.out.println("--- Total pedido: " + cant + " Etiquetas por un importe total de: $ " + acum);
    }
}