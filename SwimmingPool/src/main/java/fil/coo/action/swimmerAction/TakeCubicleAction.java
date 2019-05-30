/**
 * 
 */
package fil.coo.action.swimmerAction;

import fil.coo.action.TakeResourceAction;
import fil.coo.resource.Cubicle;
import fil.coo.resourcePool.ResourcePool;
import fil.coo.resourceUser.CubicleUser;

/**action of taking a cubicle from a cubicle pool
 * @author Assia TRARI Lina RADI
 *
 */
public class TakeCubicleAction extends TakeResourceAction<Cubicle>{

	/**Constructor for the action of taking a cubicle
	 * @param rp : the resource pool where to take a cubicle
	 * @param ru : the cubicle resource user to take a cubicle
	 */
	public TakeCubicleAction(ResourcePool<Cubicle> rp, CubicleUser ru) {
		super(rp, ru);
	}
	
	public String toString() {
		return (super.toString()+" a cubicle");
	}

}
