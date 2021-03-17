/**
 * 
 */
package lab2;

/**
 * @author haadi
 *
 */
public class Atom {
		private int protons;
		private int neutrons;
		private int electrons;
	public Atom(int givenProtons, int givenNeutrons, int givenElectrons) {
		   this.protons = givenProtons;
		   this.neutrons = givenNeutrons;
		   this.electrons = givenElectrons;		   
		}
		
	public int getAtomicMass()
	{
		return protons + neutrons;
	}
	public int getAtomicCharge()
	{
		return  protons - electrons;
	}
	public void decay()
	{
		protons-=2;
		neutrons-=2;
	}
}
