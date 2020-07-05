package fmi.feng.shui.command.signs;

import fmi.feng.shui.command.FengShuiCommand;

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
