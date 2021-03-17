package library;

//import java.util.Calendar;
import java.util.Date;
//import java.util.GregorianCalendar;

/**
 * A Book is a library item that can be checked out for 21 days and renewed at
 * most twice. If overdue, the fine is .25 per day.
 */
public class Book extends LibraryItems {
	/**
	 * Number of times the item has been renewed for the current patron.
	 */
	private int renewalCount;

	/**
	 * Constructs a book with the given title.
	 * 
	 * @param givenTitle
	 */
	public Book(String givenTitle) {
		title = givenTitle;
		dueDate = null;
		checkedOutTo = null;
		renewalCount = 0;
	}

	public void renew(Date now) {
		if (isCheckedOut() && !isOverdue(now) && renewalCount < 2) {
			super.checkOut(checkedOutTo, dueDate);
			renewalCount += 1;
		}
	}

	@Override
	public double getFine(Date now) {
		if (isCheckedOut() && isOverdue(now)) {
			// how late is it, in milliseconds
			double elapsed = now.getTime() - dueDate.getTime();

			// how late is it, in days
			int millisPerDay = 24 * 60 * 60 * 1000;
			int daysLate = (int) Math.ceil(elapsed / millisPerDay);

			// compute the fine, 25 cents per day
			return daysLate * .25;
		} else {
			return 0;
		}
	}

}