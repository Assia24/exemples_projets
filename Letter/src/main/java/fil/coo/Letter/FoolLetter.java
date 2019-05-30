/**
 * 
 */
package fil.coo.Letter;

import java.util.*;

import fil.coo.city.Inhabitant;
import fil.coo.content.FoolText;
import fil.coo.content.Money;

/**A fool letter contains a list of 4 inhabitants and has a probability of receiver to answere.
 * If he answeres, the receiver has to send 5euros to each inhabitant of the list, and resend a copy of
 * the edited fool Letter to 10 other Inhabitants.  
 * @author TRARI Assia RADI Lina
 */
public class FoolLetter extends SimpleLetter {
	protected int proba;

	/**Constructor for this FoolLetter
	 * @param i1 the sender
	 * @param i2 the receiver
	 * @param ft the text containing the list of names
	 * @param proba the probability of answere
	 */
	public FoolLetter(Inhabitant i1, Inhabitant i2, FoolText ft, int proba) {
		super(i1, i2, ft);
		this.proba=proba;
	}

	/* (non-Javadoc)
	 * @see fil.coo.Letter.SimpleLetter#action()
	 * with this probability
	 * send 5euros to each inhabitant of the list,change the message,send Fool letter to 10 inhabitants
	 */
	@Override
	public void action() {
		super.action();
		if(answere(this.proba)){
			//send 5euros to each inhabitant of the list
			send5eurosToEachInhabitants();
			//change the message
			editTheLetter();
			//send Fool letter to 10 inhabitants
			sendFoolLettersTo10Inhabitants();			
		}
	}

	/**chose if the receiver will answere
	 * @return true with proba in parameter, else false
	 */
	private boolean answere(int proba) {
		Random r = new Random();
		int i = r.nextInt(101);
		return i<=proba;
	}

	/**
	 * delete first name in the list of names in the letter and add the receiver name at the end
	 */
	private void editTheLetter() {
		//delete first name in the list
		((FoolText)this.getContent()).removeFirstName();
		//add receiver name at the end of the list
		((FoolText)this.getContent()).addName(this.getReceiver());
	}

	/**
	 * send 5euros to each inhabitant of the list in the letter
	 */
	private void send5eurosToEachInhabitants() {
		List<Inhabitant> l = new ArrayList<Inhabitant>();
		l=((FoolText)this.getContent()).getInhabitants();
		Money c = new Money(5);
		for(Inhabitant inhab : l){
			BillOfExchange boe= new BillOfExchange(this.getReceiver(),inhab,c);
			this.getReceiver().sendLetter(boe);
		}
	}

	/**
	 *send Fool letter to 10 random inhabitants of the receiver's city
	 */
	private void sendFoolLettersTo10Inhabitants() {
		int n;
		for (n=0;n<10;n++){
			Inhabitant receiver = this.getReceiver().getCity().getRandomInhabitant();
			FoolLetter l2=new FoolLetter(this.getReceiver(), receiver, (FoolText)this.getContent(), this.proba);
			this.getReceiver().sendLetter(l2);
		}
	}

	@Override
	public float getCost() {
		return super.getCost();
	}
	public String toString() {
		return "fool letter";
	}

}
