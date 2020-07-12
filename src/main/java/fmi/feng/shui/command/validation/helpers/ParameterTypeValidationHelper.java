package fmi.feng.shui.command.validation.helpers;

import fmi.feng.shui.command.exceptions.InvalidParameterException;

/**
 * Helps to validate the exact type of parameter, passed to a Feng Shui command.
 * 
 *
 * @author Ivaylo Georgiev
 */
@FunctionalInterface
public interface ParameterTypeValidationHelper {

	/**
	 * Validates, that the user has correctly specified a parameter type
	 * 
	 * @throws InvalidParameterException If the parameter, specified by the user is
	 *                                   correct
	 * @param parameter The raw user input, corresponding to the hour
	 * @return boolean true, if the user input is a valid parameter
	 */
	public boolean validateParameter(String parameter) throws InvalidParameterException;

}
