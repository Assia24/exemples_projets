/**
 * 
 */
package fil.coo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fil.coo.AdventureGame;
import fil.coo.Room;
import fil.coo.action.Action;
import fil.coo.character.Monster;

/**
 * @author assia TRARI Lina RADI
 *
 */
public class ActionTest {
	protected Action a;
	protected AdventureGame ag;
	protected Room r;
	protected Monster m;
	
	
	public Action createAction(){
		return new ActionMock();
	}
	
	
	@Before
	public void init(){
		this.a=this.createAction();
		this.r=new Room();
		this.ag =new AdventureGame(r);
		this.m=new Monster("Monster", 1, 1, 1);
	}

	/**
	 * Test method for {@link fil.coo.action.Action#Action()}.
	 */
	@Test
	public void testAction() {
		assertNotNull(this.a);
	}

	/**
	 * Test method for {@link fil.coo.action.Action#getLabel()}.
	 */
	@Test
	public void testGetLabel() {
		assertEquals("action", a.getLabel());
	}
	
	private class ActionMock extends Action{
		public ActionMock(){
			this.label="action";
		}
		public void execute(AdventureGame g){};
		public boolean isPossible(Room r){
			return true;
		}
		
	}

}
