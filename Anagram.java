

/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true
		System.out.println(isAnagram("hello", "world")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String S1= preProcess(str1);
		String S2= preProcess(str2);
		char space = ' ';
		String S1new="";
		String S2new="";
		
		for (int k = 0; k < S1.length(); k++) {
			if (space!=S1.charAt(k)) {
				S1new+=S1.charAt(k);
			}
		}
		for (int t = 0; t < S2.length(); t++) {
			if (space!=S2.charAt(t)) {
				S2new+=S2.charAt(t);
			}
		}
		if (S1new.length()!=S2new.length()) {
			return false;
		}
		boolean AreAnagram;
		for (int i = 0; i < S1new.length(); i++) {
			AreAnagram = false;
			for (int j = 0; j < S2new.length(); j++) {
				if (S1new.charAt(i)==S2new.charAt(j)) {
					AreAnagram=true;
					break;
				}
			}
			if (AreAnagram == false) {
				return false;
			}
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		str= str.toLowerCase();
		String copy = "";
		String allother = "!?/.:;,$#@!%^&*";
		for (int i = 0; i < str.length(); i++) {
			boolean check = false;
			for (int j = 0; j < allother.length(); j++) {
			if (allother.charAt(j)==str.charAt(i)) {
				check = true;
				break;
			}
			}
			if (check==false) {
				copy+= str.charAt(i);
			}
		}
		return copy;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		int block= str.length();
		String randomanag = "";
		while (str.length()!=0) { 
			int randomindex = (int) (Math.random()*str.length());
			randomanag+=str.charAt(randomindex);
			str=str.substring(0, randomindex)+str.substring(randomindex+1);
		}

		return randomanag;
	}
}
