package cp213;

/**
 * Sample string methods.
 *
 * @author Dev Patel, 212325400, and pate5400@mylaurier.ca
 * @version 2022-09-28
 */
public class StringMethods {
	// Constants
	/**
	 * String of vowels.
	 */
	public static final String VOWELS = "aeiouAEIOU";

	/**
	 * Counts the number of vowels in a string. Does not include 'y'.
	 *
	 * @param string A string.
	 * @return Number of vowels in string.
	 */
	public static int vowelCount(final String string) {
		int count = 0;

		// your code here
		int length = string.length();
		for (int x = 0; x < length; x++) {
			char ch = string.charAt(x);
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
					|| ch == 'O' || ch == 'U') {
				count++;
			}

		}

		return count;
	}

	/**
	 * Counts the number of digits in a string.
	 *
	 * @param string A string.
	 * @return Number of digits in string.
	 */
	public static int digitCount(final String string) {
		int count = 0;

		// your code here
		int length = string.length();

		for (int x = 0; x < length; x++) {

			if (Character.isDigit(string.charAt(x))) {
				count++;
			}

		}

		return count;
	}

	/**
	 * Totals the individual digits in a string.
	 *
	 * @param string A string.
	 * @return The integer total of all individuals digits in string.
	 */
	public static int totalDigits(final String string) {
		int total = 0;
		String temp = "0";
		// your code here
		int length = string.length();
		for (int x = 0; x < length; x++) {
			char ch = string.charAt(x);

			if (Character.isDigit(ch)) {
				temp += ch;

			} else {
				total += Integer.parseInt(temp);
				temp = "0";
			}
		}
		total = total + Integer.parseInt(temp);
		return total;
	}

	/**
	 * Compares string1 and string2 and returns a comma-delimited concatenated
	 * string consisting of the string that is first lexically followed by the
	 * string that is second lexically. If the strings are equal, then only string1
	 * is returned.
	 *
	 * @param string1 String to compare against string2.
	 * @param string2 String to compare against string1.
	 * @return A concatenation of string1 and string2 in order.
	 */
	public static String pairs(String string1, String string2) {
		String line = null;

		// your code here
		if (string1.equals(string2)) {
			line = string1;

		} else {
			int compare = 0;
			compare = string1.compareTo(string2);
			if (compare < 0) {
				line = string1 + "," + string2;

			} else if (compare > 0) {
				line = string2 + "," + string1;

			}
		}

		return line;
	}

	/**
	 * Finds the distance between the s1 and s2. The distance between two strings of
	 * the same length is the number of positions in the strings at which their
	 * characters are different. If two strings are not the same length, the
	 * distance is unknown (-1). If the distance is zero, then two strings are
	 * equal.
	 *
	 * @param string1 String to compare against string2.
	 * @param string2 String to compare against string1.
	 * @return The distance between string1 and string2.
	 */
	public static int stringDistance(String string1, String string2) {
		int distance = 0;

		// your code here
		int length_1 = string1.length();
		int length_2 = string2.length();
		if (length_1 != length_2) {
			distance = -1;
		} else {
			for (int i = 0; i < length_1; i++) {
				char char_1 = string1.charAt(i);
				char char_2 = string2.charAt(i);
				if (char_1 != char_2) {
					distance++;
				}

			}
		}

		return distance;
	}
}
