package fil.coo.resourcePool;

import fil.coo.resource.ResourceMock;

public class ResourcePoolMock extends ResourcePool<ResourceMock>{
	public ResourcePoolMock(int nbResources) {
		super(nbResources);
	}

	@Override
	public ResourceMock createResource() {
		return new ResourceMock();
	}

}
