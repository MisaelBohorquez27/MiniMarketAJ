package DVMarket;
import java.io.FileWriter;

public aspect SalidaProducto {
	pointcut callBorrarItem(): call(Compra.borrarItem());
    before (): callBorrarItem (){
    	 FileWriter fichero = null;
	  try{
		  fichero = new FileWriter("market.txt");
			fichero.write("accion: borrar_item "  );
			fichero.write(DVMarket.p.getNombre());	
		fichero.close();

		
				
			} catch (Exception ex) {
				System.out.println("error");
			}	 
	
 
}
    pointcut CallAgregarItem():call
    	
}
