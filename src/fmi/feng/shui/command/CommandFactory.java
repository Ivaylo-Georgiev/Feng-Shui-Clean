package fmi.feng.shui.command;

import java.util.List;

import fmi.feng.shui.command.exceptions.InvalidCommandTypeException;
import fmi.feng.shui.command.exceptions.InvalidParameterException;
import fmi.feng.shui.command.exceptions.InvalidParametersCountException;
import fmi.feng.shui.command.signs.ChineseHourSignCommand;
import fmi.feng.shui.command.signs.ChineseYearSignCommand;
import fmi.feng.shui.command.validation.ChineseHourSignParametersValidator;
import fmi.feng.shui.command.validation.ChineseYearSignParametersValidator;
import fmi.feng.shui.command.validation.CommandParametersValidator;

public class CommandFactory {

	public FengShuiCommand getFengShuiCommand(String rawCommand)
			throws InvalidCommandTypeException, InvalidParametersCountException, InvalidParameterException {
		CommandParser commandParser = new CommandParser(rawCommand);
		String commandType = commandParser.getNormalizedCommandType();
		try {
			Command command = Command.valueOf(commandType);
			switch (command) {
			case EXIT:
				return new ExitCommand();
			case CHINESE_YEAR_SIGN:
				return createChineseYearSign(commandParser);
			case CHINESE_HOUR_SIGN:
				return createChineseHourSign(commandParser);
			default:
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException illegalArgumentException) {
			String errorMessage = constructInvalidCommandErrorMessage(commandParser.getCommandType());
			throw new InvalidCommandTypeException(errorMessage, illegalArgumentException);
		}
	}

	private String constructInvalidCommandErrorMessage(String commandType) {
		StringBuilder errorMessageBuilder = new StringBuilder();
		errorMessageBuilder.append(commandType);
		errorMessageBuilder.append(" is an invalid command type. Valid commands are ");
		errorMessageBuilder.append(Command.getSupportedCommands());
		return errorMessageBuilder.toString();
	}

	private ChineseYearSignCommand createChineseYearSign(CommandParser commandParser)
			throws InvalidParametersCountException, InvalidParameterException {
		List<String> parameters = commandParser.getCommandParameters();
		CommandParametersValidator commandParametersValidator = new ChineseYearSignParametersValidator(parameters);
		boolean validParametersCount = commandParametersValidator.validateParametersCount();
		if (validParametersCount) {
			boolean validParameters = commandParametersValidator.validateParameters();
			if (validParameters) {
				return new ChineseYearSignCommand(commandParser.getFirstCommandParameter());
			}
		}

		return null;
	}

	private ChineseHourSignCommand createChineseHourSign(CommandParser commandParser)
			throws InvalidParametersCountException, InvalidParameterException {
		List<String> parameters = commandParser.getCommandParameters();
		CommandParametersValidator commandParametersValidator = new ChineseHourSignParametersValidator(parameters);
		boolean validParametersCount = commandParametersValidator.validateParametersCount();
		if (validParametersCount) {
			boolean validParameters = commandParametersValidator.validateParameters();
			if (validParameters) {
				return new ChineseHourSignCommand(commandParser.getFirstCommandParameter());
			}
		}

		return null;
	}

}
