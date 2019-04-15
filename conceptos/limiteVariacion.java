package conceptos;

public class limiteVariacion extends Exception{
	private static final long serialVersionUID = 1L;

	// Parameterless Constructor
    public limiteVariacion() {}

    // Constructor that accepts a message
    public limiteVariacion(String message)
    {
       super(message);
    }
}
