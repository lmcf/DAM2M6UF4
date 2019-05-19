 package conceptos;

import java.beans.*;
import java.io.Serializable;

@SuppressWarnings("serial")
public class panelempleado implements Serializable, PropertyChangeListener {

	public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";

	private int limiteVariacionSueldo;
	private String[] listaDeCargos = { "JUNIOR", "SEMISENIOR", "ANALSITA", "CEO" };
	static boolean check;

	@Override
	public void propertyChange(PropertyChangeEvent evt) { // Crear propia excepcion en un .class aparte
		if (evt.getPropertyName().equals("nuevoCargo")) {
			String nuevoCargo = (String) evt.getNewValue();
			nuevoCargo = nuevoCargo.toUpperCase();
			for (String nombre : listaDeCargos) {
				if (nombre.equals(nuevoCargo)) {
					check = true;
					break;
				}else {
					check = false;
				}
			}

			/*try {*/
				if (check) {
					System.out.printf("Se ha asignado un nuevo cargo: %s \nCargo viejo: %s \n", evt.getNewValue(),
							evt.getOldValue());
				} else {
					throw new IllegalArgumentException("El cargo no se encuentra en la lista - Cargo no modificado\n");
				}
			/*} catch (cargoError e) {
				System.out.println(e.getMessage());
			}*/

		}

		if (evt.getPropertyName().equals("nuevoSueldo")) {
			Double sueldoAntiguo = (Double) evt.getOldValue();
			Double sueldoNuevo = (Double) evt.getNewValue();
			Double porcentage = ((sueldoAntiguo - sueldoNuevo) / sueldoAntiguo) * 100;

			/*try {*/
				if (Math.abs(porcentage) < getLimiteVariacionSueldo()) {
					System.out.printf("Se ha asignado un nuevo sueldo: %s \nSueldo viejo: %s \n", evt.getNewValue(),
							evt.getOldValue());
				} else {
					throw new IllegalArgumentException("Limite de variación superado - Salario no modificado\n");
				}
			/*} catch (limiteVariacion e) {
				System.out.println(e.getMessage());
			}*/
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
