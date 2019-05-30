/**
 * 
 */
package fil.coo.Letter;

import fil.coo.city.Inhabitant;
import fil.coo.content.Content;
import fil.coo.content.Money;

/**
 * @author radi
 *
 */
public class BillOfExchange extends Letter<Money> {

	public BillOfExchange(Inhabitant i1, Inhabitant i2, Content c) {
		super(i1, i2, c);
	}

	@Override
	public void action() {
		this.getSender().sendLetter(new ThanksLetter(this.getReceiver(), this.getSender()));
		this.getReceiver().debitAccount(((Money) this.getContent()).getValue());

	}

	@Override
	public float getCost() {
		float s = ((Money) this.getContent()).getValue();
		return 1 + (s / 100);
	}
	public String toString() {
		return "bill of exchange";
	}

}
