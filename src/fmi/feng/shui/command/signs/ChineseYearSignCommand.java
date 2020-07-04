package fmi.feng.shui.command.signs;

import fmi.feng.shui.command.FengShuiCommand;

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
