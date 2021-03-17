package test;

import java.util.ArrayList;
import java.util.Random;

public class Problem1 {
	
	interface IPlayer {
		int play(); // Returns the player's move, which is always 0, 1, or 2

		int getPreviousMove(int movesAgo); // Returns a previous move
	}
	
	class AbstractPlayer implements IPlayer{
		protected Random rand = new Random();
		protected ArrayList<Integer> history = new ArrayList<Integer>();
		@Override
		public int play() {
			// TODO Auto-generated method stub
			return 0;
		}


		public int getPreviousMove(int movesAgo) {
			return history.get(history.size() - movesAgo);
		}
		
	}

	class RandomPlayer extends AbstractPlayer{
		

		public int play() {
			int move = rand.nextInt(3); // randomly chooses 0, 1, or 2
			history.add(move);
			return move;
		}
	}

	class AlternatingPlayer extends AbstractPlayer {
		private int state = 0;

		public int play() {
			// usually returns 0, but every third move randomly chooses 1 or 2
			int move = 0;
			if (state % 3 == 2) {
				move = rand.nextInt(2) + 1;
			}
			++state;
			history.add(move);
			return move;
		}

	}
}
