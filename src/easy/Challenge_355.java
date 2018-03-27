package easy;

/**
 * reddit/r/dailyprogrammer Challenge 355
 * @author GabStone
 * https://www.reddit.com/r/dailyprogrammer/comments/879u8b/20180326_challenge_355_easy_alphabet_cipher/
 *
 */
public class Challenge_355 {
	
	public static final String ALPHABET  = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String SECRET_WORD = "snitch";

	public static void main(String[] args) {
		String word = "thepackagehasbeendelivered";
		String encryptedWord = "";
			
		for (int i = 0; i < word.length(); i ++) {
			encryptedWord += ALPHABET.charAt((findLetterPosition(word.charAt(i)) + 
					findLetterPosition(SECRET_WORD.charAt(i % SECRET_WORD.length()))) % ALPHABET.length());		
		}
		System.out.println(encryptedWord);
	}
	
	public static int findLetterPosition(char c) {
		int position = -1;
		for (int i = 0; i < ALPHABET.length(); i++) {
			if (ALPHABET.charAt(i) == Character.toUpperCase(c)) {
				position = i;
				break;
			}
		}
		return position;
	}

}
