
package hw4;

import java.util.Random;

import api.Generator;
import api.Icon;
import api.Piece;
import api.Position;


/**
 * Generator for Piece objects in BlockAddiction. Icons are always selected
 * uniformly at random, and the Piece types are generated with the following
 * probabilities:
 * <ul>
 * <li>LPiece - 10%
 * <li>DiagonalPiece - 25%
 * <li>CornerPiece - 15%
 * <li>SnakePiece - 10%
 * <li>IPiece - 40%
 * </ul>
 * The initial position of each piece is based on its vertical size as well as
 * the width of the grid (given as an argument to getNext). The initial column
 * is always width/2 - 1. The initial row is: *
 * <ul>
 * <li>LPiece - row = -2
 * <li>DiagonalPiece - row = -1
 * <li>CornerPiece - row = -1
 * <li>SnakePiece - row = -1
 * <li>IPiece - row = -2
 * </ul>
 * 
 */
public class BasicGenerator implements Generator {
	private Random rand;

	/**
	 * Constructs a BasicGenerator that will use the given Random object as its
	 * source of randomness.
	 * 
	 * @param givenRandom instance of Random to use
	 */
	public BasicGenerator(Random givenRandom) {
		rand = givenRandom;
	}

	@Override
	public Piece getNext(int width) {
		int col = width / 2 - 1;
		Piece next;
		Icon[] icons = null;
		int length = -1;
		Position location;
		Random r = new Random();
		int randomInt = r.nextInt(100);
//		int randomInt = 19;

		if (randomInt < 10) {
			length = 4;
			location = new Position(-2, col); //-1 was -2
			icons = new Icon[length];
			for (int i = 0; i < length; i++) {
				icons[i] = randomIcon();
			}
			next = new LPiece(location, icons);
			return next;
		} else if (randomInt < 20) {
			length = 4;
			location = new Position(-1, col);
			icons = new Icon[length];
			for (int i = 0; i < length; i++) {
				icons[i] = randomIcon();
			}
			next = new SnakePiece(location, icons);
			return next;
		} else if (randomInt < 35) {
			length = 3;
			location = new Position(-1, col);
			icons = new Icon[length];
			for (int i = 0; i < length; i++) {
				icons[i] = randomIcon();
			}
			next = new CornerPiece(location, icons);
			return next;
		} else if (randomInt < 60) {
			length = 2;
			location = new Position(-1 , col);
			icons = new Icon[length];
			for (int i = 0; i < length; i++) {
				icons[i] = randomIcon();
			}
			next = new DiagonalPiece(location, icons);
			return next;
		} else {
			length = 3;
			location = new Position(-2, col); //-1 was -2
			icons = new Icon[length];
			for (int i = 0; i < length; i++) {
				icons[i] = randomIcon();
			}
			next = new IPiece(location, icons);
			return next;
		}

	}

	@Override
	public Icon randomIcon() {
		return new Icon(Icon.COLORS[rand.nextInt(Icon.COLORS.length)]);
	}

}
