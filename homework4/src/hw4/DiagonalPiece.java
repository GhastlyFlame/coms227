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
public class DiagonalPiece extends AbstractPiece {
	/**
	 * Keeps track of block movement
	 */
	private boolean toggle = true;
	/**
	 * Array of cells that contains all data for each segment of the block
	 */
	private static Cell[] cells = new Cell[2];
	/**
	 * Array of icons from constructor
	 */
	private Icon[] icon;

	/**
	 * 
	 * @param givenPosition inputted position value
	 * @param icons         Colours of each segment
	 */
	public DiagonalPiece(Position givenPosition, Icon[] icons) {
		super(givenPosition, cells, icons);
		icon = icons;
		cells = new Cell[2];
		cells[0] = new Cell(icon[0], new Position(0, 0));
		// another cell diagonal to the previous
		cells[1] = new Cell(icon[1], new Position(1, 1));
		if (!checkIcons(cells.length, icon.length)) {
			throw new IllegalArgumentException();
		}
		super.setCells(cells);
	}

	@Override
	public void transform() {

		if (toggle) {
			cells[0].setCol(1);
			cells[1].setCol(0);
			toggle = !toggle;
		} else {
			cells[0].setCol(0);
			cells[1].setCol(1);
			toggle = !toggle;
		}
		super.setCells(cells);
	}

}
