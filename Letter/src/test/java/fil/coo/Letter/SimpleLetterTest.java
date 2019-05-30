/**
 * 
 */
package fil.coo.Letter;

import fil.coo.city.Inhabitant;
import fil.coo.content.Content;

/**
 * @author radi
 *
 */
public class SimpleLetterTest extends LetterTest{

	protected Letter<? extends Content> createLetter(Inhabitant i1,Inhabitant i2, Content c){
		return new SimpleLetter(i1,i2,c);
	}

}
