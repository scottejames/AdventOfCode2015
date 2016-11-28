package com.scottejames.advent.dayseven;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.scottejames.advent.utils.Utils;

public class DaySeven {
	public static HashMap<String, String> world = new HashMap<String, String>();
	public static HashMap<String, Integer> cache = new HashMap<String, Integer>();

	public static void addToWorld(String value, String expression) {
		world.put(value, expression);
	}

	public static int evaluateExpression(String expression) {
	
		int result = 0;
		System.out.println(" processing expression " + expression);
		String[] tokens = expression.split(" ");
		if (tokens.length == 1) { 
			if (Utils.isInteger(tokens[0])) 
				return Integer.parseInt(tokens[0]);
			else
				return findValue(tokens[0]);
					
		} else  if (tokens.length == 2) {
			if (Utils.isInteger(tokens[1])) {
				result = ~Integer.parseInt(tokens[1]);
				if (result < 0)
					result += 65536;

			} else {
				result = ~findValue(tokens[1]);
				if (result < 0)
					result += 65536;
			}
		} else {
			int l = 0;
			int r = 0;
			if (Utils.isInteger(tokens[0]))
				l = Integer.parseInt(tokens[0]);
			else
				l = findValue(tokens[0]);
			if (Utils.isInteger(tokens[2]))
				r = Integer.parseInt(tokens[2]);
			else
				r = findValue(tokens[2]);

			if (tokens[1].equals("AND"))
				result = l & r;
			else if (tokens[1].equals("OR"))
				result = l | r;
			else if (tokens[1].equals("LSHIFT"))
				result = l << r;
			else if (tokens[1].equals("RSHIFT"))
				result = l >> r;
		}

		return result;
	}

	public static Integer findValue(String value) {
	//	cache.put("b", new Integer(3176)); // Part Two
		if (cache.containsKey(value)) {
			System.out.println("found cached value " + value + " -> " + cache.get(value));
			return cache.get(value);
		}
		String expression = world.get(value);
		System.out.println("expression " + expression);

		if (Utils.isInteger(expression)) {
			cache.put( value,Integer.parseInt(expression));
			return Integer.parseInt(expression);
		} else{
		
			Integer res = evaluateExpression(expression);
			cache.put(value, res);
			return res;
		}
	}

	public static void main(String[] args) throws IOException {
		Path filePath = new File("bin/com/scottejames/advent/dayseven/Program.txt").toPath();
		System.out.println(filePath);
		Charset charset = Charset.defaultCharset();
		List<String> stringList = Files.readAllLines(filePath, charset);
		String[] stringArray = stringList.toArray(new String[] {});
		for (String command : stringArray) {
			// System.out.println("Storing: " + command);
			String patternText = "(.*) -> (.*)";
			Pattern pattern = Pattern.compile(patternText);
			Matcher matcher = pattern.matcher(command);
			matcher.matches();
			String lhs = matcher.group(1);
			String rhs = matcher.group(2);
			addToWorld(rhs, lhs);
		}
		// String s = "defghixy";
		// for (int i =0; i < s.length(); i++){
		// System.out.println ("for " + s.charAt(i) + " "+ findValue(""+
		// s.charAt(i)));
		//
		System.out.println("Answer:" + findValue("a"));

	}
}
