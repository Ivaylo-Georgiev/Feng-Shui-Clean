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

	/**
	 * The raw command parameters, specified by the user
	 */
	protected List<String> parameters;

	/**
	 * Constructs a validator for Feng Shui commands with the raw parameters,
	 * specified by the user
	 */
	public CommandParametersValidator(List<String> parameters) {
		this.parameters = parameters;
	}

	/**
	 * Verify that a certain number of parameters is passed to a command
	 * 
	 * @throws InvalidParameterException If the number of parameters, passed by the
	 *                                   user, is invalid for a specific Feng Shui
	 *                                   command
	 * @return boolean true, if the exact number of parameters is passed to a
	 *         command
	 */
	public abstract boolean validateParametersCount() throws InvalidParametersCountException;

	/**
	 * Verify that every parameter, passed to a Feng Shui command, is valid
	 * 
	 * @throws InvalidParameterException If a certain type of parameter is invalid
	 * @return boolean true, if all parameters are valid
	 */
	public abstract boolean validateParameters() throws InvalidParameterException;

}
