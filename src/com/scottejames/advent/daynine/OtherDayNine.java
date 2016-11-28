package com.scottejames.advent.daynine;

import static java.lang.Integer.parseInt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.google.common.collect.Collections2;

public class OtherDayNine {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("target/classes/com/scottejames/advent/daynine/DayNineData.txt"));

        Map<String, Integer> dists = new HashMap<>();
        Set<String> places = new HashSet<>();

        while (s.hasNextLine()) {
            String line = s.nextLine();

            String[] split = line.split(" ");

            places.add(split[0]);
            places.add(split[2]);

            dists.put(split[0]+split[2], parseInt(split[4]));
            dists.put(split[2]+split[0], parseInt(split[4]));
        }

        int min = Integer.MAX_VALUE;
        int max = 0;
        for(List<String> perm : Collections2.permutations(places)) {
            int len = 0;
            for (int i = 0; i < perm.size() -1; i++) {
                len += dists.get(perm.get(i)+perm.get(i+1));
            }
            if (len < min) {
                min = len;
               
            }
            if (len > max) {
            		max = len;
            }
            for(String p : perm){
            		System.out.print(p + ", ");
            }
            System.out.println(" = " + len);
        }
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }
}
