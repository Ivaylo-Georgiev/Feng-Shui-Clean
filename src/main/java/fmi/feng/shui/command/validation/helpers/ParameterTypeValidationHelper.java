package fmi.feng.shui.command.validation.helpers;

import fmi.feng.shui.command.exceptions.InvalidParameterException;

/**
 * Helps to validate the exact type of parameter, passed to a Feng Shui command.
 * 
 *
 * @author Ivaylo Georgiev
 */
@FunctionalInterface
public interface ParameterTypeValidationHelper {

	public boolean validateParameter(String parameter) throws InvalidParameterException;

}
