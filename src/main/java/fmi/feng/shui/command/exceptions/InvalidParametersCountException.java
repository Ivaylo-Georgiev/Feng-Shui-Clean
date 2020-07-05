package fmi.feng.shui.command.exceptions;

public class InvalidParametersCountException extends Exception {

	private static final long serialVersionUID = 8516988958144594224L;

	public InvalidParametersCountException(String errorMessage) {
		super(errorMessage);
	}

	public InvalidParametersCountException(String errorMessage, Throwable error) {
		super(errorMessage, error);
	}

}
