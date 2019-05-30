package fil.coo.action;

import fil.coo.resource.ResourceMock;
import fil.coo.resourcePool.ResourcePoolMock;

public class FreeResourceActionTest extends HandleResourceActionTest {


	

	@Override
	public Action createAction() {
		return new FreeResourceAction<ResourceMock>(new ResourcePoolMock(2), new fil.coo.resourceUser.ResourceUser());
	}
}
