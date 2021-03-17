package __Tester;

public class Tester {

	public static void main(String[] args) {
		int binNumber = 10;
		double minRange = Double.NEGATIVE_INFINITY;
		double maxRange = Double.POSITIVE_INFINITY;
		System.out.println((Math.min(maxRange, 999999999)- Math.max(minRange, -999999999)) / binNumber);

	}

}
