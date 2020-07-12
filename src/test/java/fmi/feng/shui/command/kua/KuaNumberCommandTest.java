package fmi.feng.shui.command.kua;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KuaNumberCommandTest {

	private final static String KUA_1 = "1";
	private final static String KUA_2 = "2";
	private final static String KUA_3 = "3";
	private final static String KUA_4 = "4";
	// KUA 5 is ignored
	private final static String KUA_6 = "6";
	private final static String KUA_7 = "7";
	private final static String KUA_8 = "8";
	private final static String KUA_9 = "9";

	private final static int KUA_1_MALE_YEAR = 1982;
	private final static int KUA_2_MALE_YEAR = 1981;
	private final static int KUA_3_MALE_YEAR = 1980;
	private final static int KUA_4_MALE_YEAR = 1979;
	private final static int KUA_5_MALE_YEAR = 1978;
	private final static int KUA_6_MALE_YEAR = 1977;
	private final static int KUA_7_MALE_YEAR = 1976;
	private final static int KUA_8_MALE_YEAR = 1975;
	private final static int KUA_9_MALE_YEAR = 1974;

	private final static int KUA_1_FEMALE_YEAR = 1978;
	private final static int KUA_2_FEMALE_YEAR = 1979;
	private final static int KUA_3_FEMALE_YEAR = 1980;
	private final static int KUA_4_FEMALE_YEAR = 1981;
	private final static int KUA_5_FEMALE_YEAR = 1982;
	private final static int KUA_6_FEMALE_YEAR = 1983;
	private final static int KUA_7_FEMALE_YEAR = 1984;
	private final static int KUA_8_FEMALE_YEAR = 1985;
	private final static int KUA_9_FEMALE_YEAR = 1986;

	@Test
	public void test_should_calculate_male_kua_1() {
		KuaNumberCommand command = new KuaNumberCommand(KUA_1_MALE_YEAR, Gender.MALE);
		assertEquals(KUA_1, command.execute());
	}

	@Test
	public void test_should_calculate_male_kua_2() {
		KuaNumberCommand command = new KuaNumberCommand(KUA_2_MALE_YEAR, Gender.MALE);
		assertEquals(KUA_2, command.execute());
	}

	@Test
	public void test_should_calculate_male_kua_3() {
		KuaNumberCommand command = new KuaNumberCommand(KUA_3_MALE_YEAR, Gender.MALE);
		assertEquals(KUA_3, command.execute());
	}

	@Test
	public void test_should_calculate_male_kua_4() {
		KuaNumberCommand command = new KuaNumberCommand(KUA_4_MALE_YEAR, Gender.MALE);
		assertEquals(KUA_4, command.execute());
	}

	@Test
	public void test_should_calculate_male_kua_5() {
		KuaNumberCommand command = new KuaNumberCommand(KUA_5_MALE_YEAR, Gender.MALE);
		assertEquals(KUA_2, command.execute());
	}

	@Test
	public void test_should_calculate_male_kua_6() {
		KuaNumberCommand command = new KuaNumberCommand(KUA_6_MALE_YEAR, Gender.MALE);
		assertEquals(KUA_6, command.execute());
	}

	@Test
	public void test_should_calculate_male_kua_7() {
		KuaNumberCommand command = new KuaNumberCommand(KUA_7_MALE_YEAR, Gender.MALE);
		assertEquals(KUA_7, command.execute());
	}

	@Test
	public void test_should_calculate_male_kua_8() {
		KuaNumberCommand command = new KuaNumberCommand(KUA_8_MALE_YEAR, Gender.MALE);
		assertEquals(KUA_8, command.execute());
	}

	@Test
	public void test_should_calculate_male_kua_9() {
		KuaNumberCommand command = new KuaNumberCommand(KUA_9_MALE_YEAR, Gender.MALE);
		assertEquals(KUA_9, command.execute());
	}

	@Test
	public void test_should_calculate_female_kua_1() {
		KuaNumberCommand command = new KuaNumberCommand(KUA_1_FEMALE_YEAR, Gender.FEMALE);
		assertEquals(KUA_1, command.execute());
	}

	@Test
	public void test_should_calculate_female_kua_2() {
		KuaNumberCommand command = new KuaNumberCommand(KUA_2_FEMALE_YEAR, Gender.FEMALE);
		assertEquals(KUA_2, command.execute());
	}

	@Test
	public void test_should_calculate_female_kua_3() {
		KuaNumberCommand command = new KuaNumberCommand(KUA_3_FEMALE_YEAR, Gender.FEMALE);
		assertEquals(KUA_3, command.execute());
	}

	@Test
	public void test_should_calculate_female_kua_4() {
		KuaNumberCommand command = new KuaNumberCommand(KUA_4_FEMALE_YEAR, Gender.FEMALE);
		assertEquals(KUA_4, command.execute());
	}

	@Test
	public void test_should_calculate_female_kua_5() {
		KuaNumberCommand command = new KuaNumberCommand(KUA_5_FEMALE_YEAR, Gender.FEMALE);
		assertEquals(KUA_8, command.execute());
	}

	@Test
	public void test_should_calculate_female_kua_6() {
		KuaNumberCommand command = new KuaNumberCommand(KUA_6_FEMALE_YEAR, Gender.FEMALE);
		assertEquals(KUA_6, command.execute());
	}

	@Test
	public void test_should_calculate_female_kua_7() {
		KuaNumberCommand command = new KuaNumberCommand(KUA_7_FEMALE_YEAR, Gender.FEMALE);
		assertEquals(KUA_7, command.execute());
	}

	@Test
	public void test_should_calculate_female_kua_8() {
		KuaNumberCommand command = new KuaNumberCommand(KUA_8_FEMALE_YEAR, Gender.FEMALE);
		assertEquals(KUA_8, command.execute());
	}

	@Test
	public void test_should_calculate_female_kua_9() {
		KuaNumberCommand command = new KuaNumberCommand(KUA_9_FEMALE_YEAR, Gender.FEMALE);
		assertEquals(KUA_9, command.execute());
	}

}
