/**
 * 
 */
package fil.coo.Letter;

import static org.junit.Assert.*;

import org.junit.Test;


import fil.coo.city.Inhabitant;
import fil.coo.content.AcknowledgementOfReceipt;
import fil.coo.content.Content;

/**
 * @author assia
 *
 */
public class RegisteredLetterTest extends LetterTest {
	
	protected Letter<? extends Content> createLetter(Inhabitant i1,Inhabitant i2, Content c){
		return new RegisteredLetter(super.createLetter(i1, i2, c));
	}

	/**
	 * Test method for {@link fil.coo.Letter.RegisteredLetter#action()}.
	 */
	@Test
	public void testActionSendAnAcknowledgementOfReceipt() {
		
		assertEquals(0,this.c.getMailBox().size());
		i1.sendLetter(letter);
		assertEquals(1,this.c.getMailBox().size());
		assertTrue(c.getMailBox().contains(letter));
		c.distributeLetters();
		assertTrue(this.c.getMailBox().get(0).getContent() instanceof AcknowledgementOfReceipt );
	}
	

}
