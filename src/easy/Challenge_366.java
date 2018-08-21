package easy;

/**
 * reddit/r/dailyprogrammer Challenge 366
 * @author GabStone
 * https://www.reddit.com/r/dailyprogrammer/comments/98ufvz/20180820_challenge_366_easy_word_funnel_1/
 */
public class Challenge_366 {
	
	public static void main (String [] args) {
		System.out.println("Welcome Funnel");
		
		String input1 = "dragoon";
		String input2 = "dragon";
		System.out.println(funnel(input1, input2));
	}
	
	public static boolean funnel(String input1, String input2) {
		char [] inputA = input1.toCharArray();
		char [] inputB = input2.toCharArray();
		
		// Length check
		if (inputA.length != inputB.length + 1) {
			return false;
		}
		
		int errorCount = 0;
		int indexA = 0;
		int indexB = 0;
		
		while (indexA < inputA.length && errorCount <= 1) {
			if (inputA[indexA] != inputB[indexB]) {
				errorCount++;
				indexA++;
			} else {
				indexA++;
				indexB++;	
			}
		}		
		return (errorCount <= 1);
	}
}