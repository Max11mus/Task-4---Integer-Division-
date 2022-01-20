package ua.com.foxminded.lms.integerdivision;

import java.util.ArrayList;
import java.util.Iterator;

public class IntegerDivision {
	public static final String END_OF_LINE = System.getProperty("line.separator");

	public String calculateColumnDivision(int dividend, int divider) {

		checkArguments(dividend, divider);

		ArrayList<String> resultColumnDivision = new ArrayList<String>();
		String dividendString = Integer.toString(dividend);
		String dividerString = Integer.toString(divider);
		String quotientString = Integer.toString(dividend / divider);
		String remainderString = Integer.toString(dividend % divider);
		ArrayList<Integer> digits = getDigitsOfQuotient(quotientString);
		ArrayList<Integer> products = getProducstOfDividerAndDigitOfQuotient(digits, divider);

		
		int remainder = dividend % divider;
		int summ = 0;
		resultColumnDivision.add(alignLeftWithSpace(remainderString, dividendString.length() + 1));
		for (int i = digits.size() - 1, rightMargin = dividendString.length() + 1; i >= 0; i--) {
			int product = products.get(i);
			if (digits.get(i) != 0) {
				summ = product + remainder;
				resultColumnDivision.add(0, alignLeftWithSpace(multipleHyphens(Integer.toString(product).length()), 
						rightMargin));
				resultColumnDivision.add(0, alignLeftWithSpace(Integer.toString(product), rightMargin));
				resultColumnDivision.add(0, alignLeftWithSpace("_" + Integer.toString(summ), rightMargin));
				remainder = summ / 10;
			} else {
				remainder = remainder / 10;
			}
			rightMargin--;
		}

		String firstLineColumnDivision = "_" + dividendString + "|" + dividerString;
		resultColumnDivision.set(0, firstLineColumnDivision);

		if (divider > dividend) {
			resultColumnDivision.add(alignLeftWithSpace("0", dividendString.length() + 1));
		}
		String secondLineColumnDivision = resultColumnDivision.get(1);
		secondLineColumnDivision = alignRightWithSpaceChar(secondLineColumnDivision, dividendString.length() + 1);
		secondLineColumnDivision += "|" + multipleHyphens(quotientString.length());
		resultColumnDivision.set(1, secondLineColumnDivision);

		if (divider > dividend) {
			resultColumnDivision.add(alignLeftWithSpace(multipleHyphens(dividendString.length()), 
					dividendString.length() + 1));
		}
		String thirdLineColumnDivision = resultColumnDivision.get(2);
		thirdLineColumnDivision = alignRightWithSpaceChar(resultColumnDivision.get(2), dividendString.length() + 1);
		thirdLineColumnDivision += "|" + quotientString;
		resultColumnDivision.set(2, thirdLineColumnDivision);

		if (divider > dividend) {
			resultColumnDivision.add(alignLeftWithSpace(remainderString, dividendString.length() + 1));
		}
		String lastLineColumnDivision = resultColumnDivision.get(resultColumnDivision.size() - 1);
		String penultLineColumnDivision = resultColumnDivision.get(resultColumnDivision.size() - 2);
		if (lastLineColumnDivision.length() > penultLineColumnDivision.length()) {
			lastLineColumnDivision = multipleZeroes(lastLineColumnDivision.length() - penultLineColumnDivision.length());
			lastLineColumnDivision += remainderString;
			lastLineColumnDivision = alignLeftWithSpace(lastLineColumnDivision, dividendString.length() + 1);
			resultColumnDivision.set(resultColumnDivision.size() - 1, lastLineColumnDivision);
		}

		return stringArrayToString(resultColumnDivision);

	}

	private void checkArguments(int dividend, int divider) {
		if (divider == 0) {
			throw new IllegalArgumentException("ERROR: Divider is Zero.");
		}
		if ((dividend < 0) || (divider < 0)) {
			throw new IllegalArgumentException("ERROR: Arguments are Negative.");
		}
	}

	private String stringArrayToString(ArrayList<String> stringArray) {
		String resultString = "";
		Iterator<String> iterator = stringArray.iterator();
		while (iterator.hasNext()) {
			resultString += iterator.next() + END_OF_LINE;
		}
		return resultString;
	}

	private String alignLeftWithSpace(String input, int length) {
		if ((length < 0) || (toString().length() < length)) {
			return input;
		} else {
			return String.format("%1$" + length + "s", input);
		}
	}

	private String alignRightWithSpaceChar(String input, int length) {
		if ((length < 0) || (toString().length() < length)) {
			return input;
		} else {
			return String.format("%1$-" + length + "s", input);
		}
	}

	private String multipleHyphens(int length) {
		if (length > 0) {
			return String.format("%1$" + length + "s", "-").replace(" ", "-");
		} else {
			return new String("");
		}
	}

	private String multipleZeroes(int length) {
		if (length > 0) {
			return String.format("%1$" + length + "s", "0").replace(" ", "0");
		} else {
			return new String("");
		}
	}

	private ArrayList<Integer> getDigitsOfQuotient(String quotientString) {
		ArrayList<Integer> digits = new ArrayList<Integer>();

		for (int i = 0; i < quotientString.length(); i++) {
			digits.add(Character.digit(quotientString.charAt(i), 10));
		}
		return digits;
	}

	private ArrayList<Integer> getProducstOfDividerAndDigitOfQuotient(ArrayList<Integer> digits, int divider) {
		ArrayList<Integer> producstOfDividerAndDigitOfQuotient = new ArrayList<Integer>();
		for (int i = 0; i < digits.size(); i++) {
			producstOfDividerAndDigitOfQuotient.add(divider * digits.get(i));
		}
		return producstOfDividerAndDigitOfQuotient;
	}

}
