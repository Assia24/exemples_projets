/**
 * 
 */
package fil.coo.action.swimmerAction;

import fil.coo.action.Action;
import fil.coo.action.TakeResourceActionTest;
import fil.coo.resourcePool.BasketPool;
import fil.coo.resourceUser.BasketUser;

/**
 * @author assia
 *
 */
public class TakeBasketActionTest extends TakeResourceActionTest{
	public Action createAction() {
		return new TakeBasketAction(new BasketPool(2),new BasketUser());
	}


}
