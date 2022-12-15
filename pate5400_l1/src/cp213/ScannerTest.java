package cp213;

import java.util.Scanner;

/**
 * Class to demonstrate the use of Scanner with a keyboard and File objects.
 *
 * @author Dev Patel
 * @version 2022-09-22 student id 212325400 email pate5400@mylaurier.ca
 * 
 */
public class ScannerTest {

	/**
	 * Count lines in the scanned file.
	 *
	 * @param source Scanner to process
	 * @return number of lines in scanned file
	 */
	public static int countLines(final Scanner source) {
		int count = 0;

		// your code here
		while (source.hasNextLine()) {
			count++;
			source.nextLine();

		}

		return count;
	}

	/**
	 * Count tokens in the scanned object.
	 *
	 * @param source Scanner to process
	 * @return number of tokens in scanned object
	 */
	public static int countTokens(final Scanner source) {
		int tokens = 0;

		// your code here
		while (source.hasNext()) {
			tokens++;
			source.next();
		}

		return tokens;

	}

	/**
	 * Ask for and total integers from the keyboard.
	 *
	 * @param keyboard Scanner to process
	 * @return total of positive integers entered from keyboard
	 */
	public static int readNumbers(final Scanner keyboard) {
		int total = 0;

		// your code here
		System.out.println("Enter Series of integers. Press q to exit");

		String str = "";
		while (!str.equals("q")) {
			if (keyboard.hasNextInt()) {
				total += keyboard.nextInt();

			} else {
				str = keyboard.next();
				if (!str.equals("q")) {
					System.out.println("\'" + str + "\' is not an integer or 'q'.");

				}

			}

		}

		return total;
	}

}
