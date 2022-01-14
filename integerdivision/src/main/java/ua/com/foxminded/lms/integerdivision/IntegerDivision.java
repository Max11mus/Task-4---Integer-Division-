package ua.com.foxminded.lms.integerdivision;

public class IntegerDivision {

	public String calculateColumnDivisionTwoPositiveNumbers(int dividend, int divider) {
		if (divider == 0) {
			throw new IllegalArgumentException("ERROR: Divider is Zero.");
			} 
		else
			{
			if ((dividend <0) || (divider <0)) {
				throw new IllegalArgumentException("ERROR: Arguments are Negative.");	
				} 
			else
				{
				int numberOfDigitsDividend = numberOfDigitsPositiveNumber(dividend);
				int numberOfDigitsDivider = numberOfDigitsPositiveNumber(divider);
				String quotient = new String(String.valueOf(dividend/divider));
				int numberOfDigitsQuotient = quotient.length() + 1;
				String remainder = new String(String.valueOf(dividend%divider));
				
				String result = new String("_" + dividend + "|" + divider + "\n");
				int currentLineInResult = 1;
				
				for (int i = 0; i < quotient.length(); i++) {
					int curentDigitInQuotient = Character.digit(quotient.charAt(i), 10);  
					
					if (curentDigitInQuotient != 0) {
						String productCurentDigitInQuotientAndDivider = 
					}
				}
				
					
				String expected = String
		                .format("_123456789|1234%n" +
		                        " 1234     |------%n" +
		                        " ----     |100046%n" +
		                        "    _5678%n" +
		                        "     4936%n" +
		                        "     ----%n" +
		                        "     _7429%n" +
		                        "      7404%n" +
		                        "      ----%n" +
		                        "        25%n");
				System.out.println(expected);
				
				System.out.println(result);
				
				return result;
		
				}
			}
	}

	private int numberOfDigitsPositiveNumber(int x) {
		final int[] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 
				9999999, 99999999, 999999999, Integer.MAX_VALUE };

		for (int i = 0; ;i++)
			if (x <= sizeTable[i])
				return i + 1;
	}

}
