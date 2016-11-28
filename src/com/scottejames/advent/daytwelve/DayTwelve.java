package com.scottejames.advent.daytwelve;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.json.JSONArray;
import org.json.JSONObject;

public class DayTwelve {
	public static int processJSon(Object json) {
		if (json instanceof Integer){
//			System.out.println("Processing int ");
			return (int) json;

		}
		if (json instanceof String){
//			System.out.println("Processing string ");

			return 0;
		}
		int total = 0;
		if (json instanceof JSONArray) {
//			System.out.println("Processing array ");

			JSONArray jsonArray = (JSONArray) json;

			for (int i = 0; i < jsonArray.length(); i++)
				total += processJSon(jsonArray.get(i));
			return total;
		}
		total = 0;
		if (json instanceof JSONObject) {
//			System.out.println("Processing object ");

			JSONObject jsonObject = (JSONObject) json;
			JSONArray names = jsonObject.names();
			for (int i = 0; i < names.length(); i++) {
				if (jsonObject.get(names.getString(i)).equals("red"))
					return 0;
				else
					total += processJSon(jsonObject.get(names.getString(i)));
			}
			return total;
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		Path filePath = new File("target/classes/com/scottejames/advent/daytwelve/DayTwelveData.txt").toPath();
		System.out.println(filePath);

		String string = new String(Files.readAllBytes(filePath));
		JSONArray json = new JSONArray(string);
		System.out.println(processJSon(json));

	}

}
