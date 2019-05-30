package fil.coo.action;

public abstract class Action {
	
	/**this action state**/
	protected ActionState state;
	/**boolean stop*/
	protected boolean stop;
	
	public Action() {
		this.stop=false;
		this.state=ActionState.READY;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public ActionState getState() {
		return this.state;
	}
	
	public boolean isFinished(){
		return this.getState()==ActionState.FINISHED;
	}
	public boolean isReady(){
		return this.state==ActionState.READY;
	}
	public void setState(ActionState s){
		this.state=s;
	}
	
	protected abstract void makeOneStep();
	protected abstract void stopCondition();
	public String toString() {
		return " action state : " +this.getState();
	}
	
	public void doStep() throws ActionFinishedException{
		if (this.isFinished())
			throw new ActionFinishedException("cannot doStep when finished");
		if (this.isReady())
			this.setState(ActionState.IN_PROGRESS);
		this.makeOneStep();
		this.stopCondition();
		
	}

}
