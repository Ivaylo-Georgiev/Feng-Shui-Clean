package fmi.feng.shui.command.validation.helpers;

import java.util.List;

import fmi.feng.shui.command.exceptions.InvalidParametersCountException;

@FunctionalInterface
public interface ParametersCountValidationHelper {

	public boolean validateParametersCount(List<String> actualParameters) throws InvalidParametersCountException;

}
