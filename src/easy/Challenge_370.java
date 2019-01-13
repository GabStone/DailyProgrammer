package easy;

/**
 * reddit/r/dailyprogrammer Challenge 370
 * @author GabStone
 * https://www.reddit.com/r/dailyprogrammer/comments/a72sdj/20181217_challenge_370_easy_upc_check_digits/
 *
 */
public class Challenge_370 {
	
	
	public static void main (String [] args) {
		
		System.out.println("UPC CheckDigit Generator");
		
		// Bar Code Input
		String barCode = "03600029145";
		
		try {
			System.out.println("Check Digit : " + upc(barCode));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int upc(String barCode) throws Exception {
		if (barCode.length() < 11) {
			barCode = ("00000000000" + barCode).substring(barCode.length());
		} else if (barCode.length() > 11) {
			throw new Exception();
		}
		
		int checkDigit = 0;
		int oddSum = 0;
		int evenSum = 0;
		for (int i = 1; i < barCode.length() + 1; i++) {
			if (i%2 == 0) {
				evenSum += Integer.parseInt(String.valueOf(barCode.charAt(i-1)));
			} else {
				oddSum += Integer.parseInt(String.valueOf(barCode.charAt(i-1)));
			}
		}
		int m = ((oddSum*3) + evenSum) % 10;
		if (m != 0) {
			checkDigit = 10 - m;
		}
		return checkDigit;
	}
}