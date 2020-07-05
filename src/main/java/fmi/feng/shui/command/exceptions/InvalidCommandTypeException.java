package fmi.feng.shui.command.exceptions;

public class InvalidCommandTypeException extends Exception {

	private static final long serialVersionUID = 650302281086926302L;

	public InvalidCommandTypeException(String errorMessage) {
		super(errorMessage);
	}

	public InvalidCommandTypeException(String errorMessage, Throwable error) {
		super(errorMessage, error);
	}

}
