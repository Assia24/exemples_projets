/**
 * 
 */
package fil.coo.action;

/**
 * the sequentialSceduler wait the first action in list to finish to operate the following 
 * @author Assia TRARI, Lina RADI
 *
 */
public class SequentialScheduler extends SchedulerAction {

	/**return the first action in the list of action
	 * @return the first action in the list of action*/
	protected Action getNextAction() {
		return this.getActions().get(0);
	}

}
