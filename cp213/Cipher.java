package cp213;

/**
 * @author Anushree Gupte, 169050871
 * @version 2024-10-01
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
		// Create a StringBuilder for the result
		StringBuilder result = new StringBuilder();
		// calculate shift, wrapping around if it exceeds 26
		int shift = n % ALPHA_LENGTH;

		// loop through each character in the input string
		for (char c : s.toCharArray()) {
			// check if the character is a letter
			if (Character.isLetter(c)) {
				// convert the letter to uppercase
				c = Character.toUpperCase(c);
				// find the index of the letter in the alphabet
				int originalIndex = ALPHA.indexOf(c);
				// calculate the new index with the shift
				int newIndex = (originalIndex + shift) % ALPHA_LENGTH;
				// append the enciphered letter to the result
				result.append(ALPHA.charAt(newIndex));
			}

			// if it's not a letter, add the original character to the result
			else {
				result.append(c);
			}
		}

		// return the final enciphered string
		return result.toString();
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

		StringBuilder result = new StringBuilder();

		// loop through each character in the input string
		for (char c : s.toCharArray()) {
			// check if the character is a letter
			if (Character.isLetter(c)) {
				// convert the letter to uppercase
				c = Character.toUpperCase(c);
				// find the index of the letter in the alphabet
				int originalIndex = ALPHA.indexOf(c);
				// append the corresponding letter from the ciphertext
				result.append(ciphertext.charAt(originalIndex));
			}

			else {
				// if it's not a letter, add the original character to the result
				result.append(c);
			}
		}
		// return the final enciphered string
		return result.toString();
	}

}
