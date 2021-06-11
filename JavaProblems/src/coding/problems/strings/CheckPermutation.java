package coding.problems.strings;

import java.util.Arrays;

//Given two strings, write a method to decide if one is a permutation of the other.

//If two strings are permutations it means they have the same characters but in different order
//Strings with two different lengths cannot be permutations of each other
public class CheckPermutation {

	// Solution 1: Sort the string
	public static String sortString(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content); // O(NLOGN) TIME
		return new String(content);
		// cannot be content.toString() cause itll return a memory location
	}

	public static boolean checkPermutation(String a, String b) {
		if (a.length() != b.length())
			return false;
		return sortString(a).equals(sortString(b));
	}
	
	
	//Solution 2: Check for the length of each string
	public static boolean checkPermutation2(String a, String b) {
		if(a.length()!=b.length()) return false;
		
		int[] characters = new int[128]; //ASCII
		for(int i=0; i<a.length(); i++) {
			//mark the strings character as visited with 1
			characters[a.charAt(i)]++;
		}
		
		for(int i=0; i<b.length(); i++) {
			//decrement 1 from the characters array, if its less than 0 it means that char hasnt been visited
			//in the first loop, therefore its not a permutation
			characters[b.charAt(i)]--;
			if(characters[b.charAt(i)]<0) return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		System.out.println(sortString("this"));
		System.out.println(sortString("sith"));
		System.out.println(checkPermutation("this", "sith"));
		System.out.println(checkPermutation("this", "siths"));
		System.out.println(checkPermutation("this", "that"));
		System.out.println(checkPermutation("gilberto", "otreblig"));
		System.out.println("----------------------------------------------");
		System.out.println(checkPermutation2("this", "sith"));
		System.out.println(checkPermutation2("this", "siths"));
		System.out.println(checkPermutation2("this", "that"));
		System.out.println(checkPermutation2("gilberto", "otreblig"));
		
	}
}
