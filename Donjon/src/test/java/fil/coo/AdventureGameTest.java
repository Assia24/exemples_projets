package fil.coo;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Before;
import org.junit.Test;


import fil.coo.action.*;
import fil.coo.character.*;
import fil.coo.direction.Direction;
import fil.coo.item.*;


import org.junit.Test;


	/**
	 * @author Lina RADI et Assia TRARI 
	 *
	 */

	/**
	 * All tests for class AdventureGame 
	 *
	 */
	public class AdventureGameTest {

		Player player1;
		Room startingRoom,secondRoom,finishRoom;
		AdventureGame ag;
		
		
		@Before
		public void init(){
			player1=new Player("player 1",10,10,10);
			startingRoom = new Room();
			finishRoom=new Room(true);
			ag=new AdventureGame(startingRoom);
		}

		/**
		 * Test method for {@link fil.coo.AdventureGame#SetPlayer()}.
		 */
		@Test
		public void testSetPlayer() {
			ag.setPlayer(player1);
			assertSame(player1,ag.getPlayer());
		}

		/**
		 * Test method for {@link fil.coo.AdventureGame#AgventureGame()}.
		 */
		@Test
		public void testAdventureGame() {
			assertNotNull(ag);
			assertSame(startingRoom,ag.getCurrentRoom()); // je suis po sure
		}

		/**
		 * Test method for {@link fil.coo.AdventureGame#GetCurrentRoom()}.
		 */
		@Test
		public void testGetCurrentRoom() {
			assertSame(startingRoom,ag.getCurrentRoom());
		}

		/**
		 * Test method for {@link fil.coo.AdventureGame#GetPlayer()}.
		 */
		@Test
		public void testGetPlayer() {
			ag.setPlayer(player1);
			assertSame(player1,ag.getPlayer());
		}


		/**
		 * Test method for {@link fil.coo.AdventureGame#IsFinished()}.
		 */
		@Test
		public void testIsFinished() {
			ag.goToRoom(finishRoom);
			assertTrue(ag.isFinished());
			ag.goToRoom(startingRoom);
			assertFalse(ag.isFinished());
			
		}

		/**
		 * Test method for {@link fil.coo.AdventureGame#GoToRoom()}.
		 */
		@Test
		public void testGoToRoom() {
			secondRoom= new Room();
			ag.goToRoom(secondRoom);
			assertSame(secondRoom,ag.getCurrentRoom());
		}

		
		

	}
	
	
