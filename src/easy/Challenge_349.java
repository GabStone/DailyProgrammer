package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * reddit/r/dailyprogrammer Challenge 349
 * @author GabStone
 * https://www.reddit.com/r/dailyprogrammer/comments/7ttiq5/20180129_challenge_349_easy_change_calculator/
 *
 */
public class Challenge_349 {

	public static void main(String[] args) {
	
		// Amount to Return to Customer
		int amount = 18; // Input
		
		// Merchant Coins
		List<Integer> coins = new ArrayList<>(Arrays.asList(10, 10, 5, 5, 2, 1, 1)); // Input
		
		// Maximum Amount of Coins
		int maxCoins = 4; // Input
		
		// Running Total
		int total = 0;
		
		List<Integer> result = new ArrayList<>();
		
		int num = 0;
		while (total < amount) {
			num = getGreedy(coins, (amount - total));
			if (num != -1 && maxCoins > 0) {
				coins.remove(new Integer(num));
				total += num;
				result.add(num);
				maxCoins--;
			} else {
				System.out.println("Impossible!!!");
				break;
			}
		}
		System.out.println(result.toString());
	}
	
	
	/**
	 * Finds the largest value in the list that is smaller of equal to the max
	 * @param coins List<Interger>
	 * @param max Integer
	 * @return
	 */
	public static int getGreedy(List<Integer> coins, int max) {
		Collections.sort(coins);
		Collections.reverse(coins);
		int result = -1;
		for (int i = 0; i < coins.size(); i++) {
			if (coins.get(i) <= max) {
				result = coins.get(i);
				break;
			}
		}
		return result;
	}
}