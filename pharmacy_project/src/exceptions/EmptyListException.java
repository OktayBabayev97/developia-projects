package exceptions;

public class EmptyListException extends RuntimeException {
	String message;

	public EmptyListException(String message) {
		super(message);
		this.message = message;
	}

}
