package fmi.feng.shui.command.exit;

import fmi.feng.shui.command.FengShuiCommand;

public class ExitCommand implements FengShuiCommand {

	private final static String EXIT = "EXIT";

	@Override
	public String execute() {
		return EXIT;
	}

}
