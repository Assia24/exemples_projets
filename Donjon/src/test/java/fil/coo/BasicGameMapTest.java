package fil.coo;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fil.coo.AdventureGame;
import fil.coo.Room;
import fil.coo.character.*;
import fil.coo.direction.Direction;
import fil.coo.gamemaps.BasicGameMap;

/**
* @author Lina RADI et Assia TRARI 
*
*/

/**
* All tests for class BasicGameMap 
*
*/
public class BasicGameMapTest {
	
	
	BasicGameMap bgm,newBgm,gm;
	List<Room> rooms;
	Room r1;
	List<Monster> lm;
	Room startingRoom,currentRoom,nextRoom;
	@Before
	public void init(){
		bgm=new BasicGameMap();
		newBgm=new BasicGameMap();
		startingRoom=new Room();
		
	}
	

	/**
	 * Test method for {@link fil.coo.BasicGameMap#SetNbRooms()}. 
	 */
	@Test
	public void testSetNbRooms() {
		bgm.setNbRooms(2);
		assertEquals(2,bgm.getNbRooms());
	}

	/**
	 * Test method for {@link fil.coo.BasicGameMap#BasicGameMap()}. 
	 */
	@Test
	public void testBasicGameMap() {
		assertNotNull(bgm);
	}

	/**
	 * Test method for {@link fil.coo.BasicGameMap#CreateTheRooms()}. 
	 */
	@Test
	public void testCreateTheRooms() {
		assertEquals(0,newBgm.getRooms().size());
		newBgm.createTheRooms();
		assertEquals(10,newBgm.getRooms().size()); //The method "CreateTheRooms()" Creates 10 rooms.
	}

	/**
	 * Test method for {@link fil.coo.BasicGameMap#getNbRooms()}. 
	 *  BasicGameMap's Constructor sets 10 rooms;
	 */
	@Test
	public void testGetNbRooms() {
		assertEquals(10,newBgm.getNbRooms()); 
	}

	/**
	 * Test method for {@link fil.coo.BasicGameMap#GetRooms()}.
	 */
	@Test
	public void testGetRooms() {
		assertNotNull(bgm.getRooms());
	}

	/**
	 * Test method for {@link fil.coo.BasicGameMap#getStartingRoom()}. 
	 */
	@Test
	public void testGetStartingRoom() {
		bgm.createTheRooms();
		assertSame(bgm.getRooms().get(0),bgm.getStartingRoom());
	}

	/**
	 * Test method for {@link fil.coo.BasicGameMap#testLinkTheRooms()}.
	 */
	
	
	@Test
	public void testLinkTheRooms() {
		bgm.createTheRooms();
		bgm.linkTheRooms();
		currentRoom=bgm.getRooms().get(1);
		nextRoom=bgm.getRooms().get(0).nextRoom(Direction.north);
		assertSame(currentRoom,nextRoom);
	}

	

	
	

}
