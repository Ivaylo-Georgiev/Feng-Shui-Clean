package fmi.feng.shui.command;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import org.mockito.Mockito;

import fmi.feng.shui.command.exceptions.InvalidCommandTypeException;
import fmi.feng.shui.command.exceptions.InvalidParameterException;
import fmi.feng.shui.command.exceptions.InvalidParametersCountException;
import fmi.feng.shui.command.exit.ExitCommand;
import fmi.feng.shui.command.kua.Gender;
import fmi.feng.shui.command.kua.KuaNumberCommand;
import fmi.feng.shui.command.parser.CommandParser;
import fmi.feng.shui.command.signs.AstrologyAlliesCommand;
import fmi.feng.shui.command.signs.ChineseHourSignCommand;
import fmi.feng.shui.command.signs.ChineseYearSignCommand;
import fmi.feng.shui.command.signs.SecretFriendCommand;
import fmi.feng.shui.command.validation.CommandParametersValidator;

public class CommandFactoryTest {

	private final static String YEAR = "2020";
	private final static String HOUR = "24";

	private CommandFactory commandFactory;
	private CommandParser commandParser;
	private CommandParametersValidator commandParametersValidator;

	public CommandFactoryTest() {
		this.commandFactory = Mockito.spy(new CommandFactory());
		this.commandParser = Mockito.mock(CommandParser.class);
		this.commandParametersValidator = Mockito.mock(CommandParametersValidator.class);
	}

	@Test
	public void test_should_create_exit_command()
			throws InvalidCommandTypeException, InvalidParametersCountException, InvalidParameterException {
		Mockito.doReturn(Command.EXIT.toString()).when(this.commandParser).getNormalizedCommandType();
		FengShuiCommand constructedCommand = commandFactory.getFengShuiCommand(this.commandParser);
		assertTrue(constructedCommand instanceof ExitCommand);
		Mockito.verify(this.commandParser).getNormalizedCommandType();
	}

	@Test
	public void test_should_trigger_creation_of_chinese_year_sign_command()
			throws InvalidCommandTypeException, InvalidParametersCountException, InvalidParameterException {
		final ChineseYearSignCommand command = Mockito.mock(ChineseYearSignCommand.class);

		Mockito.doReturn(Command.CHINESE_YEAR_SIGN.toString()).when(this.commandParser).getNormalizedCommandType();
		Mockito.doReturn(Arrays.asList(YEAR)).when(this.commandParser).getCommandParameters();
		Mockito.doReturn(command).when(commandFactory).createChineseYearSign(Mockito.any(CommandParser.class),
				Mockito.any(CommandParametersValidator.class));

		commandFactory.getFengShuiCommand(this.commandParser);

		Mockito.verify(this.commandParser).getNormalizedCommandType();
		Mockito.verify(this.commandParser).getCommandParameters();
		Mockito.verify(commandFactory).createChineseYearSign(Mockito.any(CommandParser.class),
				Mockito.any(CommandParametersValidator.class));
	}

	@Test
	public void test_should_trigger_creation_of_chinese_hour_sign_command()
			throws InvalidCommandTypeException, InvalidParametersCountException, InvalidParameterException {
		final ChineseHourSignCommand command = Mockito.mock(ChineseHourSignCommand.class);

		Mockito.doReturn(Command.CHINESE_HOUR_SIGN.toString()).when(this.commandParser).getNormalizedCommandType();
		Mockito.doReturn(Arrays.asList(HOUR)).when(this.commandParser).getCommandParameters();
		Mockito.doReturn(command).when(commandFactory).createChineseHourSign(Mockito.any(CommandParser.class),
				Mockito.any(CommandParametersValidator.class));

		commandFactory.getFengShuiCommand(this.commandParser);

		Mockito.verify(this.commandParser).getNormalizedCommandType();
		Mockito.verify(this.commandParser).getCommandParameters();
		Mockito.verify(commandFactory).createChineseHourSign(Mockito.any(CommandParser.class),
				Mockito.any(CommandParametersValidator.class));
	}

