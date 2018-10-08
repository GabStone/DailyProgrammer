package easy;

import java.util.Scanner;

/**
 * reddit/r/dailyprogrammer Challenge 367
 * @author GabStone
 * https://www.reddit.com/r/dailyprogrammer/comments/9cvo0f/20180904_challenge_367_easy_subfactorials_another/
 */
public class Challenge_367 {
	
	public static void main (String [] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Input Amount?");
		String amount = scan.next();
		long n = 0;
		try {
			n = Long.parseLong(amount);
		} catch (NumberFormatException e) {
			System.out.println("Invalid Number");
		}
		
		if (n > 0) {
			System.out.println(derangement(n));
		}
	}
	
	public static long derangement(long n) {
		if (n == 0) {
			return 1;
		} else if (n == 1) {
			return 0;
		} else if (n == 2) {
			return 1;
		} else if (n == 3) {
			return 2;
		} else {
			return (n-1)*(derangement(n-1) + derangement(n-2)); // Recursive Case
		}
	}
}
