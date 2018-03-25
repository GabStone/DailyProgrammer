package easy;

import java.util.Scanner;

/**
 * reddit/r/dailyprogrammer Challenge 352
 * @author GabStone
 * https://www.reddit.com/r/dailyprogrammer/comments/7yyt8e/20180220_challenge_352_easy_making_imgurstyle/
 *
 */
public class Challenge_352 {
	
	public static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static void main (String [] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("How many base62 strings would you like to encode?");
		int amount = scan.nextInt();
		
		for (int i = 0; i < amount; i++) {
			String outputString = "";
			System.out.println("Enter number");
			long num = scan.nextLong();
			
			long r = num % 62;
		
			while (r != 0) {
				outputString += ALPHABET.charAt((int) r);
				num = num / 62;
				r = num % 62;
			}
			
			System.out.println(outputString);	
		}
		
		System.out.println("Thank you!");
	}
}