/**
 * 
 */
package hw1;

/**
 * @author haadi
 *
 */
public class UberDriver {
	/**
	 * Maximum number of passengers allowed in the vehicle at one time.
	 */
	public static final int MAX_PASSENGERS = 4;

	/**
	 * Cost to operate the vehicle per mile.
	 */
	public static final double OPERATING_COST = 0.5;

	private double mileRate;
	private double minuteRate;
	private int pplNum = 0;
	private int totalTime = 0;
	private int totalMiles = 0;
	private double credits = 0;

	public UberDriver(double givenPerMileRate, double givenPerMinuteRate)// Constructs an UberDriver with the given
																			// per-mile rate and per-minute rate.
	{
		mileRate = givenPerMileRate;
		minuteRate = givenPerMinuteRate;
	}

	public int getTotalMiles()// Returns the total miles driven since this UberDriver was constructed.
	{
		return totalMiles;
	}

	public int getTotalMinutes()// Returns the total minutes driven since this UberDriver was constructed.
	{
		return totalTime;
	}

	public void drive(int miles, int minutes)// Drives the vehicle for the given number of miles over the given number
												// of minutes.
	{
		credits += pplNum * ((miles * mileRate) + (minutes * minuteRate));
		totalMiles += miles;
		totalTime += minutes;
	}

	public void waitAround(int minutes) // Simulates sitting in the vehicle without moving for the given number of
										// minutes.
	{
		drive(0, minutes);
	}

	public void driveAtSpeed(int miles, double averageSpeed)
	/*
	 * Drives the vehicle for the given number of miles at the given speed.
	 * Equivalent to drive(miles, m), where m is the actual number of minutes
	 * required, rounded to the nearest integer.
	 */
	{
		drive(miles, (int) Math.round((miles * 60) / averageSpeed));
	}
	public int getPassengerCount() // Returns the number of passengers currently in the vehicle.
	{
		return pplNum;
	}

	public void pickUp() // Increases the passenger count by 1, not exceeding MAX_PASSENGERS.
	{
		pplNum = Math.min(pplNum + 1, MAX_PASSENGERS);
	}

	public void dropOff()// Decreases the passenger count by 1, not going below zero.
	{
		pplNum = Math.max(pplNum - 1, 0);
	}

	public double getTotalCredits()// Returns this UberDriver's total credits (money earned before deducting
									// operating costs).

	{
		return (credits);
	}

	public double getProfit() // Returns this UberDriver's profit (total credits, less operating costs).
	{
		return (credits - totalMiles*OPERATING_COST);
	}

	public double getAverageProfitPerHour()// Returns this UberDriver's average profit per hour worked.
	{
		return getProfit() / (getTotalMinutes() / 60.0);
	}

}
