package it.infocamere.aces.acese.ejb.exceptions;

public class EjbLookupException extends Exception {

	private static final long serialVersionUID = 1L;

	public EjbLookupException() {
		super();
	}

	public EjbLookupException(String message, Throwable cause) {
		super(message, cause);
	}

	public EjbLookupException(String message) {
		super(message);
	}

	public EjbLookupException(Throwable cause) {
		super(cause);
	}

}
