package fmi.feng.shui.command.validation;

import java.util.List;

import fmi.feng.shui.command.exceptions.InvalidParameterException;
import fmi.feng.shui.command.exceptions.InvalidParametersCountException;
import fmi.feng.shui.command.validation.helpers.GenderParameterValidationHelper;
import fmi.feng.shui.command.validation.helpers.ParameterTypeValidationHelper;
import fmi.feng.shui.command.validation.helpers.ParametersCountValidationHelper;
import fmi.feng.shui.command.validation.helpers.TwoParametersValidationHelper;
import fmi.feng.shui.command.validation.helpers.YearParameterValidationHelper;

/**
 * Validates the parameters, passed to the Feng Shui command, that finds the KUA
 * number of a person.
 * 
 *
 * @author Ivaylo Georgiev
 */
public class KuaNumberParametersValidator extends CommandParametersValidator {

	/**
	 * The index of the year parameter, needed for the KUA number Feng Shui command
	 */
	private final static int YEAR_PARAMETER_INDEX = 0;

	/**
	 * The index of the gender parameter, needed for the KUA number Feng Shui
	 * command
	 */
	private final static int GENDER_PARAMETER_INDEX = 1;

	/**
	 * Helps to validate that the right number of parameters is provided by the user
	 */
	private ParametersCountValidationHelper parametersCountValidationHelper;

	/**
	 * Helps to validate, that the year parameter is correct
	 */
	private ParameterTypeValidationHelper yearValidationHelper;

	/**
	 * Helps to validate, that the gender parameter is correct
	 */
	private ParameterTypeValidationHelper genderValidationHelper;

	/**
	 * Constructs a validator for the KUA number Feng Shui command with the raw
	 * parameters, specified by the user
	 */
	public KuaNumberParametersValidator(List<String> parameters) {
		super(parameters);
		this.parametersCountValidationHelper = new TwoParametersValidationHelper();
		this.yearValidationHelper = new YearParameterValidationHelper();
		this.genderValidationHelper = new GenderParameterValidationHelper();
	}

	/**
	 * Verify that exactly two parameters are passed to the command
	 * 
	 * @throws InvalidParameterException If more or less than two parameters are
	 *                                   passed to the command
	 * @return boolean true, if two parameters are passed to the command
	 */
	@Override
	public boolean validateParametersCount() throws InvalidParametersCountException {
		boolean isParametersCountValid = parametersCountValidationHelper.validateParametersCount(parameters);
		return isParametersCountValid;
	}

	/**
	 * Verify that the provided year parameter is a positive integer and the gender
	 * is valid
	 * 
	 * @throws InvalidParameterException If the year parameter, is not a positive
	 *                                   integer, or the gender is invalid
	 * @return boolean true, if the parameters are valid
	 */
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
