package fmi.feng.shui.command.validation;

import java.util.List;

import fmi.feng.shui.command.exceptions.InvalidParameterException;
import fmi.feng.shui.command.exceptions.InvalidParametersCountException;

/**
 * Validates the parameters, passed to a Feng Shui command.
 * 
 *
 * @author Ivaylo Georgiev
 */
public abstract class CommandParametersValidator {

	protected List<String> parameters;

	public CommandParametersValidator(List<String> parameters) {
		this.parameters = parameters;
	}

	public abstract boolean validateParametersCount() throws InvalidParametersCountException;

	public abstract boolean validateParameters() throws InvalidParameterException;

}
