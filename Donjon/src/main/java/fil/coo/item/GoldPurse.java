package fil.coo.item;

import fil.coo.Room;
import fil.coo.character.Player;

public class GoldPurse implements Item{
	
	protected int nbCoins;
	
	public GoldPurse(int nbCoins){
		this.nbCoins=nbCoins;
	}

	public void use(Player p, Room r) {
		p.winGold(this.getNbCoins());
		System.out.println("\nThe Player wins "+this.getNbCoins()+" coins !\n");
		
	}

	public int getNbCoins() {
		return nbCoins;
	}
	public String toString(){
		return "Gold Purse";
	}

}
