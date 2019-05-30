/**
 * 
 */
package fil.coo.Letter;

import fil.coo.city.Inhabitant;
import fil.coo.content.Content;
import fil.coo.content.Text;

/**
 * A simple Letter, contains just only text
 * 
 * @author TRARI Assia RADI Lina
 *
 */
public class SimpleLetter extends Letter<Text> {
	private final float COST = 0.5f;

	public SimpleLetter(Inhabitant i1, Inhabitant i2, Content c) {
		super(i1, i2, c);
	}

	@Override
	public void action() {
		//System.out.println(this.getReceiver().getName()+" has received the letter.");
	}

	@Override
	public float getCost() {
		return COST;
	}
	
	public String toString() {
		return "simple letter";
	}

}
