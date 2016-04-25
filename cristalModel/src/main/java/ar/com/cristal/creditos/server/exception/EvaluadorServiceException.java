package ar.com.cristal.creditos.server.exception;

public class EvaluadorServiceException extends DefaultException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final String MESSAGE = " El proceso de evaluación no pudo ejecutarse de manera correcta. ";
	
	/**
	 * @param message
	 */
	public EvaluadorServiceException(String message) {
		super(message);
	}
	
	/**
	 * @param message
	 */
	public EvaluadorServiceException(String message, Exception exception) {
		super(message, exception);
	}

	@Override
	public String getMessage() {
		return super.getMessage() + MESSAGE;
	}
}
