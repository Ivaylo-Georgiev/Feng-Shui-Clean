package fmi.feng.shui.command.validation.helpers;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fmi.feng.shui.command.exceptions.InvalidParameterException;

public class YearParameterValidationHelperTest {

	private final static String POSITIVE_YEAR = "2020";
	private final static String NEGATIVE_YEAR = "-2020";
	private final static String INVALID_TEXT = "abcd";

	private YearParameterValidationHelper helper;

	public YearParameterValidationHelperTest() {
		this.helper = new YearParameterValidationHelper();
	}

	@Test
	public void test_should_verify_positive_year_validation() throws InvalidParameterException {
		assertTrue(helper.validateParameter(POSITIVE_YEAR));
	}

	@Test(expected = InvalidParameterException.class)
	public void test_should_verify_negative_year_validation() throws InvalidParameterException {
		helper.validateParameter(NEGATIVE_YEAR);
	}

	@Test(expected = InvalidParameterException.class)
	public void test_should_verify_invalid_text_validation() throws InvalidParameterException {
		helper.validateParameter(INVALID_TEXT);
	}

}
