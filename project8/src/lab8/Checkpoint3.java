package lab8;

import plotter.Plotter;
import plotter.Polyline;
import java.util.Scanner;
import java.util.ArrayList;
import java.awt.Point;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.io.File;

@SuppressWarnings("unused")
public class Checkpoint3 {
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Polyline> list = readFile("hello.txt");
		Plotter plotter = new Plotter();

		for (Polyline p : list) {
			plotter.plot(p);
		}
	}

	private static ArrayList<Polyline> readFile(String filename) throws FileNotFoundException {
		ArrayList<Polyline> list = new ArrayList<Polyline>();
		File file = new File(filename);
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
			Scanner scan = new Scanner(scanner.nextLine());
			while (scan.hasNext()) {
				String line = scan.nextLine();
				if (line.isEmpty() || line.charAt(0) == '#') {
					scanner.nextLine();
				} else {
					list.add(parseOneLine(line));
				}
			}
			scan.close();
		}
		scanner.close();

		return list;
	}

	private static Polyline parseOneLine(String line) {
		ArrayList<String> list = new ArrayList<String>();
		Scanner scanner = new Scanner(line);
		while (scanner.hasNext()) {

			list.add(scanner.next());
		}
		scanner.close();

		try {
			Integer.parseInt(list.get(0));
		} catch (Exception NoSuchElementException) {
			list.add(0, "1");
		}

		Polyline pl = new Polyline(list.get(1), Integer.parseInt(list.get(0)));
		for (int i = 2; i < list.size() - 1; i += 2) {
			pl.addPoint(new Point(Integer.parseInt(list.get(i)), Integer.parseInt(list.get(i + 1))));
		}

//		 System.out.println(list);

		return pl;

	}
}
