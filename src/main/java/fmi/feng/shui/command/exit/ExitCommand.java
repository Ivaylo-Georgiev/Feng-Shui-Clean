package fmi.feng.shui.command.exit;

import fmi.feng.shui.command.FengShuiCommand;

/**
 * A Feng Shui command, that terminates the execution of the program.
 * 
 *
 * @author Ivaylo Georgiev
 */
public class ExitCommand implements FengShuiCommand {

	private final static String EXIT = "EXIT";

	@Override
	public String execute() {
		return EXIT;
	}

}
