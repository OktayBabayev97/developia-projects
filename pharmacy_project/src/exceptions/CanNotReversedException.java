package exceptions;

public class CanNotReversedException extends RuntimeException {
	String message;

	public CanNotReversedException(String message) {
		super(message);
		this.message = message;
	}
}
