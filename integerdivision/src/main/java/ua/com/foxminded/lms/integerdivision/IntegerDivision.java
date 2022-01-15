package ua.com.foxminded.lms.integerdivision;

import java.util.ArrayList;

public class IntegerDivision {

	public String calculateColumnDivisionTwoPositiveNumbers(int dividend, int divider) {
		if (divider == 0) {
			throw new IllegalArgumentException("ERROR: Divider is Zero.");
		} else {
			if ((dividend < 0) || (divider < 0)) {
				throw new IllegalArgumentException("ERROR: Arguments are Negative.");
			} else {
				String dividendString = new String(String.valueOf(dividend));
				String rightMargin = new String(String.valueOf(divider));
				String quotient = new String(String.valueOf(dividend / divider));
				int numberOfDigitsQuotient = quotient.length();
				String remainder = new String(String.valueOf(dividend % divider));
				ArrayList<String> resultColumnDivision = new ArrayList<String>();

				int partOfDividend_Minuend = 0;
				int difference = 0 ;
				String differenceString = new String("0") ;
				
				for (int i = 0, leftMargin = 0, rightMargin = dividendString.length(); i < numberOfDigitsQuotient; i++) {
					int currentDigitInQuotient = Character.digit(quotient.charAt(i), 10);
					int productOfDividerAndCurentDigitInQuotient_Substrahend = divider * currentDigitInQuotient;
					
					rightMargin  =  leftMargin + getNumberOfDigitsPositiveInteger(productOfDividerAndCurentDigitInQuotient_Substrahend);

					partOfDividend_Minuend = Integer.parseInt(dividendString.substring(leftMargin, rightMargin));
					
					if (currentDigitInQuotient != 0) {
						
						if (partOfDividend_Minuend < productOfDividerAndCurentDigitInQuotient_Substrahend) {
							rightMargin++;
							partOfDividend_Minuend = Integer.parseInt(dividendString.substring(leftMargin, rightMargin));
						}
						
						difference = partOfDividend_Minuend - productOfDividerAndCurentDigitInQuotient_Substrahend;
						differenceString = new String(String.valueOf(difference));
						
						resultColumnDivision.add(paddingLeftWithSpaceChar(partOfDividend_Minuend, ) );

					} else {
						leftMargin++;
					}

				}

//				resultColumnDivision.add("_" + dividend + "|" + divider);				
				
				String expected = String.format("_123456789|1234%n" + " 1234     |------%n" + " ----     |100046%n"
						+ "    _5678%n" + "     4936%n" + "     ----%n" + "     _7429%n" + "      7404%n"
						+ "      ----%n" + "        25%n");
				System.out.println(expected);

				System.out.println(resultColumnDivision.get(0));

				return resultColumnDivision.get(0);

			}
		}
	}

	private int getNumberOfDigitsPositiveInteger(int x) {
		final int[] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE };

		for (int i = 0;; i++)
			if (x <= sizeTable[i])
				return i + 1;
	}

	private String paddingLeftWithSpaceChar(String input, int length) {
		if ((length < 0) || (toString().length() < length)) {
			return input;
		} else {
			return String.format("%1$" + length + "s", input);
		}
	}

}
