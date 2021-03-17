package lab9;

//http://web.cs.iastate.edu/~cs227/labs/lab9/page04.html
public class Checkpoint1 {

	public static int findMax(int[] a) {
		return findMax(a, 0);
	}

	private static int findMax(int[] a, int i) {
		return i < a.length ? Math.max(a[i], findMax(a, i + 1)) : Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
		int[] list = { 1, 2, 3, 4, 1000, 10, 50, 0 };

		System.out.println(findMax(list));
		System.out.println(getPyramidCount(5));
	}

	public static int getPyramidCount(int levels) {
		if (levels == 1)
			return 1;
		else
			return power(levels, 2) + getPyramidCount(levels - 1);
	}

	public static int power(int x, int p) {
		if (p <= 0) {
			return 1;
		}
		return x * power(x, p - 1);
	}
}
