/**
 * 
 */
package hw3;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author haadi
 */
public class AsmFileUtil {
	/**
	 * Does literally nothing, much like my bird
	 */
	public AsmFileUtil() {

	}
	
	/**
	 * 
	 * @param filename - the name of the file to process
	 * @return assembled machine code as a list of strings
	 * @throws java.io.FileNotFoundException in the event the file was not found
	 */
	public static ArrayList<String> assembleFromFile(String filename) throws java.io.FileNotFoundException {
		ArrayList<String> input = new ArrayList<String>();
		File file = new File(filename);
		Scanner in = new Scanner(file);
		while (in.hasNextLine()) {
			String line = in.nextLine();
			input.add(line);
		}
		in.close();
		CS227Asm assembler = new CS227Asm(input);
		return assembler.assemble();

	}
	/**
	 * 
	 * @param filename - the name of the file to process
	 * @param annotated - true if instruction descriptions should be included in the output file, false otherwise
	 * @throws java.io.FileNotFoundException in the event the file was not found
	 */
	public static void assembleAndWriteFile(String filename, boolean annotated) throws java.io.FileNotFoundException {
		String newName = filename.substring(0, filename.indexOf('.')) + ".mach227";
		File outFile = new File(newName);
		PrintWriter out = new PrintWriter(outFile);
		ArrayList<String> fileOut = assembleFromFile(filename);
		if (annotated) {
			for (String str : fileOut) {
				out.println(str);
			}
		} else {
			for (String str : fileOut) {
				Scanner scan = new Scanner(str);
				out.println(scan.next());
				scan.close();
			}
		}
		out.close();
	}
	/**
	 * 
	 * @param filename
	 * @return assembled machine code as an array of integer values
	 * @throws java.io.FileNotFoundException in the event the file was not found
	 */
	public static int[] createMemoryImageFromFile(String filename) throws java.io.FileNotFoundException {
		
		
		ArrayList<String> fileOut = assembleFromFile(filename);
		int[] out = new int[fileOut.size()-1];
		for (int i = 0; i < out.length; i++) {
			Scanner scan = new Scanner(fileOut.get(i));
			out[i] = scan.nextInt();
			scan.close();
		}
		return out;
	}
}