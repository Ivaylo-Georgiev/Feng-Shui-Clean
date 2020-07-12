package fmi.feng.shui.command.validation;

import java.util.List;

import fmi.feng.shui.command.exceptions.InvalidParameterException;
import fmi.feng.shui.command.exceptions.InvalidParametersCountException;
import fmi.feng.shui.command.validation.helpers.OneParameterValidationHelper;
import fmi.feng.shui.command.validation.helpers.ParameterTypeValidationHelper;
import fmi.feng.shui.command.validation.helpers.ParametersCountValidationHelper;
import fmi.feng.shui.command.validation.helpers.YearParameterValidationHelper;

/**
 * Validates the parameters, passed to the Feng Shui command, that finds the
 * secret friend of a person.
 * 
 *
 * @author Ivaylo Georgiev
 */
public class SecretFriendParametersValidator extends CommandParametersValidator {

	private final static int PARAMATER_INDEX = 0;

	private ParametersCountValidationHelper parametersCountValidationHelper;
	private ParameterTypeValidationHelper yearValidationHelper;

	public SecretFriendParametersValidator(List<String> parameters) {
		super(parameters);
		this.parametersCountValidationHelper = new OneParameterValidationHelper();
		this.yearValidationHelper = new YearParameterValidationHelper();
	}

	@Override
	public boolean validateParametersCount() throws InvalidParametersCountException {
		boolean isParametersCountValid = parametersCountValidationHelper.validateParametersCount(parameters);
		return isParametersCountValid;
	}

	@Override
	public boolean validateParameters() throws InvalidParameterException {
		String parameter = parameters.get(PARAMATER_INDEX);
		boolean isYearParameterValid = yearValidationHelper.validateParameter(parameter);
		return isYearParameterValid;
	}

}
