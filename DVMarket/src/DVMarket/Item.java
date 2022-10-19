package DVMarket;

public class Item {

    
    private int id;
    private String nombre;
    private int cantidad;
    private double subtotal;
    private static int contadorID = 100;

    public Item(String nombre, int cantidad) {
        this.id = Item.obtenerNumeroIdentificatorio();
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    private static int obtenerNumeroIdentificatorio() {
        Item.contadorID++;
        return Item.contadorID;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }


    public void mostrarItem() {
        System.out.println(getCantidad() + "\t" + getNombre() + "\t" + getId() + "\t" + getSubtotal());

    }

}
