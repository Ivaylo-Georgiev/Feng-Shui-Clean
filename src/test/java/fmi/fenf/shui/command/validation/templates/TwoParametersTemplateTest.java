package fmi.fenf.shui.command.validation.templates;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import fmi.feng.shui.command.exceptions.InvalidParametersCountException;
import fmi.feng.shui.command.validation.templates.TwoParametersTemplate;

public class TwoParametersTemplateTest {

	private final static String PARAMETER = "parameter";

	@Test(expected = InvalidParametersCountException.class)
	public void test_should_pass_one_parameter_and_validate_unsuccessfully() throws InvalidParametersCountException {
		TwoParametersTemplate template = new TwoParametersTemplate();
		boolean isValid = template.validateParametersCount(Arrays.asList(PARAMETER));
		assertTrue(isValid);
	}

	@Test(expected = InvalidParametersCountException.class)
	public void test_should_pass_zero_parameters_and_validate_unsuccessfully() throws InvalidParametersCountException {
		TwoParametersTemplate template = new TwoParametersTemplate();
		template.validateParametersCount(Collections.emptyList());
	}

	@Test
	public void test_should_pass_two_parameters_and_validate_successfully() throws InvalidParametersCountException {
		TwoParametersTemplate template = new TwoParametersTemplate();
		template.validateParametersCount(Arrays.asList(PARAMETER, PARAMETER));
	}

}
