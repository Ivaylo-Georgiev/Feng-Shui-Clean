package fmi.feng.shui.command.kua;

import fmi.feng.shui.command.FengShuiCommand;

/**
 * A Feng Shui command, that calculates the KUA number of a person.
 * 
 *
 * @author Ivaylo Georgiev
 */
public class KuaNumberCommand implements FengShuiCommand {

	/**
	 * Some schools of Feng Shui do not use the Kua Number 5
	 */
	private final static int KUA_FIVE = 5;

	/**
	 * Females replace KUA 5 with KUA 8
	 */
	private final static int KUA_EIGHT = 8;

	/**
	 * Males replace KUA 5 with KUA 2
	 */
	private final static int KUA_TWO = 2;

	/**
	 * To calculate the KUA number of a female, add 4 to the reduced sum of the last
	 * two digits of the birth year
	 */
	private final static int FEMALE_KUA_ADDEND = 4;

	/**
	 * To calculate the KUA number of a male, subtract the reduced sum of the last
	 * two digits of the birth year from 11
	 */
	private final static int MALE_KUA_MINUEND = 11;

	/**
	 * Two parameters are needed to calculate the KUA number of a person. The first
	 * is birth year.
	 */
	private int year;

	/**
	 * * Two parameters are needed to calculate the KUA number of a person. The
	 * first is gender.
	 */
	private Gender gender;

	public KuaNumberCommand(int year, Gender gender) {
		this.year = year;
		this.gender = gender;
	}

	/**
	 * Calculates the KUA number of a person with the specified birth year and
	 * gender
	 * 
	 * @return String The string representation of the calculated KUA number
	 */
	@Override
	public String execute() {
		if (this.gender == Gender.MALE) {
			return Integer.toString(calculateMaleKuaNumber());
		}
		return Integer.toString(calculateFemaleKuaNumber());
	}

	/**
	 * Calculates the KUA number of a male with the specified birth year
	 * 
	 * @return int The integer representation of the calculated KUA number
	 */
	private int calculateMaleKuaNumber() {
		int reducedYear = reduceToSingleDigit(this.year);
		int kuaNumber = MALE_KUA_MINUEND - reducedYear;
		kuaNumber = reduceToSingleDigit(kuaNumber);
		return (kuaNumber == KUA_FIVE) ? KUA_TWO : kuaNumber;
	}

	/**
	 * Calculates the KUA number of a female with the specified birth year
	 * 
	 * @return int The integer representation of the calculated KUA number
	 */
	private int calculateFemaleKuaNumber() {
		int reducedYear = reduceToSingleDigit(this.year);
		int kuaNumber = FEMALE_KUA_ADDEND + reducedYear;
		kuaNumber = reduceToSingleDigit(kuaNumber);
		return (kuaNumber == KUA_FIVE) ? KUA_EIGHT : kuaNumber;
	}

	/**
	 * Represents in integer as the sum of it's digits, until it is reduced to a
	 * single digit
	 * 
	 * @param number The number, that needs to be reduced to a single digit
	 * @return int The number, reduced to a single digit
	 */
	private int reduceToSingleDigit(int number) {
		int sum = 0;

		// iterate until the number is reduced to 1 digit
		while (number > 0 || sum > 9) {
			if (number == 0) {
				number = sum;
				sum = 0;
			}
			// remove last digit
			sum += number % 10;
			number /= 10;
		}

		return sum;
	}

}
