package exceptions;

public class CountOutOfBoundException extends RuntimeException {
	String message;

	public CountOutOfBoundException(String message) {
		super(message);
		this.message = message;
	}
}
