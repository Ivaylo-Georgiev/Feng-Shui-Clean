package fmi.feng.shui.command.validation.helpers;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import fmi.feng.shui.command.exceptions.InvalidParametersCountException;
import fmi.feng.shui.command.validation.helpers.TwoParametersValidationHelper;

public class TwoParametersValidationHelperTest {

	private final static String PARAMETER = "parameter";

	private TwoParametersValidationHelper helper;

	public TwoParametersValidationHelperTest() {
		helper = new TwoParametersValidationHelper();
	}

	@Test(expected = InvalidParametersCountException.class)
	public void test_should_pass_one_parameter_and_validate_unsuccessfully() throws InvalidParametersCountException {
		boolean isValid = helper.validateParametersCount(Arrays.asList(PARAMETER));
		assertTrue(isValid);
	}

	@Test(expected = InvalidParametersCountException.class)
	public void test_should_pass_zero_parameters_and_validate_unsuccessfully() throws InvalidParametersCountException {
		helper.validateParametersCount(Collections.emptyList());
	}

	@Test
	public void test_should_pass_two_parameters_and_validate_successfully() throws InvalidParametersCountException {
		helper.validateParametersCount(Arrays.asList(PARAMETER, PARAMETER));
	}

}
