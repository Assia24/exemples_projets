package fil.coo.action;

import fil.coo.AdventureGame;
import fil.coo.Room;
import fil.coo.character.Player;
/**
* The Action program represents the different actions that the player could act
* in the different rooms.The list of possible Actions depends on what the room
what the room contains.
* @author Lina RADI et Assia Trari
*
*/
public abstract class Action {
	protected String label;

	
	public Action() {
	}
	
	public String getLabel() {
		return label;
	}
	

	/**Execute an Action.
	 * @param p the player who chose the action
	 * @param r the current room of the AdventureGame
	 * @param g the player's Adventure game .
	 */
	public abstract void execute(Player p, Room r, AdventureGame g);
	public abstract boolean isPossible(Room r);
	/**
	 * @return
	 */
	public String toString(){
		return this.getLabel();
	}

}
