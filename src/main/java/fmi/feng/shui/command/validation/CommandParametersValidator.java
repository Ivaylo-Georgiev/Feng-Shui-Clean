package fmi.feng.shui.command.validation;

import java.util.List;

import fmi.feng.shui.command.exceptions.InvalidParameterException;
import fmi.feng.shui.command.exceptions.InvalidParametersCountException;

public abstract class CommandParametersValidator {
	
	protected List<String> parameters;

	public CommandParametersValidator(List<String> parameters) {
		this.parameters = parameters;
	}

	public abstract boolean validateParametersCount() throws InvalidParametersCountException;

	public abstract boolean validateParameters() throws InvalidParameterException;

}
