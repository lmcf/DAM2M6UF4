package conceptos;

public class pruebasFinales {
	public static void main(String[] args) {
		empleado empleado = new empleado("123456789A","Caldeiro");
		panelempleado panelempleado = new panelempleado();
		
		// Se cambiara al empleado Caldeiro el cargo
		empleado.addPropertyChangeListener(panelempleado);
		empleado.setCargo("SEMISENIOR");
		
		// No se podraV el cargo a Caldeiro
		empleado.setCargo("Administrador");
		
		// Se cambiara el sueldo
		empleado.setSueldo(1005.00);
		
		// No se podra cambiar el sueldo
		empleado.setSueldo(1900.00);
		
		System.out.printf("Sueldo actual %s",empleado.getSueldo() );
		
	}
}
