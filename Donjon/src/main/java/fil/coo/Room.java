package fil.coo;

import fil.coo.action.Action;
import fil.coo.character.Monster;
import fil.coo.direction.Direction;
import fil.coo.item.Item;
import java.util.*;
/**
* * 
* The Room program represents the rooms of the game,
* those rooms are linked together with a hashmap,
* and contains a list of monsters,items.
* @author Lina RADI et Assia Trari
*
*/

public class Room {
	
	/**For the hashCode**/
	private int hashcode;
	
	/**
	 * all the destination provide by yhis Room
	 */
	protected Map <Direction,Room> dest;
	
	/**
	 * boolean exit statut of this room.
	 */
	protected boolean isExit;
	/**
	 * the list of this romm's items.
	 */
	protected List<Item> items;
	
	/**
	 * the list of this Room's monsters.
	 */
	protected List<Monster> monsters;
	
	
	/**Constructor for a non exit room*/
	public Room (){
		this.isExit = false;
		this.dest = new HashMap<Direction,Room>();
		this.items= new ArrayList<Item>();
		this.monsters=new ArrayList<Monster>();
	}
	
	/**Constructor for an exit room if parameter is true
	 * @param isExit : true if this room is an exit room, else false
	 */
	public Room (boolean isExit){
		this.isExit = true;
		this.dest = new HashMap<Direction,Room>();
		this.items= new ArrayList<Item>();
		this.monsters=new ArrayList<Monster>();
	}
	
	public List<Monster> getMonsters() {
		return monsters;
	}

	/**add a monster to this room
	 * @param monster : the monster to add
	 */
	public void addMonster(Monster monster) {
		this.monsters.add(monster);
		
	}

	/**add an item to this room
	 * @param item : the item to add
	 */
	public void addItem(Item item) {
		this.items.add(item);
		
	}

	/**return true if this room is an Exit, else false.
	 * @return return true if this room is an Exit, else false.
	 */
	public boolean isExit() {
		if (this.isExit){
		}
		return this.isExit;
	}
	
	/**add a destination to this room.
	 * @param d the direction of this destination.
	 * @param r the room provide by this destination
	 */
	public void addDestination(Direction d, Room r){
		this.dest.put(d,r);
	}

	/**return the Room provide by the direction in parameter.
	 * @param direction where is the room
	 * @return the Room provide by the direction in parameter.
	 */
	public Room nextRoom (Direction direction) {
		return this.dest.get(direction);
		
	}
	
	
	/**Provide a list of the possible directions provided by this room 
	 * @return a list of the possible directions provided by this room
	 */
	public List<Direction> possibleDirections(){
		List<Direction> ldir = new ArrayList<Direction>();
		Set<Direction> theDir = this.dest.keySet();
		Iterator<Direction> it_dir = theDir.iterator();
		while (it_dir.hasNext()){
			Direction d=it_dir.next();
			ldir.add(d);
		}
		return ldir;
	}
	
	
	/**Remove a monster (in parameter) for this room
	 * @param m : the monster to remove
	 */
	public void removeMonster(Monster m){
		int index = this.getMonsters().indexOf(m);
		this.monsters.remove(index);

	}

	/**get the list of the items in this room
	 * @return the list of the items in this room
	 */
	public List<Item> getItems() {
		return items;
	}
	/**remove an item of this room
	 * 
	 * @param i the item to remove
	 */
	public void removeItem(Item i){
		this.items.remove(i);
	}
	/**A string representation of this room
	 * @return A string representation of this room**/
	public String toString(){
		return ("This room contains "+this.getItems().size()+" Items and "+this.getMonsters().size()+" monsters ");
	}
	
	/** get the possible actions a player can do in this room
	 * 
	 * @param existingAction : the existing actions of this game
	 * @return the list of possible actions a player can do in this room
	 */
	public List<Action> getPossbileActions(List<Action> existingAction){
		List<Action> possibleActions=new ArrayList<Action>();
		for(Action ea :existingAction){
			if (ea.isPossible(this)){
				possibleActions.add(ea);
			}
		}
		return possibleActions;
	}
	
	/**return the hashcode for this Room*/
	public int hashCode(){
		return this.hashcode;
	}
	
	/**return true if this Room is equals to the object o, else false
	 * @return true if this Room is equals to the object o, else false
	 */
	public boolean equals(Object o){
		if(o instanceof Room){
			Room other= ((Room)o);
			return this.dest==other.possibleDirections() && this.items==other.getItems() && this.monsters==other.getMonsters() && this.isExit()==other.isExit();
		}else{
			return false;
		}
	}
	

}
