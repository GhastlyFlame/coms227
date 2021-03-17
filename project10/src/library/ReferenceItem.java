package library;

import java.util.Date;

/**
 * A ReferenceItem is a library item that cannot be checked out.
 */
public class ReferenceItem extends LibraryItems {
	/**
	 * Constructs a ReferenceItem with the given title.
	 * 
	 * @param givenTitle
	 */
	public ReferenceItem(String givenTitle) {
		title = givenTitle;
	}

	@Override
	public double getFine(Date now) {
		// TODO Auto-generated method stub
		return 0;
	}


}
