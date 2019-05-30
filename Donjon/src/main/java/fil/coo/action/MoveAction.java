package fil.coo.action;

import java.util.*;
import fil.coo.AdventureGame;
import fil.coo.ListChoser;
import fil.coo.Room;
import fil.coo.character.Player;
import fil.coo.direction.Direction;
/**
 * The Move Action program represents One of the actions that the player could act
 * in the different rooms if this action is possible.
 * it allows the player to move from a room to another one in order to reach the finish room .
 * @author Lina RADI et Assia Trari
 *
 */
public class MoveAction extends Action{

	public MoveAction() {
		super();
		super.label="Move";
	}



	public void execute(Player p , Room r,AdventureGame g) {
		List<Direction> ldir = r.possibleDirections();
		ListChoser lc = new ListChoser();
		Direction chosenDir =lc.chose("\nWhich direction ?", ldir);
		Room futurRoom = r.nextRoom(chosenDir);
		System.out.println("\n*** The Player enters in a new room ***\n");
		g.goToRoom(futurRoom);
		
	}


	public boolean isPossible(Room r) {
		return r.getMonsters().isEmpty();
	}
	
	

}
