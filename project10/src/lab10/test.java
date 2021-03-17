package lab10;

import java.lang.reflect.Array;
import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		
		int[] test = {1,3,0,0,7};
		movePrimesLeft(test);
		for(int i : test){
			System.out.println(i);
		}

	}
	
	public static void movePrimesLeft(int[] a){
		int[] out = new int[a.length];
		int track =0;
		for(int i = 0; i < a.length;i++){
			if(isPrime(a[i]))
			{
				out[track]=a[i];
				track++;
				
			}
			
		}
		for(int i = track; track < a.length; i++)
		{
			out[i]=0;
		}
		a = Arrays.copyOf(out, 0);
	}

	private static boolean isPrime(int n) {
		 for(int i=2;i<n;i++) {
		        if(n%i==0)
		            return false;
		    }
		    return true;
	}

}
