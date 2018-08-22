package easy;

import java.util.Random;
import java.util.Scanner;

/**
 * reddit/r/dailyprogrammer Challenge 364
 * @author GabStone
 * https://www.reddit.com/r/dailyprogrammer/comments/8s0cy1/20180618_challenge_364_easy_create_a_dice_roller/
 *
 */
public class Challenge_364 {
	
	public static void main (String [] args) {
		System.out.println("Welcome Dice Roller");

		Scanner scan = new Scanner(System.in);
		System.out.println("Dice Input?");
		String diceInput = scan.next();
		
		
		int sum = 0;
		
		
		// Check if input is valid
		if (diceInput.length() == 3 && Character.isDigit(diceInput.charAt(0)) && 
				(Integer.parseInt(Character.toString(diceInput.charAt(0))) > 0) &&
				Character.isAlphabetic(diceInput.charAt(1)) && Character.isDigit(diceInput.charAt(2)) &&
				(Integer.parseInt(Character.toString(diceInput.charAt(2))) > 0) &&
				(Integer.parseInt(Character.toString(diceInput.charAt(2))) <= 100)) {
			
			int amountOfDice = Integer.parseInt(Character.toString(diceInput.charAt(0)));
			int amountOfSides = Integer.parseInt(Character.toString(diceInput.charAt(2)));
			
			// Roll Dice & Calculate Sum
			Random r = new Random();
			int high = amountOfSides;
			
			System.out.println("amountOfDice : " + amountOfDice);
			System.out.println("amountOfSides : " + amountOfSides);
			
			System.out.println("high : " + high);

			int more = 0;
			for (int i = 0; i < amountOfDice; i++) {
				more = r.nextInt(high) + 1;
				System.out.println(more);
				sum = sum + more;
			}		
		} else {
			System.out.println("Sorry, Invalid Input");
		}
		
		System.out.println("The Sum is :" + sum);		
	}
}