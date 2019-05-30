package fil.coo.action;

/**A ForeseableAction have a number of step (duration) to finished.
 * 
 * @author Assia Trari, Lina RADI
 *
 */

public class ForeseableAction extends Action {
	
	/**the duration of the action**/
	protected final int totalTime;
	/**the remaining time to finished this action*/
	protected int remainingTime;
	
	
	/**construct a ForeseableAction
	 * @param totalTime : the duration of this action
	 */
	public ForeseableAction(int totalTime){
		super();
		this.totalTime=totalTime;
		this.remainingTime=totalTime;
	}

	@Override
	protected void makeOneStep() {
		if(this.remainingTime != 0)
			this.remainingTime--;
	}

	/**set this state to finished if this ForeseableActions is finished*/
	protected void stopCondition() {
		this.setStop(this.getRemainingTime()<=0);
		if(this.isStop()){
			/*ad */
			this.setState(ActionState.FINISHED);
		}
		
	}

	public int getRemainingTime() {
		return remainingTime;
	}

	public void setRemainingTime(int remainingTime) {
		this.remainingTime = remainingTime;
	}
	
	/**retrun a string description of this action's progression
	 * 
	 * @return a string description of this action's progression
	 */
	public String progression() {
		return "("+(this.getTotalTime()-this.getRemainingTime())+"/"+this.getTotalTime()+")";
	}

	/**
	 * @return the totalTime
	 */
	public int getTotalTime() {
		return totalTime;
	}
	
	public String toString() {
		return this.progression();
		
	}
	
	/* (non-Javadoc)
	 * @see fil.coo.action.Action#doStep()
	 */
	public void doStep() throws ActionFinishedException {
		super.doStep();
		System.out.println(this.toString());
	}



}
