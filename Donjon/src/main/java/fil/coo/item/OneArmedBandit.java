package fil.coo.item;

import java.util.List;
import java.util.Random;


import fil.coo.Room;
import fil.coo.character.Player;

public class OneArmedBandit implements Item{
	
	protected List<Item> items;
	protected int price;
	
	public OneArmedBandit(List<Item> existingItem, int price){
		this.price=price;
		this.items=existingItem;
		for(Item i:items){
			if (i instanceof OneArmedBandit){
				items.remove(i);
			}
		}
	}
	

	public void use(Player p, Room r) {
		if(p.getGold()<this.getPrice()){
			System.out.println("\n Sorry, you don't have enough money. "+this.getPrice()+" coins are required to use this OneArmedBAndit, and you have only "+p.getGold());
		}else{
			System.out.println(this.getPrice()+" coins are required to use this One Armed Bandit.");
			p.looseGold(this.getPrice());
			System.out.println("\n	********* "+p.getName()+" inserts "+this.getPrice()+" coins into the one armed bandit.*********");
			System.out.println("You still have "+ p.getGold()+" coins\n");
			Random rand = new Random();
			int nombreAleatoire = rand.nextInt(items.size());
			items.get(nombreAleatoire).use(p, r);
			}
	}


	public int getPrice() {
		return this.price;
	}
	public String toString(){
		return "One Armed Bandt";
	}

}
