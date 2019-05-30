package fil.coo.content;

import java.util.ArrayList;
import java.util.List;

import fil.coo.city.Inhabitant;

/**A fool text to use to send a fool letter
 * @author trari assia lina radi
 *
 */
public class FoolText extends Text{
	protected List<Inhabitant> l;

	/**constructor for fool text
	 * @param l a list of inhabitants to gets the names
	 */
	public FoolText(List<Inhabitant> l) {
		super("");
		this.l= new ArrayList<Inhabitant>();
		this.l=l;
		this.addNames();
	}
	
	/**
	 * add the inhabitants'name of the list in the message of this text content
	 */
	private void addNames(){
		for (Inhabitant i : l){
			this.addMsg(i.getName()+" ");
		}
	}
	
	/**the list of inhabitants whose name are written in this fool text
	 * @return the list of inhabitants
	 */
	public List<Inhabitant> getInhabitants(){
		return this.l;
	}
	
	/**
	 * remove the first name in the list and in the message
	 */
	public void removeFirstName(){
		l.remove(0);
		this.setMsg("");
		this.addNames();
	}
	
	/**add an Inhabitant in the list add add his name in the message
	 * @param inhab the inhabitant to add
	 */
	public void addName(Inhabitant inhab){
		l.add(inhab);
		this.addMsg(inhab.getName()+" ");
	}
	
	

}
