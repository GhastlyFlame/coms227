package lab9;

import java.io.File;
import java.util.ArrayList;

//http://web.cs.iastate.edu/~cs227/labs/lab9/page09.html
public class Checkpoint2 {

	static ArrayList<String> list = new ArrayList<String>();
	static int[] bricks = { 1, 3 };

	public static void main(String[] args) {
		File rootDirectory = new File(".");

		listAllFiles(rootDirectory);
		System.out.println("\n" + countFiles(rootDirectory));
		findFiles(rootDirectory);

		System.out.println("\n" + list);

		System.out.println("\n" + countPatterns(5));
	}

	static int countPatterns(int N) {
		int count[] = new int[N + 1];

		count[0] = 1;

		for (int i = 1; i <= N; i++)
			for (int j = 0; j < bricks.length; j++)

				if (i >= bricks[j])
					count[i] += count[i - bricks[j]];

		return count[N];

	}

//	public static int countPatterns(int length) {
//		int combos = 0;
//		int lengthLeft = length;
//		final int brick1 = 1;
//		final int brick2 = 3;
//		while(lengthLeft > 0)
//		{
//			if(lengthLeft >= brick2)
//			{
//				if(lengthLeft == 3)
//				{
//					return 2;
//				}
//				lengthLeft-=brick2;
//				combos+=2;
//				
//			}
//			else if(lengthLeft >= brick1)
//			{
//				lengthLeft-= brick1;
//				combos++;
//			}
//		}
//		return combos;
//	}

	public static int countFiles(File f) {
		int count = 0;
		if (!f.isDirectory()) {
			// Base case: f is a file, so just print its name
//			System.out.println(f.getName());
			return 1;
		} else {

			// Recursive case: f is a directory, so go through the
			// files and directories it contains, and recursively call
			// this method on each one
//			System.out.println("+ " + f.getName());
			File[] files = f.listFiles();
			for (int i = 0; i < files.length; ++i) {
				listAllFiles(files[i]);
				count++;
			}

		}
		return count;
	}

	public static void listAllFiles(File f) {
		if (!f.isDirectory()) {
			// Base case: f is a file, so just print its name
			System.out.println(f.getName());
		} else {
			// Recursive case: f is a directory, so go through the
			// files and directories it contains, and recursively call
			// this method on each one
			System.out.println("+ " + f.getName());
			File[] files = f.listFiles();
			for (int i = 0; i < files.length; ++i) {
				listAllFiles(files[i]);
			}
		}
	}

	private static void findFiles(File file) {

		if (!file.isDirectory()) {
			// base case
			list.add(file.getName());
		} else {
			// recursively search the subdirectory
			for (File f : file.listFiles()) {
				findFiles(f);
			}
		}
//		return list;
	}
}
