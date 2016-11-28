package com.scottejames.advent.dayten;

public class DayTen {
	public static String lookAndSay(String look) {
//		System.out.print("Look " + look);
		StringBuffer say = new StringBuffer();
		if (look.length() == 1) {

			say.append( 1 + look);
		} else {
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i <= look.length() - 1; i++) {
				buffer.append("" + look.charAt(i));
				// System.out.println("Looking at " + " Buffer: " + buffer + "
				// Considering " + look.charAt(i));
				if ((i == look.length() - 1) || (look.charAt(i) != look.charAt(i + 1))) {
					// System.out.println("Addng " + buffer.length() +"|" +
					// buffer);
					say.append(buffer.length() + buffer.substring(0, 1));
					buffer = new StringBuffer();
				}
			}
		}
//		System.out.println(" Say " + say);
		return say.toString();
	}

	public static void main(String[] args) {
		String s = "1321131112";
		for (int i = 0; i < 50; i++) {

			s = lookAndSay(s);
		}
		System.out.println(s.length());
	}

}
