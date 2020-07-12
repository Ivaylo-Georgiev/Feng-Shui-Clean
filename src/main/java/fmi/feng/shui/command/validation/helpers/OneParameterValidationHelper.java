package fmi.feng.shui.command.validation.helpers;

import java.util.List;

import fmi.feng.shui.command.exceptions.InvalidParametersCountException;

/**
 * Helps to validate, that exactly one parameter is passed to a Feng Shui
 * command.
 * 
 *
 * @author Ivaylo Georgiev
 */
public class OneParameterValidationHelper implements ParametersCountValidationHelper {

	private final static int ALLOWED_PARAMETERS_COUNT = 1;

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
