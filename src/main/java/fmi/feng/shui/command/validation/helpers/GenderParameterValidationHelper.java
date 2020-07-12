package fmi.feng.shui.command.validation.helpers;

import fmi.feng.shui.command.exceptions.InvalidParameterException;
import fmi.feng.shui.command.kua.Gender;

/**
 * Helps to validate a gender parameter, passed to a Feng Shui command.
 * 
 *
 * @author Ivaylo Georgiev
 */
public class GenderParameterValidationHelper implements ParameterTypeValidationHelper {

	/**
	 * Validates, that the user has correctly specified the gender parameter.
	 * Accepted values are 'male' and 'female' (case insensitive)
	 * 
	 * @throws InvalidParameterException If the value does not equal to 'male' or
	 *                                   'female' (case insensitive)
	 * @param parameter The raw user input, corresponding to the gender
	 * @return boolean true, if the value equals to 'male' or 'female' (case
	 *         insensitive)
	 */
	@Override
	public boolean validateParameter(String parameter) throws InvalidParameterException {
		try {
			Gender.valueOf(parameter.toUpperCase());
		} catch (IllegalArgumentException illegalArgumentException) {
			throw new InvalidParameterException(
					parameter + " is an invalid value for a gender. Please, enter either 'male' or 'female'");
		}

		return true;
	}

}
