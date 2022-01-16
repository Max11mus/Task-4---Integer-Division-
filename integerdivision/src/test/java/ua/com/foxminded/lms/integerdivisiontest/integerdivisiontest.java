package ua.com.foxminded.lms.integerdivisiontest;

import static org.junit.jupiter.api.Assertions.*;
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
		assertThrows(IllegalArgumentException.class, () -> integerDivision.calculateColumnDivisionTwoPositiveNumbers(100, 0),
				"Must throw IllegalArgumentException exception when divider is sZero.");
	}

	@Test
	void calculateColumnDivisionTwoPositiveNumbers_mustThrowIllegalArgumentException_whenArgumentsAreNegative() {
		assertThrows(IllegalArgumentException.class, () -> integerDivision.calculateColumnDivisionTwoPositiveNumbers(-100, -50),
				"Must throw IllegalArgumentException exception when arguments are negative.");
	}
	
	@Test
	void calculateColumnDivisionTwoPositiveNumbers_mustReturnSolution_whenDividendGreaterThenDivider() {
		String expected = "_666846|56\r\n"
						+ " 56    |-----\r\n"
						+ " --    |11907\r\n"
						+ "_106\r\n"
						+ "  56\r\n"
						+ "  --\r\n"
						+ " _508\r\n"
						+ "  504\r\n"
						+ "  ---\r\n"
						+ "   _446\r\n"
						+ "    392\r\n"
						+ "    ---\r\n"
						+ "     54\r\n";
		String actual = integerDivision.calculateColumnDivisionTwoPositiveNumbers(666846,56);
		
		assertEquals(expected, actual, "Must return solution when dividend greater then divider.");
	}
	
	
	@Test
	void calculateColumnDivisionTwoPositiveNumbers_mustReturnSolution_whenDividendLessThenDivider() {
		String expected = "_56|666846\r\n"
						+ "  0|-\r\n"
						+ " --|0\r\n"
						+ " 56\r\n";
		String actual = integerDivision.calculateColumnDivisionTwoPositiveNumbers(56,666846);
		
		assertEquals(expected, actual, "Must return solution when dividend less then divider.");
	}

	@Test
	void calculateColumnDivisionTwoPositiveNumbers_mustReturnSolution_whenDividendIsZero() {
		String expected = "_0|999\r\n"
						+ " 0|-\r\n"
						+ " -|0\r\n"
						+ " 0\r\n";
		String actual = integerDivision.calculateColumnDivisionTwoPositiveNumbers(0,999);
		
		assertEquals(expected, actual, "Must return solution when when dividend is zero.");
	}
	
	@Test
	void calculateColumnDivisionTwoPositiveNumbers_mustReturnSolution_whenDividerIsOne() {
		String expected = "_78654|1\r\n"
						+ " 7    |-----\r\n"
						+ " -    |78654\r\n"
						+ " _8\r\n"
						+ "  8\r\n"
						+ "  -\r\n"
						+ "  _6\r\n"
						+ "   6\r\n"
						+ "   -\r\n"
						+ "   _5\r\n"
						+ "    5\r\n"
						+ "    -\r\n"
						+ "    _4\r\n"
						+ "     4\r\n"
						+ "     -\r\n"
						+ "     0\r\n";
		String actual = integerDivision.calculateColumnDivisionTwoPositiveNumbers(78654,1);
		
		assertEquals(expected, actual, "Must return solution when divider is one.");
	}
	
	@Test
	void calculateColumnDivisionTwoPositiveNumbers_mustReturnSolution_whenDividerIsOneDigit() {
		String expected = "_97654321|7\r\n"
						+ " 7       |--------\r\n"
						+ " -       |13950617\r\n"
						+ "_27\r\n"
						+ " 21\r\n"
						+ " --\r\n"
						+ " _66\r\n"
						+ "  63\r\n"
						+ "  --\r\n"
						+ "  _35\r\n"
						+ "   35\r\n"
						+ "   --\r\n"
						+ "    _43\r\n"
						+ "     42\r\n"
						+ "     --\r\n"
						+ "     _12\r\n"
						+ "       7\r\n"
						+ "       -\r\n"
						+ "      _51\r\n"
						+ "       49\r\n"
						+ "       --\r\n"
						+ "        2\r\n";
		String actual = integerDivision.calculateColumnDivisionTwoPositiveNumbers(97654321,7);
		
		assertEquals(expected, actual, "Must return solution when divider is one digit.");
	}

	
	@Test
	void calculateColumnDivisionTwoPositiveNumbers_mustReturnSolution_whenQuotientHasTrailingZeroes() {
		String expected = "_1111000001|11\r\n"
						+ " 11        |---------\r\n"
						+ " --        |101000000\r\n"
						+ "  _11\r\n"
						+ "   11\r\n"
						+ "   --\r\n"
						+ "    0000001\r\n";
				
		String actual = integerDivision.calculateColumnDivisionTwoPositiveNumbers(1111000001,11);

		assertEquals(expected, actual, "Must return solution when quotient has trailing zeroes.");
	}


}
