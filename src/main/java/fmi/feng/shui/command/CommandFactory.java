package fmi.feng.shui.command;

import java.util.List;

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
import fmi.feng.shui.command.validation.ChineseHourSignParametersValidator;
import fmi.feng.shui.command.validation.ChineseYearSignParametersValidator;
import fmi.feng.shui.command.validation.CommandParametersValidator;
import fmi.feng.shui.command.validation.KuaNumberParametersValidator;
import fmi.feng.shui.command.validation.SecretFriendParametersValidator;

/**
 * Instantiates the proper Feng Shui command type, given raw user input.
 * 
 *
 * @author Ivaylo Georgiev
 */
public class CommandFactory {

	/**
	 * Instantiates the proper Feng Shui Command, given raw user input.
	 * 
	 * @param commandParser Contains the raw command type and parameters, specified
	 *                      by the user as strings.
	 * @throws InvalidCommandTypeException     If the raw command type, specified by
	 *                                         the user, is not supported or
	 *                                         invalid.
	 * @throws InvalidParametersCountException If the raw command type, specified by
	 *                                         the user, is valid, but the number of
	 *                                         parameters, passed to it is
	 *                                         incorrect.
	 * @throws InvalidParameterException       If both the raw command type,
	 *                                         specified by the user, or the
	 *                                         parameters count is correct, but one
	 *                                         of the parameter types is not.
	 * @return FengShuiCommand The proper Feng Shui command, corresponding to the
	 *         user specification.
	 */
	public FengShuiCommand getFengShuiCommand(CommandParser commandParser)
			throws InvalidCommandTypeException, InvalidParametersCountException, InvalidParameterException {
		String commandType = commandParser.getNormalizedCommandType();
		List<String> commandParameters = commandParser.getCommandParameters();
		try {
			Command command = Command.valueOf(commandType);
			switch (command) {
			case EXIT:
				return new ExitCommand();
			case CHINESE_YEAR_SIGN:
				return createChineseYearSign(commandParser, new ChineseYearSignParametersValidator(commandParameters));
			case CHINESE_HOUR_SIGN:
				return createChineseHourSign(commandParser, new ChineseHourSignParametersValidator(commandParameters));
			case KUA_NUMBER:
				return createKuaNumber(commandParser, new KuaNumberParametersValidator(commandParameters));
			case SECRET_FRIEND:
				return createSecretFriend(commandParser, new SecretFriendParametersValidator(commandParameters));
			case ASTROLOGY_ALLIES:
				return createAstrologyAllies(commandParser, new SecretFriendParametersValidator(commandParameters));
			default:
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException illegalArgumentException) {
			String errorMessage = constructInvalidCommandErrorMessage(commandParser.getCommandType());
			throw new InvalidCommandTypeException(errorMessage, illegalArgumentException);
		}
	}

	/**
	 * Constructs the proper error message, if the user wants to execute an invalid
	 * command.
	 * 
	 * @param commandType The command type, specified by the user.
	 * @return String The error message for the invalid command type.
	 */
	String constructInvalidCommandErrorMessage(String commandType) {
		StringBuilder errorMessageBuilder = new StringBuilder();
		errorMessageBuilder.append(commandType);
		errorMessageBuilder.append(" is an invalid command type. Valid commands are ");
		errorMessageBuilder.append(Command.getSupportedCommands());
		return errorMessageBuilder.toString();
	}

	/**
	 * Instantiates a Chinese year sign Feng Shui command, if the user has provided
	 * a valid year parameter.
	 * 
	 * @param commandParser              Contains the raw command type and
	 *                                   parameters, specified by the user as
	 *                                   strings.
	 * @param commandParametersValidator Validates year parameter, passed by the
	 *                                   user.
	 * @throws InvalidParametersCountException If the user provided more or less
	 *                                         than one parameter.
	 * @throws InvalidParameterException       If the year paramater, passed by the
	 *                                         user is not a positive integer.
	 * @return ChineseYearSignCommand The Chinese year sign Feng Shui command for a
	 *         specified year.
	 */
	ChineseYearSignCommand createChineseYearSign(CommandParser commandParser,
			CommandParametersValidator commandParametersValidator)
			throws InvalidParametersCountException, InvalidParameterException {
		boolean validParametersCount = commandParametersValidator.validateParametersCount();
		if (validParametersCount) {
			boolean validParameters = commandParametersValidator.validateParameters();
			if (validParameters) {
				int year = Integer.parseInt(commandParser.getFirstCommandParameter());
				return new ChineseYearSignCommand(year);
			}
		}

		return null;
	}

	/**
	 * Instantiates a Chinese hour sign Feng Shui command, if the user has provided
	 * a valid hour parameter.
	 * 
	 * @param commandParser              Contains the raw command type and
	 *                                   parameters, specified by the user as
	 *                                   strings.
	 * @param commandParametersValidator Validates hour parameter, passed by the
	 *                                   user.
	 * @throws InvalidParametersCountException If the user provided more or less
	 *                                         than one parameter.
	 * @throws InvalidParameterException       If the hour paramater, passed by the
	 *                                         user, is not an integer between 1 and
	 *                                         24.
	 * @return ChineseHourSignCommand The Chinese hour sign Feng Shui command for a
	 *         specified hour
	 */
	ChineseHourSignCommand createChineseHourSign(CommandParser commandParser,
			CommandParametersValidator commandParametersValidator)
			throws InvalidParametersCountException, InvalidParameterException {
		boolean validParametersCount = commandParametersValidator.validateParametersCount();
		if (validParametersCount) {
			boolean validParameters = commandParametersValidator.validateParameters();
			if (validParameters) {
				int hour = Integer.parseInt(commandParser.getFirstCommandParameter());
				return new ChineseHourSignCommand(hour);
			}
		}

		return null;
	}

	/**
	 * Instantiates a KUA number Feng Shui command, if the user has provided valid
	 * year and gender parameters.
	 * 
	 * @param commandParser              Contains the raw command type and
	 *                                   parameters, specified by the user as
	 *                                   strings.
	 * @param commandParametersValidator Validates year and gender parameters,
	 *                                   passed by the user.
	 * @throws InvalidParametersCountException If the user provided more or less
	 *                                         than two parameters.
	 * @throws InvalidParameterException       If the year paramater, passed by the
	 *                                         user, is not a positive integer, or
	 *                                         if the gender parameter not correct
	 * @return KuaNumberCommand The KUA number, specified by a year and a gender.
	 */
	KuaNumberCommand createKuaNumber(CommandParser commandParser, CommandParametersValidator commandParametersValidator)
			throws InvalidParametersCountException, InvalidParameterException {
		boolean validParametersCount = commandParametersValidator.validateParametersCount();
		if (validParametersCount) {
			boolean validParameters = commandParametersValidator.validateParameters();
			if (validParameters) {
				int year = Integer.parseInt(commandParser.getFirstCommandParameter());
				Gender gender = Gender.valueOf(commandParser.getSecondCommandParameter().toUpperCase());
				return new KuaNumberCommand(year, gender);
			}
		}

		return null;
	}

	/**
	 * Instantiates a secret friend Feng Shui command, if the user has provided a
	 * valid year parameter.
	 * 
	 * @param commandParser              Contains the raw command type and
	 *                                   parameters, specified by the user as
	 *                                   strings.
	 * @param commandParametersValidator Validates year parameter, passed by the
	 *                                   user.
	 * @throws InvalidParametersCountException If the user provided more or less
	 *                                         than one parameter.
	 * @throws InvalidParameterException       If the year paramater, passed by the
	 *                                         user, is not a positive integer.
	 * @return SecretFriendCommand The secret friend Feng Shui command for a
	 *         specified year.
	 */
	SecretFriendCommand createSecretFriend(CommandParser commandParser,
			CommandParametersValidator commandParametersValidator)
			throws InvalidParametersCountException, InvalidParameterException {
		boolean validParametersCount = commandParametersValidator.validateParametersCount();
		if (validParametersCount) {
			boolean validParameters = commandParametersValidator.validateParameters();
			if (validParameters) {
				int year = Integer.parseInt(commandParser.getFirstCommandParameter());
				return new SecretFriendCommand(year);
			}
		}

		return null;
	}

	/**
	 * Instantiates an astrology allies Feng Shui command, if the user has provided
	 * a valid year parameter.
	 * 
	 * @param commandParser              Contains the raw command type and
	 *                                   parameters, specified by the user as
	 *                                   strings.
	 * @param commandParametersValidator Validates year parameter, passed by the
	 *                                   user.
	 * @throws InvalidParametersCountException If the user provided more or less
	 *                                         than one parameter.
	 * @throws InvalidParameterException       If the year paramater, passed by the
	 *                                         user, is not a positive integer.
	 * @return AstrologyAlliesCommand The astrology allies Feng Shui command for a
	 *         specified year.
	 */
	AstrologyAlliesCommand createAstrologyAllies(CommandParser commandParser,
			CommandParametersValidator commandParametersValidator)
			throws InvalidParametersCountException, InvalidParameterException {
		boolean validParametersCount = commandParametersValidator.validateParametersCount();
		if (validParametersCount) {
			boolean validParameters = commandParametersValidator.validateParameters();
			if (validParameters) {
				int year = Integer.parseInt(commandParser.getFirstCommandParameter());
				return new AstrologyAlliesCommand(year);
			}
		}

		return null;
	}
}
