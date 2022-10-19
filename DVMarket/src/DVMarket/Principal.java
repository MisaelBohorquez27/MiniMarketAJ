package DVMarket;

public class Principal {

    public static void main(String[] args) {
        DVMarket app = new DVMarket("DVMarket");

        app.agregarProductos(new Producto(1300, "Producto 1", 500));
        app.agregarProductos(new Producto(1301, "Producto 2", 650));
        app.agregarProductos(new Producto(1302, "Producto 3", 1000));
        app.agregarProductos(new Producto(1303, "Producto 4", 360));
        app.agregarProductos(new Producto(1304, "Producto 5", 199));
        app.agregarProductos(new Producto(1305, "Producto 6", 370));
        app.agregarProductos(new Producto(1306, "Producto 7", 1500));
        app.agregarProductos(new Producto(1307, "Producto 8", 1250));
        app.agregarProductos(new Producto(1308, "Producto 9", 899));
        app.agregarProductos(new Producto(1309, "Producto 10", 160));
        app.agregarProductos(new Producto(1310, "Producto 11", 740));
        app.agregarProductos(new Producto(1311, "Producto 12", 299));
        app.agregarProductos(new Producto(1312, "Producto 13", 4000));

        app.iniciarSistema();
    }

}
