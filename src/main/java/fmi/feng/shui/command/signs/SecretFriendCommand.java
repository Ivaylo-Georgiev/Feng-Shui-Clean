package fmi.feng.shui.command.signs;

import fmi.feng.shui.command.FengShuiCommand;

/**
 * A Feng Shui command, that finds the secret friend of a person.
 * 
 *
 * @author Ivaylo Georgiev
 */
public class SecretFriendCommand implements FengShuiCommand {

	/**
	 * Only one parameter is needed to find the astrology allies of a person - a
	 * birth year.
	 */
	private int year;

	/**
	 * Constructs a secret friend Feng Shui command for a specified year
	 */
	public SecretFriendCommand(int year) {
		this.year = year;
	}

	/**
	 * Find the secret friend of a person, born in a specified year
	 * 
	 * @return String The secret friend
	 */
	@Override
	public String execute() {
		ChineseYearSignCommand chineseYearSignCommand = new ChineseYearSignCommand(year);
		AnimalSign animalSign = AnimalSign.valueOf(chineseYearSignCommand.execute());
		return animalSign.getSecretFriend().toString();
	}

}
