package com.scottejames.advent.dayeleven;

public class DayEleven {
	public static String increment(String input) {
		char[] characters = input.toCharArray();
		boolean completed = false;
		for (int i = characters.length - 1; completed == false && i >= 0; i--) {
			if (characters[i] == 'z') {
				characters[i] = 'a';
				continue;
			} else {
				characters[i] = (char) (characters[i] + 1);
				completed = true;
			}
		}
		return new String(characters);
	}
	
	public static boolean validatePassword(String input){
		boolean tripple = input.matches(".*(abc|bcd|cde|def|efg|fgh|pqr|qrs|rst|stu|tuv|uvw|vwx|wxy|xyz).*");
		boolean dodgyLetters = !input.matches(".*(i|o|l).*");
		boolean dupe = input.matches(".*(.)\\1.*(.)\\2.*");

		return tripple && dodgyLetters && dupe;
	}

	public static void testIncrement() {
		String s = "xx";
		for (int i = 0; i < 100; i++) {
			System.out.print(s + " => ");
			s = increment(s);
			System.out.println(s);
		}

	}
	
	public static void testValidation(){
		if (validatePassword("xxxxxxefgxxxxxx")){
			System.out.println("Matched valid password");
		} else {
			System.out.println("FAIL!");
		}
	}

	public static void main(String[] args) {
		String password = "cqjxxyzz";
		password = increment(password);
		while (!validatePassword(password)) {
			password = increment(password);
		}
		System.out.println(password);

	}
}
