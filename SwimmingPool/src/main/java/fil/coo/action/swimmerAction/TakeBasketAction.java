package fil.coo.action.swimmerAction;

import fil.coo.action.TakeResourceAction;
import fil.coo.resource.Basket;
import fil.coo.resourcePool.ResourcePool;
import fil.coo.resourceUser.BasketUser;
/**action of taking a basket from a pool
 * 
 * @author assia trari, lina radi
 *
 */
public class TakeBasketAction extends TakeResourceAction<Basket>{

	/**Constructor for the action of taking a basket
	 * @param rp : the resource pool where to take a basket
	 * @param resourceUser : the basket resource user to take the basket
	 */
	public TakeBasketAction(ResourcePool<Basket> rp, BasketUser resourceUser) {
		super(rp, resourceUser);
	}
	
	public String toString() {
		return(super.toString()+" a basket");
	}
	

}
