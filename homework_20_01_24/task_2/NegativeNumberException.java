package task_2;

public class NegativeNumberException extends RuntimeException {
	private String message;

	public NegativeNumberException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
