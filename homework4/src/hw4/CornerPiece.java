/**
 * 
 */
package hw4;

import api.Cell;
import api.Icon;
import api.Position;

/**
 * @author haadi
 *
 */
public class CornerPiece extends AbstractPiece {
	/**
	 * Array of what tile is next in rotation
	 */
	private Position[] sequence = { new Position(0, 0), new Position(1, 0), new Position(1, 1), new Position(0, 1) };
	/**
	 * Keeps track of where to move next in sequence
	 */
	private int tracker = 3;
	/**
	 * Array of cells that contains all data for each segment of the block
	 */
	private static Cell[] cells = new Cell[3];
	/**
	 * Array of icons from constructor
	 */
	private Icon[] icon;

	/**
	 * 
	 * @param givenPosition inputted position value
	 * @param icons         Colours of each segment
	 */
	public CornerPiece(Position givenPosition, Icon[] icons) {
		super(givenPosition, cells, icons);
		icon = icons;
		cells[0] = new Cell(icons[0], sequence[0]);
		// another cell just below the first one
		cells[1] = new Cell(icons[1], sequence[1]);
		// another cell just right the first one
		cells[2] = new Cell(icons[2], sequence[2]);
		if (!super.checkIcons(cells.length, icon.length)) {
			throw new IllegalArgumentException();
		}
		super.setCells(cells);
	}

	@Override
	public void transform() {
		for (int i = 0; i < cells.length; i++) {
			cells[i].setPosition(sequence[tracker % 4]);
			tracker++;
		}
		super.setCells(cells);
	}
}
