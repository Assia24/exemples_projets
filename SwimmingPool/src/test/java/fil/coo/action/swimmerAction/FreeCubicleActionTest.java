/**
 * 
 */
package fil.coo.action.swimmerAction;

import fil.coo.action.Action;
import fil.coo.action.FreeResourceActionTest;
import fil.coo.resourcePool.CubiclePool;
import fil.coo.resourceUser.CubicleUser;

/**
 * @author assia
 *
 */
public class FreeCubicleActionTest extends FreeResourceActionTest {

	public Action createAction() {
		return new FreeCubicleAction(new CubiclePool(2), new CubicleUser());
	}

}
