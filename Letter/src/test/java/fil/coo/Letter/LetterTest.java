/**
 * 
 */
package fil.coo.Letter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fil.coo.bank.Account;
import fil.coo.city.City;
import fil.coo.city.Inhabitant;
import fil.coo.content.Content;
import fil.coo.content.MockContent;

/**
 * @author radi
 *
 */
public class LetterTest {
	protected Letter<?> letter;
	protected Letter<?> mletter;
	protected City c;
	protected Content cont;
	protected Inhabitant i1;
	protected Inhabitant i2;
	protected Account baccount;
	protected Account baccount2;
	
	@Before
	public void init(){
		this.cont=this.createContent();
		this.c=new City("Paris");
		this.i1= new Inhabitant("Titi",c);
		this.i2= new Inhabitant("Toto",c);
		this.c.addInhabitant(i1);
		this.c.addInhabitant(i2);
		this.mletter=this.createMockLetter(i1, i2, cont);
		this.letter=this.createLetter(i1, i2, cont);
	}
	
	protected Letter<? extends Content> createMockLetter(Inhabitant i1,Inhabitant i2, Content c){
		return new MockLetter(i1,i2,c);
	}
	protected Letter<? extends Content> createLetter(Inhabitant i1,Inhabitant i2, Content c){
		return new MockLetter(i1,i2,c);
	}
	protected Content createContent(){
		return new MockContent();
	}

	@Test
	public void ConstructTest (){
		assertNotNull(this.letter);
	}
	
	@Test
	public void receiveLetterExecutesLetterAction(){
		assertFalse(((MockLetter)this.mletter).call);
		i2.receiveLetter(mletter);
		assertTrue(((MockLetter)this.mletter).call);
	}
	
	

}
