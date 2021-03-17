/**
 * 
 */
package hw3;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import api.Instruction;
import api.NVPair;
import api.SymbolTable;

/**
 * @author haadi
 *
 */

public class CS227Asm {
	/**
	 * Is the input of strings in list format that contains all the content
	 */
	private ArrayList<String> program;
	/**
	 * Instance of symbolTable for the data componenets from program
	 */
	private SymbolTable data;
	/**
	 * Instance of symbolTable for the labels componenets from program
	 */
	private SymbolTable labels;
	/**
	 * The list of instructions obtained from parsing the programme list
	 */
	private ArrayList<Instruction> instructions;

	/**
	 * Constructor of the class, declares the variables
	 * 
	 * @param program an arraylist of strings that contains all the commands for the
	 *                programme
	 */

	public CS227Asm(ArrayList<String> program) {
		this.program = program;
		data = new SymbolTable();
		labels = new SymbolTable();
		instructions = new ArrayList<Instruction>();
	}

	/**
	 * 
	 * @return the symboltable containing the data section of the programme imported
	 *         from the constructor
	 */
	public SymbolTable getData() {
		return data;
	}

	/**
	 * 
	 * @return the symboltable containing the lables section of the programme
	 *         imported from the constructor
	 */
	public SymbolTable getLabels() {
		return labels;
	}

	/**
	 * 
	 * @return an araylist of instructions from commands from the programme supplied
	 *         by the constructor
	 */
	public ArrayList<Instruction> getInstructionStream() {
		return instructions;
	}

	/**
	 * Runs all the modifing methods
	 * 
	 * @return outputs the end product of the code after everything has been done
	 */
	public ArrayList<String> assemble() {
		parseData();
		parseLabels();
		parseInstructions();
		setOperandValues();
		addLabelAnnotations();
		return writeCode();
	}

	/**
	 * goes through the arraylist imported from constructor and add's everything
	 * under the data section to it's own symboltable
	 */
	public void parseData() {
		Scanner in = null;
		boolean hasFoundData = false;
		for (String str : program) {
			in = new Scanner(str);
			String temp = in.next();
			if (temp.equals("data:")) {
				hasFoundData = true;
			} else if (temp.equals("labels:") || temp.equals("instructions:")) {
				hasFoundData = false;
			} else if (hasFoundData) {
				data.add(temp, in.nextInt());
			}
		}
	}

	/**
	 * goes through the arraylist imported from constructor and add's everything
	 * under the labels section to it's own symboltable
	 */
	public void parseLabels() {
		Scanner in = null;
		boolean hasFoundLabels = false;
		for (String str : program) {
			in = new Scanner(str);
			String temp = in.next();
			if (temp.equals("labels:")) {
				hasFoundLabels = true;
			} else if (temp.equals("instructions:")) {
				hasFoundLabels = false;
			} else if (hasFoundLabels) {
				labels.add(temp);
			}
		}
	}

	/**
	 * goes through the arraylist imported from constructor and add's everything
	 * under the imstructions section to it's own arraylist of instructions
	 */
	public void parseInstructions() {
		// Scanner in = null;
		boolean hasFoundInstructions = false;
		int instructionCount = 0;
		for (String str : program) {
			Scanner in = new Scanner(str);
			String temp = in.nextLine();
			if (temp.contentEquals("instructions:")) {
				hasFoundInstructions = true;
			} else if (hasFoundInstructions) {
				try {
					Instruction tempInstruction = new Instruction(temp);
					instructions.add(tempInstruction);
					instructionCount++;
				} catch (IllegalArgumentException e) {
					Scanner input = new Scanner(temp);
					temp = input.next();
					labels.findByName(temp).setValue(instructionCount);
					input.close();
				} catch (NoSuchElementException e) {
				}
			}
			in.close();
		}
	}

	/**
	 * Fills in the correct operand value for all instructions (either a data
	 * address or jump target address, depending on the instruction).
	 * 
	 */
	public void setOperandValues() {
		for (int i = 0; i < instructions.size(); i++) {
			if (instructions.get(i).requiresJumpTarget()) {
				instructions.get(i).setOperand(labels.findByName(instructions.get(i).getOperandString()).getValue());
			} else if (instructions.get(i).requiresDataAddress()) {
				instructions.get(i).setOperand(
						instructions.size() + data.indexOf(data.findByName(instructions.get(i).getOperandString())));
			}
		}
	}

	public void addLabelAnnotations() {
		for (int i = 0; i < labels.size(); i++) {
			NVPair label = labels.getByIndex(i);
			instructions.get(label.getValue()).addLabelToDescription(label.getName());
		}
	}

	/**
	 * 
	 * @return list of strings containing the machine code and data for this
	 *         assembler's program
	 */
	public ArrayList<String> writeCode() {
		ArrayList<String> out = new ArrayList<String>();
		for (int i = 0; i < instructions.size(); i++) {
			out.add(instructions.get(i).toString());
		}
		for (int i = 0; i < data.size(); i++) {
			out.add(String.format("%+05d %s", data.getByIndex(i).getValue(), data.getByIndex(i).getName()));
		}
		out.add("-99999");
		return out;

	}

}
