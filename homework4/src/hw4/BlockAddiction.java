/**
 * 
 */
package hw4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import api.AbstractGame;
import api.Generator;
import api.Icon;
import api.Position;

/**
 * @author haadi
 *
 */
public class BlockAddiction extends AbstractGame {

	public BlockAddiction(int givenHeight, int givenWidth, Generator generator) {
		super(givenHeight, givenWidth, generator);
	}

	public BlockAddiction(int givenHeight, int givenWidth, Generator generator, int preFillRows) {
		super(givenHeight, givenWidth, generator);
		Random rand = new Random();
		BasicGenerator gen = new BasicGenerator(rand);

		if (preFillRows > 0) {
			for (int rows = 0; rows < preFillRows; rows++) {
				for (int cols = 0; cols < getWidth(); cols++) {
					if ((rows % 2 == 0 && cols % 2 == 0) || (rows % 2 == 1 && cols % 2 == 1)) {
//						System.out.println(getHeight());
						setBlock(getHeight() - 1 - rows, getWidth() - 1 - cols, gen.randomIcon());
					}
				}
			}
		}
	}

	@Override
	public List<Position> determinePositionsToCollapse() {
//		return new ArrayList<Position>();
		ArrayList<Position> output = new ArrayList<Position>();
		ArrayList<Position> unfiltered = new ArrayList<Position>();
		for (int rows = 0; rows < getHeight(); rows++) {
			for (int cols = 0; cols < getWidth(); cols++) {
				boolean[] hits = {false, false, false, false};

				Icon mid, left, right, up, down;
				ArrayList<Icon> icons = new ArrayList<Icon>();
				@SuppressWarnings("unused")
				//ArrayList<Cell> cells = new ArrayList<Cell>();
				
				int matchedIcones = 0;
				
				// Assign Icons to test with
				try {
					mid = super.getIcon(rows, cols);
					// cells.add(new Cell(mid, new Position(rows, cols)));
					icons.add(mid);

					try {
						left = super.getIcon(rows, cols  - 1);
						// cells.add(new Cell(left, new Position(rows - 1, cols)));
						if (mid.matches(left)) {
							icons.add(left);
							hits[0] = true;
							matchedIcones++;
						}
					} catch (NullPointerException e) {

					} catch (IndexOutOfBoundsException e) {

					}

					try {
						right = super.getIcon(rows, cols + 1);
						// cells.add(new Cell(right, new Position(rows + 1, cols)));
						if (mid.matches(right)) {
							icons.add(right);
							hits[1] = true;
							matchedIcones++;
						}
					} catch (NullPointerException e) {

					} catch (IndexOutOfBoundsException e) {

					}

					try {
						up = super.getIcon(rows  - 1, cols);
						// cells.add(new Cell(up, new Position(rows, cols + 1)));
						if (mid.matches(up)) {
							icons.add(up);
							hits[2] = true;
							matchedIcones++;
						}
					} catch (NullPointerException e) {
					} catch (IndexOutOfBoundsException e) {
					}

					try {
						down = super.getIcon(rows + 1, cols);
						// cells.add(new Cell(down, new Position(rows, cols - 1)));
						if (mid.matches(down)) {
							icons.add(down);
							hits[3] = true;
							matchedIcones++;
						}
					} catch (NullPointerException e) {
					} catch (IndexOutOfBoundsException e) {
					}
				} catch (NullPointerException e) {
				} catch (IndexOutOfBoundsException e) {
				}
				
				if(matchedIcones > 1) {
					unfiltered.add(new Position(rows, cols));
					//left
					if(hits[0]) {
						unfiltered.add(new Position(rows, cols - 1));
					} 
					//right
					if (hits[1]) {
						unfiltered.add(new Position(rows, cols + 1));
					}
					//up
					if (hits[2]) {
						unfiltered.add(new Position(rows - 1, cols));
					} 
					//down
					if (hits[3]) {
						unfiltered.add(new Position(rows + 1, cols));
					}
				}
			} // end of for loop
			for (Position element : unfiltered) {

				// If this element is not present in newList
				// then add it
				if (!output.contains(element)) {

					output.add(element);
				}
				Collections.sort(output);
			}
		}

		return output;
	}
}
