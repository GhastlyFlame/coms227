/**
 * 
 */
package lab3;
import java.util.Random;
import lab3.Person;
/**
 * @author haadi
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		String a = "Hello";
	    char b = a.charAt(1);
	    //char c = s.charAt(10);
	    System.out.println(a); 
	    System.out.println(b);
	    //#1
	    System.out.println(1000000%7);
	    	    
	    //#2
	    Person Phil = new Person("Phil Swift", 74);
	    System.out.println(Phil.getName());
	    System.out.println(Phil.getAge());
	    //System.out.println(a.getNameLength());
	    
	    //3
	    int c = 42;
	    String d = "" + c;
	    System.out.println(d);
	    String e = "42";
	    int f = Integer.parseInt(e);
	    System.out.println(f);
	    //int g = Integer.parseInt(a);
	    
	    //4
	    System.out.println(Integer.MAX_VALUE);
	    System.out.println(Integer.MIN_VALUE);
	    System.out.println(Integer.MAX_VALUE+1);
	    System.out.println(Integer.MAX_VALUE+2);
	    System.out.println(Integer.MAX_VALUE+Integer.MAX_VALUE);
	    
	    //5
	    Random rand = new Random();
	    System.out.println(rand.nextInt(6));
	    System.out.println(rand.nextInt(6));
	    System.out.println(rand.nextInt(6));
	    System.out.println(rand.nextInt(6));
	    Random band = new Random(137);
	    System.out.println(band.nextInt());
	    System.out.println(band.nextInt());
	    System.out.println(band.nextInt());
	    System.out.println(band.nextInt());
	    System.out.println(band.nextInt());
	    
	    
	    
	    
	}
}