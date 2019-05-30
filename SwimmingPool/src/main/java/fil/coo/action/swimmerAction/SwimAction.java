/**
 * 
 */
package fil.coo.action.swimmerAction;

import fil.coo.action.ForeseableAction;

/**action of swimming
 * @author Assia Trari Lina Radi
 *
 */
public class SwimAction extends ForeseableAction {

	/**Constructor for the action of swimming
	 * @param totalTime : the required time to swim
	 */
	public SwimAction(int totalTime) {
		super(totalTime);
	}
	
	public String toString() {
		return ("swimming")+ " " +super.toString();
	}


}
