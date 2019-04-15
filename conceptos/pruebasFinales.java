package conceptos;

public class pruebasFinales {
	public static void main(String[] args) {
		empleado empleado = new empleado("123456789A","Caldeiro");
		panelempleado panelempleado = new panelempleado();
		 	
		empleado.setCargo("SEMISENIOR");
		empleado.addPropertyChangeListener(panelempleado);
	
	}
}
