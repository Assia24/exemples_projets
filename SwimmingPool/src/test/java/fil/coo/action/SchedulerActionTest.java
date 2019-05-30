/**
 * 
 */
package fil.coo.action;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author assia
 *
 */
public abstract class SchedulerActionTest extends ActionTest {
	protected Action a1;
	protected Action a2;
	protected Action a3;
	protected SchedulerAction sa;
	
	@Before
	public void init(){
		super.init();
		a1=new ForeseableAction (2);
		a2=new ForeseableAction (2);
		a3=new ForeseableAction (2);
		this.sa=(SchedulerAction) someAction;
		this.sa.addAction(a1);
		this.sa.addAction(a2);
		this.sa.addAction(a3);
	}

	/**
	 * Test method for {@link fil.coo.action.SchedulerAction#makeOneStep()}.
	 */
	@Test
	public void testMakeOneStep() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link fil.coo.action.SchedulerAction#stopCondition()}.
	 */
	@Test
	public void testStopCondition() {
		assertSame(ActionState.READY,this.someAction.getState());
		//the whole actions for this test needs 6 doStep
		for (int i=0; i<6; i++) {
			try {
				this.someAction.doStep();
			}catch(ActionFinishedException e) {
				;
			}
		}
		assertSame(ActionState.FINISHED,this.someAction.getState());
		
	}

	/**
	 * Test method for {@link fil.coo.action.SchedulerAction#getNextAction()}.
	 */
	@Test
	public abstract void testGetNextAction();
	
	//public Action createAction() {
		//return new MockScheduler();
	//}
	
	
	//private class MockScheduler extends SchedulerAction{

		//@Override
		//protected Action getNextAction() {
			
			//return this.getActions().get(0);
		//}
		
	//}

}
