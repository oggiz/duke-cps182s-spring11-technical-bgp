package exceptions;

/**
 * Thrown when the operating system of the client cannot be identified.
 */
public class OSException extends Exception
{

	public OSException()
	{
		super("The operating system canont be identified.");
	}

}
