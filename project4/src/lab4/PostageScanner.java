package lab4;
import java.util.Scanner;

import postage1.PostageUtil;

public class PostageScanner {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double userInput = 0.0;
		userInput = in.nextDouble();
		System.out.printf("%1.2f" , PostageUtil.computePostage(userInput));
		in.close();
	}

}
