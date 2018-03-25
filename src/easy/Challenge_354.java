package easy;

/**
 * reddit/r/dailyprogrammer Challenge 354
 * @author GabStone
 * https://www.reddit.com/r/dailyprogrammer/comments/83uvey/20180312_challenge_354_easy_integer_complexity_1/
 *
 */
public class Challenge_354 {
	
	public static final int NUMBER_A = 123456;
	
	public static void main (String [] args) {
		int b = 1;
		int c = NUMBER_A;
		
		for (int i = 1; i < Math.sqrt(NUMBER_A) + 1; i++) {
			if (NUMBER_A % i == 0) {
				if (i + (NUMBER_A / i) <= (b + c)) {
					b = i;
					c = NUMBER_A / i;
				}
			}
		}
		
		System.out.println("Given Number A = " + NUMBER_A + "\nNumber B  = " + b + "\nNumber C = " + c + "\nResult = " + Math.addExact(b, c));		
	}
}
