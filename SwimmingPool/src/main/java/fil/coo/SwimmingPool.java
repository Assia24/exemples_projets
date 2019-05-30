package fil.coo;

import fil.coo.action.ActionFinishedException;
import fil.coo.action.FairScheduler;
/**A swimmingPool registers swimmers and makes them executes their action.
 * 
 * @author assia trari, lina radi
 *
 */
public class SwimmingPool extends FairScheduler{
	
	
	/**register a swimmer
	 * @param s the swimmer to register
	 */
	public void registerSwimmer(Swimmer s){ 
		this.addAction(s);
	}
	
	/**execute all the swimmer action*/
	public void run (){
		int nbSteps=0;
		while(!this.isFinished()){
			nbSteps++;
			try {
				System.out.println(this.getNextAction().toString()+"'s turn");
				this.doStep();
			} catch (ActionFinishedException e) {
				e.getMessage();
			}
			
		}
		System.out.println("Finished in "+nbSteps+"steps");
	}
	

}
