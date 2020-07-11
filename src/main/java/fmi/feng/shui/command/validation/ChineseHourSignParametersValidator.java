package fmi.feng.shui.command.validation;

import java.util.List;

import fmi.feng.shui.command.exceptions.InvalidParameterException;
import fmi.feng.shui.command.exceptions.InvalidParametersCountException;
import fmi.feng.shui.command.validation.helpers.HourParameterValidationHelper;
import fmi.feng.shui.command.validation.helpers.OneParameterValidationHelper;
import fmi.feng.shui.command.validation.helpers.ParameterTypeValidationHelper;
import fmi.feng.shui.command.validation.helpers.ParametersCountValidationHelper;

public class ChineseHourSignParametersValidator extends CommandParametersValidator {

	private final static int PARAMATER_INDEX = 0;

	private ParametersCountValidationHelper parametersCountValidationHelper;
	private ParameterTypeValidationHelper hourValidationHelper;

	public ChineseHourSignParametersValidator(List<String> parameters) {
		super(parameters);
		this.parametersCountValidationHelper = new OneParameterValidationHelper();
		this.hourValidationHelper = new HourParameterValidationHelper();
	}

	@Override
	public boolean validateParametersCount() throws InvalidParametersCountException {
		boolean isParametersCountValid = parametersCountValidationHelper.validateParametersCount(parameters);
		return isParametersCountValid;
	}

	@Override
	public boolean validateParameters() throws InvalidParameterException {
		String parameter = parameters.get(PARAMATER_INDEX);
		boolean isHourParameterValid = hourValidationHelper.validateParameter(parameter);
		return isHourParameterValid;
	}

}
