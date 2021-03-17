package hw3;

import java.io.FileNotFoundException;
//import java.util.ArrayList;

import mini2.CS227Comp;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		int[] code = AsmFileUtil.createMemoryImageFromFile("primes.asm227");
		CS227Comp comp = new CS227Comp(100);
		comp.loadMemoryImage(code);
		comp.runProgram();
	}
	
}
