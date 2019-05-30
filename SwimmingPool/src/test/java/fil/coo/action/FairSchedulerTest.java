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
public class FairSchedulerTest extends SchedulerActionTest{

	/**
	 * Test method for {@link fil.coo.action.FairScheduler#makeOneStep()}.
	 */
	@Test
	public void testMakeOneStep() {
		assertSame(ActionState.READY,this.a1.getState());
		assertSame(ActionState.READY,this.a2.getState());
		this.sa.makeOneStep();
		assertSame(ActionState.IN_PROGRESS,this.a1.getState());
		assertSame(ActionState.READY,this.a2.getState());
		this.sa.makeOneStep();
		assertSame(ActionState.IN_PROGRESS,this.a1.getState());
		assertSame(ActionState.IN_PROGRESS,this.a2.getState());
		this.sa.makeOneStep();
		this.sa.makeOneStep();
		assertSame(ActionState.FINISHED,this.a1.getState());
	}

	/**
	 * Test method for {@link fil.coo.action.FairScheduler#getNextAction()}.
	 */
	@Test
	public void testGetNextAction() {
		assertSame(this.a1,this.sa.getNextAction());
		try {
			this.sa.doStep();
		} catch (ActionFinishedException e) {
			fail();
		}
		assertSame(this.a2,this.sa.getNextAction());
		try {
			this.sa.doStep();
		} catch (ActionFinishedException e) {
			fail();
		}
		assertSame(this.a3,this.sa.getNextAction());
		try {
			this.sa.doStep();
		} catch (ActionFinishedException e) {
			fail();
		}
		assertSame(this.a1,this.sa.getNextAction());
	}

	@Override
	public Action createAction() {
		return new FairScheduler();
	}
	

}
