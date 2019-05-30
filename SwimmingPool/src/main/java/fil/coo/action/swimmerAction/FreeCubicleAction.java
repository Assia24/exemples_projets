package fil.coo.action.swimmerAction;

import fil.coo.action.FreeResourceAction;

import fil.coo.resource.Cubicle;
import fil.coo.resourcePool.ResourcePool;
import fil.coo.resourceUser.CubicleUser;

/**action of freeing a resource
 * 
 * @author assia trari, lina radi
 *
 */
public class FreeCubicleAction extends FreeResourceAction<Cubicle>{

	/**Constructor for the action of freeing a cubicle
	 * @param rp : the resource pool from which the cubicle comes 
	 * @param ru : the resource user of the cubicle
	 */
	public FreeCubicleAction(ResourcePool<Cubicle> rp, CubicleUser ru) {
		super(rp, ru);
	}
	
	public String toString() {
		return("freeing cubicle");
	}

}
