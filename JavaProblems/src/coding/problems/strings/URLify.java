package coding.problems.strings;

//Write a method to replace all spaces in a string with '%20. You may assume that the string has sufficient space at the end to
//hold the additional characters, and that you are given the "true" length of the string.
//Note. If you are implementing in Java, please use a character array so that you can perform this operation in place.
//Example:
//Input: "Mr John Smith     ", 13
//Output: "Mr%20John%20Smith"
public class URLify {
 
	//First we count the number of spaces. We need two extra characters for each space since '%20' is 2 chars longer than ' '
	static int spaceCount(char[] str, int start, int end, char target) {
		int count = 0;
		for(int i = start; i<end; i++) {
			if(str[i] == target) count++;
		}
		return count;
	}
	
	//A common approach in string manipulation problems is to edit the string starting from the end and working backwards
	//This is useful because we have an extra buffer at the end, which allows us to change characters without worrying about what we
	//are overwriting.
	static void url(char[] word, int trueLength) {
		int spaces = spaceCount(word, 0, trueLength , ' ');
		int newIndex = trueLength -1 + spaces * 2;
		//13-1 + 2*2= 12+4 = 16
		//if there are excess spaces, add a null character. this indicates that the
		//spaces after that point have not been replaced with %20.
		//if(newIndex +1 < trueLength) word[newIndex+1] = '\0';
		for(int oldIndex = trueLength-1; oldIndex>=0; oldIndex--) {
			if(word[oldIndex]==' ') {
				word[newIndex]='0';
				word[newIndex-1]='2';
				word[newIndex-2]='%';
				System.out.println(word);
				newIndex -= 3;
			}else {
				word[newIndex] = word[oldIndex];
				//System.out.println(word);
				newIndex--;
			}
		}
	}
	
	//Strings are immutable (cannot be modified)
	public static void main(String[] args) {
		
		String word = "Mr John Smith    ";
		String word2 = "Gilberto Rogel Garcia            ";
		char[] charWord = word.toCharArray();
		url(charWord, 13);
		char[] charWord2 = word2.toCharArray();
		url(charWord2, 21);
		System.out.println(charWord);
		System.out.println(charWord2);
	}
}
