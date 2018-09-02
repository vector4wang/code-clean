package 类;

public class Demo1023 {
}

public class PrintPrimes {

	public static void main(String[] args) {
		final int M = 1000;
		final int RR = 50;
		final int CC = 4;
		final int WW = 10;
		final int ORDMAX = 30;
		int P[] = new int[M + 1];
		int PAGENUMBER;
		int PAGEOFFSET;
		int ROWOFFSET;
		int C;
		int J;
		int K;
		boolean JPRIME;
		int ORD;
		int SQUARE;
		int N;
		int MULT[] = new int[ORDMAX + 1];
		J = 1;
		K = 1;
		P[1] = 2;
		ORD = 2;
		SQUARE = 9;
		while (K < M) {
			do {
				J = J + 2;
				if (J == SQUARE) {
					ORD = ORD + 1;
					SQUARE = P[ORD] * P[ORD];
					MULT[ORD - 1] = J;
				}
				N = 2;
				JPRIME = true;
				while (N < ORD && JPRIME) {
					while (MULT[N] < J)
						MULT[N] = MULT[N] + P[N] + P[N];
					if (MULT[N] == J)
						JPRIME = false;
					N = N + 1;

				}

			} while (!JPRIME);
			K = K + 1;
			P[K] = J;

		}
		{
			PAGENUMBER = 1;
			PAGEOFFSET = 1;
			while (PAGEOFFSET <= M) {
				System.out.println("The First " + M + " Prime Numbers --- Page " + PAGENUMBER);
				System.out.println("");
				for (ROWOFFSET = PAGEOFFSET; ROWOFFSET < PAGEOFFSET + RR; ROWOFFSET++) {
					for (C = 0; C < CC; C++)
						if (ROWOFFSET + C * RR <= M)
							System.out.format("%10d", P[ROWOFFSET + C * RR]);
					System.out.println("");

				}
				System.out.println("\f");
				PAGENUMBER = PAGENUMBER + 1;
				PAGEOFFSET = PAGEOFFSET + RR * CC;

			}

		}

	}

}
===============================================================================
public class PrimePrinter {

	public static void main(String[] args) {
		final int NUMBER_OF_PRIMES = 1000;
		int[] primes = PrimeGenerator.generate(NUMBER_OF_PRIMES);
		final int ROWS_PER_PAGE = 50;
		final int COLUMNS_PER_PAGE = 4;
		RowColumnPagePrinter tablePrinter = new RowColumnPagePrinter(ROWS_PER_PAGE, COLUMNS_PER_PAGE,
				"The First " + NUMBER_OF_PRIMES + " Prime Numbers");
		tablePrinter.print(primes);

	}

}

public class RowColumnPagePrinter {

	private int rowsPerPage;

	private int columnsPerPage;

	private int numbersPerPage;

	private String pageHeader;

	private PrintStream printStream;

	public RowColumnPagePrinter(int rowsPerPage, int columnsPerPage, String pageHeader) {
		this.rowsPerPage = rowsPerPage;
		this.columnsPerPage = columnsPerPage;
		this.pageHeader = pageHeader;
		numbersPerPage = rowsPerPage * columnsPerPage;
		printStream = System.out;

	}

	public void print(int data[]) {
		int pageNumber = 1;
		for (int firstIndexOnPage = 0; firstIndexOnPage < data.length; firstIndexOnPage += numbersPerPage) {
			int lastIndexOnPage = Math.min(firstIndexOnPage + numbersPerPage - 1, data.length - 1);
			printPageHeader(pageHeader, pageNumber);
			printPage(firstIndexOnPage, lastIndexOnPage, data);
			printStream.println("\f");
			pageNumber++;

		}

	}

	private void printPage(int firstIndexOnPage, int lastIndexOnPage, int[] data) {
		int firstIndexOfLastRowOnPage = firstIndexOnPage + rowsPerPage - 1;
		for (int firstIndexInRow = firstIndexOnPage; firstIndexInRow <= firstIndexOfLastRowOnPage; firstIndexInRow++) {
			printRow(firstIndexInRow, lastIndexOnPage, data);
			printStream.println("");

		}

	}

	private void printRow(int firstIndexInRow, int lastIndexOnPage, int[] data) {
		for (int column = 0; column < columnsPerPage; column++) {
			int index = firstIndexInRow + column * rowsPerPage;
			if (index <= lastIndexOnPage)
				printStream.format("%10d", data[index]);

		}

	}

	private void printPageHeader(String pageHeader, int pageNumber) {
		printStream.println(pageHeader + " --- Page " + pageNumber);
		printStream.println("");

	}

	public void setOutput(PrintStream printStream) {
		this.printStream = printStream;

	}

}

public class PrimeGenerator {

	private static int[] primes;

	private static ArrayList<Integer> multiplesOfPrimeFactors;

	protected static int[] generate(int n) {
		primes = new int[n];
		multiplesOfPrimeFactors = new ArrayList<Integer>();
		set2AsFirstPrime();
		checkOddNumbersForSubsequentPrimes();
		return primes;

	}

	private static void set2AsFirstPrime() {
		primes[0] = 2;
		multiplesOfPrimeFactors.add(2);

	}

	private static void checkOddNumbersForSubsequentPrimes() {
		int primeIndex = 1;
		for (int candidate = 3; primeIndex < primes.length; candidate += 2) {
			if (isPrime(candidate))
				primes[primeIndex++] = candidate;

		}

	}

	private static boolean isPrime(int candidate) {
		if (isLeastRelevantMultipleOfNextLargerPrimeFactor(candidate)) {
			multiplesOfPrimeFactors.add(candidate);
			return false;

		}
		return isNotMultipleOfAnyPreviousPrimeFactor(candidate);

	}

	private static boolean isLeastRelevantMultipleOfNextLargerPrimeFactor(int candidate) {
		int nextLargerPrimeFactor = primes[multiplesOfPrimeFactors.size()];
		int leastRelevantMultiple = nextLargerPrimeFactor * nextLargerPrimeFactor;
		return candidate == leastRelevantMultiple;

	}

	private static boolean isNotMultipleOfAnyPreviousPrimeFactor(int candidate) {
		for (int n = 1; n < multiplesOfPrimeFactors.size(); n++) {
			if (isMultipleOfNthPrimeFactor(candidate, n))
				return false;

		}
		return true;
	}

	private static boolean isMultipleOfNthPrimeFactor(int candidate, int n) {
		return candidate == smallestOddNthMultipleNotLessThanCandidate(candidate, n);

	}

	private static int smallestOddNthMultipleNotLessThanCandidate(int candidate, int n) {
		int multiple = multiplesOfPrimeFactors.get(n);
		while (multiple < candidate)
			multiple += 2 * primes[n];
		multiplesOfPrimeFactors.set(n, multiple);
		return multiple;

	}

}