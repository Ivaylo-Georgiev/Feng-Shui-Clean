package fmi.feng.shui.command.parser;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class CommandParserTest {

	private final static String COMMAND_TYPE = "command-type";
	private final static String NORMALIZED_COMMAND_TYPE = "COMMAND_TYPE";
	private final static String FIRST_PARAMETER = "first-parameter";
	private final static String SECOND_PARAMETER = "second-parameter";
	private final static String COMMAND = String.join(" ", COMMAND_TYPE, FIRST_PARAMETER, SECOND_PARAMETER);

	private CommandParser parser;

	public CommandParserTest() {
		this.parser = new CommandParser(COMMAND);
	}

	@Test
	public void test_should_parse_command_type() {
		assertEquals(COMMAND_TYPE, parser.getCommandType());
	}

	@Test
	public void test_should_parse_first_parameter() {
		assertEquals(FIRST_PARAMETER, parser.getFirstCommandParameter());
	}

	@Test
	public void test_should_parse_second_parameter() {
		assertEquals(SECOND_PARAMETER, parser.getSecondCommandParameter());
	}

	@Test
	public void test_should_parse_command_parameters() {
		assertEquals(Arrays.asList(FIRST_PARAMETER, SECOND_PARAMETER), parser.getCommandParameters());
	}

	@Test
	public void test_should_parse_normalized_command_type() {
		assertEquals(NORMALIZED_COMMAND_TYPE, parser.getNormalizedCommandType());
	}

}
