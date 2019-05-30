/**
 * 
 */
package fil.coo.action;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fil.coo.action.Action;
import fil.coo.action.ActionFinishedException;
import fil.coo.action.ActionState;

/**
 * @author trari, radi
 *
 */
public abstract class ActionTest {
	protected Action someAction;
	
	public abstract Action createAction();
	
	@Before
	public void init(){
		this.someAction=this.createAction();
	}
	
	@Test
	public void creatorTest() {
		assertNotNull(this.someAction);
	}
	
	@Test
	public void stateIsReadyWhenActionCreatedTest(){
		assertEquals(ActionState.READY,this.createAction().getState());
	}
	
	@Test
	public void doStepAlwaysFinishedTest() throws ActionFinishedException{
		assertFalse(someAction.isFinished());
		while(!someAction.isFinished())
			someAction.doStep();
		assertTrue(someAction.isFinished());
	}
	
	@Test(expected=ActionFinishedException.class)
	public void doStepWhenFinishedThrowsExcceptionTest() throws ActionFinishedException{
		assertFalse(someAction.isFinished());
		while(!someAction.isFinished())
			someAction.doStep();
		assertTrue(someAction.isFinished());
		someAction.doStep();
	}
	

	/**
	 * Test method for {@link fil.coo.action.Action#doStep()}.
	 */
	@Test
	public void testDoStep() throws ActionFinishedException{
		assertSame(ActionState.READY,someAction.getState());
		someAction.doStep();
		assertNotSame(ActionState.READY,someAction.getState());
		
	}
	

	/**
	 * Test method for {@link fil.coo.action.Action#isReady()}.
	 */
	@Test
	public void testIsReady() {
		assertTrue(this.someAction.isReady());
	}
	
	@Test
	public void stateIsInProgressWhenStartedAndNotFinished(){
		try {
			someAction.doStep();
		} catch (ActionFinishedException e) {
			;
		}
		if(!someAction.isFinished())
			assertSame(ActionState.IN_PROGRESS,someAction.getState());
	}




}
