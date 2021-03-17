package mini3;

import java.util.Arrays;

/**
 * @author Haadi
 *
 */
public class Combinations {

	/**
	 * DOES LITERALLY NOTHING AT ALL, much like my brain
	 */
	public Combinations() {

	}

	/**
	 * 
	 * @param choices - an array of positive integers of length at least 1
	 * @return a 2-D array that contains all the possible combinations of the given
	 *         ingredient choices, where each row represents one unique combination.
	 */
	public static int[][] getCombinations(int[] choices) {
		int m = 1;
		int iterator;
		int[][] out;
		for (int i = 0; i < choices.length; i++) {
			m *= choices[i];
		}
		iterator = m / (choices[choices.length - 1]);
		if (choices.length == 1) {
			out = new int[m][1];
			for (int i = 0; i < m; i++) {
				out[i][0] = i;
			}
			return out;
		}
		out = new int[m][choices.length];
		int[][] temp = getCombinations(Arrays.copyOf(choices, choices.length - 1));
		for (int i = 0; i < temp.length; i++) {
			out[i] = Arrays.copyOf(temp[i], choices.length);
		}
		for (int i = 0; i < m / iterator; i++) {
			for (int j = 0; j < iterator; j++) {
				int[] col = out[i * iterator + j];
				System.arraycopy(out[j], 0, col, 0, choices.length);
				int row = i * iterator + j;
				out[row][choices.length-1] = i; 
			}
		}
		Arrays.sort(out, new ArrayComparator());
		return out;
	}
}
