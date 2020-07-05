package fmi.feng.shui.command.signs;

public enum AnimalSign {

	RAT(4, 23, 1, "OX", "DRAGON,MONKEY"), OX(5, 1, 3, "RAT", "SNAKE,ROOSTER"), TIGER(6, 3, 5, "PIG", "HORSE,DOG"),
	RABBIT(7, 5, 7, "DOG", "SHEEP,PIG"), DRAGON(8, 7, 9, "ROOSTER", "MONKEY,RAT"),
	SNAKE(9, 9, 11, "MONKEY", "OX,ROOSTER"), HORSE(10, 11, 13, "SHEEP", "TIGER,DOG"),
	SHEEP(11, 13, 15, "HORSE", "RABBIT,PIG"), MONKEY(0, 15, 17, "SNAKE", "DRAGON,RAT"),
	ROOSTER(1, 17, 19, "DRAGON", "OX,SNAKE"), DOG(2, 19, 21, "RABBIT", "TIGER,HORSE"),
	PIG(3, 21, 23, "TIGER", "RABBIT,SHEEP");

	private int yearModulo;
	private int fromHour;
	private int toHour;
	private String secretFriend;
	private String astrologyAllies;

	private AnimalSign(int yearModulo, int fromHour, int toHour, String secretFriend, String astrologyAllies) {
		this.yearModulo = yearModulo;
		this.fromHour = fromHour;
		this.toHour = toHour;
		this.secretFriend = secretFriend;
		this.astrologyAllies = astrologyAllies;
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

	public String getAstrologyAllies() {
		return this.astrologyAllies;
	}

}
