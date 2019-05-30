package fil.coo.resourcePool;

import fil.coo.resource.Basket;
/** a pool of basket
 * 
 * @author assia trari, lina radi
 *
 */

public class BasketPool extends ResourcePool<Basket> {

	
	/**constructor for this basket pool
	 * @param i the number of resources for this pool
	 */
	public BasketPool(int i) {
		super(i);
	}

	/* (non-Javadoc)
	 * @see fil.coo.resourcePool.ResourcePool#createResource()
	 */
	@Override
	public Basket createResource() {
		return new Basket();
	}
	public String toString() {
		return "pool Basket";
	}

	
	
	

}
