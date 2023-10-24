import java.util.ArrayList;

/**
 * Clase ejecutable EjecutablePedidos
 * 
 * @author Velozo, Agustin
 * @version 1 21/10/2023
 */
public class EjecutablePedidos {
    public static void main(String[] args) {
        
        Pedido pedido;
        ArrayList<Renglon> renglones = new ArrayList<Renglon>();
        
        Etiqueta premium1 = new Premium(200, 10);
        Etiqueta comun1 = new Comun(100);
        Etiqueta premium2 = new Premium(200, 7);

        Renglon item1 = new Renglon(7, premium1);
        Renglon item2 = new Renglon(57, comun1);
        Renglon item3 = new Renglon(94, premium2);

        renglones.add(item1);
        renglones.add(item2);
        renglones.add(item3);

        pedido = new Pedido(renglones);
        pedido.mostrar();

    }
}