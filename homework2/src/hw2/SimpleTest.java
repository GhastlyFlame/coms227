package hw2;

import api.Outcome;

public class SimpleTest {

	public static void main(String[] args) {
		CricketGame g = new CricketGame(2, 3, 4, 6);
		/*
		 * g.bowl(Outcome.WIDE); g.bowl(Outcome.WIDE);
		 * System.out.println(g.getScore(true)); // expected 2
		 * System.out.println("Expected 2\n");
		 * 
		 * g = new CricketGame(2, 3, 4, 6); g.bowl(Outcome.BOUNDARY_SIX);
		 * System.out.println(g.getScore(true)); // expected 6
		 * System.out.println("Expected 6\n"); System.out.println(g.getBowlCount()); //
		 * expected 1 System.out.println("Expected 1\n");
		 * 
		 * g = new CricketGame(2, 3, 4, 6); g.bowl(Outcome.BOUNDARY_SIX);
		 * g.bowl(Outcome.BOUNDARY_SIX); g.bowl(Outcome.BOUNDARY_SIX);
		 * g.bowl(Outcome.BOUNDARY_SIX); g.bowl(Outcome.BOUNDARY_SIX);
		 * System.out.println(g.getBowlCount()); // expected 1
		 * System.out.println("Expected 1\n"); System.out.println(g.getOverCount()); //
		 * expected 2 System.out.println("Expected 2\n");
		 * 
		 * g = new CricketGame(2, 3, 4, 6); g.bowl(Outcome.BOUNDARY_SIX);
		 * g.bowl(Outcome.BOUNDARY_SIX); g.bowl(Outcome.BOUNDARY_SIX);
		 * g.bowl(Outcome.BOUNDARY_SIX); g.bowl(Outcome.BOUNDARY_SIX);
		 * g.bowl(Outcome.BOUNDARY_SIX); System.out.println(g.getBowlCount()); //
		 * expected 0 System.out.println("Expected 0\n");
		 * System.out.println(g.getOverCount()); // expected 0
		 * System.out.println("Expected 0\n");
		 * System.out.println(g.getCompletedInnings()); // expected 1
		 * System.out.println("Expected 1\n"); System.out.println(g.getScore(true)); //
		 * expected 0 System.out.println("Expected 0\n");
		 * System.out.println(g.getScore(false)); // expected 36
		 * System.out.println("Expected 36\n");
		 * 
		 * g = new CricketGame(2, 3, 4, 6); g.bowl(Outcome.HIT);
		 * System.out.println(g.isInPlay()); System.out.println("Expected True\n");//
		 * expected true g.safe(); System.out.println(g.isInPlay());
		 * System.out.println("Expected False\n");// expected false
		 * 
		 * g = new CricketGame(2, 3, 4, 6); g.bowl(Outcome.HIT); g.tryRun(); g.tryRun();
		 * g.tryRun(); g.runOut(); System.out.println(g.getScore(true)); // expected 2
		 * System.out.println("Expected 2\n"); System.out.println(g.getOuts()); //
		 * expected 1 System.out.println("Exptected 1\n");
		 */
		/*
		 * g = new CricketGame(2, 3, 4, 6); g.bowl(Outcome.WIDE);
		 * g.bowl(Outcome.BOUNDARY_FOUR); g.bowl(Outcome.HIT); g.tryRun(); g.tryRun();
		 * g.tryRun(); g.runOut(); g.bowl(Outcome.CAUGHT_FLY); g.bowl(Outcome.HIT);
		 * g.tryRun(); g.tryRun(); g.tryRun(); g.safe(); g.bowl(Outcome.LBW);
		 * System.out.println(g.getCompletedInnings()+"\n"+g.getOverCount()+"\n"+g.
		 * getBowlCount()+"\n"+g.getOuts()+"\n"+g.getScore(false)+"\n"+g.getScore(true))
		 * ; System.out.
		 * println("Expected: Innings: 0 Overs: 2 Bowls: 1 Outs: 3 Side0: 10 Side1: 0");
		 */
		g.bowl(Outcome.WIDE);
		g.bowl(Outcome.BOUNDARY_FOUR);
		g.bowl(Outcome.HIT);
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.runOut();
		g.bowl(Outcome.CAUGHT_FLY);
		g.bowl(Outcome.HIT);
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.safe();
		g.bowl(Outcome.LBW);

		String expected = "Innings: 0 Overs: 2 Bowls: 1 Outs: 3 Side0: 10 Side1: 0";
		String actual = createString(g);
		System.out.println(expected);
		System.out.println(actual + "\n");

		g.bowl(Outcome.WICKET);

		expected = "Innings: 1 Overs: 0 Bowls: 0 Outs: 0 Side0: 10 Side1: 0";
		actual = createString(g);
		System.out.println(expected);
		System.out.println(actual + "\n");


		g.bowl(Outcome.BOUNDARY_FOUR);
		g.bowl(Outcome.BOUNDARY_SIX);
		g.bowl(Outcome.NO_BALL);
		g.bowl(Outcome.NO_BALL);
		g.bowl(Outcome.NO_BALL);
		g.bowl(Outcome.NO_BALL);
		g.bowl(Outcome.NO_BALL);
		g.bowl(Outcome.NO_BALL);
		g.bowl(Outcome.HIT);
		g.tryRun();
		g.runOut();
		g.bowl(Outcome.CAUGHT_FLY);
		g.bowl(Outcome.CAUGHT_FLY);

		expected = "Innings: 1 Overs: 2 Bowls: 1 Outs: 3 Side0: 10 Side1: 16";
		actual = createString(g);
		System.out.println(expected);
		System.out.println(actual + "\n");
;

		g.bowl(Outcome.LBW);

		expected = "Innings: 2 Overs: 0 Bowls: 0 Outs: 0 Side0: 10 Side1: 16";
		actual = createString(g);
		System.out.println(expected);
		System.out.println(actual + "\n");


		g.bowl(Outcome.HIT);
		g.tryRun();
		g.tryRun();
		g.safe();
		g.bowl(Outcome.HIT);
		for (int i = 0; i < 20; i++) {
			g.tryRun();
		}
		g.runOut();
		g.bowl(Outcome.HIT);
		g.tryRun();
		g.runOut();
		g.bowl(Outcome.BOUNDARY_FOUR);
		g.bowl(Outcome.WICKET);

		expected = "Innings: 2 Overs: 2 Bowls: 1 Outs: 3 Side0: 35 Side1: 16";
		actual = createString(g);
		System.out.println(expected);
		System.out.println(actual + "\n");


		g.bowl(Outcome.HIT);
		System.out.println(expected);
		System.out.println(actual + "\n");

		g.tryRun();
		actual = createString(g);

		System.out.println(expected);
		System.out.println(actual + "\n");


		g.safe();

		expected = "Innings: 3 Overs: 0 Bowls: 0 Outs: 0 Side0: 36 Side1: 16";
		actual = createString(g);

		System.out.println(expected);
		System.out.println(actual + "\n");


	}

	public static String createString(CricketGame g) {
		int side0Score = g.getScore(g.whichSideIsBatting() == 0);
		int side1Score = g.getScore(g.whichSideIsBatting() == 1);

		StringBuilder sb = new StringBuilder();
		sb.append("Innings: ");
		sb.append(g.getCompletedInnings());
		sb.append(" Overs: ");
		sb.append(g.getOverCount());
		sb.append(" Bowls: ");
		sb.append(g.getBowlCount());
		sb.append(" Outs: ");
		sb.append(g.getOuts());
		sb.append(" Side0: ");
		sb.append(side0Score);
		sb.append(" Side1: ");
		sb.append(side1Score);
		if (g.isInPlay()) {
			sb.append(" (in play)");
		}
		if (g.isRunning()) {
			sb.append(" (running)");
		}
		if (g.isGameEnded()) {
			sb.append(" (ended)");
		}

		return sb.toString();
	}
}
