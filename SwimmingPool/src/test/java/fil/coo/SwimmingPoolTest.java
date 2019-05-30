/**
 * 
 */
package fil.coo;

import static org.junit.Assert.*;

import org.junit.Test;

import fil.coo.action.Action;
import fil.coo.action.ActionState;
import fil.coo.action.FairSchedulerTest;
import fil.coo.resourcePool.BasketPool;
import fil.coo.resourcePool.CubiclePool;

/**
 * @author assia
 *
 */
public class SwimmingPoolTest extends FairSchedulerTest{
	
	public Action createAction() {
		return new SwimmingPool();
	}

	/**
	 * Test method for {@link fil.coo.SwimmingPool#run()}.
	 */
	@Test
	public void testRun() {
		BasketPool bp = new BasketPool(2);
		CubiclePool cp =new CubiclePool(2);
		((SwimmingPool) this.someAction).registerSwimmer(new Swimmer("titi", bp, cp, 2, 2, 2));
		((SwimmingPool) this.someAction).registerSwimmer(new Swimmer("toto", bp, cp, 1, 1, 1));
		((SwimmingPool) this.someAction).run();
		assertEquals(ActionState.FINISHED,this.someAction.getState());
		
	}

}
