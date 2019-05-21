import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.sql.PseudoColumnUsage;

public class prueba {
	public static final void saltoLinea() {
		System.out.print("\n");
	}
	
	public static final void imprimir(String algo) {
		System.out.print(algo);
	}
	
	public static void main(String[] args) throws IOException {	
		// A - Mostrar Productos
		verProductos.mostrarDatosProductos();
		saltoLinea();	

		// B - Mostrar Pedidos
		verProductos.mostrarDatosPedidos();
		saltoLinea();

		// C - Disparar la generacion de un pedido
		BaseDatos bbdd = new BaseDatos();
		producto pro1 = bbdd.getProducto(3);
		pedido ped1 = new pedido(pro1, bbdd);
		pro1.addPropertyChangeListener(ped1);
		pro1.setStockActual(1);
		bbdd.close();
		saltoLinea();
		
		/* D- Stockactual del producto que ha provocado la
		generación del pedido NO se modificará. Si, en cambio, la modificación del Stockactual no
		provoca la generación del pedido  SI
		*/
			// No se modifica
		verProductos.mostrarDatosPedidos();
		saltoLinea();
		
			// Si se modifica
		bbdd.open();
		producto pro2 = bbdd.getProducto(6);
		pedido ped2 = new pedido(pro2, bbdd);
		pro2.addPropertyChangeListener(ped2);
		pro2.setStockActual(4);
		bbdd.close();
		verProductos.mostrarDatosProductos();
		
		// E - Volver a mostrar los Pedidos
		verProductos.mostrarDatosPedidos();
			
	}
}
