package fmi.feng.shui.command.signs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AstrologyAlliesCommandTest {

	private final static int RECENT_RAT_YEAR = 2020;
	private final static int RECENT_OX_YEAR = 2009;
	private final static int RECENT_TIGER_YEAR = 2010;
	private final static int RECENT_RABBIT_YEAR = 2011;
	private final static int RECENT_DRAGON_YEAR = 2012;
	private final static int RECENT_SNAKE_YEAR = 2013;
	private final static int RECENT_HORSE_YEAR = 2014;
	private final static int RECENT_SHEEP_YEAR = 2015;
	private final static int RECENT_MONKEY_YEAR = 2016;
	private final static int RECENT_ROOSTER_YEAR = 2017;
	private final static int RECENT_DOG_YEAR = 2018;
	private final static int RECENT_PIG_YEAR = 2019;

	@Test
	public void test_should_verify_rat_astrology_allies() {
		AstrologyAlliesCommand command = new AstrologyAlliesCommand(RECENT_RAT_YEAR);
		assertEquals(AnimalSign.RAT.getAstrologyAllies(), command.execute());
	}

	@Test
	public void test_should_verify_ox_astrology_allies() {
		AstrologyAlliesCommand command = new AstrologyAlliesCommand(RECENT_OX_YEAR);
		assertEquals(AnimalSign.OX.getAstrologyAllies(), command.execute());
	}

	@Test
	public void test_should_verify_tiger_astrology_allies() {
		AstrologyAlliesCommand command = new AstrologyAlliesCommand(RECENT_TIGER_YEAR);
		assertEquals(AnimalSign.TIGER.getAstrologyAllies(), command.execute());
	}

	@Test
	public void test_should_verify_rabbit_astrology_allies() {
		AstrologyAlliesCommand command = new AstrologyAlliesCommand(RECENT_RABBIT_YEAR);
		assertEquals(AnimalSign.RABBIT.getAstrologyAllies(), command.execute());
	}

	@Test
	public void test_should_verify_dragon_astrology_allies() {
		AstrologyAlliesCommand command = new AstrologyAlliesCommand(RECENT_DRAGON_YEAR);
		assertEquals(AnimalSign.DRAGON.getAstrologyAllies(), command.execute());
	}

	@Test
	public void test_should_verify_snake_astrology_allies() {
		AstrologyAlliesCommand command = new AstrologyAlliesCommand(RECENT_SNAKE_YEAR);
		assertEquals(AnimalSign.SNAKE.getAstrologyAllies(), command.execute());
	}

	@Test
	public void test_should_verify_horse_astrology_allies() {
		AstrologyAlliesCommand command = new AstrologyAlliesCommand(RECENT_HORSE_YEAR);
		assertEquals(AnimalSign.HORSE.getAstrologyAllies(), command.execute());
	}

	@Test
	public void test_should_verify_sheep_astrology_allies() {
		AstrologyAlliesCommand command = new AstrologyAlliesCommand(RECENT_SHEEP_YEAR);
		assertEquals(AnimalSign.SHEEP.getAstrologyAllies(), command.execute());
	}

	@Test
	public void test_should_verify_monkey_astrology_allies() {
		AstrologyAlliesCommand command = new AstrologyAlliesCommand(RECENT_MONKEY_YEAR);
		assertEquals(AnimalSign.MONKEY.getAstrologyAllies(), command.execute());
	}

	@Test
	public void test_should_verify_rooster_astrology_allies() {
		AstrologyAlliesCommand command = new AstrologyAlliesCommand(RECENT_ROOSTER_YEAR);
		assertEquals(AnimalSign.ROOSTER.getAstrologyAllies(), command.execute());
	}

	@Test
	public void test_should_verify_dog_astrology_allies() {
		AstrologyAlliesCommand command = new AstrologyAlliesCommand(RECENT_DOG_YEAR);
		assertEquals(AnimalSign.DOG.getAstrologyAllies(), command.execute());
	}

	@Test
	public void test_should_verify_pig_astrology_allies() {
		AstrologyAlliesCommand command = new AstrologyAlliesCommand(RECENT_PIG_YEAR);
		assertEquals(AnimalSign.PIG.getAstrologyAllies(), command.execute());
	}

}
