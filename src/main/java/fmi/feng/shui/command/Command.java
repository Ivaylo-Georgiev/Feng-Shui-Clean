package fmi.feng.shui.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains the supported commands, that can be executed by the program.
 * 
 *
 * @author Ivaylo Georgiev
 */
public enum Command {

	EXIT, CHINESE_YEAR_SIGN, CHINESE_HOUR_SIGN, KUA_NUMBER, SECRET_FRIEND, ASTROLOGY_ALLIES;

	public static String getSupportedCommands() {
		List<String> supportedCommands = new ArrayList<>();
		for (Command command : values()) {
			supportedCommands.add(command.toString());
		}
		return String.join(",", supportedCommands);
	}

}
