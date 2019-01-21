package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * reddit/r/dailyprogrammer Challenge 372
 * @author GabStone
 * https://www.reddit.com/r/dailyprogrammer/comments/afxxca/20190114_challenge_372_easy_perfectly_balanced/
 *
 */
public class Challenge_372 {
	
	public static void main (String [] args) {		
		// Given a string containing only 'x' and 'y'
		String input = "xxyyxxxyyy";
		String input2 = "llllllllllljijijijijijijijijijijiyxyxyxyxyyyyaaaaaaaaaaabbbbbbbbbbbyyyxxxxxxx";
		System.out.println(balanced(input));
		System.out.println(balanced_bonus(input2));
	}
	
	public static boolean balanced(String input) {
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == 'x') {
				count++;
			} else if (input.charAt(i) == 'y') {
				count --;
			}
		}
		return count == 0;
	}
	
	public static boolean balanced_bonus(String input) {
		boolean result = true;
		if (input.length() == 0) {
			return true;
		}
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
				
		for (int i = 0; i < input.length(); i++) {
			if (map.get(input.charAt(i)) != null) {
				map.put(input.charAt(i), map.get(input.charAt(i)) + 1);
			} else {
				map.put(input.charAt(i), 1);
			}
		}
		List<Integer> list = new ArrayList<Integer>(map.values());
		int reference = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) != reference) {
				result = false;
				break;
			}
		}
		return result;
	}
}