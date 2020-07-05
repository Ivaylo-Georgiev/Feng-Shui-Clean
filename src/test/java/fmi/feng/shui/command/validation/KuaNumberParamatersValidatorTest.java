package fmi.feng.shui.command.validation;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import fmi.feng.shui.command.exceptions.InvalidParameterException;
import fmi.feng.shui.command.exceptions.InvalidParametersCountException;

public class KuaNumberParamatersValidatorTest {

	private final static String VALID_YEAR = "2020";
	private final static String INVALID_YEAR = "-1234";
	private final static String FEMALE_GENDER = "female";
	private final static String MALE_GENDER = "male";
	private final static String INVALID_TEXT = "abcd";

	@Test
	public void test_should_verify_valid_parameters_count_validation_female() throws InvalidParametersCountException {
		KuaNumberParametersValidator validator = new KuaNumberParametersValidator(
				Arrays.asList(VALID_YEAR, FEMALE_GENDER));
		assertTrue(validator.validateParametersCount());
	}

	@Test
	public void test_should_verify_valid_parameters_count_validation_male() throws InvalidParametersCountException {
		KuaNumberParametersValidator validator = new KuaNumberParametersValidator(
				Arrays.asList(VALID_YEAR, MALE_GENDER));
		assertTrue(validator.validateParametersCount());
	}

	@Test(expected = InvalidParametersCountException.class)
	public void test_should_verify_invalid_parameters_count_validation_with_only_year()
			throws InvalidParametersCountException {
		KuaNumberParametersValidator validator = new KuaNumberParametersValidator(Arrays.asList(VALID_YEAR));
		validator.validateParametersCount();
	}

	@Test(expected = InvalidParametersCountException.class)
	public void test_should_verify_invalid_parameters_count_validation_with_only_gender()
			throws InvalidParametersCountException {
		KuaNumberParametersValidator validator = new KuaNumberParametersValidator(Arrays.asList(FEMALE_GENDER));
		validator.validateParametersCount();
	}

	@Test(expected = InvalidParameterException.class)
	public void test_should_verify_invalid_negative_year_parameter() throws InvalidParameterException {
		KuaNumberParametersValidator validator = new KuaNumberParametersValidator(Arrays.asList(INVALID_YEAR));
		validator.validateParameters();
	}

	@Test(expected = InvalidParameterException.class)
	public void test_should_verify_invalid_text_year_parameter() throws InvalidParameterException {
		KuaNumberParametersValidator validator = new KuaNumberParametersValidator(Arrays.asList(INVALID_TEXT));
		validator.validateParameters();
	}

	@Test(expected = InvalidParameterException.class)
	public void test_should_verify_valid_year_parameter_and_invalid_gender() throws InvalidParameterException {
		KuaNumberParametersValidator validator = new KuaNumberParametersValidator(
				Arrays.asList(VALID_YEAR, INVALID_TEXT));
		validator.validateParameters();
	}

	@Test
	public void test_should_verify_valid_year_parameter_and_invalid_female_gender() throws InvalidParameterException {
		KuaNumberParametersValidator validator = new KuaNumberParametersValidator(
				Arrays.asList(VALID_YEAR, FEMALE_GENDER));
		assertTrue(validator.validateParameters());
	}

	@Test
	public void test_should_verify_valid_year_parameter_and_invalid_male_gender() throws InvalidParameterException {
		KuaNumberParametersValidator validator = new KuaNumberParametersValidator(
				Arrays.asList(VALID_YEAR, MALE_GENDER));
		assertTrue(validator.validateParameters());
	}

}
