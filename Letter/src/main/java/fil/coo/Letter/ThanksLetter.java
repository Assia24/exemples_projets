/**
 * 
 */
package fil.coo.Letter;

import fil.coo.city.Inhabitant;
import fil.coo.content.Content;
import fil.coo.content.Text;

/**
 * @author radi
 *
 */
public class ThanksLetter extends SimpleLetter {
	private final static Text C = new Text("Merci");

	public ThanksLetter(Inhabitant i1, Inhabitant i2) {
		super(i1, i2, C);

	}
	public String toString() {
		return "thanks letter";
	}

}
