/**
 * 
 */
package fil.coo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fil.coo.Room;
import fil.coo.character.Player;
import fil.coo.item.HealthPotion;

/**
 * @author TRARI Assia RADI Lina
 *
 */
public class HealthPotionTest {
	protected HealthPotion hp;
	protected Player p;
	protected Room r;
	
	@Before
	public void init(){
		this.hp=new HealthPotion(15);
		this.p=new Player("titi",1,1,1);
		this.r=new Room();
	}

	/**
	 * Test method for {@link fil.coo.item.HealthPotion#HealthPotion(int)}.
	 */
	@Test
	public void testHealthPotion() {
		assertNotNull(this.hp);
	}

	/**
	 * Test method for {@link fil.coo.item.HealthPotion#use(fil.coo.character.Player, fil.coo.Room)}.
	 */
	@Test
	public void testUse() {
		assertEquals(1,this.p.getLifePoint());
		this.hp.use(p, r);
		assertEquals(16,this.p.getLifePoint());
	}

	/**
	 * Test method for {@link fil.coo.item.HealthPotion#getNbPoints()}.
	 */
	@Test
	public void testGetNbPoints() {
		assertEquals(15,this.hp.getNbPoints());
	}

}
