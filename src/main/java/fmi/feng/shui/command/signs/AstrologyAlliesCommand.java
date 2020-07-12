package fmi.feng.shui.command.signs;

import fmi.feng.shui.command.FengShuiCommand;

/**
 * A Feng Shui command, that finds the astrology allies of a person.
 * 
 *
 * @author Ivaylo Georgiev
 */
public class AstrologyAlliesCommand implements FengShuiCommand {

	/**
	 * Only one parameter is needed find the astrology allies of a person - the
	 * birth year.
	 */
	private int year;

	/**
	 * Constructs an astrology allies Feng Shui command for a specified year
	 */
	public AstrologyAlliesCommand(int year) {
		this.year = year;
	}

	/**
	 * Find the astrology allies of a person, born in a specified year
	 */
	@Override
	public String execute() {
		ChineseYearSignCommand chineseYearSignCommand = new ChineseYearSignCommand(year);
		AnimalSign animalSign = AnimalSign.valueOf(chineseYearSignCommand.execute());
		return animalSign.getAstrologyAllies();
	}

}
