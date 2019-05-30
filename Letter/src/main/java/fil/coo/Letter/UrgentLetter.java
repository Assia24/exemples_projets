package fil.coo.Letter;

import fil.coo.content.Content;

public class UrgentLetter extends AbstractDecoratingLetter{

	public UrgentLetter(Content c) {
		super(c);
	}
	
	public float getCost() {
		return 2*super.getCost();
	}
	public String toString() {
		return "urgent"+super.toString();
	}

}
