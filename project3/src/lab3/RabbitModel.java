package lab3;
import java.util.Random;

public class RabbitModel {
	private int population;
	private int lastYear;
	private int lastLastYear;
	Random rand = new Random();
	public RabbitModel() {
		population = 0;
		lastYear = 1;
		lastLastYear = 0;
	}

	public void reset() {
		population = 0;
		lastYear = 1;
		lastLastYear = 0;
	}

	public void simulateYear() {
		population = lastYear + lastLastYear;
		lastLastYear = lastYear;
		lastYear = population;
	}


	public int getPopulation() {
		return population;
	}
}
