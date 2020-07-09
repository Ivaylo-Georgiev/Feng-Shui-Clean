package fmi.feng.shui.command.validation;

import java.util.List;

import fmi.feng.shui.command.exceptions.InvalidParameterException;
import fmi.feng.shui.command.exceptions.InvalidParametersCountException;
import fmi.feng.shui.command.validation.helpers.OneParameterValidationHelper;
import fmi.feng.shui.command.validation.helpers.YearParameterValidationHelper;

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
		YearParameterValidationHelper yearValidationHelper = new YearParameterValidationHelper();
		return yearValidationHelper.validateYearParameter(parameter);
	}

}
