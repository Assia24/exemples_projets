/**
 * 
 */
package fil.coo.content;

/**
 * @author radi trari
 *
 */
public class Money implements Content{
	
	/**The value of this money*/
	protected float s;
	
	public Money(float s){
		this.s=s;
	}

	public float getValue() {
		return this.s;
	}

}
