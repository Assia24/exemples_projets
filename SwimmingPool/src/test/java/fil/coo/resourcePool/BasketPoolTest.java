/**
 * 
 */
package fil.coo.resourcePool;

/**
 * @author radi,trari
 *
 */
public class BasketPoolTest extends ResourcePoolTest{

	
	
	public BasketPool CreateResource(int nbResource) {
		return new BasketPool(nbResource);
	}

	

}
