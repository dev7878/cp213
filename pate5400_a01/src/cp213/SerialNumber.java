package cp213;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author Dev Patel, 212325400, pate5400@mylaurier.ca
 * @version 2022-09-23
 */
public class SerialNumber {

	/**
	 * Determines if a string contains all digits.
	 *
	 * @param str The string to test.
	 * @return true if str is all digits, false otherwise.
	 */
	public static boolean allDigits(final String str) {

		// your code here
		boolean check = true;
		for (char ch : str.toCharArray()) {
			if (!Character.isDigit(ch)) {
				check = false;
			}
		}

		return check;
	}

	/**
	 * Determines if a string is a good serial number. Good serial numbers are of
	 * the form 'SN/nnnn-nnn', where 'n' is a digit.
	 *
	 * @param sn The serial number to test.
	 * @return true if the serial number is valid in form, false otherwise.
	 */
	public static boolean validSn(final String sn) {

		// your code here
		boolean check = false;
		if (sn != null) {

			if (sn.length() == 11) {

				if (sn.startsWith("SN/")) {
					if (allDigits(sn.substring(3, 7)) && allDigits(sn.substring(8))) {
						if (sn.charAt(7) == '-') {
							check = true;

						}
					}
				}
			}
		}
		return check;
	}

	/**
	 * Evaluates serial numbers from a file. Writes valid serial numbers to
	 * good_sns, and invalid serial numbers to bad_sns.
	 *
	 * @param fileIn  a file already open for reading
	 * @param goodSns a file already open for writing
	 * @param badSns  a file already open for writing
	 */
	public static void validSnFile(final Scanner fileIn, final PrintStream goodSns, final PrintStream badSns) {

		// your code here
		while (fileIn.hasNext()) {
			String s = fileIn.next();
			if (validSn(s)) {
				goodSns.println(s);
			} else {
				badSns.println(s);
			}
		}

		return;
	}

}
