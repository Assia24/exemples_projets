package fil.coo;
/**
 * Lina RADI assia TRARI
 * Main class to play to the DONJON GAME, interacting with the user.
 */
import java.util.ArrayList;
import java.util.List;

import fil.coo.action.Action;
import fil.coo.action.*;
import fil.coo.character.Player;
import fil.coo.gamemaps.*;
/**
 * 
 * The Donjon Main program runs the Adventure Game,initialize the gamemap
 * and starts the game.
 * @author Lina RADI et Assia Trari
 *
 */
public class DonjonMain {
	
	public static void main(String[] args){
		BasicGameMap gameMap = new BasicGameMap();
		gameMap.init();
		Player p1=new Player("Player",25, 11, 10);
		
		List<Action> existingActions= new ArrayList<Action>();
		existingActions.add(new LookAction());
		existingActions.add(new TakeAction());
		existingActions.add(new AttackAction());
		existingActions.add(new MoveAction());
		
		AdventureGame ag = new AdventureGame(gameMap.getStartingRoom());
		System.out.println("Welcome to the Donjon !");
		ag.play(p1, existingActions);
		
	}

}
