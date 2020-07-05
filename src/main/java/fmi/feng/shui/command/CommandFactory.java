package fmi.feng.shui.command;

import java.util.List;

import fmi.feng.shui.command.exceptions.InvalidCommandTypeException;
import fmi.feng.shui.command.exceptions.InvalidParameterException;
import fmi.feng.shui.command.exceptions.InvalidParametersCountException;
import fmi.feng.shui.command.exit.ExitCommand;
import fmi.feng.shui.command.kua.Gender;
import fmi.feng.shui.command.kua.KuaNumberCommand;
import fmi.feng.shui.command.parser.CommandParser;
import fmi.feng.shui.command.signs.ChineseHourSignCommand;
import fmi.feng.shui.command.signs.ChineseYearSignCommand;
import fmi.feng.shui.command.validation.ChineseHourSignParametersValidator;
import fmi.feng.shui.command.validation.ChineseYearSignParametersValidator;
import fmi.feng.shui.command.validation.CommandParametersValidator;
import fmi.feng.shui.command.validation.KuaNumberParametersValidator;

public class CommandFactory {

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
			default:
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException illegalArgumentException) {
			String errorMessage = constructInvalidCommandErrorMessage(commandParser.getCommandType());
			throw new InvalidCommandTypeException(errorMessage, illegalArgumentException);
		}
	}

	String constructInvalidCommandErrorMessage(String commandType) {
		StringBuilder errorMessageBuilder = new StringBuilder();
		errorMessageBuilder.append(commandType);
		errorMessageBuilder.append(" is an invalid command type. Valid commands are ");
		errorMessageBuilder.append(Command.getSupportedCommands());
		return errorMessageBuilder.toString();
	}

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
}
