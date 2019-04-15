package conceptos;

public class cargoError extends Exception{
	private static final long serialVersionUID = 1L;

	// Parameterless Constructor
    public cargoError() {}

    // Constructor that accepts a message
    public cargoError(String message)
    {
       super(message);
    }
}
