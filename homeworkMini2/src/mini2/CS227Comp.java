package mini2;

/**
 * @author Haadi Majeed
 */
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CS227Comp {

	/**
	 * Opcode for the read instruction.
	 */
	public static final int READ = 10;

	/**
	 * Opcode for the write instruction.
	 */
	public static final int WRITE = 20;

	/**
	 * Opcode for the load instruction.
	 */
	public static final int LOAD = 30;

	/**
	 * Opcode for the store instruction.
	 */
	public static final int STORE = 40;

	/**
	 * Opcode for the add instruction.
	 */
	public static final int ADD = 50;

	/**
	 * Opcode for the sub instruction.
	 */
	public static final int SUB = 51;

	/**
	 * Opcode for the div instruction.
	 */
	public static final int DIV = 52;

	/**
	 * Opcode for the mod instruction.
	 */
	public static final int MOD = 53;

	/**
	 * Opcode for the mul instruction.
	 */
	public static final int MUL = 54;

	/**
	 * Opcode for the jump instruction.
	 */
	public static final int JUMP = 60;

	/**
	 * Opcode for the jumpn (jump if negative) instruction.
	 */
	public static final int JUMPN = 61;

	/**
	 * Opcode for the jumpz (jump if zero) instruction.
	 */
	public static final int JUMPZ = 63;

	/**
	 * Opcode for the halt instruction.
	 */
	public static final int HALT = 80;

	private int IC;
	private int AC;
	private int IR;
	private int[] memory;
	private int opCode;
	private int operand;
	private boolean isHalted;

	/**
	 * Constructs a machine with the given number of words of memory, all words
	 * zero, all registers zero, in a halted state.
	 */
	public CS227Comp(int memorySize) {
		isHalted = true;
		IC = 0;
		AC = 0;
		IR = 0;
		memory = new int[memorySize];

	}

	/**
	 * Constructs a machine with the given initial values in the instruction counter
	 * and accumulator, and the given memory contents. The memory size will be that
	 * of the given array. Immediately crashes the machine if the given memory
	 * contains any invalid instructions, as specified in loadMemoryImage.
	 * 
	 * @param initialIC
	 * @param initialAC
	 * @param memoryImage
	 */
	public CS227Comp(int initialIC, int initialAC, int[] memoryImage) {

		IC = initialIC;
		AC = initialAC;
		memory = memoryImage;

	}

	/**
	 * Returns the current value in the accumulator.
	 * 
	 * @return current value in the accumulator
	 */
	public int getAC() {

		return AC;
	}

	/**
	 * Returns the current value of the instruction counter.
	 * 
	 * @return current value of the instruction counter
	 */
	public int getIC() {

		return IC;
	}

	/**
	 * Returns the contents of the instruction register (most recently executed
	 * instruction)
	 * 
	 * @return contents of the instruction register
	 */
	public int getIR() {

		return IR;
	}

	/**
	 * Returns the opcode for the most recently executed instruction (instruction
	 * register divided by 100).
	 * 
	 * @return opcode for the most recently executed instruction
	 */
	public int getOpcode() {

		return IR / 100;
	}

	/**
	 * Returns the operand for the most recently executed instruction (instruction
	 * register modulo 100).
	 * 
	 * @return operand for the most recently executed instruction
	 */
	public int getOperand() {

		return IR % 100;
	}

	/**
	 * Returns true if the machine is in a halted state, false otherwise.
	 * 
	 * @return true if the machine is in a halted state, false otherwise
	 */
	public boolean isHalted() {

		if (memory[IC] == 0) {

			return true;
		}
		if (isHalted == true) {

			return true;

		}

		return false;
	}

	/**
	 * Returns the contents of the memory cell at the given address.
	 * 
	 * @param address memory address
	 * @return contents of memory cell at the given address
	 */
	public int peekMemory(int address) {

		return memory[address];
	}

	/**
	 * Returns the number of words of memory this machine has.
	 * 
	 * @return the number of words of memory
	 */
	public int getMemorySize() {

		return memory.length;
	}

	/**
	 * Executes one instruction at a time, over and over, as long as the machine is
	 * not halted.
	 */
	public void runProgram() {

		while (opCode != HALT) {

			nextInstruction();
		}

	}

	/**
	 * Displays complete machine state. This one is done for you. Observe the
	 * conversions that are used to print the values, as you'll need them elsewhere
	 * if you want a uniform look to your output.
	 */
	public void dumpCore() {

		System.out.printf("REGISTERS:\n");
		System.out.printf("%-20s %+05d\n", "accumulator", getAC());
		System.out.printf("%-20s    %02d\n", "instruction counter", getIC());
		System.out.printf("%-20s %+05d\n", "instruction register", getIR());
		System.out.printf("%-20s    %02d\n", "operation code", getIR() / 100);
		System.out.printf("%-20s    %02d\n", "operand", getIR() % 100);
		System.out.printf("\nMEMORY:\n  ");
		for (int i = 0; i < 10; i++) {
			System.out.printf("%6d", i);
		}
		int row = 0;
		for (int i = 0; i < getMemorySize(); i++) {
			if (i % 10 == 0) {
				row += 1;
				System.out.printf("\n%2d ", row * 10);
			}
			System.out.printf("%+05d ", peekMemory(i));
		}
		System.out.println();
	}

	/**
	 * Loads the given values into the machine's memory. If the length of the given
	 * array is smaller than this machine's memory size, the remaining cells are
	 * filled with zeros; if larger, extra values are ignored. If any value is
	 * encountered in the given array that is not a valid instruction, the machine
	 * crashes at that point with message "*** Invalid input ***". The machine's
	 * memory size is not modified. If no invalid instructions are encountered, the
	 * machine will be in a non-halted state.
	 * 
	 * @param image memory image to load
	 */
	public void loadMemoryImage(int[] image) {

//		if (image.length == memory.length) {
//
//			for (int i = 0; i < memory.length; i++) {
//
//				memory[i] = image[i];
//			}
//
//		}
//
//		if (image.length < memory.length) {
//
//			for (int i = 0; i < image.length; i++) {
//
//				memory[i] = image[i];
//			}
//			for (int i = 0; i < memory.length; i++) {
//
//				if (i > image.length - 1) {
//
//					memory[i] = 0;
//
//				}
//			}
//
//		}
//
//		if (image.length > memory.length) {
//
//			for (int i = 0; i < memory.length; i++) {
//
//				memory[i] = image[i];
//			}
//
//		}
		
		int i;
		for(i = 0; i < Math.min(memory.length, image.length); i++)
		{
			memory[i] = image[i];
		}
		
		while(i < memory.length)
		{
			
			memory[i] = 0;
			i++;
		}

	}

	/**
	 * Reads instructions from the terminal, one per line, until the sentinel value
	 * (-99999) is read. Instructions are decimal integers in the range
	 * [-9999,9999]. Any invalid input should immediately crash the machine with
	 * error message "*** Invalid input ***". Each instruction should be prompted
	 * for with the zero-padded, two digit sequential instruction number followed by
	 * a question mark. The instruction or sentinel should then be echoed as a four
	 * digit (or five, for the sentinel), signed, zero-padded decimal integer. After
	 * successfully loading, display the message "*** Program Loaded ***" and move
	 * to a running state.
	 */
	public void loadProgramFromConsole() {
		
		Scanner scan = new Scanner(System.in);
		
		int input;
		int count = 0;
		do
		{
			input = scan.nextInt();
			if(input < 9999 && input > -9999) {
				memory[count] = input;
				count++;
			}
			else
			{
				System.out.println("***Invalid input***");
				isHalted = true;
				dumpCore();
				break;
			}
			
		}while (input != -99999);
		
		System.out.println("***Program Loaded***");
		
		
		scan.close();
	}

	/**
	 * Reads instructions from the given file. Instructions are then loaded into
	 * memory according to the specification for loadMemoryImage.
	 * 
	 * @param filename file from which to read instructions
	 * @throws IOException 
	 */
	public void loadProgramFromFile(String filename) throws IOException {

		File file = new File(filename);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		int i = 0;
		while((line = br.readLine()) != null){
		    //process the line
		    //System.out.println(line);
		    memory[i] = Integer.parseInt(line);
		    i++;
		}
		br.close();
	}

	/**
	 * Loads the next instruction from memory, parses it for the opcode and operand,
	 * and executes the instruction. The opcode is the high-order two digits of the
	 * instruction; the operand is the low-order two digits. Except in case of a
	 * jump, the instruction counter is incremented by one following execution of
	 * the instruction.
	 * <p>
	 * Invalid opcodes crash the machine.
	 * <p>
	 * Descriptions of all instructions follow:
	 *
	 * <ul>
	 * <li>READ: Executes the read instruction. Reads a decimal word from the
	 * terminal into the address referenced by operand and updates the instruction
	 * counter. Valid words are in the range [-9999,9999]. Out of range words are
	 * truncated on the right until within range before being stored; the truncated
	 * portion is discarded. For example, -723471 will be truncated to -7234.
	 *
	 * <li>WRITE: Displays the value stored in memory at the address referenced by
	 * the operand as a signed, four digit, zero padded decimal integer and updates
	 * the instruction counter.
	 *
	 * <li>LOAD: Loads the value stored in memory at the address referenced by
	 * operand into the accumulator and updates the instruction counter.
	 *
	 * <li>STORE: Stores the value in the accumulator into memory at the address
	 * referenced by the operand and updates the instruction counter.
	 *
	 * <li>ADD: Adds the value stored in memory at the address referenced by operand
	 * to the accumulator, accounting for overflow, and updates the instruction
	 * counter.
	 *
	 * <li>SUB: Subtracts the value stored in memory at the address referenced by
	 * operand from the accumulator, accounting for overflow, and updates the
	 * instruction counter.
	 *
	 * <li>DIV: Divides the accumulator by the value stored in memory at the address
	 * referenced by operand, accounting for overflow, and updates the instruction
	 * counter. All division is integer division. Division by zero crashes the
	 * machine.
	 *
	 * <li>MOD: Calculates the remainder when dividing the accumulator by the value
	 * stored in memory at the address referenced by operand, accounting for
	 * overflow, stores the result in the accumulator, and updates the instruction
	 * counter. All division is integer division. Division by zero crashes the
	 * machine.
	 *
	 * <li>MUL: Multiplies the accumulator by the value stored in memory at the
	 * address referenced by operand, accounting for overflow, and updates the
	 * instruction counter.
	 *
	 * <li>JUMP: Changes the instruction counter to operand.
	 *
	 * <li>JUMPN: If the accumulator is negative, changes the instruction counter to
	 * operand, otherwise updates the instruction counter normally.
	 *
	 * <li>JUMPZ: If the accumulator is zero, changes the instruction counter to
	 * operand, otherwise updates the instruction counter normally.
	 *
	 * <li>HALT: Displays the message "*** Program terminated normally ***", halts
	 * the machine, and dumps core.
	 * </ul>
	 * Arithmetic overflow occurs when the accumulator acquires a value outside of
	 * the range [-9999,9999]. It is handled by truncating the value of the
	 * accumulator to the low order four digits.
	 * <p>
	 * Instruction counter overflow occurs when when the value of the instruction
	 * counter matches or exceeds the memory size. It is handled by setting the
	 * instruction counter to zero.
	 * <p>
	 * All crashes dump core.
	 */
	// int count = 0;

	public void nextInstruction() {

		if (IC == 0) {

			IR = memory[0];

		}

		IR = memory[IC];
		Scanner scan = new Scanner(System.in);
		operand = IR % 100;
		opCode = IR / 100;

		switch (opCode) {

		case (READ):

			int temp = scan.nextInt();

			while (temp < -9999 || temp > 9999) {

				temp = temp / 10;

			}

			memory[operand] = temp;

			IC++;

			break;

		case (WRITE):

			System.out.printf("%+05d\n", peekMemory(operand));

			IC++;

			break;

		case (LOAD):

			AC = memory[operand];

			IC++;

			break;

		case (STORE):

			memory[operand] = AC;

			IC++;

			break;

		case (ADD):

			AC = memory[operand] + AC;

			if (AC > 9999 || AC < -9999) {

				AC = AC % 10000;
			}

			IC++;

			break;

		case (SUB):

			AC = AC - memory[operand];

			if (AC > 9999 || AC < -9999) {

				AC = AC % 10000;

			}

			IC++;

			break;

		case (DIV):

			if (memory[operand] == 0) {

				dumpCore();
			} else {

				AC = AC / memory[operand];

			}

			IC++;

			break;

		case (MOD):

			AC = AC % memory[operand];

			IC++;

			break;

		case (MUL):

			AC = AC * memory[operand];

			if (AC > 9999 || AC < -9999) {

				AC = AC % 10000;

			}

			IC++;

			break;

		case (JUMP):

			IC = operand;

			// IR = memory[IC];

			break;

		case (JUMPN):

			if (AC < 0) {

				IC = operand;

			} else {

				IC++;

			}

			break;

		case (JUMPZ):

			if (AC == 0) {

				IC = operand;

			} else {

				IC++;

			}

			break;

		case (HALT):

			System.out.println("***Program Terminated Normally***");
			isHalted = true;
			dumpCore();

			break;

		default:
			isHalted = true;
			dumpCore();
		}

		if (IC >= memory.length) {

			IC = 0;

		}
		scan.close();
	}
}