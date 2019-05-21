

import java.beans.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class pedido implements Serializable,PropertyChangeListener {
	private int numPed;
	private producto producto;
	private Instant fecha;
	private int cantidad;
	private BaseDatos bbdd;
	
	public pedido(producto producto, BaseDatos bbdd) {
		this.producto = producto;
		this.bbdd = bbdd;
	}

	public pedido(int numPed, producto producto, Instant fecha, int cantidad) {
		this.numPed = numPed;
		this.producto = producto;
		this.fecha = fecha;
		this.cantidad = cantidad;
	}

	@Override
	// Se realiza un pedido con la cantidad de producto que falta para llegar al minimo
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("stockactual")) {
			int cantidadNueva = (int) evt.getNewValue();
			//ZoneId z = ZoneId.of( "Spain/Madrid" );
			//ZonedDateTime zdt = ZonedDateTime.now(z);
			//Instant fechaActual = zdt.toInstant();
			pedido pedido = new pedido(bbdd.getAutoIdPedido()+1,this.producto,Instant.now(),cantidadNueva);
			bbdd.insertarPedido(pedido);
			
		}
	}

	public int getNumPed() {
		return numPed;
	}

	public void setNumPed(int numPed) {
		this.numPed = numPed;
	}

	public producto getProducto() {
		return producto;
	}

	public void setProducto(producto producto) {
		this.producto = producto;
	}

	public Instant getFecha() {
		return fecha;
	}

	public void setFecha(Instant fecha) {
		this.fecha = fecha;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
