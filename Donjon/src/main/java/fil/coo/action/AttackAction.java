package fil.coo.action;

import java.util.*;
/**
* The Attack Action program represents One of the actions that the player could act
* in the different rooms if this action is possible,The list of possible Actions depends on what the room contains,
The player chose a Monster to Attack.
* @author Lina RADI et Assia Trari
*
*/

import fil.coo.AdventureGame;
import fil.coo.ListChoser;
import fil.coo.Room;
import fil.coo.character.Monster;
import fil.coo.character.Player;

public class AttackAction extends Action{
	

	public AttackAction() {
		super();
		super.label ="Attack";
	}

	public void execute(Player p, Room r, AdventureGame g) {

		if(!this.isPossible(r))
			return;
		ListChoser lc = new ListChoser();
		List<Monster> lm=r.getMonsters();
		Monster chosenMonster = lc.chose("\nChose a monster to attack", lm);
		p.attack(chosenMonster);
		if (chosenMonster.isDead()){
			System.out.println("\n*** The monster is dead !\n");
			chosenMonster.dropHisGold(r);
			r.removeMonster(chosenMonster);
			
		}else{
			chosenMonster.attack(p);
			System.out.println("\nYou have "+p.getLifePoint()+" life points");
		}
		
	}

	public boolean isPossible(Room r) {
		
		return (r.getMonsters().size()!=0);
	}

}
