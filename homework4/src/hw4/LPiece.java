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
public class LPiece extends AbstractPiece {
	private boolean toggle = true;
	/**
	 * Array of cells that contains all data for each segment of the block
	 */
	private static Cell[] cells = new Cell[4];
	/**
	 * Array of icons from constructor
	 */
	private Icon[] icon;

	/**
	 * 
	 * @param givenPosition inputted position value
	 * @param icons         Colours of each segment
	 */
	public LPiece(Position givenPosition, Icon[] icons) {
		super(givenPosition, cells, icons);
		icon = icons;
		cells = new Cell[4];
		cells[0] = new Cell(icon[0], new Position(0, 0));
		cells[1] = new Cell(icon[1], new Position(0, 1));
		cells[2] = new Cell(icon[2], new Position(1, 1));
		cells[3] = new Cell(icon[3], new Position(2, 1));
		if (!checkIcons(cells.length, icon.length)) {
			throw new IllegalArgumentException();
		}
		super.setCells(cells);
	}

	@Override
	public void transform() {

		if (toggle) {
			cells[0].setCol(2);
			toggle = !toggle;
		} else {
			cells[0].setCol(0);
			toggle = !toggle;
		}
		super.setCells(cells);
	}

}
