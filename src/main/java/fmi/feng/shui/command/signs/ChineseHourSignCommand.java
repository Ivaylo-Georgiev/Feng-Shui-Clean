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

	/**
	 * Only one parameter is needed to calculate the Chinese hour animal sign - an
	 * hour.
	 */
	private int hour;

	/**
	 * Constructs a Chinese hour sign Feng Shui command for a specified hour
	 */
	public ChineseHourSignCommand(int hour) {
		this.hour = hour;
	}

	/**
	 * Calculate the Chinese animal sign, corresponding to the specified hour
	 */
	@Override
	public String execute() {
		AnimalSign animalSign = AnimalSign.mapHourToSign(this.hour);
		return animalSign.toString();
	}

}
