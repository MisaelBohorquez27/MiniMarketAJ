
package DVMarket;


public class Menu {
    public final static int OPCION_1 = 1;
    private final static String NOMBRE_1 = "Nueva Compra";
    public final static int OPCION_2 = 2;
    private final static String NOMBRE_2 = "Ver Compras";
    public final static int OPCION_3 = 3;
    private final static String NOMBRE_3 = "Ver compras canceladas";
    public final static int OPCION_4 = 4;
    private final static String NOMBRE_4 = "Salir";
    public final static int OPCION_5 = 5;
    private final static String NOMBRE_5 = "Vaciar compras canceladas";
    
    public static void mostrarMenu(){
        System.out.println("Bienvenido/a:");
        System.out.println(OPCION_1 + ") " + NOMBRE_1 + "\n" + OPCION_2 + ") " + NOMBRE_2 + "\n" + OPCION_3 + ") " + NOMBRE_3 + "\n" + OPCION_4 + ") " + NOMBRE_4 + "\n" + OPCION_5 + ") " + NOMBRE_5);
        System.out.println("-------------------------");
    }
}
