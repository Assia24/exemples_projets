/**
 * 
 */
package fil.coo;

import static org.junit.Assert.*;

import org.junit.Test;

import fil.coo.Room;
import fil.coo.character.Monster;
import fil.coo.item.GoldPurse;

/**
 * @author TRARI Assia RADI Lina
 *
 */
public class MonsterTest {

	/**
	 * Test method for {@link fil.coo.character.Monster#dropHisGold(fil.coo.Room)}.
	 */
	@Test
	public void testDropHisGold() {
		Room r = new Room();
		Monster m= new Monster("m",1,1,5);
		
		assertEquals(5,m.getGold());
		assertEquals(0,r.getItems().size());
		m.dropHisGold(r);
		assertEquals(0,m.getGold());
		assertEquals(1,r.getItems().size());
		assertTrue(r.getItems().get(0) instanceof GoldPurse);
		assertEquals(5,((GoldPurse) r.getItems().get(0)).getNbCoins());
	}

}
