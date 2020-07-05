package fmi.feng.shui.command.validation;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import fmi.feng.shui.command.exceptions.InvalidParameterException;
import fmi.feng.shui.command.exceptions.InvalidParametersCountException;

public class ChineseYearSignParametersValidatorTest {

	private final static String VALID_PARAMETER = "2020";
	private final static String INVALID_TEXT_PARAMETER = "abcd";
	private final static String INVALID_NEGATIVE_INTEGER_PARAMETER = "-1";

	@Test
	public void test_should_verify_valid_parameters_count_validation() throws InvalidParametersCountException {
		ChineseYearSignParametersValidator validator = new ChineseYearSignParametersValidator(
				Arrays.asList(VALID_PARAMETER));
		assertTrue(validator.validateParametersCount());
	}

	@Test(expected = InvalidParametersCountException.class)
	public void test_should_verify_invalid_parameters_count_validation() throws InvalidParametersCountException {
		ChineseYearSignParametersValidator validator = new ChineseYearSignParametersValidator(
				Arrays.asList(VALID_PARAMETER, VALID_PARAMETER));
		validator.validateParametersCount();
	}

	@Test
	public void test_should_verify_valid_parameter_validation() throws InvalidParameterException {
		ChineseYearSignParametersValidator validator = new ChineseYearSignParametersValidator(
				Arrays.asList(VALID_PARAMETER));
		assertTrue(validator.validateParameters());
	}

	@Test(expected = InvalidParameterException.class)
	public void test_should_verify_invalid_text_parameter_validation() throws InvalidParameterException {
		ChineseYearSignParametersValidator validator = new ChineseYearSignParametersValidator(
				Arrays.asList(INVALID_TEXT_PARAMETER));
		validator.validateParameters();
	}

	@Test(expected = InvalidParameterException.class)
	public void test_should_verify_invalid_negative_integer_parameter_validation() throws InvalidParameterException {
		ChineseYearSignParametersValidator validator = new ChineseYearSignParametersValidator(
				Arrays.asList(INVALID_NEGATIVE_INTEGER_PARAMETER));
		validator.validateParameters();
	}

}
