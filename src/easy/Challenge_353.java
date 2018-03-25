package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * reddit/r/dailyprogrammer Challenge 353
 * @author GabStone
 * https://www.reddit.com/r/dailyprogrammer/comments/826coe/20180305_challenge_353_easy_closest_string/
 *
 */
public class Challenge_353 {
	
	public static void main (String args []) {
			
		// Assuming input file has correct format as per challenge
		List<String> input = getFileInput();
		input.remove(0); // Remove size, not needed
			
		int min = -1;
		int current = 0;
		String minString = input.get(0);
		for (int i = 0; i < input.size(); i ++) {
			for (int j = 0; j < input.size(); j++) {
				if (input.get(i) == input.get(j)) {
					continue;					
				}
				current += hammingDistance(input.get(i), input.get(j));
			}
			
			if (current < min || min == -1) {
				min = current;
				minString = input.get(i);
			}
			current = 0;
		}
		
		System.out.println("Distance : " + min);
		System.out.println("DNA Sequence : " + minString);		
	}
	
	/**
	 * Hamming Distance Algorithm performed on s1 and s2
	 * @param s1
	 * @param s2
	 * @return Distance between s1 and s2
	 */
	public static int hammingDistance(String s1, String s2) {
		int distance = 0;
		if (s1.length() == s2.length()) {
			for (int i = 0; i < s1.length(); i++) {
				if (s1.charAt(i) != s2.charAt(i)) {
					distance++;
				}
			}			
			return distance;
		} else {
			return -1;
		}
	}
	
	/**
	 * Reads Input File
	 * @return List of Strings found in file
	 */
	public static List<String> getFileInput() {
		List<String> input = new ArrayList<String>();
		try {
			File file = new File("C:\\Workspace\\DailyProgrammer\\src\\easy\\input_challenge_353.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				input.add(line);
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return input;
	}
}