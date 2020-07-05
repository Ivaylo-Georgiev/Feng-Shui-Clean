package fmi.feng.shui.command.signs;

import fmi.feng.shui.command.FengShuiCommand;

public class AstrologyAlliesCommand implements FengShuiCommand {

	private int year;

	public AstrologyAlliesCommand(int year) {
		this.year = year;
	}

	@Override
	public String execute() {
		ChineseYearSignCommand chineseYearSignCommand = new ChineseYearSignCommand(year);
		AnimalSign animalSign = AnimalSign.valueOf(chineseYearSignCommand.execute());
		return animalSign.getAstrologyAllies();
	}

}
