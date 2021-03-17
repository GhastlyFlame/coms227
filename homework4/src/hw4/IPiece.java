package hw4;

import api.Cell;
import api.Icon;
import api.Position;

/**
 * @author haadi
 *
 */
public class IPiece extends AbstractPiece {
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
	public IPiece(Position givenPosition, Icon[] icons) {
		super(givenPosition, cells, icons);
		icon = icons;
		cells = new Cell[3];
		cells[0] = new Cell(icon[0], new Position(0, 1));
		cells[1] = new Cell(icon[1], new Position(1, 1));
		cells[2] = new Cell(icon[2], new Position(2, 1));
		if (!checkIcons(cells.length, icon.length)) {
			throw new IllegalArgumentException();
		}
		super.setCells(cells);
	}

	@Override
	public void transform() {
		// Does nothing

	}

}
