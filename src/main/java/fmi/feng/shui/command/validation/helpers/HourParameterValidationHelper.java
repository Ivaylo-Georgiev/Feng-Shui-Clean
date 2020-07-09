package fmi.feng.shui.command.validation.helpers;

import fmi.feng.shui.command.exceptions.InvalidParameterException;

public class HourParameterValidationHelper {
	
	private final static int MIN_HOUR = 1;
	private final static int MAX_HOUR = 24;
	
	public boolean validateHourParameter(String parameter) throws InvalidParameterException {
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
