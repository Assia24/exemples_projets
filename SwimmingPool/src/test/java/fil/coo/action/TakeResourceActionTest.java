/**
 * 
 */
package fil.coo.action;

import static org.junit.Assert.*;

import org.junit.Test;

import fil.coo.resource.ResourceMock;
import fil.coo.resourcePool.ResourcePoolMock;

/**
 * @author assia
 *
 */
public class TakeResourceActionTest extends HandleResourceActionTest{


	@Override
	public Action createAction() {
		return new TakeResourceAction<ResourceMock>(new ResourcePoolMock(2), new fil.coo.resourceUser.ResourceUser());
	}

}
