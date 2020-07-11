package fmi.feng.shui.command.validation;

import java.util.List;

import fmi.feng.shui.command.exceptions.InvalidParameterException;
import fmi.feng.shui.command.exceptions.InvalidParametersCountException;
import fmi.feng.shui.command.validation.helpers.GenderParameterValidationHelper;
import fmi.feng.shui.command.validation.helpers.ParameterTypeValidationHelper;
import fmi.feng.shui.command.validation.helpers.ParametersCountValidationHelper;
import fmi.feng.shui.command.validation.helpers.TwoParametersValidationHelper;
import fmi.feng.shui.command.validation.helpers.YearParameterValidationHelper;

public class KuaNumberParametersValidator extends CommandParametersValidator {

	private final static int YEAR_PARAMETER_INDEX = 0;
	private final static int GENDER_PARAMETER_INDEX = 1;

	private ParametersCountValidationHelper parametersCountValidationHelper;
	private ParameterTypeValidationHelper yearValidationHelper;
	private ParameterTypeValidationHelper genderValidationHelper;

	public KuaNumberParametersValidator(List<String> parameters) {
		super(parameters);
		this.parametersCountValidationHelper = new TwoParametersValidationHelper();
		this.yearValidationHelper = new YearParameterValidationHelper();
		this.genderValidationHelper = new GenderParameterValidationHelper();
	}

	@Override
	public boolean validateParametersCount() throws InvalidParametersCountException {
		boolean isParametersCountValid = parametersCountValidationHelper.validateParametersCount(parameters);
		return isParametersCountValid;
	}

	@Override
	public boolean validateParameters() throws InvalidParameterException {
		String yearParameter = parameters.get(YEAR_PARAMETER_INDEX);
		boolean isYearParameterValid = yearValidationHelper.validateParameter(yearParameter);
		if (isYearParameterValid) {
			String genderParameter = parameters.get(GENDER_PARAMETER_INDEX);
			boolean isGenderParameterValid = genderValidationHelper.validateParameter(genderParameter);
			return isGenderParameterValid;
		}
		return false;
	}

}
