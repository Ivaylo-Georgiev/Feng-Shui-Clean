package fmi.feng.shui.command.signs;

/**
 * Stores information about the 12 Chinese zodiac animal signs, needed for the
 * execution of numerous Feng Shui commands.
 * 
 *
 * @author Ivaylo Georgiev
 */
public enum AnimalSign {

	RAT(4, 23, "OX", "DRAGON,MONKEY"), OX(5, 1, "RAT", "SNAKE,ROOSTER"), TIGER(6, 3, "PIG", "HORSE,DOG"),
	RABBIT(7, 5, "DOG", "SHEEP,PIG"), DRAGON(8, 7, "ROOSTER", "MONKEY,RAT"), SNAKE(9, 9, "MONKEY", "OX,ROOSTER"),
	HORSE(10, 11, "SHEEP", "TIGER,DOG"), SHEEP(11, 13, "HORSE", "RABBIT,PIG"), MONKEY(0, 15, "SNAKE", "DRAGON,RAT"),
	ROOSTER(1, 17, "DRAGON", "OX,SNAKE"), DOG(2, 19, "RABBIT", "TIGER,HORSE"), PIG(3, 21, "TIGER", "RABBIT,SHEEP");

	private int yearModulo;
	private int fromHour;
	private String secretFriend;
	private String astrologyAllies;

	private AnimalSign(int yearModulo, int fromHour, String secretFriend, String astrologyAllies) {
		this.yearModulo = yearModulo;
		this.fromHour = fromHour;
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
		final int offset = 2;
		for (AnimalSign sign : values()) {
			if (hour >= sign.fromHour && hour < sign.fromHour + offset) {
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
