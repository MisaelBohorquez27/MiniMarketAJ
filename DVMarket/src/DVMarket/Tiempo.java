
package DVMarket;

import java.util.Calendar;

public class Tiempo {
    
     public static String fechaDeHoy() {
        Calendar fecha = Calendar.getInstance();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);

        String laFecha = dia + "/" + (mes + 1) + "/" + año;
        return laFecha;
    }

    public static String horaExacta() {
        Calendar horario = Calendar.getInstance();
        int hora = horario.get(Calendar.HOUR_OF_DAY);
        int minuto = horario.get(Calendar.MINUTE);
        int segundo = horario.get(Calendar.SECOND);

        String laHora = hora + "-" + minuto + "-" + segundo;
        return laHora;
    }
}
