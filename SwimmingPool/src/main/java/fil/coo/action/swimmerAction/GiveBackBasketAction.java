/**
 * 
 */
package fil.coo.action.swimmerAction;

import fil.coo.action.FreeResourceAction;
import fil.coo.resource.Basket;
import fil.coo.resourcePool.ResourcePool;
import fil.coo.resourceUser.BasketUser;

/**action of giving back a cubicle
 * @author Assia TRARI Lina RADI
 *
 */
public class GiveBackBasketAction extends FreeResourceAction<Basket> {

	/**Constructor for the action of giving back a basket
	 * @param rp : the resource pool from which the basket comes 
	 * @param ru : the basket's resource user
	 */
	public GiveBackBasketAction(ResourcePool<Basket> rp, BasketUser ru) {
		super(rp, ru);
	}
	
	public String toString() {
		return ("giving back the basket");
	}

}
