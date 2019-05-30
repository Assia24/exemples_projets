/**
 * 
 */
package fil.coo.action.swimmerAction;

import fil.coo.action.ForeseableAction;

/**action of getting dressed
 * @author Assia TRARI Lina RADI
 *
 */
public class DressAction extends ForeseableAction {

	/**Constructor for the action to getting dressed
	 * @param totalTime : the require time to dress
	 */
	public DressAction(int totalTime) {
		super(totalTime);
	}
	
	public String toString() {
		return ("getting dressed") + " " +super.toString();
	}
	

}
