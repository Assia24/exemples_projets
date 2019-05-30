/**
 * 
 */
package fil.coo.city;

import java.util.*;

import fil.coo.Letter.Letter;
import fil.coo.content.Content;

/**
 * @author radi
 *
 */
public class City {
	protected String name;
	protected List<Inhabitant>inhabitants;
	private List<Letter<?>> mailBox;

		

	/**the city's constructor
	 * @param name the city's name 
	 */
	public City(String name) {
		this.name=name;
		this.inhabitants=new ArrayList<Inhabitant>();
		this.mailBox=new ArrayList<Letter<?>>();
	}

	/**add an habitant to a city
	 * @param i1
	 */
	public void addInhabitant(Inhabitant i1) {
		this.inhabitants.add(i1);
	}
	
	public void distributeLetters(){
		List<Letter<?>> bag=new ArrayList<Letter<?>>(this.mailBox);
		this.mailBox.clear();
		for(Letter<?> l : bag)
			l.getReceiver().receiveLetter(l);
		
	}

	public void addToMailbox(Letter<? extends Content> l) {
		this.mailBox.add(l);	
	}
	
	
	public Inhabitant getRandomInhabitant(){
		Random r=new Random();
		int i =r.nextInt(this.inhabitants.size());
		return this.inhabitants.get(i);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Inhabitant> getInhabitants() {
		return inhabitants;
	}

	public void setInhabitants(List<Inhabitant> inhabitants) {
		this.inhabitants = inhabitants;
	}

	public List<Letter<?>> getMailBox() {
		return mailBox;
	}

	public void setMailBox(List<Letter<?>> mailBox) {
		this.mailBox = mailBox;
	}

	

}
