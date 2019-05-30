/**
 * 
 */
package fil.coo.action.swimmerAction;

import fil.coo.action.Action;
import fil.coo.action.ForeseableActionTest;

/**
 * @author assia
 *
 */
public class SwimActionTest extends ForeseableActionTest {

	public Action createAction() {
		return new SwimAction(3);
	}
}
