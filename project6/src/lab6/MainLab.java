/**
 * 
 */
package lab6;
import java.util.Scanner;
/**
 * @author haadi
 *
 */
public class MainLab {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initials();
//		int index = firstVowel();
//		System.out.println("Index of Vowel: " + index);
	}
	
	public static void initials()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Entre your name\n");
		String name = in.nextLine();
		String initials = name.charAt(0)+"";
		for(int i = 0; i < name.length(); i++)
		{
			if(name.charAt(i) == (' '))
			{
				initials += name.charAt(i+1);
			}
		}
		System.out.println(initials);
		in.close();
	}
	
	public static int firstVowel()
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Entre a string: ");
		String word = in.nextLine();
		char[] vowels = {'a','e','o','i','u','y'};
	    String wordLowered =  word.toLowerCase();
	    for (int i = 0; i < wordLowered.length(); i++){
	        for (int j = 0; j < vowels.length; j++) {
	           if (wordLowered.charAt(i) == vowels[j]){
	        	   in.close();
	              return i;
	           }
	        }
	    }
	    in.close();
	    return -1;
		
	}

}
