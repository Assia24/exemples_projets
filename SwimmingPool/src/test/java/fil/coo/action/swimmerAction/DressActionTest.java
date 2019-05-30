package fil.coo.action.swimmerAction;

import org.junit.Test;

import fil.coo.action.Action;
import fil.coo.action.ForeseableAction;
import fil.coo.action.ForeseableActionTest;

public class DressActionTest extends ForeseableActionTest{

	public Action createAction() {
		return new DressAction(3);
	}

}
