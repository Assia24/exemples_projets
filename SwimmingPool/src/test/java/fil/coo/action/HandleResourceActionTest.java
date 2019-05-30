/**
 * 
 */
package fil.coo.action;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import fil.coo.resource.Resource;
import fil.coo.resourcePool.ResourcePoolMock;

/**
 * @author trari
 *
 */
public abstract class HandleResourceActionTest<R extends Resource> extends ActionTest{
	protected ResourcePoolMock rp;
	protected fil.coo.resourceUser.ResourceUser ru;
	
	@Before
	public void init() {
		super.init();
		this.rp=new ResourcePoolMock(2);
		this.ru=new fil.coo.resourceUser.ResourceUser();
	}
	@Test
	public void testStopCondition() {
		assertSame(ActionState.READY,this.someAction.getState());
		try {
			this.someAction.doStep();
		} catch (ActionFinishedException e) {
			;
		}
		assertSame(ActionState.FINISHED,this.someAction.getState());
	}
	
	
}
