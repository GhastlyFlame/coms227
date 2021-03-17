/**
 * 
 */
package mini1;

/**
 * @author haadi
 *
 */
public class FromLoopToNuts {

	private FromLoopToNuts()
	{
		
	}
	public static int countMatches(String s, String t) {
		int length = Math.min(s.length(), t.length());
		int count = 0;
		for (int i = 0; i < length; i++) {
			if (t.charAt(i) == s.charAt(i)) {
				count++;
			}
		}

		return count;
	}

	public static int countSubstrings(String t, String s) {
		int length = t.length();
		int count = 0;
		String modified = s;
		for (int i = 0; i < length; i++) {
			modified += " ";
		}
		if (s.equals(t) && !s.contentEquals("")) {
			return 1;
		}
		if (t.contentEquals("") && t.equals(s)) {
			return 0;
		}
		if (t.contentEquals("") && !t.equals(s)) {
			return 0;
		}

		for (int i = 0; i < s.length(); i++) {
			if (modified.substring(i, i + length).equals(t)) {
				i+=length;
				count++;
			}
		}
		return count;
	}

	public static int countSubstringsWithOverlap(String t, String s) {
		int length = t.length();
		int count = 0;
		String modified = s;
		for (int i = 0; i < length; i++) {
			modified += " ";
		}
		if (s.equals(t) && !s.contentEquals("")) {
			return 1;
		}
		if (t.contentEquals("") && t.equals(s)) {
			return 0;
		}
		if (t.contentEquals("") && !t.equals(s)) {
			return 0;
		}

		for (int i = 0; i < s.length(); i++) {
			if (modified.substring(i, i + length).equals(t)) {
				count++;
			}
		}
		return count;

	}

	public static boolean differByOneSwap(String s, String t) {
		if (s.length() != t.length() || s.equals(t)) {
			return false;
		}
		char[] strg1 = s.toCharArray();
		char[] strg2 = t.toCharArray();
		int numDiff = 0;
		
		for(int i = 0; i < strg1.length; i++)
		{
			if(strg1[i] != strg2[i])
			{
				numDiff++;
				if(numDiff > 2)
				{
					return false;
					
				}
			}
		}
		return true;
	}

	public static String eliminateRuns(String s) {
		return s.replaceAll("(.)\\1{1,}", "$1");
//		String modified = s + " ";
//		char[] str = modified.toCharArray();
//		String out = "";
//		
//		for(int i = 0; i < s.length(); i++)
//		{
//			if(str[i] != str[i+1])
//			{
//				out+=str[i];
//			}
//		}
//		return out;
	}

	public static int findEscapeCount(double x, double y, int maxIterations) {
		double a = 0;
		double b = 0;
		double tempA;
		double tempB;
		int i = 0;
//		while ((a * a + b * b) <= 4) {
//			tempA = a * a - b * b + x;
//			tempB = 2 * a * b + y;
//			a = tempA;
//			b = tempB;
//			i++;
//		}
		for(int j = 0; j < maxIterations; j++)
		{
			if((a * a + b * b) <= 4)
			{
				tempA = a * a - b * b + x;
				tempB = 2 * a * b + y;
				a = tempA;
				b = tempB;
				i++;
			}
		}
		return Math.min(i, maxIterations);

	}

	public static boolean isArithmetic(String text) {
		String[] numbers = text.split(",");
		int[] nums = new int[numbers.length];
		try {

			if (numbers.length <= 2) {
				return true;
			}

			for (int i = 0; i < numbers.length; i++) {
				nums[i] = Integer.parseInt(numbers[i]);
			}
		} catch (Exception e) {
			return false;
		}

		int factor = nums[1] - nums[0];

		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] + factor != nums[i + 1]) {
				return false;
			}
		}

		return true;
	}

	public static int threeInARow(java.util.Random rand, int bound) {
		int count = 0;
//		int numCount = 0;
//		int currentNum = rand.nextInt(bound);
//		int nextNum = rand.nextInt(bound);
//		do {
//			if (currentNum == nextNum) {
//				count++;
//			} else {
//				count = 0;
//				currentNum = nextNum;
//			}
//			nextNum = rand.nextInt(bound);
//			numCount++;
//		} while (count != 3);
//		return numCount;
		int[] nums = new int[1000000];
		int i;
		for (i = 0; i < nums.length; i++) {
			nums[i] = rand.nextInt(bound);
		}

		for (i = 0; i < nums.length - 2; i++) {
			count++;
			if (nums[i] == nums[i + 1] && nums[i] == nums[i + 2]) {
				count += 2;
				break;
			}

		}
		return count;

	}
}
