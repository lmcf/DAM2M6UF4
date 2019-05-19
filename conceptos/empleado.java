package conceptos;

import java.beans.*;
import java.io.Serializable;

@SuppressWarnings("serial")
public class empleado implements Serializable {

	public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
	private String NIF;
	private String nombre;
	private String cargo;
	private double sueldo;

	private PropertyChangeSupport propertySupport;

	public empleado() {
		propertySupport = new PropertyChangeSupport (this);
		this.cargo = "Junior";
		this.sueldo = 1000.00;
	}

	public empleado(String nif, String nombre) {
		this();
		this.setNombre(nombre);
		this.setNIF(nif);
	}

	public String getNIF() {
		return NIF;
	}

	public void setNIF(String nIF) {
		NIF = nIF;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		if (cargo != null && !cargo.equals("")) {
			String cargoViejo = this.cargo;
			System.out.println(cargo);
			try {
				propertySupport.firePropertyChange("nuevoCargo", cargoViejo, cargo);
				this.cargo = cargo;
			} catch (IllegalArgumentException e) {
				System.out.print(e.getMessage());
			}
			
		}
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		if (sueldo != 0) {
			double sueldoViejo = this.sueldo;
			try {
				propertySupport.firePropertyChange("nuevoSueldo", sueldoViejo, sueldo);
				this.sueldo = sueldo;
			} catch (IllegalArgumentException e) {
				System.out.print(e.getMessage());
			}

		}
	}

	public static String getPropSampleProperty() {
		return PROP_SAMPLE_PROPERTY;
	}

	public void addPropertyChangeListener (PropertyChangeListener listener) {
		propertySupport.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener (PropertyChangeListener listener) {
		propertySupport.removePropertyChangeListener(listener);
	}

	public PropertyChangeSupport getPropertySupport() {
		return propertySupport;
	}

	public void setPropertySupport(PropertyChangeSupport propertySupport) {
		this.propertySupport = propertySupport;
	}

}
