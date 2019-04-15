package conceptos;

import java.beans.*;
import java.io.Serializable;

@SuppressWarnings("serial")
public class panelempleado implements Serializable, PropertyChangeListener {

	public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";

	private int limiteVariacionSueldo;
	private String[] listaDeCargos = { "JUNIOR", "SEMISENIOR", "ANALSITA", "CEO" };

	@Override
	public void propertyChange(PropertyChangeEvent evt) { // Crear propia excepcion en un .class aparte
		if (evt.getPropertyName().equals("nuevoCargo")) {
			String nuevoCargo = (String) evt.getNewValue();
			nuevoCargo = nuevoCargo.toUpperCase();
			Boolean esta = false;

			for (String nombre : listaDeCargos) {
				if (nombre.equals(nuevoCargo)) {
					esta = true;
				}
			}

			try {
				if (esta = true) {
					System.out.printf("Se ha asignado un nuevo cargo: %s \nCargo viejo: %s", evt.getNewValue(),
							evt.getOldValue());
				} else {
					throw new cargoError("El cargo no se encuntra en la lista - Cargo no modificado");
				}
			} catch (cargoError e) {
				e.getMessage();
			}

		}

		if (evt.getPropertyName().equals("nuevoSueldo")) {
			Double sueldoAntiguo = (Double) evt.getOldValue();
			Double sueldoNuevo = (Double) evt.getNewValue();
			Double porcentage = ((sueldoAntiguo - sueldoNuevo) / sueldoAntiguo) * 100;

			try {
				if (porcentage < getLimiteVariacionSueldo()) {
					System.out.printf("Se ha asignado un nuevo sueldo: %s \nSueldo viejo: %s", evt.getNewValue(),
							evt.getOldValue());
				} else {
					throw new limiteVariacion("Limite de variación superado - Salario no modificado");
				}
			} catch (limiteVariacion e) {
				e.getMessage();
			}
		}
	}

	public panelempleado() {
		this.setLimiteVariacionSueldo(10);
	}

	public panelempleado(int valor) {
		this();
		this.setLimiteVariacionSueldo(valor);
	}

	public int getLimiteVariacionSueldo() {
		return limiteVariacionSueldo;
	}

	public void setLimiteVariacionSueldo(int limiteVariacionSueldo) {
		this.limiteVariacionSueldo = limiteVariacionSueldo;
	}

	public String[] getListaDeCargos() {
		return listaDeCargos;
	}

	public void setListaDeCargos(String[] listaDeCargos) {
		this.listaDeCargos = listaDeCargos;
	}
}
