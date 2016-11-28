package com.scottejames.advent.dayseven;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class DaySevenX {

	public static void main(String[] args) throws Exception {
	    Map<String, Integer> wires = new HashMap<>();
	    while (!wires.containsKey("a")) {
	        BufferedReader reader = new BufferedReader(new FileReader("bin/com/scottejames/advent/dayseven/Program.txt"));
	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] str = line.split(" ");
	            if (str.length == 3) {
	                if (Character.isDigit(str[0].charAt(0))) {
	                    wires.put(str[2], Integer.parseInt(str[0]));
	                } else if (wires.containsKey(str[0])) {
	                    wires.put(str[2], wires.get(str[0]));
	                }
	            } else if (str.length == 4) {
	                if (wires.containsKey(str[1])) {
	                    wires.put(str[3], ~wires.get(str[1]) & 0xFFFF);
	                }
	            } else if (str[1].endsWith("SHIFT")) {
	                if (wires.containsKey(str[0])) {
	                    int val = Integer.parseInt(str[2]);
	                    if (str[1].charAt(0) == 'R') {
	                        wires.put(str[4], wires.get(str[0]) >> val);
	                    } else {
	                        wires.put(str[4], wires.get(str[0]) << val);
	                    }
	                }
	            } else {
	                int val = -1;
	                if (Character.isDigit(str[0].charAt(0))) {
	                    val = Integer.parseInt(str[0]);
	                }
	                if ((val != -1 || wires.containsKey(str[0])) && wires.containsKey(str[2])) {
	                    if (str[1].equals("AND")) {
	                        wires.put(str[4], (val != -1 ? val : wires.get(str[0])) & wires.get(str[2]));
	                    } else {
	                        wires.put(str[4], (val != -1 ? val : wires.get(str[0])) | wires.get(str[2]));
	                    }
	                }
	            }
	        }
	        reader.close();
	    }
	    System.out.println(wires.get("a"));
	}

}
