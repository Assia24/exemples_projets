/**
 * 
 */
package fil.coo.action.swimmerAction;

import fil.coo.action.Action;
import fil.coo.action.FreeResourceActionTest;
import fil.coo.resourcePool.BasketPool;
import fil.coo.resourceUser.BasketUser;

/**
 * @author assia
 *
 */
public class GiveBackBasketActionTest extends FreeResourceActionTest{

	public Action createAction() {
		return new GiveBackBasketAction(new BasketPool(2), new BasketUser());
	}

}
