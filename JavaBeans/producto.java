

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.logging.Logger;

import javax.lang.model.element.Element;

public class producto implements Serializable {
	private int id;
	private String nombreProducto;
	private int stockActual;
	private int stockMinimo;
	private double precioProducto;
	
	//public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
	private PropertyChangeSupport propertySupport;
	
	public producto() {
		propertySupport = new PropertyChangeSupport(this);
	}
	
	public producto(int id, String nombreProducto, int stockActual, int stockMinimo, double precioProducto) {
		super();
		this.id = id;
		this.nombreProducto = nombreProducto;
		this.stockActual = stockActual;
		this.stockMinimo = stockMinimo;
		this.precioProducto = precioProducto;
	}
	
	
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertySupport.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertySupport.removePropertyChangeListener(listener);
	}
	
	public PropertyChangeSupport getPropertySupport() {
		return propertySupport;
	}

	public void setPropertySupport(PropertyChangeSupport propertySupport) {
		this.propertySupport = propertySupport;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public int getStockActual() {
		return stockActual;
	}
	
	public void setStockActual(int stock) {
		int stockViejo = this.stockActual;
		
		// Si el stock actual es inferior al minimo se realizara un pedido con la cantidad hasta llegar al minimo
		if (stock < getStockMinimo()) {
			propertySupport.firePropertyChange("stockactual", stockViejo, getStockMinimo()-stock);
			System.out.println("Pedido insertado en la BBDD");
			this.stockActual = stockViejo;			
		}
	}
	public int getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	public double getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}
	
}
