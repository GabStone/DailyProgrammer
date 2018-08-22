package medium;

import java.util.HashMap;

/**
 * reddit/r/dailyprogrammer Challenge 365
 * @author GabStone
 * https://www.reddit.com/r/dailyprogrammer/comments/8xzwl6/20180711_challenge_365_intermediate_sales/
 *
 */
public class Challenge_365 {
	
	private static final double COMMISSION_RATE = 0.062;
	
	public static void main(String [] args) {
		System.out.println("Commission Calculator");
		
		// Input Variable #1
		String [][] revenue = new String [][] {
			{ "",     "Johnver", "Vanston", "Danbree", "Vansey", "Mundyke"},
			{ "Tea",    "190",     "140",     "1926",    "14",     "143"},
			{ "Coffee", "325",     "19",      "293",     "1491",   "162"},
			{ "Water",  "682",     "14",      "852",     "56",     "659"},
			{ "Milk",   "829",     "140",     "609",     "120",    "87"}};
		
		// Input Variable #2
		String [][] cost = new String [][] {
			{ "",     "Johnver", "Vanston", "Danbree", "Vansey", "Mundyke"},
			{ "Tea",    "120",     "65",     "890",      "54",     "430"},
			{ "Coffee", "300",     "10",     "23",       "802",    "235"},
			{ "Water",  "50",     "299",     "1290",     "12",     "145"},
			{ "Milk",   "67",     "254",     "89",       "129",    "76"}};
		
		HashMap<String, Double> commission = calculateComission(revenue, cost);
		
		if (commission != null) {
			System.out.println(commission.toString());	
		} else {
			System.out.println("Error, Invalid Input");
		}
	}
	
	public static HashMap<String, Double> calculateComission(String [][] revenue, String [][] cost) {
		
		// Size Check
		if (revenue.length != cost.length || revenue[0].length != cost[0].length) {
			return null;
		}
		
		HashMap<String, Double> result = new HashMap<>();
		
		int productIncome = 0;
		double totalCommission = 0;
		for (int i = 1; i < revenue[0].length; i++) {
			for (int j = 1; j < revenue.length; j++) {
				// Check Product Name AND Salesperson Name
				if (revenue[j][0] != cost[j][0] || revenue[0][i] != cost[0][i]) {
					return null;
				}
				
				productIncome = Integer.parseInt(revenue[j][i]) - Integer.parseInt(cost[j][i]);
				if (productIncome > 0) {
					totalCommission += productIncome * COMMISSION_RATE;
				}
			}
			result.put(revenue[0][i], totalCommission);
			totalCommission = 0;
		}		
		return result;
	}
}