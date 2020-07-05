package fmi.feng.shui.command;

import java.util.ArrayList;
import java.util.List;

public enum Command {

	EXIT, CHINESE_YEAR_SIGN, CHINESE_HOUR_SIGN, KUA_NUMBER, SECRET_FRIEND;

	public static String getSupportedCommands() {
		List<String> supportedCommands = new ArrayList<>();
		for (Command command : values()) {
			supportedCommands.add(command.toString());
		}
		return String.join(",", supportedCommands);
	}

}
