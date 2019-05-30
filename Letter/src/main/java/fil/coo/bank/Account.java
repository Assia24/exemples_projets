/**
 * 
 */
package fil.coo.bank;

import fil.coo.city.Inhabitant;

/**A bank account where the owner can credit or debit money.
 * @author Assia TRARI Lina RADI
 *
 */
public class Account {
	protected float solde;
	protected Inhabitant owner;
	

	/**construct an account with 0 money
	 * @param owner this account's owner
	 */
	public Account(Inhabitant owner) {
		this.owner=owner;
		this.solde = 0;
	}
	
	/**construct an account with money
	 * @param owner this account's owner
	 * @money the money to put on this account
	 */
	public Account(Inhabitant owner, float money) {
		this(owner);
		this.solde = money;
	}
	
	/**Credit this account if there is enough money
	 * @param c the amount to credit
	 * @throws NotEnoughMoneyException if there is not enough money in this account
	 */
	public void credit(float c) throws NotEnoughMoneyException{
		if (this.solde>=c)
			this.solde=solde-c;
		else{
			throw new NotEnoughMoneyException();
		}
	}
	/** debit this account
	 * @param value the amount to debit
	 */
	public void debit(float value){
		this.solde=solde+value;
	}
	
	public float getSolde(){
		return this.solde;
	}
	
	public Inhabitant getOwner(){
		return this.owner;
	}
	
	public String toString(){
		return  this.getOwner().toString()+"' bankAccount.";
	}
	
	public boolean Equals(Object o){
		if (o instanceof Account){
			Account other= (Account)o;
			return (this.getOwner().equals(other.getOwner()) && this.getSolde()==other.getSolde());
		}
		return false;
	}
	
	

}
