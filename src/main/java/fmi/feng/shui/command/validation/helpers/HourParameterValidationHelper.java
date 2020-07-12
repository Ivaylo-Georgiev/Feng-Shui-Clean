package fmi.feng.shui.command.validation.helpers;

import fmi.feng.shui.command.exceptions.InvalidParameterException;

/**
 * Helps to validate an hour parameter, passed to a Feng Shui command. An hour
 * parameter is considered valid, if it is an integer between 1 and 24.
 * 
 *
 * @author Ivaylo Georgiev
 */
public class HourParameterValidationHelper implements ParameterTypeValidationHelper {

	private final static int MIN_HOUR = 1;
	private final static int MAX_HOUR = 24;

	@Override
	public boolean validateParameter(String parameter) throws InvalidParameterException {
		try {
			int hour = Integer.parseInt(parameter);
			if (hour < MIN_HOUR || hour > MAX_HOUR) {
				throw new InvalidParameterException(
						parameter + " is an invalid value for an hour. Please, enter an integer between 1 and 24");
			}
		} catch (NumberFormatException numberFormatException) {
			throw new InvalidParameterException(
					parameter + " is an invalid value for an hour. Please, enter an integer");
		}

		return true;
	}

}
