package fmi.feng.shui.command.validation.helpers;

import java.util.List;

import fmi.feng.shui.command.exceptions.InvalidParameterException;
import fmi.feng.shui.command.exceptions.InvalidParametersCountException;

/**
 * Helps to validate the exact parameters count, passed to a Feng Shui command.
 * 
 *
 * @author Ivaylo Georgiev
 */
@FunctionalInterface
public interface ParametersCountValidationHelper {

	/**
	 * Validates, that the user has specified an exact number of parameters
	 * 
	 * @throws InvalidParameterException If the actual parameters count, provided by
	 *                                   the user, is invalid
	 * @param actualParameters The parameters, specified by the user
	 * @return boolean true, if the user has provided the exact number of parameters
	 */
	public boolean validateParametersCount(List<String> actualParameters) throws InvalidParametersCountException;

}
