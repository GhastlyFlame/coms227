package lab5;

import balloon1.Balloon;

public class BalloonTest {

	public static void main(String[] args) {
		Balloon b = new Balloon(5);
		System.out.println("balloon.Balloon will run with no errors");
		System.out.println("Is the baloon popped? " + b.isPopped()+"\nWhat is the radius: "+b.getRadius());
		b.blow(3);
		System.out.println("Is the baloon popped? " + b.isPopped()+"\nWhat is the radius: "+b.getRadius());
		b.deflate();
		System.out.println("Is the baloon popped? " + b.isPopped()+"\nWhat is the radius: "+b.getRadius());
		b.pop();
		System.out.println("Is the baloon popped? " + b.isPopped()+"\nWhat is the radius: "+b.getRadius());
		
		System.out.println("\nballoon1.Balloon keeps inflating and does not care if it is popped, also can be inflated beyond the max");
		b=new Balloon(5);
		System.out.println("The max size is set to 5");
		b.blow(4);
		System.out.println("Is the baloon popped? " + b.isPopped()+"\nWhat is the radius: "+b.getRadius());
		b.blow(5);
		System.out.println("Is the baloon popped? " + b.isPopped()+"\nWhat is the radius: "+b.getRadius());

		System.out.println("\nballoon2.Balloon does not check if it is already popped");
		b = new Balloon(5);
		System.out.println("Is the baloon popped? " + b.isPopped()+"\nWhat is the radius: "+b.getRadius());
		b.blow(3);
		System.out.println("Is the baloon popped? " + b.isPopped()+"\nWhat is the radius: "+b.getRadius());
		b.pop();
		System.out.println("Is the baloon popped? " + b.isPopped()+"\nWhat is the radius: "+b.getRadius());
		b.blow(1);
		System.out.println("Is the baloon popped? " + b.isPopped()+"\nWhat is the radius: "+b.getRadius());
		
		System.out.println("\nballoon3.Balloon does not add the amount, it just sets it");
		b = new Balloon(5);
		System.out.println("Is the baloon popped? " + b.isPopped()+"\nWhat is the radius: "+b.getRadius());
		b.blow(3);
		System.out.println("Is the baloon popped? " + b.isPopped()+"\nWhat is the radius: "+b.getRadius());
		b.blow(2);
		System.out.println("Is the baloon popped? " + b.isPopped()+"\nWhat is the radius: "+b.getRadius());
		
		System.out.println("\nballoon4.Balloon deflating pops the balloon");
		b = new Balloon(5);
		System.out.println("Is the baloon popped? " + b.isPopped()+"\nWhat is the radius: "+b.getRadius());
		b.blow(3);
		System.out.println("Is the baloon popped? " + b.isPopped()+"\nWhat is the radius: "+b.getRadius());
		b.deflate();
		System.out.println("Is the baloon popped? " + b.isPopped()+"\nWhat is the radius: "+b.getRadius());

	}

}
