package com.scottejames.advent.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
	public static boolean isInteger(String str) {
		try {
			int d = Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public static int findMatches(String line, String pattern) {
		Matcher matcher = Pattern.compile(pattern).matcher(line);
		int matches = 0;
		while (matcher.find()) {
			matches++;
		}
		return matches;
	}
	
}
