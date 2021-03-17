/**
 * 
 */
package hw4;

import api.Cell;
import api.Icon;
import api.Piece;
import api.Position;

/**
 * @author haadi
 *
 */
public abstract class AbstractPiece implements Piece {
	/**
	 * Position of the block
	 */
	private Position position;
	/**
	 * Array of cells that contains all data for each segment of the block
	 */
	private Cell[] cells;
	/**
	 * Array of icons from constructor
	 */
	@SuppressWarnings("unused")
	private Icon[] icon;

	protected AbstractPiece(Position position, Cell[] cells, Icon[] icon) {
		this.position = position;
		this.cells = cells;
		this.icon = icon;
	}

	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public void setCells(Cell[] givenCells) {
		// deep copy the given array
		cells = new Cell[givenCells.length];
		for (int i = 0; i < givenCells.length; i++) {
			cells[i] = new Cell(givenCells[i]);
		}
	}

	@Override
	public Cell[] getCells() {
		// deep copy this object's cell array
		Cell[] copy = new Cell[cells.length];
		for (int i = 0; i < cells.length; i++) {
			copy[i] = new Cell(cells[i]);
		}
		return copy;
	}

	@Override
	public Cell[] getCellsAbsolute() {
		Cell[] ret = new Cell[cells.length];

//		int row = cells[0].getRow() + position.row();
//		int col = cells[0].getCol() + position.col();
//		Icon b = cells[0].getIcon();
//		ret[0] = new Cell(b, new Position(row, col));
//
//		row = cells[1].getRow() + position.row();
//		col = cells[1].getCol() + position.col();
//		b = cells[1].getIcon();
//		ret[1] = new Cell(b, new Position(row, col));

		for (int i = 0; i < cells.length; i++) {
			int row = cells[i].getRow() + position.row();
			int col = cells[i].getCol() + position.col();
			Icon b = cells[i].getIcon();
			ret[i] = new Cell(b, new Position(row, col));
		}

		return ret;
	}

	@Override
	public void shiftDown() {
		position = new Position(position.row() + 1, position.col());
	}

	@Override
	public void shiftLeft() {
		position = new Position(position.row(), position.col() - 1);
	}

	@Override
	public void shiftRight() {
		position = new Position(position.row(), position.col() + 1);
	}

	@Override
	public void transform() {
	}

	@Override
	public void cycle() {
//		Icon[] temp = new Icon[icon.length];
//		for (int i = 0; i < icon.length - 1; i++) {
//			temp[i + 1] = icon[i];
//		}
//		temp[0] = icon[icon.length - 1];
//		for (int i = 0; i < icon.length; i++) {
//			icon[i] = temp[i];
//		}
//		for (int i = 1; i < cells.length; i++) {
//			cells[i].setIcon(icon[i - 1]);
//		}

		Icon temp = cells[cells.length - 1].getIcon();
		for (int i = cells.length - 1; i > 0; i--) {
			cells[i].setIcon(cells[i - 1].getIcon());
		}
		cells[0].setIcon(temp);
	}

	@Override
	public Piece clone() {
		try {
			// call the Object clone() method to create a shallow copy
			AbstractPiece s = (AbstractPiece) super.clone();

			// then make it into a deep copy (note there is no need to copy the position,
			// since Position is immutable, but we have to deep-copy the cell array
			// by making new Cell objects
			s.cells = new Cell[cells.length];
			for (int i = 0; i < cells.length; ++i) {
//				System.out.println(cells.length);
				s.cells[i] = new Cell(cells[i]);
			}
			return s;
		} catch (CloneNotSupportedException e) {
			// can't happen, since we know the superclass is cloneable
			return null;

		}

	}

	/**
	 * 
	 * @param cellLength	length of cell array
	 * @param iconLength	length of icon array
	 * @return				returns true if they equal, otherwise false
	 */
	protected boolean checkIcons(int cellLength, int iconLength) {
		if (cellLength == iconLength)
			return true;
		else
			return false;

	}

}
