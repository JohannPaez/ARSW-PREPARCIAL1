package edu.eci.arsw.blueprints.exception;

public class FoundPrimeException extends Exception {
	
	public FoundPrimeException(String message) {
        super(message);
    }

    public FoundPrimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
