package ua.com.foxminded.lms.integerdivisiontest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.com.foxminded.lms.integerdivision.IntegerDivision;

class IntegerDivisionTest {
	static IntegerDivision integerDivision;

	@BeforeAll
	static void integerDivisionTestSetUp() {
		integerDivision = new IntegerDivision();
	}

	@Test
	void calculateColumnDivisionTwoPositiveNumbers_mustThrowIllegalArgumentException_whenDividerIsZero() {
		assertThrows(IllegalArgumentException.class, () -> integerDivision.calculateColumnDivision(100, 0),
				"Must throw IllegalArgumentException exception when divider is sZero.");
	}

	@Test
	void calculateColumnDivisionTwoPositiveNumbers_mustThrowIllegalArgumentException_whenArgumentsAreNegative() {
		assertThrows(IllegalArgumentException.class, () -> integerDivision.calculateColumnDivision(-100, -50),
				"Must throw IllegalArgumentException exception when arguments are negative.");
	}
	
	@Test
	void calculateColumnDivisionTwoPositiveNumbers_mustReturnSolution_whenDividendGreaterThenDivider() {
		String expected = "_666846|56" + IntegerDivision.END_OF_LINE
						+ " 56    |-----" + IntegerDivision.END_OF_LINE
						+ " --    |11907" + IntegerDivision.END_OF_LINE
						+ "_106" + IntegerDivision.END_OF_LINE
						+ "  56" + IntegerDivision.END_OF_LINE
						+ "  --" + IntegerDivision.END_OF_LINE
						+ " _508" + IntegerDivision.END_OF_LINE
						+ "  504" + IntegerDivision.END_OF_LINE
						+ "  ---" + IntegerDivision.END_OF_LINE
						+ "   _446" + IntegerDivision.END_OF_LINE
						+ "    392" + IntegerDivision.END_OF_LINE
						+ "    ---" + IntegerDivision.END_OF_LINE
						+ "     54" + IntegerDivision.END_OF_LINE;
		String actual = integerDivision.calculateColumnDivision(666846,56);
		
		assertEquals(expected, actual, "Must return solution when dividend greater then divider.");
	}
	
	
	@Test
	void calculateColumnDivisionTwoPositiveNumbers_mustReturnSolution_whenDividendLessThenDivider() {
		String expected = "_56|666846" + IntegerDivision.END_OF_LINE
						+ "  0|-" + IntegerDivision.END_OF_LINE
						+ " --|0" + IntegerDivision.END_OF_LINE
						+ " 56" + IntegerDivision.END_OF_LINE;
		String actual = integerDivision.calculateColumnDivision(56,666846);
		
		assertEquals(expected, actual, "Must return solution when dividend less then divider.");
	}

	@Test
	void calculateColumnDivisionTwoPositiveNumbers_mustReturnSolution_whenDividendIsZero() {
		String expected = "_0|999" + IntegerDivision.END_OF_LINE
						+ " 0|-" + IntegerDivision.END_OF_LINE
						+ " -|0" + IntegerDivision.END_OF_LINE
						+ " 0" + IntegerDivision.END_OF_LINE;
		String actual = integerDivision.calculateColumnDivision(0,999);
		
		assertEquals(expected, actual, "Must return solution when when dividend is zero.");
	}
	
	@Test
	void calculateColumnDivisionTwoPositiveNumbers_mustReturnSolution_whenDividerIsOne() {
		String expected = "_78654|1" + IntegerDivision.END_OF_LINE
						+ " 7    |-----" + IntegerDivision.END_OF_LINE
						+ " -    |78654" + IntegerDivision.END_OF_LINE
						+ " _8" + IntegerDivision.END_OF_LINE
						+ "  8" + IntegerDivision.END_OF_LINE
						+ "  -" + IntegerDivision.END_OF_LINE
						+ "  _6" + IntegerDivision.END_OF_LINE
						+ "   6" + IntegerDivision.END_OF_LINE
						+ "   -" + IntegerDivision.END_OF_LINE
						+ "   _5" + IntegerDivision.END_OF_LINE
						+ "    5" + IntegerDivision.END_OF_LINE
						+ "    -" + IntegerDivision.END_OF_LINE
						+ "    _4" + IntegerDivision.END_OF_LINE
						+ "     4" + IntegerDivision.END_OF_LINE
						+ "     -" + IntegerDivision.END_OF_LINE
						+ "     0" + IntegerDivision.END_OF_LINE;
		String actual = integerDivision.calculateColumnDivision(78654,1);
		
		assertEquals(expected, actual, "Must return solution when divider is one.");
	}
	
	@Test
	void calculateColumnDivisionTwoPositiveNumbers_mustReturnSolution_whenDividerIsOneDigit() {
		String expected = "_97654321|7" + IntegerDivision.END_OF_LINE
						+ " 7       |--------" + IntegerDivision.END_OF_LINE
						+ " -       |13950617" + IntegerDivision.END_OF_LINE
						+ "_27" + IntegerDivision.END_OF_LINE
						+ " 21" + IntegerDivision.END_OF_LINE
						+ " --" + IntegerDivision.END_OF_LINE
						+ " _66" + IntegerDivision.END_OF_LINE
						+ "  63" + IntegerDivision.END_OF_LINE
						+ "  --" + IntegerDivision.END_OF_LINE
						+ "  _35" + IntegerDivision.END_OF_LINE
						+ "   35" + IntegerDivision.END_OF_LINE
						+ "   --" + IntegerDivision.END_OF_LINE
						+ "    _43" + IntegerDivision.END_OF_LINE
						+ "     42" + IntegerDivision.END_OF_LINE
						+ "     --" + IntegerDivision.END_OF_LINE
						+ "     _12" + IntegerDivision.END_OF_LINE
						+ "       7" + IntegerDivision.END_OF_LINE
						+ "       -" + IntegerDivision.END_OF_LINE
						+ "      _51" + IntegerDivision.END_OF_LINE
						+ "       49" + IntegerDivision.END_OF_LINE
						+ "       --" + IntegerDivision.END_OF_LINE
						+ "        2" + IntegerDivision.END_OF_LINE;
		String actual = integerDivision.calculateColumnDivision(97654321,7);
		
		assertEquals(expected, actual, "Must return solution when divider is one digit.");
	}

	
	@Test
	void calculateColumnDivisionTwoPositiveNumbers_mustReturnSolution_whenQuotientHasTrailingZeroes() {
		String expected = "_1111000001|11" + IntegerDivision.END_OF_LINE
						+ " 11        |---------" + IntegerDivision.END_OF_LINE
						+ " --        |101000000" + IntegerDivision.END_OF_LINE
						+ "  _11" + IntegerDivision.END_OF_LINE
						+ "   11" + IntegerDivision.END_OF_LINE
						+ "   --" + IntegerDivision.END_OF_LINE
						+ "    0000001" + IntegerDivision.END_OF_LINE;
				
		String actual = integerDivision.calculateColumnDivision(1111000001, 11);

		assertEquals(expected, actual, "Must return solution when quotient has trailing zeroes.");
	}

}
