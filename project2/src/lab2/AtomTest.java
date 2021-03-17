/**
 * 
 */
package lab2;

/**
 * @author hmajeed
 *
 */
public class AtomTest {
	public static void main(String[] args) {
		Atom Urainium = new Atom(92, 146, 92);
		System.out.println(Urainium.getAtomicCharge());
		System.out.println(Urainium.getAtomicMass());
		Urainium.decay();
		System.out.println(Urainium.getAtomicCharge());
		System.out.println(Urainium.getAtomicMass());
		
	}

}
