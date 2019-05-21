import java.util.ArrayList;

public class llenarProductos {
	public static void main(String[] args) {
		ArrayList<producto> productos = new ArrayList<producto>();

		producto p1 = new producto(1, "Duruss Cobalt", 10, 3, 220);
		producto p2 = new producto(2, "Varlion Avant Carbon", 5, 2, 176);
		producto p3 = new producto(3, "Star Vie Pyramid R50", 20, 5, 193);
		producto p4 = new producto(4, "Dunlop Titan", 8, 3, 85);
		producto p5 = new producto(5, "Vision King", 7, 1, 159);
		producto p6 = new producto(6, "Slazenger Reflex Pro", 5, 2, 80);

		productos.add(p1);
		productos.add(p2);
		productos.add(p3);
		productos.add(p4);
		productos.add(p5);
		productos.add(p6);

		// Abrimos BBDD
		BaseDatos bbdd = new BaseDatos();

		for (producto producto : productos) {
			bbdd.insertarProducto(producto);
		}
		
		bbdd.close();
	}
}
