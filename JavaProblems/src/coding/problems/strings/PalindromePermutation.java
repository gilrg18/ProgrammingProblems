package coding.problems.strings;

/*
 * Given a string, write a function to check if it is a permutation of a palindrome. 
 * A palindrome is a sword or phrase that is the same forwards and backwards
 * A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words,
 * You can ignore casing and non-letter characters.
 * 
 * Input: Tact Coa
 * Output: True (permutations : "taco cat", "atco cta", etc.
 */
public class PalindromePermutation {

	/*
	 * Strings with even lenegth (after removing all non-letter characters) must
	 * have all even counts of character. Strings of an odd length must have exactly
	 * one character with an odd count. Of Course. an "even" string cant have an odd
	 * number of exactly one character, otherwise it wouldnt be an even-length
	 * string (an odd number + many even numbers = an odd number). Likewise, a
	 * string with odd length cant have all characters with even counts (sum of even
	 * is even), Its therefore sufficient to say that, to be permutation of
	 * palindrome, astring can have no more than one character that is odd. This
	 * will cover both the oidd anbd the even cases.
	 */
	
	/*
	 * We will use an array to count how many times each character appears. Then, we iterate through the array and ensure
	 * that no more than one character has an odd count.
	 */

	/*
	 * Map each character to a number, a->0, b->1, c->2, etc.\ This is case
	 * insensitive. Non-letter characters map to -1.
	 */
	static int getCharNumber(Character c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		//System.out.println(val);
		if (a <= val && val <= z) {
			return val - a;
		}
		return -1;
	}
	
	//Count how many times each character appears
	static int[] buildCharFrequencyTable(String phrase) {
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') +1]; //35 - 10 + 1 (26 alphabet letters)
		//System.out.println(Character.getNumericValue('z') - Character.getNumericValue('a') +1);
		//System.out.println(table.length);
		for(char c: phrase.toCharArray()) {
			int x = getCharNumber(c);
			//if x is a non letter character it maps to -1
			if(x!=-1) {
				table[x]++;
			}
		}
		return table;
	}
	
	//Check that no more that one character has an odd count	
	static boolean checkMaxOneOdd(int[] table) {
		boolean oddFound = false;
		for(int val : table) {
			if(val % 2 == 1) {
				if(oddFound) {
					return false;
				}
				oddFound = true;
			}
		}
		return true;
	}
	
	static boolean isPermutationOfPalindome(String phrase) {
		int[] table = buildCharFrequencyTable(phrase);
		return checkMaxOneOdd(table);
	}
	
	public static void main(String[] args) {
		System.out.println(Character.getNumericValue('a')); //10
		System.out.println(Character.getNumericValue('z')); //25
		System.out.println(getCharNumber('z'));
		System.out.println(isPermutationOfPalindome("tacocta"));
		System.out.println(isPermutationOfPalindome("anitalavalaitna"));
		System.out.println(isPermutationOfPalindome("concha"));
	}
}
