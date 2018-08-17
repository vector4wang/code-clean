package 注释;

/**
 * @author vector
 * @Data 2018/8/17 0017
 * @Description 范例
 */
public class Demo4419 {
}

/**
 * This class Generates prime numbers up to a user specified
 * maximum. The algorithm used is the Sieve of Eratosthenes.
 * <p>
 * Eratosthenes of Cyrene, b. c. 276 BC, Cyrene, Libya --
 * d. c. 194, Alexandria. The first man to calculate the
 * circumference of the Earth. Also known for working on
 * calendars with leap years and ran the library at Alexandria.
 * <p>
 * The algorithm is quite simple. Given an array of integers
 * starting at 2. Cross out all multiples of 2. Find the next
 * uncrossed integer, and cross out all of its multiples.
 * Repeat untilyou have passed the square root of the maximum
 * value.
 *
 * @author Alphonse
 * @version 13 Feb 2002 atp
 */
class GeneratePrimes {

	/**

	 * @param maxValue is the generation limit.

	 */
	public static int[] generatePrimes(int maxValue) {
		if (maxValue >= 2) // the only valid case
		{
			// declarations
			int s = maxValue + 1; // size of array
			boolean[] f = new boolean[s];
			int i;
			// initialize array to true.
			for (i = 0; i < s; i++)
				f[i] = true;
			// get rid of known non-primes
			f[0] = f[1] = false;
			// sieve
			int j;
			for (i = 2; i < Math.sqrt(s) + 1; i++) {
				if (f[i]) // if i is uncrossed, cross its multiples.
				{
					for (j = 2 * i; j < s; j += i)
						f[j] = false; // multiple is not prime

				}

			}
			// how many primes are there?
			int count = 0;
			for (i = 0; i < s; i++) {
				if (f[i])
					count++; // bump count.

			}
			int[] primes = new int[count];
			// move the primes into the result
			for (i = 0, j = 0; i < s; i++) {
				if (f[i]) // if prime
					primes[j++] = i;

			}
			return primes; // return the primes

		} else // maxValue < 2
			return new int[0]; // return null array if bad input.
	}

}

/**

 * This class Generates prime numbers up to a user specified
 * maximum. The algorithm used is the Sieve of Eratosthenes.
 * Given an array of integers starting at 2:
 * Find the first uncrossed integer, and cross out all its
 * multiples. Repeat until there are no more multiples
 * in the array.
 */
public class PrimeGenerator2 {

	private static boolean[] crossedOut;

	private static int[] result;

	public static int[] generatePrimes(int maxValue) {
		if (maxValue < 2)
			return new int[0];
		else {
			uncrossIntegersUpTo(maxValue);
			crossOutMultiples();
			putUncrossedIntegersIntoResult();
			return result;

		}

	}

	private static void uncrossIntegersUpTo(int maxValue) {
		crossedOut = new boolean[maxValue + 1];
		for (int i = 2; i < crossedOut.length; i++)
			crossedOut[i] = false;

	}

	private static void crossOutMultiples() {
		int limit = determineIterationLimit();
		for (int i = 2; i <= limit; i++)
			if (notCrossed(i))
				crossOutMultiplesOf(i);

	}

	private static int determineIterationLimit() {
		// Every multiple in the array has a prime factor that
		// is less than or equal to the root of the array size,
		// so we don't have to cross out multiples of numbers
		// larger than that root.
		double iterationLimit = Math.sqrt(crossedOut.length);
		return (int) iterationLimit;

	}

	private static void crossOutMultiplesOf(int i) {
		for (int multiple = 2 * i; multiple < crossedOut.length; multiple += i)
			crossedOut[multiple] = true;

	}

	private static boolean notCrossed(int i) {
		return crossedOut[i] == false;

	}

	private static void putUncrossedIntegersIntoResult() {
		result = new int[numberOfUncrossedIntegers()];
		for (int j = 0, i = 2; i < crossedOut.length; i++)
			if (notCrossed(i))
				result[j++] = i;

	}

	private static int numberOfUncrossedIntegers() {
		int count = 0;
		for (int i = 2; i < crossedOut.length; i++)
			if (notCrossed(i))
				count++;
		return count;

	}

}