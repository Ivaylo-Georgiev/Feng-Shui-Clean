package fmi.feng.shui.command.validation;

import java.util.List;

import fmi.feng.shui.command.exceptions.InvalidParameterException;
import fmi.feng.shui.command.exceptions.InvalidParametersCountException;
import fmi.feng.shui.command.validation.helpers.HourParameterValidationHelper;
import fmi.feng.shui.command.validation.helpers.OneParameterValidationHelper;

public class ChineseHourSignParametersValidator extends CommandParametersValidator {

	private final static int PARAMATER_INDEX = 0;

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
		HourParameterValidationHelper hourValidationHelper = new HourParameterValidationHelper();
		return hourValidationHelper.validateHourParameter(parameter);
	}

}
