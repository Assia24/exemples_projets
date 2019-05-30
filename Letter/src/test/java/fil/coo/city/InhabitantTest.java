package fil.coo.city;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fil.coo.Letter.Letter;
import fil.coo.Letter.MockLetter;
import fil.coo.content.Content;
import fil.coo.content.MockContent;

/**
 * @author trari
 *
 */
public class InhabitantTest {
	
	protected Inhabitant sender;
	protected Inhabitant receiver1;
	protected Inhabitant receiver2;
	protected MockLetter ml;
	protected MockLetter ml2;
	protected City c1;
	protected City c2;
	protected MockContent cont;
	
	
	@Before
	public void init(){
		this.cont=new MockContent();
		this.ml=new MockLetter(sender, receiver1,cont);
		this.ml=new MockLetter(sender, receiver2,cont);
		this.c1=new City("Lille");
		this.c1=new City("Paris");
		this.sender= new Inhabitant("sender from lille",c1);
		this.receiver1= new Inhabitant("receiver from lille",c1);
		this.receiver1= new Inhabitant("receiver from paris",c2);
	}
	

	@Test
	public void constructorTest() {
		assertNotNull(this.sender);
	}
	
//	@Test
//	public void sendLetterTest() {
//		assertFalse(this.c1.mailBoxContainsLetter(ml));
//		this.sender.sendLetter(this.ml);
//		ass!:ertTrue(this.c1.mailBoxContainsLetter(ml));
//		
//	}
	
	/**
	 * @author assia
	 *
	 */
//	/*private class MockCity extends City{
//		
//		public List<Letter<?>> mailBox;
//
//		public MockCity(String name) {
//			super(name);
//			this.mailBox=new ArrayList<Letter<?>>();
//		}
//		public boolean mailBoxContainsLetter(Letter<?> l) {
//			return mailBox.contains(l);
//		}
//		
//	}*/

}
