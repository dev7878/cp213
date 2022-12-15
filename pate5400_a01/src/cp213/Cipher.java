package cp213;

/**
 * @author Dev Patel, 212325400, pate5400@mylaurier.ca
 * @version 2022-09-28
 */
public class Cipher {
	// Constants
	public static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final int ALPHA_LENGTH = ALPHA.length();

	/**
	 * Encipher a string using a shift cipher. Each letter is replaced by a letter
	 * 'n' letters to the right of the original. Thus for example, all shift values
	 * evenly divisible by 26 (the length of the English alphabet) replace a letter
	 * with itself. Non-letters are left unchanged.
	 *
	 * @param s string to encipher
	 * @param n the number of letters to shift
	 * @return the enciphered string in all upper-case
	 */
	public static String shift(final String s, final int n) {

		// your code here
		String temp = "";
		String new_s = s;
		new_s = new_s.toUpperCase();
		for (int i = 0; i < new_s.length(); i++) {
			if (!Character.isLetter(new_s.charAt(i)) == false) {
				temp += (char) ((new_s.charAt(i) + n - 65) % 26 + 65);

			} else {
				temp += new_s.charAt(i);
			}
		}

		return temp;
	}

	/**
	 * Encipher a string using the letter positions in ciphertext. Each letter is
	 * replaced by the letter in the same ordinal position in the ciphertext.
	 * Non-letters are left unchanged. Ex:
	 *
	 * <pre>
	Alphabet:   ABCDEFGHIJKLMNOPQRSTUVWXYZ
	Ciphertext: AVIBROWNZCEFGHJKLMPQSTUXYD
	 * </pre>
	 *
	 * A is replaced by A, B by V, C by I, D by B, E by R, and so on. Non-letters
	 * are ignored.
	 *
	 * @param s          string to encipher
	 * @param ciphertext ciphertext alphabet
	 * @return the enciphered string in all upper-case
	 */
	public static String substitute(final String s, final String ciphertext) {

		// your code here
		int t;
		String temp = "";
		String new_s = s.toUpperCase();
		for (int i = 0; i < new_s.length(); i++) {

			if (!Character.isLetter(new_s.charAt(i)) == false) {
				char ch = new_s.charAt(i);
				for (t = 0; t < ALPHA.length(); t++) {
					char Alpha = ALPHA.charAt(t);
					if (ch == Alpha) {
						int x = t;
						temp += ciphertext.charAt(x);
					}

				}
			} else {
				temp += new_s.charAt(i);
			}

		}
		return temp;
	}

}
