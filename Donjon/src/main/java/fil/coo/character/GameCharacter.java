package fil.coo.character;

import fil.coo.Room;

public abstract class GameCharacter {
	
	protected int lifePoint;
	protected int strength;
	protected int gold;
	protected Room currentRoom;
	protected String name;
	
	/**Constructor for this Game Character
	 * @param lifeP : this Game Caracter's life point
	 * @param s : this Game Caracter's strength point
	 * @param gold : this Game Caracter's gold
	 */
	public GameCharacter(String name,int lifeP, int s, int gold){
		this.lifePoint = lifeP;
		this.strength= s;
		this.gold=gold;
		this.name=name;

	}
	
	public boolean isDead(){
		return this.getLifePoint()<=0;
	}
	
	public void attack(GameCharacter gc){
		gc.lowerNbLifePoint(this.getStrength());
		System.out.println("\n***"+this.getName()+" attack "+gc.getName());
	}

	public String getName() {
		return this.name;
	}

	public void lowerNbLifePoint(int p) {
		this.setLifePoint(this.getLifePoint()-p);
		
	}
	
	public void plusNbLifePoint(int p) {
		this.setLifePoint(this.getLifePoint()+p);
		
	}
	public int getLifePoint() {
		return lifePoint;
	}

	public void setLifePoint(int lifePoint) {
		this.lifePoint = lifePoint;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	public void plusStrength(int strength) {
		this.strength += strength;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}
	
	public void winGold(int gold){
		this.gold+=gold;
	}
	public void looseGold(int gold){
		this.gold-=gold;
	}

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
	
	public String toString(){
		return this.getName();
	}
	
	
	
	

}
