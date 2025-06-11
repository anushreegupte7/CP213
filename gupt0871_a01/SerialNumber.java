package cp213;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author Anushree Gupte, 169050871
 * @version 2024-10-03
 */
public class SerialNumber {

	/**
	 * Determines if a string contains all digits.
	 *
	 * @param str The string to test.
	 * @return true if str is all digits, false otherwise.
	 */
	public static boolean allDigits(final String str) {
		// loop through each character in the string
		for (int i = 0; i < str.length(); i++) {
			// if the current character is not a digit, return false
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Determines if a string is a good serial number. Good serial numbers are of
	 * the form 'SN/nnnn-nnn', where 'n' is a digit.
	 *
	 * @param sn The serial number to test.
	 * @return true if the serial number is valid in form, false otherwise.
	 */
	public static boolean validSn(final String sn) {

		// check if the string starts with "SN/"
		if (sn.startsWith("SN/")) {
			// extracts part after "SN/"
			String numberPart = sn.substring(3);

			// checks if it matches the format ("nnnn-nnn")
			if (numberPart.length() == 8 && numberPart.charAt(4) == '-') {
				String firstPart = numberPart.substring(0, 4);
				String secondPart = numberPart.substring(5);

				// checks if both parts are all digits
				if (allDigits(firstPart) && allDigits(secondPart)) {
					return true;
				}
			}
		}

		// will return false if conditions aren't met
		return false;
	}

	/**
	 * Evaluates serial numbers from a file. Writes valid serial numbers to
	 * good_sns, and invalid serial numbers to bad_sns. Each line of fileIn contains
	 * a (possibly valid) serial number.
	 *
	 * @param fileIn  a file already open for reading
	 * @param goodSns a file already open for writing
	 * @param badSns  a file already open for writing
	 */
	public static void validSnFile(final Scanner fileIn, final PrintStream goodSns, final PrintStream badSns) {

		// loop through each line in the input file
		while (fileIn.hasNextLine()) {
			// reads the next line (serial number)
			String serialNumber = fileIn.nextLine();

			// checks if the serial number is valid
			if (validSn(serialNumber)) {
				// will write to the good serial numbers file
				goodSns.println(serialNumber);
			}

			else {
				// will write to the bad serial numbers file
				badSns.println(serialNumber);
			}
		}

		return;
	}

}
