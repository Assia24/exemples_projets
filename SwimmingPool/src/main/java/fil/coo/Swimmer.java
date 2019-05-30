package fil.coo;

import fil.coo.action.ActionFinishedException;
import fil.coo.action.HandleResourceAction;
import fil.coo.action.SequentialScheduler;
import fil.coo.action.swimmerAction.TakeBasketAction;
import fil.coo.action.swimmerAction.*;
import fil.coo.resourcePool.BasketPool;
import fil.coo.resourcePool.CubiclePool;
import fil.coo.resourceUser.BasketUser;
import fil.coo.resourceUser.CubicleUser;

/**A Swimmer is a sequentialScheduler who make in order the following actions :
 * takes a basket from a basketPool
 * takes a cubicle from a cubicle pool
 * undresses with a specific time
 * frees the cubicle
 * swims with a specific time
 * takes a cubicle from the cubiclePool
 * dress with a specific time
 * frees the cubicle
 * gives back the basket 
 * @author Assia TRARI Lina RADI
 *
 */

public class Swimmer extends SequentialScheduler{
	/**this swimmer's name.*/
	protected String name;
	/**the basket pool where to take a basket*/
	protected BasketPool bp;
	/**the cubicle pool where to take a cubicle*/
	protected CubiclePool cp;
	/**this Swimmer's required time to undress*/
	protected int undressTime;
	/**this Swimmer's require time to swim*/
	protected int swimTime;
	/** this Swimmer's require time to dress*/
	protected int dressTime;
	/** this Swimmer's BasketUser*/
	protected BasketUser bu;
	/** this Swimmer's CubicleUser**/
	protected CubicleUser cu;
	

	/**Construct a Swimmer
	 * @param name : this swimmer's name.
	 * @param basketsP : the basket pool where to take a basket
	 * @param cubiclesP : the cubicle pool where to take a cubicle
	 * @param undressTime : this Swimmer's required time to undress
	 * @param swimTime : this Swimmer's require time to swim
	 * @param dressTime : this Swimmer's require time to dress
	 */
	public Swimmer(String name, BasketPool basketsP, CubiclePool cubiclesP, int undressTime, int swimTime, int dressTime){
		this.name=name;
		this.bp=basketsP;
		this.cp=cubiclesP;
		this.undressTime=undressTime;
		this.swimTime=swimTime;
		this.dressTime=dressTime;
		
		//initialize the resource user
		this.bu=new BasketUser();
		this.cu= new CubicleUser();
		
		//Add the swimmer's actions in order to this swimmer's list of actions to do
		this.setTheSwimmerActions();
	}


	/**Add the swimmer's actions in order to this swimmer's list of actions to do*/
	private void setTheSwimmerActions() {
		this.addAction(new TakeBasketAction(this.getBp(),this.getBu()));
		this.addAction(new TakeCubicleAction(this.getCp(),this.getCu()));
		this.addAction(new UndressAction(this.getUndressTime()));
		this.addAction(new FreeCubicleAction(this.getCp(),this.getCu()));
		this.addAction(new SwimAction(this.getSwimTime()));
		this.addAction(new TakeCubicleAction(this.getCp(),this.getCu()));
		this.addAction(new DressAction(this.getDressTime()));
		this.addAction(new FreeCubicleAction(this.getCp(),this.getCu()));
		this.addAction(new GiveBackBasketAction(this.getBp(),this.getBu()));
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @return the bp
	 */
	public BasketPool getBp() {
		return bp;
	}


	/**
	 * @return the cp
	 */
	public CubiclePool getCp() {
		return cp;
	}


	/**
	 * @return the undressTime
	 */
	public int getUndressTime() {
		return undressTime;
	}


	/**
	 * @return the swimTime
	 */
	public int getSwimTime() {
		return swimTime;
	}


	/**
	 * @return the dressTime
	 */
	public int getDressTime() {
		return dressTime;
	}


	/**
	 * @return the bu
	 */
	public BasketUser getBu() {
		return bu;
	}


	/**
	 * @return the cu
	 */
	public CubicleUser getCu() {
		return cu;
	}
	
	public String toString() {
		return this.getName();
	}
	
	/* (non-Javadoc)
	 * @see fil.coo.action.Action#doStep()
	 */
	public void doStep() {
		if(this.getNextAction() instanceof HandleResourceAction) {
			HandleResourceAction<?> hr = (HandleResourceAction<?>) this.getNextAction();
			System.out.print(" "+this.getName()+" "+hr.toString() +" from "+hr.getRp().toString());
		}
		try {
			super.doStep();
			
		} catch (ActionFinishedException e) {
			;
		}
		System.out.println(" ");
	
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof Swimmer)) {
			return false;
		}
		Swimmer other = (Swimmer) obj;
		return (this.actions.equals(other.getActions()));
	}
	
	
	

}
