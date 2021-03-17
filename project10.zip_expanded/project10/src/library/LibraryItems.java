package library;

import java.util.Date;

public abstract class LibraryItems implements Item{
	 /**
	   * Title of this item.
	   */
	  String title = "";
	  
	  /**
	   * Due date for this item.  This value is null when not checked out.
	   */
	  Date dueDate= null;
	  
	  /**
	   * Patron to whom this item is checked out.  This value is null when not checked out.
	   */
	  Patron checkedOutTo=null;

}
