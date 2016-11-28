package com.scottejames.advent.dayfive;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

public class DayFive {
	public static boolean isNice(String s) {
		boolean result = false;

		boolean doubleResult = false;
		boolean trippleResult = false;
		
		for (int i = 0; i < s.length()-1; i++) {
			String match = s.substring(i,i+2);
//			System.out.println("looking for " + match);
			for (int j = i+2 ; j< s.length()-1; j++){
				String check = s.substring(j,j+2);
//				System.out.println("  checking for " + check);

				if (check.equals(match)){
//					System.out.println("found a match");
					doubleResult  = true;
				}
					
			}
		}
		for (int i = 0; i < s.length()-2; i++) {
			if (s.charAt(i) == s.charAt(i+2)){
//				System.out.println(" at "+ i+ " found " + s.substring(i,i+3));
				trippleResult = true;
			}
		}
		return doubleResult && trippleResult;
	}
	public static boolean isNiceOld(String s) {
		boolean result = false;
		int vowelCount = 0;
		boolean vowelCheck = false;
		boolean repeatCheck = false;
		boolean dodgeCheck = false;
		HashMap<Character, Integer> vowels = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			// Put chars into hash to check for vowels
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				vowelCount++;
//				System.out.println("Found vowel");
				if (vowelCount >= 3) vowelCheck=true;
			}
			if ((i + 1 < s.length()) && (s.charAt(i + 1) == c)) {
				repeatCheck = true;
//				System.out.println("Found repeat at " + i + " is " + c + "," + s.charAt(i+1));
			}
			if ((i + 1 < s.length())) {
				// ab cd pq xy
				if ((c == 'a' && s.charAt(i + 1) == 'b') || (c == 'c' && s.charAt(i + 1) == 'd')
						|| (c == 'p' && s.charAt(i + 1) == 'q') || (c == 'x' && s.charAt(i + 1) == 'y')) {
					dodgeCheck = true;
				}
			}
		}

//		System.out.println("Vowlcheck: " + vowelCheck + " Rc " + repeatCheck + " DC " + !dodgeCheck);
		return vowelCheck && repeatCheck && !dodgeCheck;
	}

	public static void main(String[] args) throws IOException {
//		if (isNice("ieodomkazucvgmuy"))
//			System.out.println("nice");
//		else
//			System.out.println("not nice");
		 Path filePath = new
		 File("bin/com/scottejames/advent/dayfive/DayFiveData.txt").toPath();
		 System.out.println(filePath);
		 Charset charset = Charset.defaultCharset();
		 List<String> stringList = Files.readAllLines(filePath, charset);
		 String[] stringArray = stringList.toArray(new String[] {});
		 int niceCount = 0;
		 for (String s : stringArray) {
			 if (isNice(s)) niceCount++;
		 }
		 System.out.println("There are " + niceCount + " words");
	}

}
