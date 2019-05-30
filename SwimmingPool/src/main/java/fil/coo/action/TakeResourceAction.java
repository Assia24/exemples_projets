/**
 * 
 */
package fil.coo.action;

import java.util.*;

import fil.coo.resource.Resource;
import fil.coo.resourcePool.ResourcePool;
import fil.coo.resourceUser.ResourceUser;

/**to take a resource from a pool
 * @author assia
 *
 */
public class TakeResourceAction<R extends Resource> extends HandleResourceAction<R>{

	/**constructor
	 * @param rp the resourcePool
	 * @param ru the resource user
	 */
	public TakeResourceAction(ResourcePool<R> rp, ResourceUser<R> ru) {
		super(rp, ru);
	}

	protected void makeOneStep() {
		try {
			ru.setResource(rp.provideResource());
		}catch(NoSuchElementException e) {
			System.out.println("... failed");
			return;
		}
		System.out.println("... success");
		
	}


	/* (non-Javadoc)
	 * @see fil.coo.action.Action#stopCondition()
	 */
	protected void stopCondition() {
		this.setStop(ru.getResource() != null);
		if(this.isStop())
			this.setState(ActionState.FINISHED);
		
	}
	public String toString() {
		return "trying to take ";
	}

}
