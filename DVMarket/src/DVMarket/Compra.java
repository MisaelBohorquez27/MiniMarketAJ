package DVMarket;

import java.util.ArrayList;

public class Compra {

    private String fecha;
    private String hora;
    private int numID;
    private Estado estado;
    private ArrayList<Item> items;
    private static int contadorNumID = 1000;

    public Compra() {
        this.fecha = fecha;
        this.hora = hora;
        this.numID = Compra.obtenerNumeroIdentificatorio();
        this.estado = estado;
        this.items = new ArrayList<>();
    }

    private static int obtenerNumeroIdentificatorio() {
        Compra.contadorNumID++;
        return Compra.contadorNumID;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public int getNumID() {
        return this.numID;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }


    public void cargarItem(Item i) {
        this.items.add(i);

    }
    
    public boolean hayItems(){
        return !this.items.isEmpty();
    }

    public Item buscarItem(int id) {
        int j = 0;
        Item item = null;
        while (j < this.items.size() && item == null) {
            Item i = this.items.get(j);
            if (i.getId()==id) {
                item = i;
            }
            j++;
        }
        return item;
    }

    public void borrarItem(Item i) {
        this.items.remove(i);
    }
    
    public void mostrarItemsActuales(){
        for(Item item : this.items){
            item.mostrarItem();
        }
    }
    
    public double precioTotal(){
        double subtotal=0;
        for(Item i:this.items){
           subtotal=subtotal + i.getSubtotal();
        }
        return subtotal;
    }
    
    public void crearTicket(){
        Ticket ticket= new Ticket(fecha, hora, items, precioTotal());
    }
}
