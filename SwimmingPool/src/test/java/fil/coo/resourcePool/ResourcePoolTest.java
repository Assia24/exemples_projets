package fil.coo.resourcePool;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import fil.coo.resource.Resource;

/**
 * @author radi,trari
 *
 */
public class ResourcePoolTest {
	
	protected ResourcePool<Resource> rp;
	protected ResourcePool<Resource> rp2;

 	@Before 
 	public void init(){ 	
 		rp=(ResourcePool<Resource>) this.createResourcePool(5);
 		
 	}
 		
 	/**
	 * Test method for {@link fil.coo.resourcePool.ResourcePool#CreateResourcePool(int)}.
	 */
	public ResourcePool<? extends Resource> createResourcePool(int nbResource){
		return new ResourcePoolMock(nbResource);
	}


	/**
	 * Test method for {@link fil.coo.resourcePool.ResourcePool#CreateResource()}.
	 */
	@Test
	public void testCreateResource() {
		assertNotNull(this.rp);
	}


	/**
	 * Test method for {@link fil.coo.resourcePool.ResourcePool#ProvideResource()}.
	 */
	@Test(expected=NoSuchElementException.class)
	public void testProvideResourceWhenNoSuchElement() throws NoSuchElementException {
		rp2=(ResourcePool<Resource>) this.createResourcePool(0);
		assert(rp2.available.size()==0);
		rp2.provideResource();	
	}
	

	/**
	 * Test method for {@link fil.coo.resourcePool.ResourcePool#ProvideResource()}.
	 */
	@Test
	public void testProvideResourceWhenOk() {
		int oldSize=rp.available.size();
		rp.provideResource();
		int newSize=rp.available.size();
		assertEquals(oldSize-1,newSize);
	}
	
	

	/**
	 * Test method for {@link fil.coo.resourcePool.ResourcePool#RecoverResource()}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testRecoverResourceWhenIllegalArgument() throws IllegalArgumentException{
		rp.recoverResource(null);
	}
	
	/**
	 * Test method for {@link fil.coo.resourcePool.ResourcePool#RecoverResource()}.
	 */
	@Test
	public void testRecoverResourceWhenOk() {
		Resource resource=rp.provideResource();
		rp.recoverResource(resource);
		
	}

	
}
