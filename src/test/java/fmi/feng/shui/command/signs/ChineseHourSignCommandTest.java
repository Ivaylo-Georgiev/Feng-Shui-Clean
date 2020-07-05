package fmi.feng.shui.command.signs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ChineseHourSignCommandTest {

	private final static int RAT_HOUR = 24;
	private final static int OX_HOUR = 2;
	private final static int TIGER_HOUR = 4;
	private final static int RABBIT_HOUR = 6;
	private final static int DRAGON_HOUR = 8;
	private final static int SNAKE_HOUR = 10;
	private final static int HORSE_HOUR = 12;
	private final static int SHEEP_HOUR = 14;
	private final static int MONKEY_HOUR = 16;
	private final static int ROOSTER_HOUR = 18;
	private final static int DOG_HOUR = 20;
	private final static int PIG_HOUR = 22;

	@Test
	public void test_should_verify_rat_upper_hour() {
		ChineseHourSignCommand command = new ChineseHourSignCommand(RAT_HOUR);
		assertEquals(AnimalSign.RAT.toString(), command.execute());
	}

	@Test
	public void test_should_verify_rat_lower_hour() {
		ChineseHourSignCommand command = new ChineseHourSignCommand(RAT_HOUR - 1);
		assertEquals(AnimalSign.RAT.toString(), command.execute());
	}

	@Test
	public void test_should_verify_ox_upper_hour() {
		ChineseHourSignCommand command = new ChineseHourSignCommand(OX_HOUR);
		assertEquals(AnimalSign.OX.toString(), command.execute());
	}

	@Test
	public void test_should_verify_ox_lower_hour() {
		ChineseHourSignCommand command = new ChineseHourSignCommand(OX_HOUR - 1);
		assertEquals(AnimalSign.OX.toString(), command.execute());
	}

	@Test
	public void test_should_verify_tiger_upper_hour() {
		ChineseHourSignCommand command = new ChineseHourSignCommand(TIGER_HOUR);
		assertEquals(AnimalSign.TIGER.toString(), command.execute());
	}

	@Test
	public void test_should_verify_tiger_lower_hour() {
		ChineseHourSignCommand command = new ChineseHourSignCommand(TIGER_HOUR - 1);
		assertEquals(AnimalSign.TIGER.toString(), command.execute());
	}

	@Test
	public void test_should_verify_rabbit_upper_hour() {
		ChineseHourSignCommand command = new ChineseHourSignCommand(RABBIT_HOUR);
		assertEquals(AnimalSign.RABBIT.toString(), command.execute());
	}

	@Test
	public void test_should_verify_rabbit_lower_hour() {
		ChineseHourSignCommand command = new ChineseHourSignCommand(RABBIT_HOUR - 1);
		assertEquals(AnimalSign.RABBIT.toString(), command.execute());
	}

	@Test
	public void test_should_verify_dragon_upper_hour() {
		ChineseHourSignCommand command = new ChineseHourSignCommand(DRAGON_HOUR);
		assertEquals(AnimalSign.DRAGON.toString(), command.execute());
	}

	@Test
	public void test_should_verify_dragon_lower_hour() {
		ChineseHourSignCommand command = new ChineseHourSignCommand(DRAGON_HOUR - 1);
		assertEquals(AnimalSign.DRAGON.toString(), command.execute());
	}

	@Test
	public void test_should_verify_snake_upper_hour() {
		ChineseHourSignCommand command = new ChineseHourSignCommand(SNAKE_HOUR);
		assertEquals(AnimalSign.SNAKE.toString(), command.execute());
	}

	@Test
	public void test_should_verify_snake_lower_hour() {
		ChineseHourSignCommand command = new ChineseHourSignCommand(SNAKE_HOUR - 1);
		assertEquals(AnimalSign.SNAKE.toString(), command.execute());
	}

	@Test
	public void test_should_verify_horse_upper_hour() {
		ChineseHourSignCommand command = new ChineseHourSignCommand(HORSE_HOUR);
		assertEquals(AnimalSign.HORSE.toString(), command.execute());
	}

	@Test
	public void test_should_verify_horse_lower_hour() {
		ChineseHourSignCommand command = new ChineseHourSignCommand(HORSE_HOUR - 1);
		assertEquals(AnimalSign.HORSE.toString(), command.execute());
	}

	@Test
	public void test_should_verify_sheep_upper_hour() {
		ChineseHourSignCommand command = new ChineseHourSignCommand(SHEEP_HOUR);
		assertEquals(AnimalSign.SHEEP.toString(), command.execute());
	}

	@Test
	public void test_should_verify_sheep_lower_hour() {
		ChineseHourSignCommand command = new ChineseHourSignCommand(SHEEP_HOUR - 1);
		assertEquals(AnimalSign.SHEEP.toString(), command.execute());
	}

	@Test
	public void test_should_verify_monkey_upper_hour() {
		ChineseHourSignCommand command = new ChineseHourSignCommand(MONKEY_HOUR);
		assertEquals(AnimalSign.MONKEY.toString(), command.execute());
	}

	@Test
	public void test_should_verify_monkey_lower_hour() {
		ChineseHourSignCommand command = new ChineseHourSignCommand(MONKEY_HOUR - 1);
		assertEquals(AnimalSign.MONKEY.toString(), command.execute());
	}

	@Test
	public void test_should_verify_rooster_upper_hour() {
		ChineseHourSignCommand command = new ChineseHourSignCommand(ROOSTER_HOUR);
		assertEquals(AnimalSign.ROOSTER.toString(), command.execute());
	}

	@Test
	public void test_should_verify_rooster_lower_hour() {
		ChineseHourSignCommand command = new ChineseHourSignCommand(ROOSTER_HOUR - 1);
		assertEquals(AnimalSign.ROOSTER.toString(), command.execute());
	}

	@Test
	public void test_should_verify_dog_upper_hour() {
		ChineseHourSignCommand command = new ChineseHourSignCommand(DOG_HOUR);
		assertEquals(AnimalSign.DOG.toString(), command.execute());
	}

	@Test
	public void test_should_verify_dog_lower_hour() {
		ChineseHourSignCommand command = new ChineseHourSignCommand(DOG_HOUR - 1);
		assertEquals(AnimalSign.DOG.toString(), command.execute());
	}

	@Test
	public void test_should_verify_pig_upper_hour() {
		ChineseHourSignCommand command = new ChineseHourSignCommand(PIG_HOUR);
		assertEquals(AnimalSign.PIG.toString(), command.execute());
	}

	@Test
	public void test_should_verify_pig_lower_hour() {
		ChineseHourSignCommand command = new ChineseHourSignCommand(PIG_HOUR - 1);
		assertEquals(AnimalSign.PIG.toString(), command.execute());
	}

}
