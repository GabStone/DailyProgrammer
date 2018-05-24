package easy;

import java.util.HashMap;
import java.util.Scanner;

/**
 * reddit/r/dailyprogrammer Challenge 361
 * @author GabStone
 * https://www.reddit.com/r/dailyprogrammer/comments/8jcffg/20180514_challenge_361_easy_tally_program/
 *
 */
public class Challenge_361 {
	
	public static void main (String [] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("What is the score?");
		String score = scan.next();
		
		/* Rules:
		 *  Lowercase = 1 point
		 *  Uppercase = -1 point
		 *  Each unique letter is a player
		 */
		HashMap<Character, Integer> playerScore = new HashMap<Character, Integer>();
		
		int point = 0;
		for (int i = 0; i < score.length(); i++) {
			if (playerScore.containsKey(Character.toUpperCase(score.charAt(i)))) {
				// Contains key -> update score
				if (score.charAt(i) == Character.toUpperCase(score.charAt(i))) {
					point = -1;
				} else  {
					point = 1;
				}
				playerScore.put(Character.toUpperCase(score.charAt(i)), playerScore.get(Character.toUpperCase(score.charAt(i))) + point);
			} else {
				// Does not contain key -> set score
				if (score.charAt(i) == Character.toUpperCase(score.charAt(i))) {
					point = -1;
				} else  {
					point = 1;
				}
				playerScore.put(Character.toUpperCase(score.charAt(i)), point);
			}
		}
		System.out.println(playerScore.toString());
	}
}