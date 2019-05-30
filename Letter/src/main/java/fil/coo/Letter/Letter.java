package fil.coo.Letter;

import fil.coo.city.Inhabitant;
import fil.coo.content.Content;

public abstract class Letter<C extends Content> implements Content {

	private Inhabitant sender;
	private Inhabitant receiver;
	protected Content content;
	protected Float cost;

	public Letter(Inhabitant sender, Inhabitant receiver, Content c) {
		this.sender = sender;
		this.receiver = receiver;
		this.content = c;
	}

	/**
	 * @return the sender
	 */
	public Inhabitant getSender() {
		return sender;
	}

	/**
	 * @return the receiver
	 */
	public Inhabitant getReceiver() {
		return receiver;
	}

	/**
	 * @return the content
	 */
	public Content getContent() {
		return content;
	}

	public abstract void action();

	/**
	 * get this letter send cost
	 * 
	 * @return the cost of this letter
	 */
	public abstract float getCost();

	public String toString() {
		return "Letter from " + this.getSender().toString() + " to " + this.sender.toString() + ".";
	}

}
