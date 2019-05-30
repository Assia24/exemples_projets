package fil.coo;

import java.util.*;

import fil.coo.action.Action;
import fil.coo.character.Monster;
import fil.coo.character.Player;
import fil.coo.item.Item;
/**
 * The Adventure Game program implements an application
 * for the "Donjon"
 * One player starts the game from a given starting room
 * which could contains list of monsters,items..
 * The game finishes when the player arrives to the finish room
 * or died when he attacks monsters.
 * @author Lina RADI et Assia Trari
 *
 */
public class AdventureGame {
	
	/**
	 * The current room of the game.
	 */
	private Room currentRoom;
	/**
	 * The player in the current room.
	 */
	private Player player;
	

	/**set a player in this current current room.
	 * @param player the player to set.
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**construct a new AdventureGame
	 * @param startingRoom : the starting room of this Adventure game.
	 */
	public AdventureGame(Room startingRoom){
		this.currentRoom= startingRoom;
	}
	
	/**get this AdventureGame's current Room
	 * @return this AdventureGame's current Room
	 */
	public Room getCurrentRoom() {
		return this.currentRoom;
	}
	
	/**get this current's room Player
	 * @return this current's room Player
	 */
	public Player getPlayer() {
		return this.player;
	}
	
	/**
	 * @param player
	 */
	public void play(Player player,List<Action> existingAction){
		
		while(!(this.getCurrentRoom().isExit()|| player.isDead())){
			List<Action> possibleActions=this.getCurrentRoom().getPossbileActions(existingAction);
			ListChoser lc = new ListChoser();
			Action a =lc.chose("What do you yant to do ? ( Enter the index of the action you want to chose. )",possibleActions);
			a.execute(player,this.getCurrentRoom(),this);
			System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		}
		if (this.getCurrentRoom().isExit()){
			System.out.println("Congratulations, you find the exit !");
		}else{
			System.out.println("Game over !");
		}
		
	}
	
	
	/**return true if this Adventuregame is finished, else false
	 * @return true if this Adventuregame is finished, else false
	 */
	public boolean isFinished(){
		return this.getCurrentRoom().isExit();
	}
	
	/**go in an other room
	 * @param newCurrentRoom : the room where to go
	 */
	public void goToRoom(Room newCurrentRoom){
		
		this.currentRoom=newCurrentRoom;
	}
}
