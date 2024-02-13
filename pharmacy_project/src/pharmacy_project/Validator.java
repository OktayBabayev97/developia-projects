package pharmacy_project;

import exceptions.WrongIntervalException;

public class Validator {
	public void priceValidation(int minPrice, int maxPrice) {
		if (minPrice <= 0 || maxPrice <= minPrice) {
			throw new WrongIntervalException("Wrong price interval");
		}
	}
}
