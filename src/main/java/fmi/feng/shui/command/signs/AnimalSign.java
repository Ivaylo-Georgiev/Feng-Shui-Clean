package fmi.feng.shui.command.signs;

public enum AnimalSign {

	RAT(4, 23, 1, "OX"), OX(5, 1, 3, "RAT"), TIGER(6, 3, 5, "PIG"), RABBIT(7, 5, 7, "DOG"), DRAGON(8, 7, 9, "ROOSTER"),
	SNAKE(9, 9, 11, "MONKEY"), HORSE(10, 11, 13, "SHEEP"), SHEEP(11, 13, 15, "HORSE"), MONKEY(0, 15, 17, "SNAKE"),
	ROOSTER(1, 17, 19, "DRAGON"), DOG(2, 19, 21, "RABBIT"), PIG(3, 21, 23, "TIGER");

	private int yearModulo;
	private int fromHour;
	private int toHour;
	private String secretFriend;

	private AnimalSign(int yearModulo, int fromHour, int toHour, String secretFriend) {
		this.yearModulo = yearModulo;
		this.fromHour = fromHour;
		this.toHour = toHour;
		this.secretFriend = secretFriend;
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

	public AnimalSign getSecretFriend() {
		return valueOf(this.secretFriend);
	}

}
