package fmi.feng.shui.command.validation.helpers;

import java.util.List;

import fmi.feng.shui.command.exceptions.InvalidParameterException;
import fmi.feng.shui.command.exceptions.InvalidParametersCountException;

/**
 * Helps to validate, that exactly two parameters are passed to a Feng Shui
 * command.
 * 
 *
 * @author Ivaylo Georgiev
 */
public class TwoParametersValidationHelper implements ParametersCountValidationHelper {

	private final static int ALLOWED_PARAMETERS_COUNT = 2;

	/**
	 * Validates, that the user has specified exactly two parameters
	 * 
	 * @throws InvalidParameterException If less or more than 2 parameters are
	 *                                   passed
	 * @param actualParameters The parameters, specified by the user
	 * @return boolean true, if the user has provided exactly two parameters
	 */
	@Override
	public boolean validateParametersCount(List<String> actualParameters) throws InvalidParametersCountException {
		int parametersCount = actualParameters.size();
		if (parametersCount != ALLOWED_PARAMETERS_COUNT) {
			throw new InvalidParametersCountException(
					"Invalid number of parameters was passed to the command. Allowed number of parameters is "
							+ ALLOWED_PARAMETERS_COUNT);
		}

		return true;
	}

}
