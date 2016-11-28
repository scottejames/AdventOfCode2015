package com.scottejames.advent.dayfour;

import java.security.NoSuchAlgorithmException;

public class DayFour {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		String start = "bgvyzdsv";
		int count = 0;
		boolean resultFound = false;
		while (!resultFound){
			String test = start + count;
	        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
	        byte[] array = md.digest(test.getBytes());
	        
	        StringBuffer sb = new StringBuffer();

	        for (int i = 0; i < array.length; ++i) {
	            sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
	         }
	        if (sb.toString().substring(0,6).equals("000000")){
	        		resultFound=true;
	        		System.out.println("Answer is " + count);
	        		System.out.println("Hash is " + sb.toString());
	        }
	        count++;
		}
	}

}
