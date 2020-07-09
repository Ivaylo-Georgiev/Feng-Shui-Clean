package fmi.feng.shui.command.validation.helpers;

import fmi.feng.shui.command.exceptions.InvalidParameterException;
import fmi.feng.shui.command.kua.Gender;

public class GenderParameterValidationHelper {

	public boolean validateGenderParameter(String parameter) throws InvalidParameterException {
		try {
			Gender.valueOf(parameter.toUpperCase());
		} catch (IllegalArgumentException illegalArgumentException) {
			throw new InvalidParameterException(
					parameter + " is an invalid value for a gender. Please, enter either 'male' or 'female'");
		}

		return true;
	}

}
