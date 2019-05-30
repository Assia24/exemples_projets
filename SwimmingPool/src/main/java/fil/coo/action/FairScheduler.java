/**
 * 
 */
package fil.coo.action;

/**
 * the FairSceduler operate the actions of the list of action in parallel
 * @author Assia TRARI, Lina RADI
 *
 */
public class FairScheduler extends SchedulerAction{
	/**the index of the current action in the list*/
	private int index=0;

	/**return the next action in list of actions to do
	 * @return the next action in list of actions to do
	 */
	public Action getNextAction() {
		return this.getActions().get(index);
		
	}

	/**
	 * Increment the index of the action in the list of actions do to
	 */
	private void nextIndex() {
		if(this.getActions().size()>0)
			this.index=(index+1)%this.getActions().size();
	}
	
	//make one step + increment index
	public void makeOneStep() {
		super.makeOneStep();
		nextIndex();
	}
	
	

}
