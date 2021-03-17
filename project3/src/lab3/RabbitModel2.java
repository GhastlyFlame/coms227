package lab3;
//if resets the instant year 5 occurs
///*
public class RabbitModel2 {
	private int population = 0;

	public RabbitModel2() {

	}

	public void reset() {
		population = 0;
	}

	public void simulateYear() {
		population++;
		if(population%5 == 0)
			population = 0;
	}


	public int getPopulation() {
		return population;
	}
}
//*/
//if resets after hitting 5 for a year
/*
 	public class RabbitModel {
 
	private int population = 0;

	public RabbitModel() {

	}

	public void reset() {
		population = 0;
	}

	public void simulateYear() {
		if(population%5 == 0 && population > 0)
			population = 0;
		else
			population++;
	}


	public int getPopulation() {
		return population;
	}
}
*/