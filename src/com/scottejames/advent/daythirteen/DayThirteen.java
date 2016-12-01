package com.scottejames.advent.daythirteen;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Collections2;

public class DayThirteen {
	public static void main(String[] args) throws IOException {
		Path filePath = new File("target/classes/com/scottejames/advent/daythirteen/DayThirteenData.txt").toPath();
		System.out.println(filePath);
		Charset charset = Charset.defaultCharset();
		List<String> stringList = Files.readAllLines(filePath, charset);
		String[] stringArray = stringList.toArray(new String[] {});

		Set<String> people = new HashSet<String>();
		HashMap<String, Integer> happynessModifier = new HashMap<String, Integer>();
		people.add("ME");
		for (String s : stringArray) {
			// Alice would gain 54 happiness units by sitting next to Bob.
			String[] split = s.split(" ");
			String name = split[0];
			String direction = split[2];
			String subject = split[10].substring(0, split[10].length() - 1);
			int value = Integer.parseInt(split[3]);
			if (direction.equals("lose")) {
				value = value * -1;
			}
			people.add(name);
			happynessModifier.put(name + subject, value);

		}
		System.out.println(happynessModifier);
		Collection<List<String>> permutations = Collections2.permutations(people);
		int happyness[] = new int[permutations.size()];
		for (int i = 0; i < happyness.length; i++)
			happyness[i] = 0;
		int count = 0;
		for (List<String> perm : permutations) {
			// System.out.println("Considering PM: " + perm);

			for (int i = 0; i < perm.size() - 1; i++) {
				// System.out.println("For " + perm.get(i) + " to " +
				// perm.get(i+1) +" - "+ happynessModifier.get(perm.get(i) +
				// perm.get(i+1)));
				// System.out.println("For " + perm.get(i+1) + " to " +
				// perm.get(i) + " - "+ happynessModifier.get(perm.get(i+1) +
				// perm.get(i)));
				if ((!perm.get(i).equals("ME")) && (!perm.get(i + 1).equals("ME"))) {
					happyness[count] += happynessModifier.get(perm.get(i) + perm.get(i + 1));
					happyness[count] += happynessModifier.get(perm.get(i + 1) + perm.get(i));
				}
			}
			if ((!perm.get(0).equals("ME")) && (!perm.get(perm.size() - 1).equals("ME"))) {

				happyness[count] += happynessModifier.get(perm.get(0) + perm.get(perm.size() - 1));
				happyness[count] += happynessModifier.get(perm.get(perm.size() - 1) + perm.get(0));
			}
			// System.out.println("For perm " + perm + " Happy delta " +
			// happyness[count]);
			count++;

		}
		int min = Integer.MAX_VALUE;
		int max = 0;
		for (int i = 0; i < happyness.length; i++) {
			if (happyness[i] < min)
				min = happyness[i];
			if (happyness[i] > max)
				max = happyness[i];
		}
		System.out.println("Min :" + min);
		System.out.println("Max : " + max);
	}
}
