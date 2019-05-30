/**
 * 
 */
package fil.coo.action.swimmerAction;

import fil.coo.action.Action;
import fil.coo.action.TakeResourceActionTest;
import fil.coo.resourcePool.CubiclePool;
import fil.coo.resourceUser.CubicleUser;

/**
 * @author Assia Trari Lina RADI
 *
 */
public class TakeCubicleActionTest extends TakeResourceActionTest {

	public Action createAction() {
		return new TakeCubicleAction(new CubiclePool(2),new CubicleUser());
	}

}
