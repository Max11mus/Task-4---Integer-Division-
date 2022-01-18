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
		ArrayList<Integer> digitsOfQuotient = new ArrayList<Integer>();
		ArrayList<Integer> producstOfDividerAndDigitOfQuotient = new ArrayList<Integer>();

		for (int i = 0; i < quotientString.length(); i++) {
			digitsOfQuotient.add(Character.digit(quotientString.charAt(i), 10));
		}

		for (int i = 0; i < digitsOfQuotient.size(); i++) {
			producstOfDividerAndDigitOfQuotient.add(divider * digitsOfQuotient.get(i));
		}

		int remainder = dividend % divider;
		int summ = 0;
		resultColumnDivision.add(paddingLeftWithSpaceChar(remainderString, dividendString.length() + 1));
		for (int i = digitsOfQuotient.size() - 1, rightMargin = dividendString.length() + 1; i >= 0; i--) {
			int product = producstOfDividerAndDigitOfQuotient.get(i);
			if (digitsOfQuotient.get(i) != 0) {
				summ = product + remainder;
				resultColumnDivision.add(0, paddingLeftWithSpaceChar(multipleHyphens(Integer.toString(product).length()), rightMargin));
				resultColumnDivision.add(0, paddingLeftWithSpaceChar(Integer.toString(product), rightMargin));
				resultColumnDivision.add(0, paddingLeftWithSpaceChar("_" + Integer.toString(summ), rightMargin));
				remainder = summ / 10;
			} else {
				remainder = remainder / 10;
			}
			rightMargin--;
		}

		String firstLineColumnDivision = "_" + dividendString + "|" + dividerString;
		resultColumnDivision.set(0, firstLineColumnDivision);

		if (divider > dividend) {
			resultColumnDivision.add(paddingLeftWithSpaceChar("0", dividendString.length() + 1));
		}
		String secondLineColumnDivision = resultColumnDivision.get(1);
		secondLineColumnDivision = paddingRightWithSpaceChar(secondLineColumnDivision, dividendString.length() + 1);
		secondLineColumnDivision += "|" + multipleHyphens(quotientString.length());
		resultColumnDivision.set(1, secondLineColumnDivision);

		if (divider > dividend) {
			resultColumnDivision.add(paddingLeftWithSpaceChar(multipleHyphens(dividendString.length()), dividendString.length() + 1));
		}
		String thirdLineColumnDivision = resultColumnDivision.get(2);
		thirdLineColumnDivision = paddingRightWithSpaceChar(resultColumnDivision.get(2), dividendString.length() + 1);
		thirdLineColumnDivision += "|" + quotientString;
		resultColumnDivision.set(2, thirdLineColumnDivision);

		if (divider > dividend) {
			resultColumnDivision.add(paddingLeftWithSpaceChar(remainderString, dividendString.length() + 1));
		}
		String lastLineColumnDivision = resultColumnDivision.get(resultColumnDivision.size() - 1);
		String penultLineColumnDivision = resultColumnDivision.get(resultColumnDivision.size() - 2);
		if (lastLineColumnDivision.length() > penultLineColumnDivision.length()) {
			lastLineColumnDivision = multipleZeroes(lastLineColumnDivision.length() - penultLineColumnDivision.length());
			lastLineColumnDivision += remainderString;
			lastLineColumnDivision = paddingLeftWithSpaceChar(lastLineColumnDivision, dividendString.length() + 1);
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

	private String paddingLeftWithSpaceChar(String input, int length) {
		if ((length < 0) || (toString().length() < length)) {
			return input;
		} else {
			return String.format("%1$" + length + "s", input);
		}
	}

	private String paddingRightWithSpaceChar(String input, int length) {
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

}
