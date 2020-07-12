package fmi.feng.shui.command.validation.helpers;

import java.util.List;

import fmi.feng.shui.command.exceptions.InvalidParametersCountException;

/**
 * Helps to validate the exact parameters count, passed to a Feng Shui command.
 * 
 *
 * @author Ivaylo Georgiev
 */
@FunctionalInterface
public interface ParametersCountValidationHelper {

	public boolean validateParametersCount(List<String> actualParameters) throws InvalidParametersCountException;

}
