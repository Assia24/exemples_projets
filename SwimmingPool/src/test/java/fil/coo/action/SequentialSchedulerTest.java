/**
 * 
 */
package fil.coo.action;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author trari
 *
 */
public class SequentialSchedulerTest extends SchedulerActionTest {

	@Test
	public void testMakeOneStep() {
		assertSame(ActionState.READY,this.a1.getState());
		assertSame(ActionState.READY,this.a2.getState());
		this.sa.makeOneStep();
		assertSame(ActionState.IN_PROGRESS,this.a1.getState());
		assertSame(ActionState.READY,this.a2.getState());
		this.sa.makeOneStep();
		assertSame(ActionState.FINISHED,this.a1.getState());
		assertSame(ActionState.READY,this.a2.getState());
		this.sa.makeOneStep();
		this.sa.makeOneStep();
		assertSame(ActionState.FINISHED,this.a2.getState());
	}

	@Override
	public void testGetNextAction() {
		assertSame(this.a1,this.sa.getNextAction());
		try {
			this.sa.doStep();
		} catch (ActionFinishedException e) {
			fail();
		}
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
		assertSame(this.a2,this.sa.getNextAction());
		
	}

	@Override
	public Action createAction() {
		return new SequentialScheduler();
	}

}
