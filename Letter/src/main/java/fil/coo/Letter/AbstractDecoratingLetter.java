/**
 * 
 */
package fil.coo.Letter;

import fil.coo.city.Inhabitant;
import fil.coo.content.Content;

/**
 * @author assia
 *
 */
public abstract class AbstractDecoratingLetter extends Letter<Letter<?>>{

	public AbstractDecoratingLetter(Content c) {
		super(((Letter<?>)c).getSender(), ((Letter<?>)c).getReceiver(), c);
	}
	@Override
	public void action() {
		((Letter<?>) this.getContent()).action();
	}
	@Override
	public float getCost() {
		float p = ((Letter<?>) this.getContent()).getCost();
		return p;
	}
	/**
	 * @return the sender
	 */
	public Inhabitant getSender() {
		return ((Letter<?>) this.getContent()).getSender();
	}
	/**
	 * @return the receiver
	 */
	public Inhabitant getReceiver() {
		return ((Letter<?>) this.getContent()).getReceiver();
	}

	/**
	 * @return the content
	 */
	public Content getContent() {
		return content;
	}
	
	public String toString() {
		return this.getContent().toString();
	}
	

}
