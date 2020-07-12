package fmi.feng.shui.command.signs;

import fmi.feng.shui.command.FengShuiCommand;

/**
 * A Feng Shui command, that finds the secret friend of a person.
 * 
 *
 * @author Ivaylo Georgiev
 */
public class SecretFriendCommand implements FengShuiCommand {

	private int year;

	public SecretFriendCommand(int year) {
		this.year = year;
	}

	@Override
	public String execute() {
		ChineseYearSignCommand chineseYearSignCommand = new ChineseYearSignCommand(year);
		AnimalSign animalSign = AnimalSign.valueOf(chineseYearSignCommand.execute());
		return animalSign.getSecretFriend().toString();
	}

}
