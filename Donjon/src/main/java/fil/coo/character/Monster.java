package fil.coo.character;

import fil.coo.Room;
import fil.coo.item.GoldPurse;

public class Monster extends GameCharacter{

	public Monster(String name,int lifeP, int s, int gold) {
		super(name, lifeP, s, gold);
	}
	
	public void dropHisGold(Room r){
		GoldPurse gp =new GoldPurse(this.getGold());
		r.addItem(gp);
		this.gold=0;
		System.out.println("\n *** "+this.toString()+" droped a gold purse ! ***\n");
	}

}
