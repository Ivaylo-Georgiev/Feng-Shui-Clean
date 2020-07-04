package fmi.feng.shui.command.kua;

import fmi.feng.shui.command.FengShuiCommand;

public class KuaNumberCommand implements FengShuiCommand {

	private int year;
	private Gender gender;

	public KuaNumberCommand(int year, Gender gender) {
		this.year = year;
		this.gender = gender;
	}

	@Override
	public String execute() {
		if (this.gender == Gender.MALE) {
			return Integer.toString(calculateMaleKuaNumber());
		}
		return Integer.toString(calculateFemaleKuaNumber());
	}

	private int calculateMaleKuaNumber() {
		int reducedYear = reduceToSingleDigit(this.year);
		int kuaNumber = 11 - reducedYear;
		kuaNumber = reduceToSingleDigit(kuaNumber);
		return (kuaNumber == 5) ? 2 : kuaNumber;
	}

	private int calculateFemaleKuaNumber() {
		int reducedYear = reduceToSingleDigit(this.year);
		int kuaNumber = 4 + reducedYear;
		kuaNumber = reduceToSingleDigit(kuaNumber);
		return (kuaNumber == 5) ? 8 : kuaNumber;
	}

	private int reduceToSingleDigit(int number) {
		int sum = 0;

		while (number > 0 || sum > 9) {
			if (number == 0) {
				number = sum;
				sum = 0;
			}
			sum += number % 10;
			number /= 10;
		}

		return sum;
	}

}
