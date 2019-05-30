/**
 * 
 */
package fil.coo.bank;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fil.coo.city.City;
import fil.coo.city.Inhabitant;

/**
 * @author radi
 *
 */
public class AccountTest {
	Account accountWithZeroSold;
	Account accountWithSold;
	Account account;
	public static final float MONEY=5000;
	
	@Before
	public void init(){
		
		Inhabitant inhabitant=new Inhabitant("toto",new City("Lille"));
		accountWithZeroSold=new Account(inhabitant);
		accountWithSold=new Account(inhabitant,MONEY);
		account=new Account(inhabitant);
	}

	/**
	 * Test method for {@link bank.Account#Account(city.Inhabitant)}.
	 */
	@Test
	public void testAccountInhabitant() {
		assertNotNull(accountWithZeroSold);
		assertTrue(accountWithZeroSold.getSolde()==0);
		
	}

	/**
	 * Test method for {@link bank.Account#Account(city.Inhabitant, float)}.
	 */
	@Test
	public void testAccountInhabitantFloat() {
		assertNotNull(accountWithSold);
		assertTrue(accountWithSold.getSolde()!=0);
		assertEquals(accountWithSold.getSolde(),MONEY,0);
	}

	/**
	 * Test method for {@link bank.Account#credit(float)}.
	 */
	@Test
	public void testCreditWhenEnoughMoney() {
		float soldToCredit=2000;
		
		float oldSold=accountWithSold.getSolde();
		assertEquals(accountWithSold.getSolde(),MONEY,0);
		try {
			accountWithSold.credit(soldToCredit);
		} catch (NotEnoughMoneyException e) {
			e.printStackTrace();
		}
		float soldAfterCredit=accountWithSold.getSolde();
		assertEquals(oldSold-soldToCredit,soldAfterCredit,0);
	}
	
	/**
	 * Test method for {@link bank.Account#credit(float)}.
	 * @throws NotEnoughMoneyException 
	 */
	@Test(expected=NotEnoughMoneyException.class)
	public void testCreditWhenNotEnoughMoney() throws NotEnoughMoneyException {
		float soldToCredit=2000;
		
		assertEquals(accountWithZeroSold.getSolde(),0,0);
		accountWithZeroSold.credit(soldToCredit);
	}

	/**
	 * Test method for {@link bank.Account#debit(float)}.
	 */
	@Test
	public void testDebit() {
		float oldSold=account.getSolde();
		account.debit(MONEY);
		float oldAfterDebit=account.getSolde();
		
		assertEquals(oldSold+MONEY,oldAfterDebit,1);
	}

}
