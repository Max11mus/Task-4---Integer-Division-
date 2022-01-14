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
	void calculateColumnDivisionTwoPositiveNumbers_throwIllegalArgumentException_dividerIsZero() {
		assertThrows(IllegalArgumentException.class, () -> integerDivision.calculateColumnDivisionTwoPositiveNumbers(100, 0),
				"Must throw IllegalArgumentException exception when divider is sZero.");
	}

	@Test
	void calculateColumnDivisionTwoPositiveNumbers_throwIllegalArgumentException_argumentsAreNegative() {
		assertThrows(IllegalArgumentException.class, () -> integerDivision.calculateColumnDivisionTwoPositiveNumbers(-100, -50),
				"Must throw IllegalArgumentException exception when arguments are negative.");
	}
	
	@Test
	void calculateColumnDivisionTwoPositiveNumbers_mustReturnSolution_dividendGreaterThenDivider() {
		String expected = "";
		String actual = integerDivision.calculateColumnDivisionTwoPositiveNumbers(100,33);

		assertEquals(expected, actual, "Must return empty string when input empty string.");
	}
}
