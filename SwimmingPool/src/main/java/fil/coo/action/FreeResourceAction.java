package fil.coo.action;

import fil.coo.resource.Resource;
import fil.coo.resourcePool.ResourcePool;
import fil.coo.resourceUser.ResourceUser;
/**give back a resource
 * 
 * @author assia trari, lina radi
 *
 * @param <R> the type of resource
 */
public class FreeResourceAction<R extends Resource> extends HandleResourceAction<R> {
	

	/**give back the resource to the original resource pool
	 * @param rp the resource pool
	 * @param ru the resource user to use the resource
	 */
	public FreeResourceAction(ResourcePool<R> rp, ResourceUser<R> ru) {
		super(rp, ru);
		
	}

	@Override
	protected void makeOneStep() {
		try {
			this.rp.recoverResource(ru.getResource());
		}catch(IllegalArgumentException e) {
			e.getMessage();
			return;
		}
		this.ru.resetResource();
		System.out.println("");
	}
	
	protected void stopCondition() {
		this.setStop(ru.getResource() == null);
		if(this.isStop())
			this.setState(ActionState.FINISHED);
		
	}
	
	public String toString() {
		return "freeing resource";
	}

}
