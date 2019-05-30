/**
 * 
 */
package fil.coo;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import fil.coo.action.Action;
import fil.coo.action.AttackAction;
import fil.coo.action.LookAction;
import fil.coo.action.MoveAction;
import fil.coo.action.TakeAction;
import fil.coo.character.Monster;
import fil.coo.direction.Direction;
import fil.coo.item.HealthPotion;
import fil.coo.item.Item;
import fil.coo.item.StrengthPotion;

/**
 * @author assia TRARI lina RADI
 *
 */
public class RoomTest {
	
	Room r;
	Room r2;
	Room rexit;
	Monster m1;
	Monster m2;
	Item i1;
	Item i2;
	Direction d1;
	Direction d2;
	List<Action> possible;
	Action ma;
	Action la;
	Action aa;
	Action ta;
	
	@Before
	public void init(){
		r = new Room();
		rexit= new Room(true);
		r2=new Room();
		m1 = new Monster("monster1",10,10,10);
		m2 = new Monster("monster2",5,5,5);
		i1=new HealthPotion(5);
		i2=new StrengthPotion(5);
		d1=Direction.north;
		d2=Direction.south;
		possible = new ArrayList<Action>();
		ma = new MoveAction();
		la = new LookAction();
		aa = new AttackAction();
		ta = new TakeAction();
		
		r.addMonster(m1);
		r.addMonster(m2);
		r.addItem(i1);
		r.addItem(i2);
		r.addDestination(d1, rexit);
		r.addDestination(d2, r2);
		rexit.addDestination(d1, r);
		possible.add(ma);
		possible.add(la);
		possible.add(aa);
		possible.add(ta);
		
	}

	/**
	 * Test method for {@link fil.coo.Room#Room()}.
	 */
	@Test
	public void testRoom() {
		assertNotNull(r);
	}

	/**
	 * Test method for {@link fil.coo.Room#Room(boolean)}.
	 */
	@Test
	public void testRoomBoolean() {
		assertNotNull(rexit);
	}

	/**
	 * Test method for {@link fil.coo.Room#getMonsters()}.
	 */
	@Test
	public void testGetMonsters() {
		List<Monster> lm=new ArrayList<Monster>();
		lm.add(m1);
		lm.add(m2);
		assertEquals(lm,r.getMonsters());
		assertSame(m1,r.getMonsters().get(0));
	}

	/**
	 * Test method for {@link fil.coo.Room#addMonster(fil.coo.character.Monster)}.
	 */
	@Test
	public void testAddMonster() {
		Monster m3 = new Monster("Monster3",1,1,1);
		assertFalse(r.getMonsters().contains(m3));
		r.addMonster(m3);
		assertTrue(r.getMonsters().contains(m3));
		
	}

	/**
	 * Test method for {@link fil.coo.Room#addItem(fil.coo.item.Item)}.
	 */
	@Test
	public void testAddItem() {
		Item i3 = new HealthPotion(0);
		assertFalse(r.getItems().contains(i3));
		r.addItem(i3);
		assertTrue(r.getItems().contains(i3));
	}

	/**
	 * Test method for {@link fil.coo.Room#isExit()}.
	 */
	@Test
	public void testIsExit() {
		assertTrue(rexit.isExit());
		assertFalse(r.isExit());
	}

	/**
	 * Test method for {@link fil.coo.Room#addDestination(fil.coo.direction.Direction, fil.coo.Room)}.
	 */
	@Test
	public void testAddDestination() {
		Direction d3 = Direction.east;
		Room r4= new Room();
		assertFalse(r.possibleDirections().contains(d3));
		r.addDestination(d3,r4);
		assertTrue(r.possibleDirections().contains(d3));
	}

	/**
	 * Test method for {@link fil.coo.Room#nextRoom(fil.coo.direction.Direction)}.
	 */
	@Test
	public void testNextRoom() {
		assertSame(rexit,r.nextRoom(d1));
	}

	/**
	 * Test method for {@link fil.coo.Room#possibleDirections()}.
	 */
	@Test
	public void testPossibleDirections() {
		assertEquals(2,r.possibleDirections().size());
		assertTrue(r.possibleDirections().contains(d1));
		assertTrue(r.possibleDirections().contains(d2));
	}

	/**
	 * Test method for {@link fil.coo.Room#removeDeadMonster(fil.coo.character.Monster)}.
	 */
	@Test
	public void testRemoveMonster() {
		assertTrue(r.getMonsters().contains(m1));
		r.removeMonster(m1);
		assertFalse(r.getMonsters().contains(m1));
	}

	/**
	 * Test method for {@link fil.coo.Room#getItems()}.
	 */
	@Test
	public void testGetItems() {
		List<Item> li =new ArrayList<Item>();
		li.add(i1);
		li.add(i2);
		assertEquals(li,r.getItems());
		assertSame(i1,r.getItems().get(0));
	}

	/**
	 * Test method for {@link fil.coo.Room#removeItem(fil.coo.item.Item)}.
	 */
	@Test
	public void testRemoveItem() {
		assertTrue(r.getItems().contains(i1));
		r.removeItem(i1);
		assertFalse(r.getItems().contains(i1));
	}

	/**
	 * Test method for {@link fil.coo.Room#getPossbileActions(java.util.List)}.
	 */
	@Test
	public void testGetPossbileActionsWhenItemButNoMonsters() {
		rexit.addItem(i1);
		assertTrue(rexit.getPossbileActions(possible).contains(ma));
		assertFalse(rexit.getPossbileActions(possible).contains(aa));
		assertTrue(rexit.getPossbileActions(possible).contains(la));
		assertTrue(rexit.getPossbileActions(possible).contains(ta));
		assertEquals(3,rexit.getPossbileActions(possible).size());
		
	}
	/**
	 * Test method for {@link fil.coo.Room#getPossbileActions(java.util.List)}.
	 */
	@Test
	public void testGetPossbileActionsWhenNoItem() {
		assertFalse(rexit.getPossbileActions(possible).contains(ta));
		
	}
	/**
	 * Test method for {@link fil.coo.Room#getPossbileActions(java.util.List)}.
	 */
	@Test
	public void testGetPossbileActionsWhenCantMove() {
		assertFalse(r.getPossbileActions(possible).contains(ma));
		assertTrue(r.getPossbileActions(possible).contains(aa));
		assertTrue(r.getPossbileActions(possible).contains(la));
		assertTrue(r.getPossbileActions(possible).contains(ta));
		assertEquals(3,r.getPossbileActions(possible).size());
		
	}
	
	
	
	
	

	
	

}