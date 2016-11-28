package com.scottejames.advent.daysix;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Instruction{
	public String action = null;
	public int startX = 0;
	public int endX = 0;
	public int startY = 0;
	public int endY = 0;
	
	public Instruction(String i){
		//"turn on 0,0 through 999,999";
		//"toggle 0,0 through 999,0";
		//"turn off 499,499 through 500,500";
		String patternText="(turn on|turn off|toggle) (\\d+),(\\d+) through (\\d+),(\\d+)";
		Pattern pattern = Pattern.compile(patternText);
		Matcher matcher = pattern.matcher(i);
		matcher.matches();
		action = matcher.group(1);
		startX = Integer.parseInt(matcher.group(2));
		startY = Integer.parseInt(matcher.group(3));
		endX = Integer.parseInt(matcher.group(4));
		endY = Integer.parseInt(matcher.group(5));
	}
}
