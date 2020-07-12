package fmi.feng.shui.command.exceptions;

/**
 * Signals that the command, specified by the user, is supported and the number
 * of parameters is correct, but one of the parameters is invalid.
 * 
 *
 * @author Ivaylo Georgiev
 */
public class InvalidParameterException extends Exception {

	private static final long serialVersionUID = -6533917251099783877L;

	public InvalidParameterException(String errorMessage) {
		super(errorMessage);
	}

	public InvalidParameterException(String errorMessage, Throwable error) {
		super(errorMessage, error);
	}

}
