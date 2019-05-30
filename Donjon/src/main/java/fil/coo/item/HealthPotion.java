package fil.coo.item;

import fil.coo.Room;
import fil.coo.character.Player;

public class HealthPotion implements Item{
	protected int nbPoints;
	
	public HealthPotion(int nbpoints){
		this.nbPoints=nbpoints;
		}
			
	public void use(Player p, Room r) {
		p.plusNbLifePoint(this.getNbPoints());
		System.out.println("\nThe Player wins "+this.getNbPoints()+" life points !\n");
		}
			
	public int getNbPoints() {
		return nbPoints;
		}
	
	public String toString(){
		return "Health Potion";
	}

}
