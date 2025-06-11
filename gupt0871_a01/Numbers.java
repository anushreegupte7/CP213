package cp213;

/**
 * @author Anushree Gupte, 169050871
 * @version 2024-10-03
 */
public class Numbers {

	/**
	 * Determines closest value of two values to a target value.
	 *
	 * @param target the target value
	 * @param v1     first comparison value
	 * @param v2     second comparison value
	 * @return one of v1 or v2 that is closest to target, v1 is the value chosen if
	 *         v1 and v2 are an equal distance from target
	 */
	public static double closest(final double target, final double v1, final double v2) {

		// calculate the absolute difference between target and v1 and target and v2
		double diff1 = Math.abs(target - v1);
		double diff2 = Math.abs(target - v2);

		// return v1 if v1 is closer or they are equal in distance
		if (diff1 <= diff2) {
			return v1;
		}

		// return v2 if it is closer
		else if (diff1 > diff2) {
			return v2;
		}

		return 0.0;
	}

	/**
	 * Determines if n is a prime number. Prime numbers are whole numbers greater
	 * than 1, that have only two factors - 1 and the number itself. Prime numbers
	 * are divisible only by the number 1 or itself.
	 *
	 * @param n an integer
	 * @return true if n is prime, false otherwise
	 */
	public static boolean isPrime(final int n) {

		// prime numbers must be greater than 1
		if (n <= 1) {
			return false;
		}

		// check if n is divisible by any number from 2 to sqrt(n)
		for (int i = 2; i * i <= n; i++) {
			// n is not a prime number if its divisible by any number other than 1 or itself
			if (n % i == 0) {
				return false;
			}
		}

		// return true if no divisors were found meaning the number is a prime number
		if (n > 1) {
			return true;
		}

		return false;
	}

	/**
	 * Sums and returns the total of a partial harmonic series. This series is the
	 * sum of all terms 1/i, where i ranges from 1 to n (inclusive). Ex:
	 *
	 * n = 3: sum = 1/1 + 1/2 + 1/3 = 1.8333333333333333
	 *
	 * @param n an integer
	 * @return sum of partial harmonic series from 1 to n
	 */
	public static double sumPartialHarmonic(final int n) {

		// set sum value to 0.0
		double sum = 0.0;

		// iterate over all values from 1 to n
		for (int i = 1; i <= n; i++) {
			// add the reciprocal of i to the sum
			sum += 1.0 / i;
		}

		// return the sum of the harmonic series
		return sum;
	}

}
