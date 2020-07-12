package fmi.feng.shui.command.exceptions;

/**
 * Signals that the command, specified by the user, is not supported. Possible
 * reasons may include a typo in the raw input, invalid syntax or non-existent
 * command type.
 * 
 *
 * @author Ivaylo Georgiev
 */
public class InvalidCommandTypeException extends Exception {

	private static final long serialVersionUID = 650302281086926302L;

	public InvalidCommandTypeException(String errorMessage) {
		super(errorMessage);
	}

	public InvalidCommandTypeException(String errorMessage, Throwable error) {
		super(errorMessage, error);
	}

}