	@Test
	public void test_should_trigger_creation_of_kua_number_command()
			throws InvalidCommandTypeException, InvalidParametersCountException, InvalidParameterException {
		final KuaNumberCommand command = Mockito.mock(KuaNumberCommand.class);

		Mockito.doReturn(Command.KUA_NUMBER.toString()).when(this.commandParser).getNormalizedCommandType();
		Mockito.doReturn(Arrays.asList(YEAR, Gender.FEMALE.toString())).when(this.commandParser).getCommandParameters();
		Mockito.doReturn(command).when(commandFactory).createKuaNumber(Mockito.any(CommandParser.class),
				Mockito.any(CommandParametersValidator.class));

		commandFactory.getFengShuiCommand(this.commandParser);

		Mockito.verify(this.commandParser).getNormalizedCommandType();
		Mockito.verify(this.commandParser).getCommandParameters();
		Mockito.verify(commandFactory).createKuaNumber(Mockito.any(CommandParser.class),
				Mockito.any(CommandParametersValidator.class));
	}

	@Test
	public void test_should_trigger_creation_of_secret_friend_command()
			throws InvalidCommandTypeException, InvalidParametersCountException, InvalidParameterException {
		final SecretFriendCommand command = Mockito.mock(SecretFriendCommand.class);

		Mockito.doReturn(Command.SECRET_FRIEND.toString()).when(this.commandParser).getNormalizedCommandType();
		Mockito.doReturn(Arrays.asList(YEAR)).when(this.commandParser).getCommandParameters();
		Mockito.doReturn(command).when(commandFactory).createSecretFriend(Mockito.any(CommandParser.class),
				Mockito.any(CommandParametersValidator.class));

		commandFactory.getFengShuiCommand(this.commandParser);

		Mockito.verify(this.commandParser).getNormalizedCommandType();
		Mockito.verify(this.commandParser).getCommandParameters();
		Mockito.verify(commandFactory).createSecretFriend(Mockito.any(CommandParser.class),
				Mockito.any(CommandParametersValidator.class));
	}

	@Test
	public void test_should_trigger_creation_of_astrology_allies_command()
			throws InvalidCommandTypeException, InvalidParametersCountException, InvalidParameterException {
		final AstrologyAlliesCommand command = Mockito.mock(AstrologyAlliesCommand.class);

		Mockito.doReturn(Command.ASTROLOGY_ALLIES.toString()).when(this.commandParser).getNormalizedCommandType();
		Mockito.doReturn(Arrays.asList(YEAR)).when(this.commandParser).getCommandParameters();
		Mockito.doReturn(command).when(commandFactory).createAstrologyAllies(Mockito.any(CommandParser.class),
				Mockito.any(CommandParametersValidator.class));

		commandFactory.getFengShuiCommand(this.commandParser);

		Mockito.verify(this.commandParser).getNormalizedCommandType();
		Mockito.verify(this.commandParser).getCommandParameters();
		Mockito.verify(commandFactory).createAstrologyAllies(Mockito.any(CommandParser.class),
				Mockito.any(CommandParametersValidator.class));
	}

	@Test(expected = InvalidCommandTypeException.class)
	public void test_should_fail_to_trigger_creation_of_a_command()
			throws InvalidCommandTypeException, InvalidParametersCountException, InvalidParameterException {
		Mockito.doReturn("abcd").when(this.commandParser).getNormalizedCommandType();
		commandFactory.getFengShuiCommand(this.commandParser);
		Mockito.verify(this.commandParser).getNormalizedCommandType();
	}

	@Test
	public void test_should_create_chinese_year_sign_command()
			throws InvalidParametersCountException, InvalidParameterException {
		Mockito.doReturn(true).when(this.commandParametersValidator).validateParametersCount();
		Mockito.doReturn(true).when(this.commandParametersValidator).validateParameters();
		Mockito.doReturn(YEAR).when(this.commandParser).getFirstCommandParameter();

		assertNotNull(commandFactory.createChineseYearSign(this.commandParser, this.commandParametersValidator));

		Mockito.verify(this.commandParametersValidator).validateParametersCount();
		Mockito.verify(this.commandParametersValidator).validateParameters();
		Mockito.verify(this.commandParser).getFirstCommandParameter();
	}

