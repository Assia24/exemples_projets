package fil.coo.item;

import fil.coo.Room;
import fil.coo.character.Player;

public class StrengthPotion implements Item{
	
	protected int nbPoints;
	
	public StrengthPotion(int nbpoints){
		this.nbPoints=nbpoints;
	}

	public void use(Player p, Room r) {
		p.plusStrength(this.getNbPoints());
		System.out.println("\nThe Player wins "+this.getNbPoints()+" strength points !\n");
		
	}

	public int getNbPoints() {
		return nbPoints;
	}
	public String toString(){
		return "Health potion";
	}

}
