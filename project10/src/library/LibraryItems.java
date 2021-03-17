package library;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class LibraryItems implements Item {
	/**
	 * Title of this item.
	 */
	String title = "";

	/**
	 * Due date for this item. This value is null when not checked out.
	 */
	Date dueDate = null;

	/**
	 * Patron to whom this item is checked out. This value is null when not
	 * checked out.
	 */
	Patron checkedOutTo = null;

	public void checkOut(Patron p, Date now) {
		if (!isCheckedOut()) {
			int checkOutDays = 7;

			// use a GregorianCalendar to figure out the Date corresponding to
			// midnight, 7 days from now
			GregorianCalendar cal = new GregorianCalendar();
			cal.setTime(now);
			cal.add(Calendar.DAY_OF_YEAR, checkOutDays);

			// always set to 11:59:59 pm on the day it's due
			cal.set(Calendar.HOUR_OF_DAY, 23);
			cal.set(Calendar.MINUTE, 59);
			cal.set(Calendar.SECOND, 59);

			// convert back to Date object
			dueDate = cal.getTime();

			checkedOutTo = p;
		}
	}

	public void checkIn() {
		if (isCheckedOut()) {
			checkedOutTo = null;
			dueDate = null;
		}
	}

	public void renew(Date now) {
		// cannot be renewed
	}

	public Patron getPatron() {
		return checkedOutTo;
	}

	public boolean isOverdue(Date now) {
		if (!isCheckedOut()) {
			return false;
		}
		return now.after(dueDate);
	}

	public int compareTo(Item other) {
		return title.compareTo(other.getTitle());
	}

	public String getTitle() {
		return title;
	}

	public boolean isCheckedOut() {
		return dueDate != null;
	}

	public Date getDueDate() {
		return dueDate;
	}
}
