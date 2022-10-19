
package DVMarket;

import java.util.Scanner;


public class Consola {
    
    public static int LeerNumero() {
        Scanner entrada = new Scanner(System.in);

        int ingreso;
        do {
            ingreso = entrada.nextInt();
        } while (ingreso <= 0);
        return ingreso;
    }

    public static String LeerCadena() {
        Scanner entrada = new Scanner(System.in);

        String ingreso;
        ingreso = entrada.nextLine();
        return ingreso;
    }
}
