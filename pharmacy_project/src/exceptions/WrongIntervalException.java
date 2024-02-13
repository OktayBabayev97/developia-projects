package exceptions;

public class WrongIntervalException extends RuntimeException {
	String message;

	public WrongIntervalException(String message) {
		super(message);
		this.message = message;
	}
}
