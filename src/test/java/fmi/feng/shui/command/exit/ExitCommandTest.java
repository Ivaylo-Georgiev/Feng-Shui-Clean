package fmi.feng.shui.command.exit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ExitCommandTest {

	private final static String EXIT_OUTPUT = "EXIT";

	@Test
	public void test_should_verify_exit_command() {
		ExitCommand command = new ExitCommand();
		assertEquals(EXIT_OUTPUT, command.execute());
	}

}