	@Test
	public void test_should_create_chinese_year_sign_command_due_to_invalid_parameter()
			throws InvalidParametersCountException, InvalidParameterException {
		Mockito.doReturn(true).when(this.commandParametersValidator).validateParametersCount();
		Mockito.doReturn(false).when(this.commandParametersValidator).validateParameters();
		assertNull(commandFactory.createChineseYearSign(this.commandParser, this.commandParametersValidator));
		Mockito.verify(this.commandParametersValidator).validateParametersCount();
		Mockito.verify(this.commandParametersValidator).validateParameters();
	}

	@Test
	public void test_should_fail_to_create_chinese_year_sign_command_due_to_invalid_parameters_count()
			throws InvalidParametersCountException, InvalidParameterException {
		Mockito.doReturn(false).when(this.commandParametersValidator).validateParametersCount();
		assertNull(commandFactory.createChineseYearSign(this.commandParser, this.commandParametersValidator));
		Mockito.verify(this.commandParametersValidator).validateParametersCount();
	}

	@Test
	public void test_should_create_chinese_hour_sign_command()
			throws InvalidParametersCountException, InvalidParameterException {
		Mockito.doReturn(true).when(this.commandParametersValidator).validateParametersCount();
		Mockito.doReturn(true).when(this.commandParametersValidator).validateParameters();
		Mockito.doReturn(HOUR).when(this.commandParser).getFirstCommandParameter();

		assertNotNull(commandFactory.createChineseHourSign(this.commandParser, this.commandParametersValidator));

		Mockito.verify(this.commandParametersValidator).validateParametersCount();
		Mockito.verify(this.commandParametersValidator).validateParameters();
		Mockito.verify(this.commandParser).getFirstCommandParameter();
	}

	@Test
	public void test_should_create_chinese_hour_sign_command_due_to_invalid_parameter()
			throws InvalidParametersCountException, InvalidParameterException {
		Mockito.doReturn(true).when(this.commandParametersValidator).validateParametersCount();
		Mockito.doReturn(false).when(this.commandParametersValidator).validateParameters();
		assertNull(commandFactory.createChineseHourSign(this.commandParser, this.commandParametersValidator));
		Mockito.verify(this.commandParametersValidator).validateParametersCount();
		Mockito.verify(this.commandParametersValidator).validateParameters();
	}

	@Test
	public void test_should_fail_to_create_chinese_hour_sign_command_due_to_invalid_parameters_count()
			throws InvalidParametersCountException, InvalidParameterException {
		Mockito.doReturn(false).when(this.commandParametersValidator).validateParametersCount();
		assertNull(commandFactory.createChineseHourSign(this.commandParser, this.commandParametersValidator));
		Mockito.verify(this.commandParametersValidator).validateParametersCount();
	}

	@Test
	public void test_should_create_kua_number_command()
			throws InvalidParametersCountException, InvalidParameterException {
		Mockito.doReturn(true).when(this.commandParametersValidator).validateParametersCount();
		Mockito.doReturn(true).when(this.commandParametersValidator).validateParameters();
		Mockito.doReturn(YEAR).when(this.commandParser).getFirstCommandParameter();
		Mockito.doReturn(Gender.MALE.toString()).when(this.commandParser).getSecondCommandParameter();

		assertNotNull(commandFactory.createKuaNumber(this.commandParser, this.commandParametersValidator));

		Mockito.verify(this.commandParametersValidator).validateParametersCount();
		Mockito.verify(this.commandParametersValidator).validateParameters();
		Mockito.verify(this.commandParser).getFirstCommandParameter();
		Mockito.verify(this.commandParser).getSecondCommandParameter();
	}

	@Test
	public void test_should_create_kua_number_command_due_to_invalid_parameter()
			throws InvalidParametersCountException, InvalidParameterException {
		Mockito.doReturn(true).when(this.commandParametersValidator).validateParametersCount();
		Mockito.doReturn(false).when(this.commandParametersValidator).validateParameters();
		assertNull(commandFactory.createKuaNumber(this.commandParser, this.commandParametersValidator));
		Mockito.verify(this.commandParametersValidator).validateParametersCount();
		Mockito.verify(this.commandParametersValidator).validateParameters();
	}

