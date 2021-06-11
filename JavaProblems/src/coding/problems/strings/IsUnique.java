package coding.problems.strings;

//Implement an algorithm to determine if a string has all unique characters. What if you
//cannot use additional data structures?
//ASCII - 128 OR 256(extended ASCII) unique characters
public class IsUnique {
	public static boolean isUnique(String str) {
		//if the length is greater than 128 then not all of the characters are unique
		if(str.length() > 128) return false;
		
		boolean[] uniqueChars = new boolean[128];
		for(int i = 0; i<str.length(); i++) {
			//this will take the characters ASCII value
			int value = str.charAt(i);
			if(uniqueChars[value]) {
				//value found true, meaning its repeated so return false
				return false;
			}
			uniqueChars[value] = true;
		}
		return true;
	}
	
	//O(n) time where n is the strings length, could also be O(1) (constant time) since the loop will never iterate
	//for more than 128 characters
	//O(1) space 
	
	//Other solutions:
	//Compare each char O(n^2) time
	//Sort the word and check for neighbour identical chars O(nlogn) time but takes extra space.
	
	
	public static void main(String[] args) {
		System.out.println(isUnique("Gilberto"));
		System.out.println(isUnique("Miguel"));
		System.out.println(isUnique("Laura"));
		System.out.println(isUnique("Dennis"));
		System.out.println(isUnique("Julio"));
		//Converting character to ascii code
		String k = "this";
		int x = k.charAt(3);
		System.out.println(k.charAt(3)+": " + x);
		
		
		int checker =0;
		//bitwise bit shift operators: 
		//<< shifts a bit pattern to the left
		//>> shifts a bit pattern to the right
		//>>> shifts a zero into the leftmost position
		checker |= (1<<2);
		System.out.println(checker);
	}
}
