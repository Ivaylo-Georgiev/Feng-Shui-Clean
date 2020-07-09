package fmi.feng.shui.command.validation;

import java.util.List;

import fmi.feng.shui.command.exceptions.InvalidParameterException;
import fmi.feng.shui.command.exceptions.InvalidParametersCountException;
import fmi.feng.shui.command.validation.helpers.OneParameterValidationHelper;

public class ChineseHourSignParametersValidator extends CommandParametersValidator {

	private final static int PARAMATER_INDEX = 0;
	private final static int MIN_HOUR = 1;
	private final static int MAX_HOUR = 24;

	public ChineseHourSignParametersValidator(List<String> parameters) {
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
