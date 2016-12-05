package com.scottejames.advent.dayforteen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.scottejames.advent.utils.Utils;

public class DayForteen {
	public static void main(String[] args) throws IOException {

		// Reindeer commet = new Reindeer("commet", 10, 127, 14);
		// Reindeer dancer = new Reindeer("dancer", 11, 162, 16);
		// for (int i = 0; i < 1000; i++) {
		// commet.tic();
		// dancer.tic();
		// }
		// System.out.println("Commet has travelled " + commet.getDistance());
		// System.out.println("Dancer has travelled " + dancer.getDistance());
		String[] stringList = Utils.readFile("/dayforteen/SimpleData.txt");
		List<Reindeer> reindeer = new ArrayList<Reindeer>();
		for (String s : stringList) {
			// Dancer can fly 27 km/s for 5 seconds, but then must rest for 132
			// seconds.

			String[] split = s.split(" ");
			String name = split[0];
			int speed = Integer.parseInt(split[3]);
			int flyTime = Integer.parseInt(split[6]);
			int restTime = Integer.parseInt(split[13]);

			reindeer.add(new Reindeer(name, flyTime, restTime, speed));
		}
		for (int i = 1; i < 145; i++) {
			for (Reindeer r : reindeer) {
				r.tic();

			}
			for (Reindeer r : reindeer) {
				System.out.println(r);
			}
			furthest(reindeer).incrPoints();

		}

		System.out.println(pointiest(reindeer));
	}

	public static Reindeer furthest(List<Reindeer> reindeer) {
		int distance = 0;
		Reindeer furthest = null;
		for (int i = 0; i < reindeer.size(); i++) {
			if (reindeer.get(i).getDistance() > distance) {
				distance = reindeer.get(i).getDistance();
				furthest = reindeer.get(i);
			}
		}
		return furthest;
	}

	public static Reindeer pointiest(List<Reindeer> reindeer) {
		int pointiest = 0;
		Reindeer r = null;
		for (int i = 0; i < reindeer.size(); i++) {
			if (reindeer.get(i).getPoints() > pointiest) {
				pointiest = reindeer.get(i).getPoints();
				r = reindeer.get(i);
			}
		}
		return r;
	}
}
