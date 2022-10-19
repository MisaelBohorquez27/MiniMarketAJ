
package DVMarket;

import java.util.ArrayList;

public class Ticket {
    private String fecha;
    private String hora;
    private ArrayList<Item> listaItems;
    private double precioTotal;

    public Ticket(String fecha, String hora, ArrayList<Item> listaItems, double precioTotal) {
        this.fecha = fecha;
        this.hora = hora;
        this.listaItems = listaItems;
        this.precioTotal = precioTotal;
    }

    public void mostrarTicket(){
        System.out.println("Ticket: \nFecha: " + fecha + "\tHora: " + hora);
        for (Item item : this.listaItems) {
            item.mostrarItem();
            System.out.println(".");
        }
        System.out.println("TOTAL: $" + precioTotal );
    }
}
