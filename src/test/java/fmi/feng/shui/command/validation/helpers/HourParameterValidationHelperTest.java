package fmi.feng.shui.command.validation.helpers;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fmi.feng.shui.command.exceptions.InvalidParameterException;

public class HourParameterValidationHelperTest {

	private final static String VALID_HOUR = "12";
	private final static String LARGE_HOUR = "123456789";
	private final static String NEGATIVE_HOUR = "-12";
	private final static String INVALID_TEXT = "abcd";

	private HourParameterValidationHelper helper;

	public HourParameterValidationHelperTest() {
		this.helper = new HourParameterValidationHelper();
	}

	@Test
	public void test_should_verify_positive_hour_validation() throws InvalidParameterException {
		assertTrue(helper.validateHourParameter(VALID_HOUR));
	}

	@Test(expected = InvalidParameterException.class)
	public void test_should_verify_large_hour_validation() throws InvalidParameterException {
		helper.validateHourParameter(LARGE_HOUR);
	}

	@Test(expected = InvalidParameterException.class)
	public void test_should_verify_negative_hour_validation() throws InvalidParameterException {
		helper.validateHourParameter(NEGATIVE_HOUR);
	}

	@Test(expected = InvalidParameterException.class)
	public void test_should_verify_invalid_text_validation() throws InvalidParameterException {
		helper.validateHourParameter(INVALID_TEXT);
	}

}
