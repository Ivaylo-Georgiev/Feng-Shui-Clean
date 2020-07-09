package fmi.feng.shui.command.validation.helpers;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fmi.feng.shui.command.exceptions.InvalidParameterException;

public class GenderParameterValidationHelperTest {

	private final static String MALE_GENDER = "male";
	private final static String FEMALE_GENDER = "female";
	private final static String INVALID_TEXT = "abcd";

	private GenderParameterValidationHelper helper;

	public GenderParameterValidationHelperTest() {
		this.helper = new GenderParameterValidationHelper();
	}

	@Test
	public void test_should_verify_male_gender_validation() throws InvalidParameterException {
		assertTrue(helper.validateGenderParameter(MALE_GENDER));
	}

	@Test
	public void test_should_verify_female_gender_validation() throws InvalidParameterException {
		assertTrue(helper.validateGenderParameter(FEMALE_GENDER));
	}

	@Test(expected = InvalidParameterException.class)
	public void test_should_verify_invalid_text_validation() throws InvalidParameterException {
		assertTrue(helper.validateGenderParameter(INVALID_TEXT));
	}

}
