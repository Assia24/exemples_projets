package fil.coo.resourcePool;

import fil.coo.resource.Cubicle;
/** a pool of cubicle
 * 
 * @author assia trari, lina radi
 *
 */

public class CubiclePool  extends ResourcePool<Cubicle>{

	/**constructor for this cubicle pool
	 * @param i the number of resources for this cubicle pool
	 */
	public CubiclePool(int i) {
		super(i);
	}

	/* (non-Javadoc)
	 * @see fil.coo.resourcePool.ResourcePool#createResource()
	 */
	@Override
	public Cubicle createResource() {
		return new Cubicle();
	}
	
	public String toString() {
		return "pool Cubicle";
	}

}
