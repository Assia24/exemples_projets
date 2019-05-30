/**
 * 
 */
package fil.coo.resourcePool;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author radi,trari
 *
 */
public class CubiclePoolTest extends ResourcePoolTest{
	
	public ResourcePool createResourcePool(int nbResource){
		return new CubiclePool(nbResource);
	}
	


}
