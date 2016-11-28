package com.scottejames.advent.daytwo;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class DayTwo {

	public static void main(String[] args) throws IOException {
		Path filePath = new File("bin/com/scottejames/advent/daytwo/day-two-data.txt").toPath();
		System.out.println(filePath);
		Charset charset = Charset.defaultCharset();
		List<String> stringList = Files.readAllLines(filePath, charset);
		String[] stringArray = stringList.toArray(new String[] {});
		int totalSize = 0;
		int ribbonSize = 0;

		for (String s : stringArray) {
			System.out.println(s);
			String[] parts = s.split("x");
			int l = Integer.parseInt(parts[0]);
			int w = Integer.parseInt(parts[1]);
			int h = Integer.parseInt(parts[2]);

			Integer sides[] = new Integer[3];
			sides[0] = l * w;
			sides[1] = w * h;
			sides[2] = h * l;

			int smallest = sides[0];
			for (int i = 1; i < sides.length; i++) {
				if (sides[i] < smallest)
					smallest = sides[i];
			}

			totalSize += 2 * sides[0] + 2 * sides[1] + 2 * sides[2] + smallest;

			if (l >= w && l >= h)
				ribbonSize += 2 * w + 2 * h;
			else if (w >= h && w >= l)
				ribbonSize += 2 * h + 2 * l;
			else if (h >= w && h >= l)
				ribbonSize += 2 * w + 2 * l;
			ribbonSize += l * w *h;

		}
		System.out.println("Total: " + totalSize);
		System.out.println("Ribbon: " + ribbonSize);
	}
}
