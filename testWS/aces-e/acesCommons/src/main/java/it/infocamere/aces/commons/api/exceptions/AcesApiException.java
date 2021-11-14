package it.infocamere.aces.commons.api.exceptions;

public class AcesApiException extends Exception{

	private static final long serialVersionUID = 1L;
		
	public int retCodeException; 	

	public AcesApiException() {
		super();
	}

	public AcesApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AcesApiException(String message, Throwable cause) {
		super(message, cause);
	}

	public AcesApiException(String message) {
		super(message);
	}

	public AcesApiException(int retCodeException, String message) {
		super(message);
		this.retCodeException =  retCodeException;
	}

	public AcesApiException(Throwable cause) {
		super(cause);
	}
	
	public int getRetCodeException() {
		return retCodeException;
	}

}