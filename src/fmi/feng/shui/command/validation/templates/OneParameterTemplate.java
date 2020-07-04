package fmi.feng.shui.command.validation.templates;

import java.util.List;

import fmi.feng.shui.command.Command;
import fmi.feng.shui.command.exceptions.InvalidParametersCountException;

public class OneParameterTemplate {

	private final static int ALLOWED_PARAMETERS_COUNT = 1;

	public boolean validateParametersCount(List<String> actualParameters)
			throws InvalidParametersCountException {
		int parametersCount = actualParameters.size();
		if (parametersCount != ALLOWED_PARAMETERS_COUNT) {
			throw new InvalidParametersCountException(
					"Invalid number of parameters was passed to the command " + Command.CHINESE_YEAR_SIGN.toString()
							+ ": " + parametersCount + ". Allowed number of parameters is " + ALLOWED_PARAMETERS_COUNT);
		}

		return true;
	}

}
