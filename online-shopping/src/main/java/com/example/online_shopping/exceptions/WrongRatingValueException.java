package com.example.online_shopping.exceptions;

public class WrongRatingValueException extends RuntimeException {
	private String message;

	public WrongRatingValueException(String message) {
		super(message);
		this.message = message;
	}
}
