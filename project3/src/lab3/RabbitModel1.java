package lab3;

public class RabbitModel1 {
	private int population = 2;

	public RabbitModel1() {

	}

	public void reset() {
		population = 2;
	}

	public void simulateYear() {
		population++;
	}


	public int getPopulation() {
		return population;
	}
}