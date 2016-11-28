package com.scottejames.advent.daynine;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Collections2;

public class DayNine {

	public static void main(String[] args) throws IOException {
		Path filePath = new File("target/classes/com/scottejames/advent/daynine/DayNineData.txt").toPath();
		System.out.println(filePath);
		Charset charset = Charset.defaultCharset();

		List<String> stringList = Files.readAllLines(filePath, charset);

		String[] stringArray = stringList.toArray(new String[] {});
		
		Set<String> places = new HashSet<String>();
		HashMap<String, Integer> costs = new HashMap<String, Integer>();
		
		for (String s : stringArray) {
			// London to Dublin = 464
			String[] tokens = s.split(" ");
			places.add(tokens[0]);
			places.add(tokens[2]);
			costs.put(tokens[0] + tokens[2], Integer.parseInt(tokens[4]));
			costs.put(tokens[2] + tokens[0], Integer.parseInt(tokens[4]));

		}
		int min = Integer.MAX_VALUE;
		int max = 0;
		for (List<String> perm : Collections2.permutations(places)) {
			int length = 0;
			for (int i = 0; i < perm.size() - 1; i++) {
				length += costs.get(perm.get(i) + perm.get(i + 1));
			}
			if (length < min) {
				min = length;
			}
			if (length > max) {
				max = length;
			}
			for (String p : perm) {
				System.out.print(p + " ");
			}
			System.out.println(" = " + length);

		}
		System.out.println("Max: " + max);
		System.out.println("Min: " + min);
	}

}
