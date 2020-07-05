package fmi.feng.shui.command.signs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SecretFriendCommandTest {

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
	public void test_should_verify_rat_secret_friend() {
		SecretFriendCommand command = new SecretFriendCommand(RECENT_RAT_YEAR);
		assertEquals(AnimalSign.OX.toString(), command.execute());
	}

	@Test
	public void test_should_verify_ox_secret_friend() {
		SecretFriendCommand command = new SecretFriendCommand(RECENT_OX_YEAR);
		assertEquals(AnimalSign.RAT.toString(), command.execute());
	}

	@Test
	public void test_should_verify_tiger_secret_friend() {
		SecretFriendCommand command = new SecretFriendCommand(RECENT_TIGER_YEAR);
		assertEquals(AnimalSign.PIG.toString(), command.execute());
	}

	@Test
	public void test_should_verify_rabbit_secret_friend() {
		SecretFriendCommand command = new SecretFriendCommand(RECENT_RABBIT_YEAR);
		assertEquals(AnimalSign.DOG.toString(), command.execute());
	}

	@Test
	public void test_should_verify_dragon_secret_friend() {
		SecretFriendCommand command = new SecretFriendCommand(RECENT_DRAGON_YEAR);
		assertEquals(AnimalSign.ROOSTER.toString(), command.execute());
	}

	@Test
	public void test_should_verify_snake_secret_friend() {
		SecretFriendCommand command = new SecretFriendCommand(RECENT_SNAKE_YEAR);
		assertEquals(AnimalSign.MONKEY.toString(), command.execute());
	}

	@Test
	public void test_should_verify_horse_secret_friend() {
		SecretFriendCommand command = new SecretFriendCommand(RECENT_HORSE_YEAR);
		assertEquals(AnimalSign.SHEEP.toString(), command.execute());
	}

	@Test
	public void test_should_verify_sheep_secret_friend() {
		SecretFriendCommand command = new SecretFriendCommand(RECENT_SHEEP_YEAR);
		assertEquals(AnimalSign.HORSE.toString(), command.execute());
	}

	@Test
	public void test_should_verify_monkey_secret_friend() {
		SecretFriendCommand command = new SecretFriendCommand(RECENT_MONKEY_YEAR);
		assertEquals(AnimalSign.SNAKE.toString(), command.execute());
	}

	@Test
	public void test_should_verify_rooster_secret_friend() {
		SecretFriendCommand command = new SecretFriendCommand(RECENT_ROOSTER_YEAR);
		assertEquals(AnimalSign.DRAGON.toString(), command.execute());
	}

	@Test
	public void test_should_verify_dog_secret_friend() {
		SecretFriendCommand command = new SecretFriendCommand(RECENT_DOG_YEAR);
		assertEquals(AnimalSign.RABBIT.toString(), command.execute());
	}

	@Test
	public void test_should_verify_pig_secret_friend() {
		SecretFriendCommand command = new SecretFriendCommand(RECENT_PIG_YEAR);
		assertEquals(AnimalSign.TIGER.toString(), command.execute());
	}

}
