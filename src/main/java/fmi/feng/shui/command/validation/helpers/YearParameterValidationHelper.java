package fmi.feng.shui.command.validation.helpers;

import fmi.feng.shui.command.exceptions.InvalidParameterException;

public class YearParameterValidationHelper {

	public boolean validateYearParameter(String parameter) throws InvalidParameterException {
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
