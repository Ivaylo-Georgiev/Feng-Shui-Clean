package fmi.feng.shui.command.validation.helpers;

import fmi.feng.shui.command.exceptions.InvalidParameterException;

@FunctionalInterface
public interface ParameterTypeValidationHelper {

	public boolean validateParameter(String parameter) throws InvalidParameterException;

}
