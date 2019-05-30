/**
 * 
 */
package fil.coo.content;

import fil.coo.city.Inhabitant;

/**
 * @author TRARI Assia
 *
 */
public class AcknowledgementOfReceipt extends Text {

	public AcknowledgementOfReceipt(Inhabitant i) {
		super(i.getName() +" has received your letter.");
	}

}