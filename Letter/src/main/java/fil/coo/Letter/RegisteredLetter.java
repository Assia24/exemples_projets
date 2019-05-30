/**
 * 
 */
package fil.coo.Letter;

import fil.coo.city.Inhabitant;
import fil.coo.content.AcknowledgementOfReceipt;
import fil.coo.content.Content;
import fil.coo.content.Text;

/**
 * @author assia
 *
 */
public class RegisteredLetter extends AbstractDecoratingLetter {

	public RegisteredLetter(Content c) {
		super(c);
	}

	@Override
	public void action() {
		super.action();
		Text aor = new AcknowledgementOfReceipt(this.getReceiver());
		SimpleLetter l = new SimpleLetter(super.getReceiver(), super.getSender(), aor);
		super.getReceiver().sendLetter(l);

	}

	@Override
	public float getCost() {
		float p=super.getCost();
		return p + (15 * p / 100);
	}
	
	public String toString() {
		return "registered letter containing "+super.toString();
	}

}
