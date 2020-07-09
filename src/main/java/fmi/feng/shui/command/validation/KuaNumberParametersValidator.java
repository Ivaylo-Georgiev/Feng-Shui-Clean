package fmi.feng.shui.command.validation;

import java.util.List;

import fmi.feng.shui.command.exceptions.InvalidParameterException;
import fmi.feng.shui.command.exceptions.InvalidParametersCountException;
import fmi.feng.shui.command.validation.helpers.GenderParameterValidationHelper;
import fmi.feng.shui.command.validation.helpers.TwoParametersValidationHelper;
import fmi.feng.shui.command.validation.helpers.YearParameterValidationHelper;

public class KuaNumberParametersValidator extends CommandParametersValidator {

	private final static int YEAR_PARAMETER_INDEX = 0;
	private final static int GENDER_PARAMETER_INDEX = 1;

	public KuaNumberParametersValidator(List<String> parameters) {
		super(parameters);
	}

	@Override
	public boolean validateParametersCount() throws InvalidParametersCountException {
		TwoParametersValidationHelper twoParametersTemplate = new TwoParametersValidationHelper();
		return twoParametersTemplate.validateParametersCount(parameters);
	}

	@Override
	public boolean validateParameters() throws InvalidParameterException {
		String yearParameter = parameters.get(YEAR_PARAMETER_INDEX);
		YearParameterValidationHelper yearValidationHelper = new YearParameterValidationHelper();
		if (yearValidationHelper.validateYearParameter(yearParameter)) {
			String genderParameter = parameters.get(GENDER_PARAMETER_INDEX);
			GenderParameterValidationHelper genderValidationHelper = new GenderParameterValidationHelper();
			return genderValidationHelper.validateGenderParameter(genderParameter);
		}
		return false;
	}

}
