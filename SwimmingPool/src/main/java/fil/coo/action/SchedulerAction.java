/**
 * 
 */
package fil.coo.action;

import java.util.*;

/**A scheduler is an group of action
 * @author Assia TRARI, Lina RADI
 *
 */
public abstract class SchedulerAction extends Action{
	
	/**the list of this scedulerAction's actions*/
	protected List<Action> actions;
	


	/**Constructor for this ScedularAction*/
	public SchedulerAction () {
		super();
		this.actions = new ArrayList<Action>();
	}

	/**
	 * @return the actions
	 */
	public List<? extends Action> getActions() {
		return actions;
	}

	/**
	 * @param action : the actions to set
	 */
	public void addAction(Action action) {
		this.actions.add(action);
	}
	
	/**
	 * @param action : the actions to remove
	 */
	public void removeAction(Action action) {
		this.actions.remove(action);
	}
	
	/**return the next action to operate
	 * @return the next action to operate*/
	protected abstract Action getNextAction();

	@Override
	protected void makeOneStep() {
		if(! actions.isEmpty()) {  // happens if no action added to the scheduler before first doStep
			Action nextAction = this.getNextAction(); // result depends of the type of scheduler
			try {
				nextAction.doStep();
			} catch (ActionFinishedException e) {
				;
			}
			if(nextAction.isFinished()) {
				this.removeAction(nextAction);
			}
		}
		
	}

	/**set this state to finished if all of this actions are finished*/
	protected void stopCondition() {
		stop = (this.state == ActionState.IN_PROGRESS &&this.actions.isEmpty());
		if(stop) {
			this.state = ActionState.FINISHED;
		}
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof SchedulerAction)) {
			return false;
		}
		SchedulerAction other = (SchedulerAction) obj;
		return this.getActions().equals(other.getActions());
	}

}
