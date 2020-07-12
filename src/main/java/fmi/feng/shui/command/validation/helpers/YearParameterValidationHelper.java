package fmi.feng.shui.command.validation.helpers;

import fmi.feng.shui.command.exceptions.InvalidParameterException;

/**
 * Helps to validate a year parameter, passed to a Feng Shui command. A year
 * parameter is considered valid, if it is a positive integer
 * 
 *
 * @author Ivaylo Georgiev
 */
public class YearParameterValidationHelper implements ParameterTypeValidationHelper {

	/**
	 * Validates, that the user has correctly specified the year parameter. Accepted
	 * values are positive integers
	 * 
	 * @throws InvalidParameterException If the year parameter is not a positive
	 *                                   integer
	 * @param parameter The raw user input, corresponding to the year
	 * @return boolean true, if the user input is a positive integer
	 */
	@Override
	public boolean validateParameter(String parameter) throws InvalidParameterException {
		try {
			int year = Integer.parseInt(parameter);
			if (isNegative(year)) {
				throw new InvalidParameterException(
						parameter + " is an invalid value for a year. Please, enter a positive integer");
			}
		} catch (NumberFormatException numberFormatException) {
			throw new InvalidParameterException(
					parameter + " is an invalid value for a year. Please, enter an integer");
		}

		return true;
	}

	private boolean isNegative(int year) {
		if (year < 0) {
			return true;
		}

		return false;
	}

}
