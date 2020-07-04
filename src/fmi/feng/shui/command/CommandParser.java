package fmi.feng.shui.command;

import java.util.Arrays;
import java.util.List;

public class CommandParser {

	private final static String COMMAND_ELEMENTS_DELIMITER = " ";
	private final static String RAW_COMMAND_TYPE_WORDS_DELIMITER = "-";
	private final static String NORMALIZED_COMMAND_TYPE_WORDS_DELIMITER = "_";
	private final static int COMMAND_TYPE_INDEX = 0;
	private final static int PARAMETERS_INDEX = 1;
	private final static int FIRST_PARAMETER_INDEX = 0;

	private String commandType;
	private List<String> commandParameters;

	public CommandParser(String rawCommand) {
		String[] rawCommandElements = rawCommand.split(COMMAND_ELEMENTS_DELIMITER);
		int rawCommandElementsCount = rawCommandElements.length;
		this.commandType = rawCommandElements[COMMAND_TYPE_INDEX];
		String[] commandParametersArray = Arrays.copyOfRange(rawCommandElements, PARAMETERS_INDEX,
				rawCommandElementsCount);
		this.commandParameters = Arrays.asList(commandParametersArray);
	}

	public String getCommandType() {
		return this.commandType;
	}

	public String getNormalizedCommandType() {
		String normalizedCommandType = this.commandType.replace(RAW_COMMAND_TYPE_WORDS_DELIMITER,
				NORMALIZED_COMMAND_TYPE_WORDS_DELIMITER);
		return normalizedCommandType.toUpperCase();
	}

	public List<String> getCommandParameters() {
		return this.commandParameters;
	}

	public int getFirstCommandParameter() {
		String firstParameter = this.commandParameters.get(FIRST_PARAMETER_INDEX);
		return Integer.parseInt(firstParameter);
	}

}
