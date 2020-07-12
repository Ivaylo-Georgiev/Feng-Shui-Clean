package fmi.feng.shui.command.validation;

import java.util.List;

import fmi.feng.shui.command.exceptions.InvalidParameterException;
import fmi.feng.shui.command.exceptions.InvalidParametersCountException;
import fmi.feng.shui.command.validation.helpers.OneParameterValidationHelper;
import fmi.feng.shui.command.validation.helpers.ParameterTypeValidationHelper;
import fmi.feng.shui.command.validation.helpers.ParametersCountValidationHelper;
import fmi.feng.shui.command.validation.helpers.YearParameterValidationHelper;

/**
 * Validates the parameters, passed to the Feng Shui command, that calculates
 * the Chinese animal sign, corresponding to a year.
 * 
 *
 * @author Ivaylo Georgiev
 */
public class ChineseYearSignParametersValidator extends CommandParametersValidator {

	/**
	 * The index of the one and only parameter, needed for the astrology allies Feng
	 * Shui command
	 */
	private final static int PARAMATER_INDEX = 0;

	/**
	 * Helps to validate that the right number of parameters is provided by the user
	 */
	private ParametersCountValidationHelper parametersCountValidationHelper;

	/**
	 * Helps to validate, that the year parameter is correct
	 */
	private ParameterTypeValidationHelper yearValidationHelper;

	/**
	 * Constructs a validator for the Chinese year sign Feng Shui command with the
	 * raw parameters, specified by the user
	 */
	public ChineseYearSignParametersValidator(List<String> parameters) {
		super(parameters);
		this.parametersCountValidationHelper = new OneParameterValidationHelper();
		this.yearValidationHelper = new YearParameterValidationHelper();
	}

	/**
	 * Verify that exactly one parameter is passed to the command
	 * 
	 * @throws InvalidParameterException If more or less than one parameter is
	 *                                   passed to the command
	 * @return boolean true, if only one parameter is passed to the command
	 */
	@Override
	public boolean validateParametersCount() throws InvalidParametersCountException {
		boolean isParametersCountValid = parametersCountValidationHelper.validateParametersCount(parameters);
		return isParametersCountValid;
	}

	/**
	 * Verify that the provided year parameter is a positive integer
	 * 
	 * @throws InvalidParameterException If the parameter, is not a positive integer
	 * @return boolean true, if the parameters are valid
	 */
	@Override
	public boolean validateParameters() throws InvalidParameterException {
		String parameter = parameters.get(PARAMATER_INDEX);
		boolean isYearParameterValid = yearValidationHelper.validateParameter(parameter);
		return isYearParameterValid;
	}

}
