/**
 * 
 */
package fil.coo.Letter;

import fil.coo.city.Inhabitant;
import fil.coo.content.Content;

/**
 * @author radi
 *
 */
public class MockLetter extends Letter<Content> {
	public boolean call;

	public MockLetter(Inhabitant i1, Inhabitant i2, Content c) {
		super(i1, i2, c);
		this.call = false;
	}

	public void action() {
		this.call = true;
	}

	public float getCost() {
		return 1;
	}

}
