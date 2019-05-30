/**
 * 
 */
package fil.coo.city;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fil.coo.Letter.Letter;
import fil.coo.Letter.MockLetter;
import fil.coo.content.Content;
import fil.coo.content.MockContent;

/**
 * @author radi
 *
 */
public class CityTest {
	City city;
	MockLetter letter;
	MockContent content;
	Inhabitant sender,receiver;
	
	@Before
	public void init(){
		city=new City("Lille");
		sender=new Inhabitant("Lina",city);
		receiver=new Inhabitant("Assia",city);
		content=new MockContent();
		letter=new MockLetter(sender,receiver ,content);
		
	}

	/**
	 * Test method for {@link city.City#City(java.lang.String)}.
	 */
	@Test
	public void testCity() {
		assertNotNull(city);
		assertSame("Lille",city.getName());
		
	}

	/**
	 * Test method for {@link city.City#addInhabitant(city.Inhabitant)}.
	 */
	@Test
	public void testAddInhabitant() {
		assertEquals(city.getInhabitants().size(),0);
		city.addInhabitant(new Inhabitant("Lina",city));
		assertEquals(city.getInhabitants().size(),1);
	}
	
	
	/**
	 * Test method for {@link city.City#addToMailbox(Letter<? extends Content> l)}.
	 */
	@Test
	public void testAddToMailbox(){
		assertEquals(city.getMailBox().size(),0);
		city.addToMailbox(letter);
		assertEquals(city.getMailBox().size(),1);	
	}
	
	
	/**
	 * Test method for {@link city.City#distributeLetters()}.
	 */
	@Test
	public void testDistributeLetters() {
		assertNotNull(city.getMailBox().size());
		city.distributeLetters();
		assertTrue(city.getMailBox().isEmpty());
	
		
	}

}

