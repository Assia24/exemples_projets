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
public class UndressActionTest extends ForeseableActionTest {

	public Action createAction() {
		return new UndressAction(3);
	}

}
