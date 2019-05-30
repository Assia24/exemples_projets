/**
 * 
 */
package fil.coo.city;

import fil.coo.Letter.Letter;
import fil.coo.bank.Account;
import fil.coo.bank.NotEnoughMoneyException;
import fil.coo.content.Content;

/**An Inhabitant has a name, a city and a bank account. He can receive or send letter and credit or debit his bank account.
 * @author RADI Lina, TRARI Assia
 *
 */
public class Inhabitant {
	protected String name;
	protected City c;
	private Account baccount;

	/**Constructor for this Inhabitant
	 * @param name : this Inhabitant's name
	 * @param c : this Inhabitant's city
	 */
	public Inhabitant(String name, City c) {
		this.name=name;
		this.c=c;
		this.baccount=new Account(this);
		
	}

	public String getName() {
		return this.name;
	}

	/**send a letter.
	 * @param l the letter to send
	 */
	public void sendLetter(Letter<? extends Content> l) {
		try {
			this.creditAccount(l.getCost());
		}catch(NotEnoughMoneyException e) {
			System.out.println("can't send letter, not enough money !");
		}
		this.getCity().addToMailbox(l);
		System.out.println(">>> "+this.getName()+" send a "+l.toString()+" to "+l.getReceiver().getName());
		
	}
	
	/**Receive a letter and execute the associated action
	 * @param l the received letter
	 */
	public void receiveLetter(Letter<? extends Content> l) {
		l.action();
		System.out.println(this.getName()+" receive a "+l.toString()+" from "+l.getSender().getName());
	}

	/**debit this inhabitant's bank account
	 * @param value the amount to debit
	 */
	public void debitAccount(float value) {
		this.baccount.debit(value);
		
	}
	
	/**Credit this inhabitant's bank account
	 * @param v the amount to credit
	 * @throws NotEnoughMoneyException if this inhabitant's account doesn't have enough money.
	 */
	public void creditAccount(float v) throws NotEnoughMoneyException {
		try {
			this.baccount.credit(v);
		}
		catch(NotEnoughMoneyException e) {
			System.out.println("Can't credit, this account doesn't have enough money.");
		}	
	}
	
	public float getSold() {
		return this.baccount.getSolde();
	}

	public City getCity() {
		return this.c;
	}
	
	public String toString() {
		return this.getName();
	}
	
	public boolean equals(Object o) {
		if (o instanceof Inhabitant) {
			Inhabitant other = (Inhabitant)o;
			return (this.name==other.name && this.getCity()==other.getCity());
		}
		return false;
	}
	
}
