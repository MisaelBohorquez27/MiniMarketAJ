package DVMarket;

import java.util.ArrayList;

public class DVMarket {

    private String nombre;
    private ArrayList<Producto> productos;
    private ArrayList<Compra> compras;

    public DVMarket(String nombre) {
        this.nombre = nombre;
        this.productos = new ArrayList<>();
        this.compras = new ArrayList<>();
    }

    public void separador() {
        System.out.println("-------------------------");
    }

    public void iniciarSistema() {
        Menu.mostrarMenu();
        int opcion = Consola.LeerNumero();
        opcion = validacionMenu(opcion);
        opcionesMenu(opcion);

    }

    private int validacionMenu(int opcion) {
        while (opcion != Menu.OPCION_1 && opcion != Menu.OPCION_2 && opcion != Menu.OPCION_3 && opcion != Menu.OPCION_4 && opcion != Menu.OPCION_5) {
            System.out.println("--Opción incorrecta--");
            Menu.mostrarMenu();
            opcion = Consola.LeerNumero();
        }
        return opcion;
    }

    private void opcionesMenu(int opcion) {
        switch (opcion) {
            case Menu.OPCION_1:
                nuevaCompra();
                break;
            case Menu.OPCION_2:
                separador();
                mostrarComprasConfirmadas();
                separador();
                iniciarSistema();
                break;
            case Menu.OPCION_3:
                separador();
                mostrarComprasCanceladas();
                separador();
                iniciarSistema();
                break;
            case Menu.OPCION_4:
                System.exit(0);
                break;
            case Menu.OPCION_5:
                separador();
                vaciarComprasCanceladas();
                iniciarSistema();
        }
    }

    private void aMenuCompra(Compra compra) {
        MenuCompra.mostrarMenu();
        int opcion = Consola.LeerNumero();
        opcion = validacionMenuCompra(opcion);
        opcionesMenuCompra(opcion, compra);
    }

    private int validacionMenuCompra(int opcion) {
        while (opcion == MenuCompra.OPCION_1 && opcion == MenuCompra.OPCION_2 && opcion == MenuCompra.OPCION_3 && opcion == MenuCompra.OPCION_4 && opcion == MenuCompra.OPCION_5) {
            System.out.println("--Opción incorrecta--");
            MenuCompra.mostrarMenu();
            opcion = Consola.LeerNumero();
        }
        return opcion;
    }

    private void opcionesMenuCompra(int opcion, Compra compra) {
        switch (opcion) {
            case MenuCompra.OPCION_1:
                separador();
                cargarItem(compra);
                separador();
                aMenuCompra(compra);
                break;
            case MenuCompra.OPCION_2:
                separador();
                borrarItem(compra);
                separador();
                aMenuCompra(compra);
                break;
            case MenuCompra.OPCION_3:
                separador();
                mostrarItemsActuales(compra);
                separador();
                aMenuCompra(compra);
                break;
            case MenuCompra.OPCION_4:
                separador();
                confirmarCompra(compra);
                separador();
                iniciarSistema();
                break;
            case MenuCompra.OPCION_5:
                separador();
                cancelarCompra(compra);
                separador();
                iniciarSistema();
                break;
        }
    }

    public int lectorCodigoDeBarras() {
        System.out.println("Ingrese codigo del producto: ");
        int codigo = Consola.LeerNumero();
        Producto p = buscarProducto(codigo);
        while (p == null) {
            System.out.println("*Código no encontrado. Ingrese el código nuevamente:* ");
            codigo = Consola.LeerNumero();
            p = buscarProducto(codigo);
        }
        separador();
        System.out.println("Producto encontrado: " + p.getNombre() + ": $" + p.getPrecio() + " Id: " + p.getId());
        System.out.println("Se agrego con exito!");

        return codigo;
    }

    public void agregarProductos(Producto p) {
        this.productos.add(p);
    }

    private void nuevaCompra() {
        Compra compra = new Compra();
        this.compras.add(compra);
        separador();
        aMenuCompra(compra);
    }

