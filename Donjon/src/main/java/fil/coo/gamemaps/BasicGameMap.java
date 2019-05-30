package fil.coo.gamemaps;

import java.util.*;
import fil.coo.Room;
import fil.coo.character.*;
import fil.coo.direction.Direction;
import fil.coo.item.*;
import fil.coo.gamemaps.GameMap;

public class BasicGameMap implements GameMap {
	protected List<Room> rooms;
	protected List<Item> itemsForOneArmeBandit;



	public void setNbRooms(int nbRooms) {
		this.nbRooms = nbRooms;
	}

	private int nbRooms;
	
	public BasicGameMap(){
		this.rooms= new ArrayList<Room>();
		this.nbRooms =10;
		this.itemsForOneArmeBandit=new ArrayList<Item>();
		this.itemsForOneArmeBandit.add(new GoldPurse(5));
		this.itemsForOneArmeBandit.add(new GoldPurse(15));
		this.itemsForOneArmeBandit.add(new HealthPotion(15));
		this.itemsForOneArmeBandit.add(new HealthPotion(11));
		this.itemsForOneArmeBandit.add(new StrengthPotion(25));
		this.itemsForOneArmeBandit.add(new StrengthPotion(17));
	}
	
	public void createTheRooms(){
		for (int i =0; i<(this.getNbRooms()-1); i++){
			this.rooms.add(new Room());
		}
		this.rooms.add(new Room(true));
	}
	
	public int getNbRooms() {
		return this.nbRooms;
	}
	public List<Room> getRooms() {
		return this.rooms;
	}
	
	public Room getStartingRoom(){
		return this.rooms.get(0);
	}
	
	public void linkTheRooms(){
		this.rooms.get(0).addDestination(Direction.north,rooms.get(1));
		
		this.rooms.get(1).addDestination(Direction.south,rooms.get(0));
		this.rooms.get(1).addDestination(Direction.north,rooms.get(3));
		this.rooms.get(1).addDestination(Direction.east,rooms.get(2));
		
		this.rooms.get(2).addDestination(Direction.west,rooms.get(1));
		
		this.rooms.get(3).addDestination(Direction.north,rooms.get(4));
		this.rooms.get(3).addDestination(Direction.west,rooms.get(7));
		this.rooms.get(3).addDestination(Direction.south,rooms.get(1));
		
		this.rooms.get(4).addDestination(Direction.east,rooms.get(5));
		this.rooms.get(4).addDestination(Direction.south,rooms.get(3));
		
		this.rooms.get(5).addDestination(Direction.east,rooms.get(6));
		this.rooms.get(5).addDestination(Direction.west,rooms.get(4));
		
		this.rooms.get(6).addDestination(Direction.west,rooms.get(5));
		
		this.rooms.get(7).addDestination(Direction.east,rooms.get(3));
		this.rooms.get(7).addDestination(Direction.north,rooms.get(8));
		
		this.rooms.get(8).addDestination(Direction.north,rooms.get(9));
		this.rooms.get(8).addDestination(Direction.south,rooms.get(7));
		
	}
	
	

	public void addMonsters() {
		this.rooms.get(2).addMonster(new Monster("EvilGhost",17,11,7));
		this.rooms.get(3).addMonster(new Monster("Mr.Werewolf",13,12,10));
		this.rooms.get(5).addMonster(new Monster("SuperBoo",15,5,5));
		this.rooms.get(5).addMonster(new Monster("Giant Octopus",16,10,2));
		this.rooms.get(8).addMonster(new Monster("BigBoss 1",20,15,3));
		this.rooms.get(8).addMonster(new Monster("BigBoss 2",25,12,3));
		this.rooms.get(8).addMonster(new Monster("BigBoss 3",30,9,3));
	}
	
	

	public void addItems() {
		this.rooms.get(1).addItem(new GoldPurse(5));
		this.rooms.get(1).addItem(new StrengthPotion(10));
		this.rooms.get(6).addItem(new OneArmedBandit(this.itemsForOneArmeBandit,20));
		this.rooms.get(7).addItem(new HealthPotion(10));
		this.rooms.get(7).addItem(new StrengthPotion(20));
	}
	
	public void init(){
		this.createTheRooms();
		this.linkTheRooms();
		this.addItems();
		this.addMonsters();
	}

}
