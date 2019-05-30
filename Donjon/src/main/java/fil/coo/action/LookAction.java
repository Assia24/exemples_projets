package fil.coo.action;

import fil.coo.AdventureGame;
import fil.coo.Room;
import fil.coo.character.Player;
/**
* The Look Action program represents One of the actions that the player could act
* in the different rooms,this action is always possible and provides a full discription of the current room.
* @author Lina RADI et Assia Trari
*
*/

public class LookAction extends Action{

	
	public LookAction() {
		super();
		super.label="Look";
		// TODO Auto-generated constructor stub
	}




	public void execute(Player p, Room r, AdventureGame g) {
		
		
		System.out.println("\n********* \n	"+g.getCurrentRoom().toString()+"\n*********");
		
	}

	public boolean isPossible(Room r) {
		return true;
	} 

}
