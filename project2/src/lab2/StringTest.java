/**
 * 
 */
package lab2;

/**
 * @author haadi
 *
 */
public class StringTest {


	public static void main(String[] args) {

		String message;
		message = "Hello, world!";
		System.out.println(message);
		int theLength = message.length();
		System.out.println(theLength);
		char theChar = message.charAt(0);
		System.out.println(theChar);

		theChar = message.charAt(1);
		System.out.println(theChar);	
		System.out.println(message.toUpperCase());
		System.out.println(message.substring(0, 5));
		message=message.replace('o', '*');
		System.out.println(message);
	}

}
