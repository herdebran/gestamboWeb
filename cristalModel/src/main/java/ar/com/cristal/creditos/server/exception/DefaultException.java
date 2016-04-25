package ar.com.cristal.creditos.server.exception;

public class DefaultException extends Exception {

	public DefaultException(String message) {
		super(message);
	}
	
	public DefaultException(String message, Exception e) {
		super(message, e);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2833223867110586353L;
	
}