    public void mostrarComprasConfirmadas() {
        if (hayComprasConfirmadas()) {
            for (Compra c : this.compras) {
                if (c.getEstado() == Estado.CONFIRMADA) {
                    mostrarCompras(c);
                }
            }
        } else {
            System.out.println("-No hay compras confirmadas-");
        }
    }

    public boolean hayComprasConfirmadas() {
        int i = 0;
        boolean hayCompras = false;
        while (i < compras.size() && hayCompras == false) {
            if (compras.get(i).getEstado() == Estado.CONFIRMADA) {
                hayCompras = true;
            }
            i++;
        }
        return hayCompras;
    }

    public void mostrarComprasCanceladas() {        
        if (hayComprasCanceladas()) {
            for (Compra c : this.compras) {
                if (c.getEstado() == Estado.CANCELADA) {
                    mostrarCompras(c);
                }
            }
        } else {
            System.out.println("-No hay compras canceladas-");
        }
    }

    public boolean hayComprasCanceladas() {
        int i = 0;
        boolean noHayCompras = false;
        while (i < compras.size() && noHayCompras == false) {
            if (compras.get(i).getEstado() == Estado.CANCELADA) {
                noHayCompras = true;
            }
            i++;
        }
        return noHayCompras;
    }

    public Producto buscarProducto(int id) {
        int i = 0;
        Producto producto = null;
        while (i < this.productos.size() && producto == null) {
            Producto prod = this.productos.get(i);
            if (prod.getId() == id) {
                producto = prod;
            }
            i++;
        }
        return producto;
    }

    public Compra buscarCompra(int id) {
        int i = 0;
        Compra compra = null;
        while (i < this.compras.size() && compra == null) {
            Compra comp = this.compras.get(i);
            if (comp.getNumID() == id) {
                compra = comp;
            }
            i++;
        }
        return compra;
    }

    public Item buscarItem(int id) {
        int j = 0;
        Item item = null;
        while (j < this.compras.size() && item == null) {
            item = this.compras.get(j).buscarItem(id);
            j++;
        }
        return item;
    }

    public void cargarItem(Compra c) {
        int codigo = lectorCodigoDeBarras();
        Producto producto = buscarProducto(codigo);
        separador();
        System.out.println("Ingrese cantidad: ");
        int cant = Consola.LeerNumero();
        c.cargarItem(new Item(producto.getNombre(), cant));
        System.out.println("Item agregado exitosamente!");
    }

    public void borrarItem(Compra c) {
        int id;
        if (!c.hayItems()) {
            System.out.println("-Todavia no agregaste items-");
        } else {
            System.out.println("*Ingresar id del item: ");
            id = Consola.LeerNumero();
            Item item = c.buscarItem(id);
            if (item != null) {
                c.borrarItem(item);
                System.out.println("Item eliminado exitosamente!");
            } else {
                System.out.println("-Item inexistente-");
            }
        }
    }

    public void mostrarItemsActuales(Compra c) {
        if (c.hayItems()) {
            c.mostrarItemsActuales();
        } else {
            System.out.println("-No hay items cargados-");
        }

    }

    public void confirmarCompra(Compra c) {

        if (c.hayItems()) {
            System.out.println("Compra confirmada!");
            c.setEstado(Estado.CONFIRMADA);
            c.crearTicket();
        } else {
            System.out.println("-No hay items cargados-");
        }
    }

    public void cancelarCompra(Compra c) {
        System.out.println("Compra cancelada!");
        c.setEstado(Estado.CANCELADA);
    }

    private void mostrarCompras(Compra c) {
        if (c != null) {
            System.out.println(c.getNumID() + "\t" + c.getFecha() + "\t" + c.getHora() + "\t" + c.getEstado());
        }
    }

    public void vaciarComprasCanceladas() {  
        int i=0;
        if (hayComprasCanceladas()) {
            while (i < compras.size()) {
            if (compras.get(i).getEstado() == Estado.CANCELADA) {
                borrarCompra(compras.get(i));
        } else {
            System.out.println("-No hay compras canceladas todavia-");
        }}}}

    

    public void borrarCompra(Compra c) {
        this.compras.remove(c);
    }
}
