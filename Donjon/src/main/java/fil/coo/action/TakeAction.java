package fil.coo.action;

import java.util.*;

import fil.coo.AdventureGame;
import fil.coo.ListChoser;
import fil.coo.Room;
import fil.coo.character.Player;
import fil.coo.item.Item;
/**@author Assia TRARI Lina RADI
 * 
 * Provide the user to chose an item to use
 *
 */
public class TakeAction extends Action{
	
	public TakeAction() {
		super();
		super.label="Take";
		// TODO Auto-generated constructor stub
	}

	public void execute(Player p, Room r,AdventureGame g) {
		if(!this.isPossible(r)){
			System.out.println("problem");
			return;
		}
		ListChoser lc = new ListChoser();
		List<Item> li=r.getItems();
		Item chosenItem = lc.chose("\nChose an item to use", li);
		chosenItem.use(p,r);
		r.removeItem(chosenItem);
		
	}

	public boolean isPossible(Room r) {
		return (r.getItems().size()>0);
	}

	

}
