package fmi.feng.shui.command.validation.templates;

import java.util.List;

import fmi.feng.shui.command.exceptions.InvalidParametersCountException;

public class TwoParametersTemplate {

	private final static int ALLOWED_PARAMETERS_COUNT = 2;

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
