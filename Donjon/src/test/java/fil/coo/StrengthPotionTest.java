/**
 * 
 */
package fil.coo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fil.coo.Room;
import fil.coo.character.Player;
import fil.coo.item.StrengthPotion;

/**
 * @author TRARI Assia RADI Lina
 *
 */
public class StrengthPotionTest {
	protected StrengthPotion sp;
	protected Player p;
	protected Room r;
	
	@Before
	public void init(){
		this.sp=new StrengthPotion(15);
		this.p=new Player("titi",1,1,1);
		this.r=new Room();
	}

	/**
	 * Test method for {@link fil.coo.item.StrengthPotion#StrengthPotion(int)}.
	 */
	@Test
	public void testStrengthPotion() {
		assertNotNull(this.sp);
	}

	/**
	 * Test method for {@link fil.coo.item.StrengthPotion#use(fil.coo.character.Player, fil.coo.Room)}.
	 */
	@Test
	public void testUse() {
		assertEquals(1,this.p.getStrength());
		this.sp.use(p, r);
		assertEquals(16,this.p.getStrength());
	}

	/**
	 * Test method for {@link fil.coo.item.StrengthPotion#getNbPoints()}.
	 */
	@Test
	public void testGetNbPoints() {
		assertEquals(15,this.sp.getNbPoints());
	}

}
