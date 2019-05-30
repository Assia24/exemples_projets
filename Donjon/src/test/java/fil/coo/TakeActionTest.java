/**
 * 
 */
package fil.coo;

import static org.junit.Assert.*;

import org.junit.Test;

import fil.coo.Room;
import fil.coo.action.Action;
import fil.coo.action.TakeAction;
import fil.coo.item.HealthPotion;

/**
 * @author assia
 *
 */
public class TakeActionTest extends ActionTest {

	/**
	 * Test method for {@link fil.coo.action.TakeAction#isPossible(fil.coo.Room)}.
	 */
	@Test
	public void testIsPossible() {
		assertFalse(this.a.isPossible(this.r));
		this.r.addItem(new HealthPotion(5));
		assertTrue(this.a.isPossible(this.r));
	}
	/**
	 * Test method for {@link fil.coo.action.Action#getLabel()}.
	 */
	@Test
	public void testGetLabel() {
		assertEquals("Take",this.a.getLabel());
	}
	public Action createAction(){
		return new TakeAction();
	}

}
