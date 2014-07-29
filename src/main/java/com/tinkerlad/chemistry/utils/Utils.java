package com.tinkerlad.chemistry.utils;

public class Utils {

	public static String getSubScriptNumber(int number) {
		String subscript = "";
		String[] input = new String[2];
		if (number > 9) {
			input[0] = String.valueOf((Integer.toString(number)).charAt(0));
			input[1] = String.valueOf((Integer.toString(number)).charAt(1));
		} else {
			input[0] = (Integer.toString(number));
		}
		for (String string : input) {
			switch (number) {
				case 0:
					subscript += ("\u2080");
					break;
				case 1:
					subscript += ("\u2081");
					break;
				case 2:
					subscript += ("\u2082");
					break;
				case 3:
					subscript += ("\u2083");
					break;
				case 4:
					subscript += ("\u2084");
					break;
				case 5:
					subscript += ("\u2085");
					break;
				case 6:
					subscript += ("\u2086");
					break;
				case 7:
					subscript += ("\u2087");
					break;
				case 8:
					subscript += ("\u2088");
					break;
				case 9:
					subscript += ("\u2089");
					break;
			}
		}
		return subscript;
	}
}
