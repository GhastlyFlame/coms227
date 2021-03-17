package lab3;

public class RabbitModel3 {
	private int population = 500;

	public RabbitModel3() {

	}

	public void reset() {
		population = 500;
	}

	public void simulateYear() {
		population/=2;
	
	}


	public int getPopulation() {
		return population;
	}
}
