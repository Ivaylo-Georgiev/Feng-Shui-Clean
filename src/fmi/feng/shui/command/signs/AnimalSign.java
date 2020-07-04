package fmi.feng.shui.command.signs;

public enum AnimalSign {

	RAT(4, 23, 1), OX(5, 1, 3), TIGER(6, 3, 5), RABBIT(7, 5, 7), DRAGON(8, 7, 9), SNAKE(9, 9, 11), HORSE(10, 11, 13),
	SHEEP(11, 13, 15), MONKEY(0, 15, 17), ROOSTER(1, 17, 19), DOG(2, 19, 21), PIG(3, 21, 23);

	private int yearModulo;
	private int fromHour;
	private int toHour;

	private AnimalSign(int yearModulo, int fromHour, int toHour) {
		this.yearModulo = yearModulo;
		this.fromHour = fromHour;
		this.toHour = toHour;
	}

	public static AnimalSign mapYearToSign(int year) {
		final int signsCount = values().length;
		int yearModulo = year % signsCount;
		for (AnimalSign sign : values()) {
			if (yearModulo == sign.yearModulo) {
				return sign;
			}
		}

		return null;
	}

	public static AnimalSign mapHourToSign(int hour) {
		for (AnimalSign sign : values()) {
			if (hour >= sign.fromHour && hour < sign.toHour) {
				return sign;
			}
		}

		// cover the case for 24, which is ignored by the checks above
		return RAT;
	}

}
