package lab8;

import java.io.File;
//import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
//import java.util.regex.Pattern;

public class Checkpointe1 {
	  public static void main(String[] args) throws IOException 
	    { 
		  
		  File file = new File("stuff\\story.txt");
		  Scanner in = new Scanner(file);
		  
		  while(in.hasNextLine())
		  {
			  Scanner in1 = new Scanner(in.nextLine());
			  int wordCount = 0;
			  while(in1.hasNext())
			  {
				  in1.next();
				  wordCount++;
			  }
			  System.out.println(wordCount);
			  in1.close();
		  }
		  in.close();
		  
	    } 
}
