package com.scottejames.advent.dayeight;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayEight {
	public static int countStrings(String s) {
		s = s.trim(); // clean things up.
		s = s.substring(1, s.length() - 1);
//		System.out.println("processing " + s);
		// Count backslashes
		int backSlash = findMatches(s, "\\\\\\\\");
//		System.out.println("Found " + backSlash + " backslashes");
		int escapedQuote = findMatches(s, "\\\\\"");
//		System.out.println("Found " + escapedQuote + " quotes");
		int hex = findMatches(s, "\\\\x[0-9a-fA-F][0-9a-fA-F]");
//		System.out.println("Found " + hex + " hex");

		return s.length() - backSlash - escapedQuote - (hex *3);
	}
	public static int countEncodeStrings(String s) {
		s = s.trim(); // clean things up.
		s = s.substring(1, s.length() - 1);
//		System.out.println("processing " + s);
		// Count backslashes
		int backSlash = findMatches(s, "\\\\\\\\");
//		System.out.println("Found " + backSlash + " backslashes");
		int escapedQuote = findMatches(s, "\\\\\"");
//		System.out.println("Found " + escapedQuote + " quotes");
		int hex = findMatches(s, "\\\\x[0-9a-fA-F][0-9a-fA-F]");
//		System.out.println("Found " + hex + " hex");
		return s.length() + 6 + (backSlash * 2) + (escapedQuote *2) + hex;
	}
	private static int findMatches(String line, String pattern) {
		Matcher matcher = Pattern.compile(pattern).matcher(line);
		int matches = 0;
		while (matcher.find()) {
			matches++;
		}
		return matches;
	}

	public static void main(String[] args) throws IOException {
		Path filePath = new File("bin/com/scottejames/advent/dayeight/Data.txt").toPath();
		System.out.println(filePath);
		Charset charset = Charset.defaultCharset();
		List<String> stringList = Files.readAllLines(filePath, charset);
		String[] stringArray = stringList.toArray(new String[] {});
		int storedCount = 0;
		int printCount = 0;
		int encodeString = 0;
		for (String s : stringArray) {
			storedCount += s.length();
			printCount += countStrings(s);
			encodeString += countEncodeStrings(s);
		}
		System.out.println(  storedCount -printCount);
		System.out.println(   encodeString - storedCount);
	}
}
