/**
 * 
 */
package fil.coo;

import static org.junit.Assert.*;

import org.junit.Test;

import fil.coo.Room;
import fil.coo.action.Action;
import fil.coo.action.MoveAction;

/**
 * @author assia Trari Lina RADI
 *
 */
public class MoveActionTest extends ActionTest {

	/**
	 * Test method for {@link fil.coo.action.MoveAction#isPossible(fil.coo.Room)}.
	 */
	@Test
	public void testIsPossible() {
		assertTrue(this.a.isPossible(r));
		r.addMonster(this.m);
		assertFalse(this.a.isPossible(r));
	}

	/**
	 * Test method for {@link fil.coo.action.Action#getLabel()}.
	 */
	@Test
	public void testGetLabel() {
		assertEquals("Move",this.a.getLabel());
	}
	public Action createAction(){
		return new MoveAction();
	}

}
