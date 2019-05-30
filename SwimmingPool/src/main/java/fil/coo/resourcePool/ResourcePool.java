package fil.coo.resourcePool;

import java.util.*;

import fil.coo.resource.Resource;
/**A resource pool.
 * 
 * @author assia trari lina radi
 *
 * @param <T> : the type of resources provided by this pool
 */

public abstract class ResourcePool<T extends Resource> {

	protected int nbResources;
	protected List<T> available;
	protected List<T> provided;
	
	
	/**construct a resource for this pool
	 * @return a resource for this pool
	 */
	public abstract T createResource();

	/**Constructor for this ResourcePool
	 * @param nbResources : the number of resources for this ResourcePool
	 */
	public ResourcePool(int nbResources) {
		
		this.nbResources = nbResources;
		this.available = new ArrayList<T>();
		this.provided = new ArrayList<T>();
		for(int i=0;i< this.nbResources;i++){
			available.add(this.createResource());
		}
	}
	/**
	 * provide a resource from this ResourcePool
	 * @return a resource
	 * @throws NoSuchElementException if this resource pool can't provide any resource
	 */
	public T provideResource()throws NoSuchElementException{
		if (this.available.size()==0){
			throw new NoSuchElementException();
		}
		else {
			T resource;
			resource=this.available.get(0);
			this.available.remove(resource);
			this.provided.add(resource);
			return resource;
		}

	}
	/**
	 * recover the resource in parameter to this resource Pool
	 * @param resource the resource to recover
	 * @throws IllegalArgumentException if this resource is not from this resource pool
	 */
	public void recoverResource( T resource) throws IllegalArgumentException {
		if (!this.provided.contains(resource)){
			throw new IllegalArgumentException("This resource can't be given back because it is not from this resource pool !\n");
		}else{
			this.available.add(resource);
			this.provided.remove(resource);
		}
	}
	
	
}
