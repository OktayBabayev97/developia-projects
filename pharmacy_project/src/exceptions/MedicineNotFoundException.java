package exceptions;

public class MedicineNotFoundException extends RuntimeException {
	String message;

	public MedicineNotFoundException(String message) {
		super(message);
		this.message = message;
	}
}
