package com.scottejames.advent.daysix;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DaySix {

	static int sizeX = 1001;
	static int sizeY = 1001;
	static int[][] lights = new int[sizeX][sizeY];

	public static void initLights() {
		for (int i = 0; i <= sizeX; i++) {
			for (int j = 0; j <= sizeY; j++) {
				lights[i][j] = 0;
			}
		}
	}

	public static int countLights() {
		int count = 0;
		for (int i = 0; i < sizeX; i++) {
			for (int j = 0; j < sizeY; j++) {
				count += lights[i][j];
			}
		}
		return count;
	}
	public static int printLights() {
		int count = 0;
		for (int i = 0; i < sizeX; i++) {
			for (int j = 0; j < sizeY; j++) {
				System.out.print(" ["+ lights[i][j] + "] ");
			}
			System.out.println("");
		}
		return count;
	}

	public static void lightOn(int x, int y) {
		lights[x][y]++;
	}

	public static void lightOff(int x, int y) {
		lights[x][y]--;
		if (lights[x][y]<0) lights[x][y]=0;
	}

	public static void lightToggle(int x, int y) {
		lights[x][y] +=2;
	}

	public static void processInstruction(Instruction instr) {
		for (int i = instr.startX; i <= instr.endX; i++) {
			for (int j = instr.startY; j <= instr.endY; j++) {
				if (instr.action.equals("turn on")) {
					lightOn(i, j);
				} else if (instr.action.equals("turn off")) {
					lightOff(i, j);
				} else {
					lightToggle(i, j);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
//		String commandOne = "turn on 0,0 through 1,5";
//		String commandTwo = "toggle 0,0 through 999,0";
//		String commandThree = "turn off 499,499 through 500,500";
//		Instruction iOne = new Instruction(commandOne);
//		Instruction iTwo = new Instruction(commandTwo);
//		Instruction iThree = new Instruction(commandThree);
//		printLights();
//		System.out.println("");
//		processInstruction(iOne);
//		printLights();
		
		 Path filePath = new
		 File("bin/com/scottejames/advent/daysix/DaySixData.txt").toPath();
		 System.out.println(filePath);
		 Charset charset = Charset.defaultCharset();
		 List<String> stringList = Files.readAllLines(filePath, charset);
		 String[] stringArray = stringList.toArray(new String[] {});
		 int niceCount = 0;
		 for (String s : stringArray) {
			 processInstruction(new Instruction(s));
		 }
		 System.out.println("There are " + countLights() + " lights on");
	}

}
