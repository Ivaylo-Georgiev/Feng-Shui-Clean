package fmi.feng.shui.command;

public class ExitCommand implements FengShuiCommand {

	private final static String EXIT = "EXIT";

	@Override
	public String execute() {
		return EXIT;
	}

}
