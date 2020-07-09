package fmi.feng.shui.command.validation;

import java.util.List;

import fmi.feng.shui.command.exceptions.InvalidParameterException;
import fmi.feng.shui.command.exceptions.InvalidParametersCountException;
import fmi.feng.shui.command.validation.helpers.OneParameterValidationHelper;

public class ChineseYearSignParametersValidator extends CommandParametersValidator {

	private final static int PARAMATER_INDEX = 0;

	public ChineseYearSignParametersValidator(List<String> parameters) {
		super(parameters);
	}

	@Override
	public boolean validateParametersCount() throws InvalidParametersCountException {
		OneParameterValidationHelper oneParameterTemplate = new OneParameterValidationHelper();
		return oneParameterTemplate.validateParametersCount(parameters);
	}

	@Override
	public boolean validateParameters() throws InvalidParameterException {
		String parameter = parameters.get(PARAMATER_INDEX);
		try {
			int year = Integer.parseInt(parameter);
			if (year < 0) {
				throw new InvalidParameterException(
						parameter + " is an invalid value for a year. Please, enter a positive integer");
			}
		} catch (NumberFormatException numberFormatException) {
			throw new InvalidParameterException(
					parameter + " is an invalid value for a year. Please, enter an integer");
		}

		return true;
	}

}
