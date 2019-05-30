/**
 * 
 */
package fil.coo.action.swimmerAction;

import fil.coo.action.ForeseableAction;

/**action of getting undressed
 * @author Assia TRARI Lina RADI
 *
 */
public class UndressAction extends ForeseableAction{

	/**Constructor for the action of getting undressed
	 * @param totalTime : the require time to get undressed
	 */
	public UndressAction(int totalTime) {
		super(totalTime);
	}
	
	public String toString() {
		return ("getting undressed")+ " " +super.toString();
	}

}
