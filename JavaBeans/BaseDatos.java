

import java.math.BigDecimal;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

public class BaseDatos {
	ODB db;
	
	public BaseDatos() {
		db = ODBFactory.open("pedidos_productos.DB");
	}
	
	public void open() {
		db = ODBFactory.open("pedidos_productos.DB");
	}
	
	public void insertarProducto(producto producto) {
		db.store(producto);
	}
	
	public void insertarPedido(pedido pedido) {
		db.store(pedido);
	}
	
	public void insertarVenta(venta venta) {
		db.store(venta);
	}
	
	public Objects<producto> getProductos() {
		return db.getObjects(producto.class);
	}

	public Objects<pedido> getPedidos() {
		return db.getObjects(pedido.class);
	}
	
	public void close() {
		db.close();
	}
	
	public producto getProducto(int idAEncontrar) {
		// Cuando el id coincida devolver ese producto, si no sera null
		ICriterion criterio = Where.equal("id", idAEncontrar);
		CriteriaQuery query = new CriteriaQuery(producto.class, criterio);
		Objects<producto> productos = db.getObjects(query);
		if (productos.hasNext()) {
			return productos.getFirst();
		}
		System.out.print("No hay ningun producto con esa referencia");
		return null;
	}
	
	public int getAutoIdPedido() {
		Values val = db.getValues(new ValuesCriteriaQuery(pedido.class).max("numPed"));
		int autoId = ((BigDecimal) val.next().getByAlias("numPed")).intValue(); 
		return autoId;
	}
	
	
}
