package fil.coo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fil.coo.AdventureGame;
import fil.coo.Room;
import fil.coo.character.GameCharacter;

/**
 * @author Lina RADI et Assia TRARI 
 *
 */
public class GameCharacterTest {
	protected int lifePoint;
	protected int strength;
	protected int gold;
	protected Room currentRoom;
	protected String name;
	
	protected  GameCharacter gc,gameCharacter;
	protected GameCharacter deadGameCarachter,notDeadGameCarachter;
	protected Room r;
	protected AdventureGame ag;
	int oldLifePoint,NewLifePoint;
	int oldStrength,newStrength;
	int oldGold,newGold;
	
	
	public GameCharacter createGameCharacter(String name,int lifePoint,int strength,int gold){
		return new GameCharacterMock(name,lifePoint,strength,gold);
	}
	
	@Before
	public void init(){
		gc=this.createGameCharacter("Mock",10,10,5);
		this.r=new Room();
		this.ag =new AdventureGame(r);
		notDeadGameCarachter=this.createGameCharacter("notDead", 9,5,5);
		deadGameCarachter=this.createGameCharacter("dead", 0,0,0);
		gameCharacter=this.createGameCharacter("gameCharacter", 3, 3, 3);
	}

	/**
	 * Test method for {@link fil.coo.character.GameCharacter#GameCharacter(java.lang.String, int, int, int)}.
	 */
	@Test
	public void testGameCharacter() {
		assertNotNull(this.gc);
	}

	/**
	 * Test method for {@link fil.coo.character.GameCharacter#isDead()}.
	 */
	@Test
	public void testIsDeadWhenLifePointsEqualToZero() {
		assertTrue(deadGameCarachter.isDead());
	}
	
	@Test
	public void testIsDeadWhenLifePointsHigherThanZero() {
		assertFalse(notDeadGameCarachter.isDead());
	}

	/**
	 * Test method for {@link fil.coo.character.GameCharacter#attack(fil.coo.character.GameCharacter)}.
	 */
	@Test
	public void testAttack() {
		int oldLifePoints=notDeadGameCarachter.getLifePoint();
		gc.attack(notDeadGameCarachter);
		int newLifePoints=notDeadGameCarachter.getLifePoint();
		assertNotEquals(oldLifePoints,newLifePoints);
	}

	/**
	 * Test method for {@link fil.coo.character.GameCharacter#getName()}.
	 */
	@Test
	public void testGetName() {
		assertSame(gc.getName(),"Mock");
	}

	/**
	 * Test method for {@link fil.coo.character.GameCharacter#lowerNbLifePoint(int)}.
	 */
	@Test
	public void testLowerNbLifePoint() {
		oldLifePoint=gc.getLifePoint();
		gc.lowerNbLifePoint(5);
		NewLifePoint=gc.getLifePoint();
		assertNotEquals(oldLifePoint,NewLifePoint);

	}

	/**
	 * Test method for {@link fil.coo.character.GameCharacter#plusNbLifePoint(int)}.
	 */
	@Test
	public void testPlusNbLifePoint() {
		oldLifePoint=gc.getLifePoint();
		gc.plusNbLifePoint(5);
		NewLifePoint=gc.getLifePoint();
		assertNotEquals(oldLifePoint,NewLifePoint);
	}

	/**
	 * Test method for {@link fil.coo.character.GameCharacter#getLifePoint()}.
	 */
	@Test
	public void testGetLifePoint() {
		assertSame(gc.getLifePoint(),10);
	}

	/**
	 * Test method for {@link fil.coo.character.GameCharacter#setLifePoint(int)}.
	 */
	@Test
	public void testSetLifePoint() {
		gameCharacter.setLifePoint(6);
		assertEquals(gameCharacter.getLifePoint(),6);
	}

	/**
	 * Test method for {@link fil.coo.character.GameCharacter#getStrength()}.
	 */
	@Test
	public void testGetStrength() {
		assertSame(gc.getStrength(),10);
	}

	/**
	 * Test method for {@link fil.coo.character.GameCharacter#setStrength(int)}.
	 */
	@Test
	public void testSetStrength() {
		assertEquals(gameCharacter.getStrength(),3);
		gameCharacter.setStrength(12);
		assertEquals(gameCharacter.getStrength(),12);
	}

	/**
	 * Test method for {@link fil.coo.character.GameCharacter#plusStrength(int)}.
	 */
	@Test
	public void testPlusStrength() {
		oldStrength=gc.getStrength();
		gc.plusStrength(5);
		newStrength=gc.getStrength();
		assertNotEquals(oldStrength,newStrength);
		
	}

	/**
	 * Test method for {@link fil.coo.character.GameCharacter#getGold()}.
	 */
	@Test
	public void testGetGold() {
		assertSame(gc.getGold(),5);
	}

	/**
	 * Test method for {@link fil.coo.character.GameCharacter#setGold(int)}.
	 */
	@Test
	public void testSetGold() {
		assertEquals(gameCharacter.getGold(),3);
		gameCharacter.setGold(12);
		assertEquals(gameCharacter.getGold(),12);
	}

	/**
	 * Test method for {@link fil.coo.character.GameCharacter#winGold(int)}.
	 */
	@Test
	public void testWinGold() {
		oldGold=gc.getGold();
		gc.winGold(5);
		newGold=gc.getGold();
		assertNotEquals(oldGold,newGold);
		
	}

	/**
	 * Test method for {@link fil.coo.character.GameCharacter#looseGold(int)}.
	 */
	@Test
	public void testLooseGold() {
		oldGold=gc.getGold();
		gc.looseGold(1);
		newGold=gc.getGold();
		assert(oldGold!=newGold);
	}

	/**
	 * Test method for {@link fil.coo.character.GameCharacter#getCurrentRoom()}.
	 */
	@Test
	public void testGetCurrentRoom() {
		assertNull(gameCharacter.getCurrentRoom());
	}

	/**
	 * Test method for {@link fil.coo.character.GameCharacter#setCurrentRoom(fil.coo.Room)}.
	 */
	@Test
	public void testSetCurrentRoom() {
		assertNull(gameCharacter.getCurrentRoom());
		gameCharacter.setCurrentRoom(currentRoom);
		assertSame(currentRoom,gameCharacter.getCurrentRoom());
	}


	
	
	private class GameCharacterMock extends GameCharacter{
		public GameCharacterMock(String name,int lifeP, int s, int gold){
			super(name,lifeP,s,gold);
		}
		
	}
}
