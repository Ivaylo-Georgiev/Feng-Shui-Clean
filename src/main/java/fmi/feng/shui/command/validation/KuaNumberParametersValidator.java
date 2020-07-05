package fmi.feng.shui.command.validation;

import java.util.List;

import fmi.feng.shui.command.exceptions.InvalidParameterException;
import fmi.feng.shui.command.exceptions.InvalidParametersCountException;
import fmi.feng.shui.command.kua.Gender;
import fmi.feng.shui.command.validation.templates.TwoParametersTemplate;

public class KuaNumberParametersValidator extends CommandParametersValidator {

	private final static int YEAR_PARAMETER_INDEX = 0;
	private final static int GENDER_PARAMETER_INDEX = 1;

	public KuaNumberParametersValidator(List<String> parameters) {
		super(parameters);
	}

	@Override
	public boolean validateParametersCount() throws InvalidParametersCountException {
		TwoParametersTemplate twoParametersTemplate = new TwoParametersTemplate();
		return twoParametersTemplate.validateParametersCount(parameters);
	}

	@Override
	public boolean validateParameters() throws InvalidParameterException {
		if (validateYearParameter(parameters.get(YEAR_PARAMETER_INDEX))) {
			return validateGenderParameter(parameters.get(GENDER_PARAMETER_INDEX));
		}
		return false;
	}

	private boolean validateYearParameter(String year) throws InvalidParameterException {
		try {
			Integer.parseInt(year);
		} catch (NumberFormatException numberFormatException) {
			throw new InvalidParameterException(year + " is an invalid value for a year. Please, enter an integer");
		}

		return true;
	}

	private boolean validateGenderParameter(String gender) throws InvalidParameterException {
		try {
			Gender.valueOf(gender.toUpperCase());
		} catch (IllegalArgumentException illegalArgumentException) {
			throw new InvalidParameterException(
					gender + " is an invalid value for a gender. Please, enter either 'male' or 'female'");
		}

		return true;
	}

}
