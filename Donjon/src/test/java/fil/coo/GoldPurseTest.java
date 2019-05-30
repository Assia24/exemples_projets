/**
 * 
 */
package fil.coo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fil.coo.Room;
import fil.coo.character.Player;
import fil.coo.item.GoldPurse;

/**
 * @author TRARI Assia RADI Lina
 *
 */
public class GoldPurseTest {
	protected GoldPurse gp;
	protected Player p;
	protected Room r;
	
	@Before
	public void init(){
		this.gp=new GoldPurse(15);
		this.p=new Player("titi",1,1,1);
		this.r=new Room();
	}

	/**
	 * Test method for {@link fil.coo.item.GoldPurse#GoldPurse(int)}.
	 */
	@Test
	public void testGoldPurse() {
		assertNotNull(this.gp);
	}

	/**
	 * Test method for {@link fil.coo.item.GoldPurse#use(fil.coo.character.Player, fil.coo.Room)}.
	 */
	@Test
	public void testUse() {
		assertEquals(1,this.p.getGold());
		this.gp.use(p, r);
		assertEquals(16,this.p.getGold());
	}

	/**
	 * Test method for {@link fil.coo.item.GoldPurse#getNbCoins()}.
	 */
	@Test
	public void testGetNbCoins() {
		assertEquals(15,this.gp.getNbCoins());
	}

}
