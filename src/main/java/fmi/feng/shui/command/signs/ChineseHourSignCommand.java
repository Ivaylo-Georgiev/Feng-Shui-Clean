package fmi.feng.shui.command.signs;

import fmi.feng.shui.command.FengShuiCommand;

/**
 * A Feng Shui command, that calculates the Chinese animal sign, corresponding
 * to an hour.
 * 
 *
 * @author Ivaylo Georgiev
 */
public class ChineseHourSignCommand implements FengShuiCommand {

	private int hour;

	public ChineseHourSignCommand(int hour) {
		this.hour = hour;
	}

	@Override
	public String execute() {
		AnimalSign animalSign = AnimalSign.mapHourToSign(this.hour);
		return animalSign.toString();
	}

}