	@Test
	public void test_should_fail_to_create_kua_number_command_due_to_invalid_parameters_count()
			throws InvalidParametersCountException, InvalidParameterException {
		Mockito.doReturn(false).when(this.commandParametersValidator).validateParametersCount();
		assertNull(commandFactory.createKuaNumber(this.commandParser, this.commandParametersValidator));
		Mockito.verify(this.commandParametersValidator).validateParametersCount();
	}

	@Test
	public void test_should_create_secret_friend_command()
			throws InvalidParametersCountException, InvalidParameterException {
		Mockito.doReturn(true).when(this.commandParametersValidator).validateParametersCount();
		Mockito.doReturn(true).when(this.commandParametersValidator).validateParameters();
		Mockito.doReturn(YEAR).when(this.commandParser).getFirstCommandParameter();

		assertNotNull(commandFactory.createSecretFriend(this.commandParser, this.commandParametersValidator));

		Mockito.verify(this.commandParametersValidator).validateParametersCount();
		Mockito.verify(this.commandParametersValidator).validateParameters();
		Mockito.verify(this.commandParser).getFirstCommandParameter();
	}

	@Test
	public void test_should_create_secret_friend_command_due_to_invalid_parameter()
			throws InvalidParametersCountException, InvalidParameterException {
		Mockito.doReturn(true).when(this.commandParametersValidator).validateParametersCount();
		Mockito.doReturn(false).when(this.commandParametersValidator).validateParameters();
		assertNull(commandFactory.createSecretFriend(this.commandParser, this.commandParametersValidator));
		Mockito.verify(this.commandParametersValidator).validateParametersCount();
		Mockito.verify(this.commandParametersValidator).validateParameters();
	}

	@Test
	public void test_should_fail_to_create_secret_friend_command_due_to_invalid_parameters_count()
			throws InvalidParametersCountException, InvalidParameterException {
		Mockito.doReturn(false).when(this.commandParametersValidator).validateParametersCount();
		assertNull(commandFactory.createSecretFriend(this.commandParser, this.commandParametersValidator));
		Mockito.verify(this.commandParametersValidator).validateParametersCount();
	}

	@Test
	public void test_should_create_astrology_allies_command()
			throws InvalidParametersCountException, InvalidParameterException {
		Mockito.doReturn(true).when(this.commandParametersValidator).validateParametersCount();
		Mockito.doReturn(true).when(this.commandParametersValidator).validateParameters();
		Mockito.doReturn(YEAR).when(this.commandParser).getFirstCommandParameter();

		assertNotNull(commandFactory.createAstrologyAllies(this.commandParser, this.commandParametersValidator));

		Mockito.verify(this.commandParametersValidator).validateParametersCount();
		Mockito.verify(this.commandParametersValidator).validateParameters();
		Mockito.verify(this.commandParser).getFirstCommandParameter();
	}

	@Test
	public void test_should_create_astrologyAllies_command_due_to_invalid_parameter()
			throws InvalidParametersCountException, InvalidParameterException {
		Mockito.doReturn(true).when(this.commandParametersValidator).validateParametersCount();
		Mockito.doReturn(false).when(this.commandParametersValidator).validateParameters();
		assertNull(commandFactory.createAstrologyAllies(this.commandParser, this.commandParametersValidator));
		Mockito.verify(this.commandParametersValidator).validateParametersCount();
		Mockito.verify(this.commandParametersValidator).validateParameters();
	}

	@Test
	public void test_should_fail_to_create_astrologyAllies_command_due_to_invalid_parameters_count()
			throws InvalidParametersCountException, InvalidParameterException {
		Mockito.doReturn(false).when(this.commandParametersValidator).validateParametersCount();
		assertNull(commandFactory.createAstrologyAllies(this.commandParser, this.commandParametersValidator));
		Mockito.verify(this.commandParametersValidator).validateParametersCount();
	}

}
