package fmi.feng.shui.command;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CommandTest {

	private final static String SUPPORTED_COMMANDS = "EXIT,CHINESE_YEAR_SIGN,CHINESE_HOUR_SIGN,KUA_NUMBER";

	@Test
	public void test_should_list_supported_commands() {
		assertEquals(SUPPORTED_COMMANDS, Command.getSupportedCommands());
	}

}
