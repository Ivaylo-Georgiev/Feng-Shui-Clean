package fmi.feng.shui.command.signs;

import fmi.feng.shui.command.FengShuiCommand;

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
