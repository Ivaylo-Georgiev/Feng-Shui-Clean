package fmi.feng.shui.command.signs;

import fmi.feng.shui.command.FengShuiCommand;

/**
 * A Feng Shui command, that calculates the Chinese animal sign, corresponding
 * to a year.
 * 
 *
 * @author Ivaylo Georgiev
 */
public class ChineseYearSignCommand implements FengShuiCommand {

	/**
	 * Only one parameter is needed to calculate the Chinese year animal sign - a
	 * year.
	 */
	private int year;

	/**
	 * Constructs a Chinese year sign Feng Shui command for a specified year
	 */
	public ChineseYearSignCommand(int year) {
		this.year = year;
	}

	/**
	 * Calculate the Chinese animal sign, corresponding to the specified year
	 * 
	 * @return String The Chinese year animal sign
	 */
	@Override
	public String execute() {
		AnimalSign animalSign = AnimalSign.mapYearToSign(this.year);
		return animalSign.toString();
	}

}
