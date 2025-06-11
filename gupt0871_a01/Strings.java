package cp213;

/**
 * @author Anushree Gupte, 169050871
 * @version 2024-10-03
 */
public class Strings {
	// Constants
	public static final String VOWELS = "aeiouAEIOU";

	/**
	 * Determines if string is a "palindrome": a word, verse, or sentence (such as
	 * "Able was I ere I saw Elba") that reads the same backward or forward. Ignores
	 * case, spaces, digits, and punctuation in the string parameter s.
	 *
	 * @param string a string
	 * @return true if string is a palindrome, false otherwise
	 */
	public static boolean isPalindrome(final String string) {
		// get rid of special characters and make everything lowercase
		String replacedString = string.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

		// checks if replacedString is the same backwards
		String reversedString = new StringBuilder(replacedString).reverse().toString();

		if (replacedString.equals(reversedString)) {
			return true;
		}

		return false;
	}

	/**
	 * Determines if name is a valid Java variable name. Variables names must start
	 * with a letter or an underscore, but cannot be an underscore alone. The rest
	 * of the variable name may consist of letters, numbers and underscores.
	 *
	 * @param name a string to test as a Java variable name
	 * @return true if name is a valid Java variable name, false otherwise
	 */
	public static boolean isValid(final String name) {

		// checks if the name is empty or is an underscore alone
		if (name.isEmpty() || name.equals("_")) {
			return false;
		}

		// check first character
		char firstCharacter = name.charAt(0);
		if (!Character.isLetter(firstCharacter) && firstCharacter != '_') {
			return false;
		}

		// checks rest of characters
		for (int i = 1; i < name.length(); i++) {
			char a = name.charAt(i);
			if (!Character.isLetterOrDigit(a) && a != '_') {
				return false;
			}
		}

		return true;
	}

	/**
	 * Converts a word to Pig Latin. The conversion is:
	 * <ul>
	 * <li>if a word begins with a vowel, add "way" to the end of the word.</li>
	 * <li>if the word begins with consonants, move the leading consonants to the
	 * end of the word and add "ay" to the end of that. "y" is treated as a
	 * consonant if it is the first character in the word, and as a vowel for
	 * anywhere else in the word.</li>
	 * </ul>
	 * Preserve the case of the word - i.e. if the first character of word is
	 * upper-case, then the new first character should also be upper case.
	 *
	 * @param word The string to convert to Pig Latin
	 * @return the Pig Latin version of word
	 */
	public static String pigLatin(String word) {

		// will return as is if the input is null or empty
		if (word == null || word.isEmpty()) {
			return word;
		}

		// checks if the first character is a vowel
		if (VOWELS.indexOf(word.charAt(0)) != -1) {
			// adds 'way' for words starting with a vowel
			return word + "way";
		}

		// for words starting with consonants, find first vowel
		int vowelIndex = -1;
		for (int i = 0; i < word.length(); i++) {
			if (VOWELS.indexOf(word.charAt(i)) != -1) {
				vowelIndex = i;
				break;
			}
		}

		// if no vowels were found return just as it is
		if (vowelIndex == -1) {
			return word;
		}

		// move leading consonants to the end and add "ay"
		String consonantStart = word.substring(0, vowelIndex);
		String wordInPigLatin = word.substring(vowelIndex) + consonantStart + "ay";

		// preserve the case of the first character
		if (Character.isUpperCase(word.charAt(0))) {
			wordInPigLatin = Character.toUpperCase(wordInPigLatin.charAt(0))
					+ wordInPigLatin.substring(1).toLowerCase();

		}

		else {
			wordInPigLatin = wordInPigLatin.toLowerCase();
		}

		return wordInPigLatin;
	}

}
