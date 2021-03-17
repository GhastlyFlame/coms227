package hw2;

import api.Outcome;
import api.Defaults;

/**
 * @author Haadi
 *
 */
public class CricketGame {
	private int side0Score = 0; // score of side 0
	private int side1Score = 0; // score of side 1
	private int numPlayers = 0; // number of players on each team
	private int numOuts = 0; // number of outs this inning
	private int completedInnings = 0; // number of completed innings this game
	private int totalInnings = 0; // max number of innings this game
	private int bowlCount = 0; // number of bowls this over
	private int bowlsPerOver = 0; // max number of bowls per over
	private int numOvers = 0; // number of overs this inning
	private int oversPerInning = 0; // max number of overs per inning
	private int teamBatting = 0; // keeps track of which team is currently
									// batting
	private boolean inPlay; // determines the status of the bowl
	private boolean isRunning; // keeps track of the batter's status

	/**
	 * If the given total innings is an odd number, then the actual number of
	 * innings will be one more than the given value. Side 0 will bat first.
	 * 
	 * @param givenBowlsPerOver    - constructor supplied value
	 * @param givenOversPerInnings - constructor supplied value
	 * @param givenTotalInnings    - constructor supplied value
	 * @param givenNumPlayers      - constructor supplied value
	 */
	public CricketGame(int givenBowlsPerOver, int givenOversPerInnings, int givenTotalInnings, int givenNumPlayers) {
		bowlsPerOver = givenBowlsPerOver;
		oversPerInning = givenOversPerInnings;
		totalInnings = givenTotalInnings + givenTotalInnings % 2;
		numPlayers = givenNumPlayers;
	}

	/**
	 * Constructs a CricketGame using the public default values. Side 0 will bat
	 * first.
	 */
	public CricketGame() {
		bowlsPerOver = Defaults.DEFAULT_BOWLS_PER_OVER;
		oversPerInning = Defaults.DEFAULT_OVERS_PER_INNINGS;
		totalInnings = Defaults.DEFAULT_NUM_INNINGS;
		numPlayers = Defaults.DEFAULT_NUM_PLAYERS;
	}

	public void bowl(Outcome outcome) {
		// Bowls the ball and updates the game state depending on the given
		// outcome.
		bowlCount++;
		if (bowlCount == bowlsPerOver && bowlCount < numPlayers) {
			numOvers++;
			bowlCount = 0;
		}

		if (Outcome.WICKET == outcome || Outcome.LBW == outcome || Outcome.CAUGHT_FLY == outcome) {
			numOuts++;
			if (numOuts == numPlayers - 1 && !inPlay) {
				completedInnings = Math.min(completedInnings + 1, totalInnings);
				numOvers = 0;
				teamBatting = completedInnings % 2;
				numOuts = 0;
				bowlCount = 0;
			}
			if (inPlay) {
				numOuts--;
			}
		} else if (Outcome.NO_BALL == outcome || Outcome.WIDE == outcome) {
			addScore(teamBatting, 1);
			bowlCount--;
		} else if (Outcome.BOUNDARY_FOUR == outcome) {
			if (isGameEnded() == false && !inPlay) {
				addScore(teamBatting, 4);
			}
		} else if (Outcome.BOUNDARY_SIX == outcome) {
			if (isGameEnded() == false && !inPlay) {
				addScore(teamBatting, 6);
			}
		} else if (Outcome.HIT == outcome) {
			inPlay = true;
		}

		if (numOvers == oversPerInning) {
			completedInnings = Math.min(completedInnings + 1, totalInnings);
			numOvers = 0;
			numOuts = 0;
			bowlCount = 0;
			if(!isRunning && inPlay) {
				addScore(teamBatting, 1);
			}
			teamBatting = (teamBatting + 1) % 2;
			inPlay = false;
		}
	}

	/**
	 * 
	 * @return number of bowls so far in the current over
	 */
	public int getBowlCount() {
		// Returns the number of times the bowler has bowled so far during the
		// current
		// over, not counting wicket or no-balls.
		return bowlCount;
	}

	/**
	 * @return number of completed innings
	 */
	public int getCompletedInnings() {
		return completedInnings;
	}

	/**
	 * 
	 * @return the number of players out in the current innings.
	 */
	public int getOuts() {
		return numOuts;
	}

	/**
	 * 
	 * @return the number of completed overs for the current innings
	 */
	public int getOverCount() {
		return numOvers;
	}

	/**
	 * 
	 * @param battingSide - if true, returns the score for the side currently at
	 *                    bat; otherwise returns the score for the other side
	 * @return score for one of the two sides
	 */
	public int getScore(boolean battingSide) {
		int output;
		if (battingSide) {
			if (teamBatting == 0) {
				output = side0Score;
			} else {
				output = side1Score;
			}
		} else {
			if (teamBatting == 1) {
				output = side0Score;
			} else {
				output = side1Score;
			}
		}
		return output;
	}

	/**
	 * 
	 * @return true if the game has ended, false otherwise
	 */
	public boolean isGameEnded() {
		boolean status = false;
		if (totalInnings == completedInnings) {
			status = true;
		}
		if (totalInnings - 1 == completedInnings && side1Score > side0Score) {
			status = true;
		}
		return status;
	}

	/**
	 * 
	 * @return true if the ball is currently in play, false otherwise
	 */
	public boolean isInPlay() {
		// Returns true if the ball is currently in play.
		return inPlay;
	}

	/**
	 * 
	 * @return true if batsmen are running, false otherwise
	 */
	public boolean isRunning() {
		// Returns true if batsmen are currently running.
		return isRunning;
	}

	/**
	 * Runs the batsman out (i.e., fielders knock over wicket while batsmen are
	 * running).
	 */
	public void runOut() {

		if (isRunning) {
			isRunning = false;
			numOuts++;
			inPlay = false;
		}
	}

	/**
	 * Transitions from ball in play to ball not in play, without an out.
	 */
	public void safe() {
		if (isRunning) {
			addScore(teamBatting, 1);
		}
		inPlay = false;
		isRunning = false;
	}

	/**
	 * Starts the batsmen running from one end of the pitch to the other.
	 */
	public void tryRun() {
		if (isRunning && inPlay) {
			addScore(teamBatting, 1);
		}
		if (inPlay) {
			isRunning = true;
		}

	}

	/**
	 * @return 0 if side 0 is batting or 1 if side 1 is batting
	 */
	public int whichSideIsBatting() {
		return teamBatting;
	}

	/**
	 * @param team   - team one or zero to know which team to add points to
	 * @param amount - how many points to add to said team
	 */
	private void addScore(int team, int amount) {
		if (team == 0) {
			side0Score += amount;
		}

		if (team == 1) {
			side1Score += amount;
		}
	}
}
