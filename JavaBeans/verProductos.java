
public class verProductos {
	public static void mostrarDatosProductos() {
		BaseDatos bbdd = new BaseDatos();
		for (producto producto : bbdd.getProductos()) {
			System.out.println("|" + String.valueOf(producto.getId()) + "|"
					+ producto.getNombreProducto() + "|"
					+ String.valueOf(producto.getStockActual()) + "|"
					+ String.valueOf(producto.getStockMinimo()) + "|"
					+ String.valueOf(producto.getPrecioProducto()) + "|");
		}
		bbdd.close();

	}
	
	public static void mostrarDatosPedidos() {
		BaseDatos bbdd = new BaseDatos();
		for (pedido pedido : bbdd.getPedidos()) {
			System.out.println("|" + String.valueOf(pedido.getNumPed()) + "|"
					+ pedido.getProducto().getNombreProducto()+ "|"
					+ String.valueOf(pedido.getFecha()) + "|"
					+ String.valueOf(pedido.getCantidad()) + "|");
		}
		bbdd.close();
	}
	
}
