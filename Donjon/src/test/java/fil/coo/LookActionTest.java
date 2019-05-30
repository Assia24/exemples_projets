/**
 * 
 */
package fil.coo;

import static org.junit.Assert.*;

import org.junit.Test;

import fil.coo.Room;
import fil.coo.action.Action;
import fil.coo.action.LookAction;

/**
 * @author assia
 *
 */
public class LookActionTest extends ActionTest {


	/**
	 * Test method for {@link fil.coo.action.LookAction#isPossible(fil.coo.Room)}.
	 */
	@Test
	public void testIsPossible() {
		assertTrue(this.a.isPossible(this.r));
	}

	/**
	 * Test method for {@link fil.coo.action.Action#getLabel()}.
	 */
	@Test
	public void testGetLabel() {
		assertEquals("Look",this.a.getLabel());
	}
	
	public Action createAction(){
		return new LookAction();
	}

}
