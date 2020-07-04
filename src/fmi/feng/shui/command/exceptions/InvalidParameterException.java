package fmi.feng.shui.command.exceptions;

public class InvalidParameterException extends Exception {

	private static final long serialVersionUID = -6533917251099783877L;

	public InvalidParameterException(String errorMessage) {
		super(errorMessage);
	}

	public InvalidParameterException(String errorMessage, Throwable error) {
		super(errorMessage, error);
	}

}
