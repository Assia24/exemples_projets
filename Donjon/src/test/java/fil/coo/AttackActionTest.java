/**
 * 
 */
package fil.coo;

import static org.junit.Assert.*;

import org.junit.Test;


import fil.coo.action.Action;
import fil.coo.action.AttackAction;

/**
 * @author assia TRARI Lina RADI
 *
 */
public class AttackActionTest extends ActionTest{


	/**
	 * Test method for {@link fil.coo.action.AttackAction#isPossible(fil.coo.Room)}.
	 */
	@Test
	public void testIsPossible() {
		assertFalse(this.a.isPossible(r));
		r.addMonster(this.m);
		assertTrue(this.a.isPossible(r));
	}
	@Test
	public void testGetLabel() {
		assertEquals("Attack", a.getLabel());
	}
	public Action createAction(){
		return new AttackAction();
	}
	
	

}
