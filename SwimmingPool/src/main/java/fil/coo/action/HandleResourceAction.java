/**
 * 
 */
package fil.coo.action;

import fil.coo.resource.Resource;
import fil.coo.resourcePool.ResourcePool;
import fil.coo.resourceUser.ResourceUser;

/**Handle a resource from a resource pool
 * @author Assia TRARI, Lina RADI
 *
 */
public abstract class HandleResourceAction<R extends Resource> extends Action {
	
	/**the resourcePool to handle*/
	protected ResourcePool<R> rp;
	/**the resource user who will use the resource*/
	protected ResourceUser<R> ru;
	

	/**Constructor for this handleResourceAction
	 * @param rp : the resourcePool to handle a resource
	 * @param ru : the resource user who will use this resource
	 */
	public HandleResourceAction(ResourcePool<R> rp, ResourceUser<R> ru) {
		this.rp = rp;
		this.ru = ru;
	}


	/**
	 * @return the rp
	 */
	public ResourcePool<R> getRp() {
		return rp;
	}


	/**
	 * @return the ru
	 */
	public ResourceUser<R> getRu() {
		return ru;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rp == null) ? 0 : rp.hashCode());
		result = prime * result + ((ru == null) ? 0 : ru.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof HandleResourceAction)) {
			return false;
		}
		HandleResourceAction other = (HandleResourceAction) obj;
		return this.getRp().equals(other.getRp())&&this.getRu().equals(other.getRu());
	}
	
	
	
	
}
