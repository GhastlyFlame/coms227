/**
 * 
 */
package lab3;
import plotter.SimulationPlotter;

/**
 * @author haadi
 *
 */
public class RabbitSimApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimulationPlotter plotter = new SimulationPlotter();
		RabbitModel myModel = new RabbitModel();
		plotter.simulate(myModel);
		
	}

}
