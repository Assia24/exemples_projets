/**
 * 
 */
package fil.coo.action;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author assia
 *
 */
public class ForeseableActionTest extends ActionTest {

	/**
	 * Test method for {@link fil.coo.action.ForeseableAction#makeOneStep()}.
	 */
	@Test
	public void testMakeOneStepWhenRemainingTimeNotNull(){
		assertEquals(3,((ForeseableAction)this.someAction).getRemainingTime());
		this.someAction.makeOneStep();
		assertEquals(2,((ForeseableAction)this.someAction).getRemainingTime());
		this.someAction.makeOneStep();
		assertEquals(1,((ForeseableAction)this.someAction).getRemainingTime());
		
	}
	@Test
	public void testMakeOneStepWhenRemainingTimeIsNull(){
		assertEquals(3,((ForeseableAction)this.someAction).getRemainingTime());
		this.someAction.makeOneStep();
		this.someAction.makeOneStep();
		this.someAction.makeOneStep();
		assertEquals(0,((ForeseableAction)this.someAction).getRemainingTime());
		this.someAction.makeOneStep();
		assertEquals(0,((ForeseableAction)this.someAction).getRemainingTime());
	}

	/**
	 * Test method for {@link fil.coo.action.ForeseableAction#stopCondition()}.
	 */
	@Test
	public void testStopCondition() {
		this.someAction.stopCondition();
		assertEquals(ActionState.READY,this.someAction.getState());
		assertFalse(this.someAction.isStop());
		this.someAction.makeOneStep();
		this.someAction.makeOneStep();
		this.someAction.makeOneStep();
		this.someAction.stopCondition();
		assertEquals(ActionState.FINISHED,this.someAction.getState());
		assertTrue(this.someAction.isStop());
		
	}


	@Override
	public Action createAction() {
		return new ForeseableAction(3);
	}

}
