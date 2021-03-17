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
public class SnakePiece extends AbstractPiece {
	/**
	 * Array of cells that contains all data for each segment of the block
	 */
	private static Cell[] cells = new Cell[4];
	/**
	 * Array of icons from constructor
	 */
	private Icon[] icon;
	/**
	 * holds the order that the snake will move in
	 */
	private static final Position[] sequence = { new Position(0, 0), new Position(0, 1), new Position(0, 2),
			new Position(1, 2), new Position(1, 1), new Position(1, 0), new Position(2, 0), new Position(2, 1),
			new Position(2, 2), new Position(1, 2), new Position(1, 1), new Position(1, 0), };
	/**
	 * Keeps positon in sequence snake is at
	 */
	private int tracker;

	/**
	 * 
	 * @param givenPosition inputted position value
	 * @param icons         Colours of each segment
	 */
	public SnakePiece(Position givenPosition, Icon[] icons) {
		super(givenPosition, cells, icons);
		icon = icons;

		cells[0] = new Cell(icon[0], sequence[0]);
		cells[1] = new Cell(icon[1], new Position(1, 0));
		cells[2] = new Cell(icon[2], new Position(1, 1));
		cells[3] = new Cell(icon[3], new Position(1, 2));
		tracker = 0;
		if (!checkIcons(cells.length, icon.length)) {
			throw new IllegalArgumentException();
		}
		super.setCells(cells);
	}

	@Override
	public void transform() {
		cells = getCells();
		for (int i = cells.length - 1; i > 0; i--) {
//			System.out.println(cells[i].getRow()+cells[i].getCol());
			cells[i].setPosition(new Position(cells[i - 1].getRow(), cells[i - 1].getCol()));
		}
		tracker++;
		cells[0].setPosition(sequence[tracker % 12]);

		super.setCells(cells);
	}

}
