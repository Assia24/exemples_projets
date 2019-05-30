package fil.coo.resourceUser;
/**to manage taken resource
 * @author assia,lina
 */

import fil.coo.resource.Resource;

public class ResourceUser<R extends Resource> {
	/*a resource*/
	protected R resource;
	
	public R getResource() {
		return resource;
	}
	
	public void setResource(R resource) {
		this.resource=resource;	
	}
	
	public void resetResource() {
		this.resource=null;
	}
	

}
