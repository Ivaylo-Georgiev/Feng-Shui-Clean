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

	private int year;

	public ChineseYearSignCommand(int year) {
		this.year = year;
	}

	@Override
	public String execute() {
		AnimalSign animalSign = AnimalSign.mapYearToSign(this.year);
		return animalSign.toString();
	}

}
