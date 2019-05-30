/**
 * 
 */
package fil.coo.city;

import java.util.Random;

import fil.coo.Letter.BillOfExchange;
import fil.coo.Letter.Letter;
import fil.coo.Letter.RegisteredLetter;
import fil.coo.Letter.SimpleLetter;
import fil.coo.Letter.UrgentLetter;
import fil.coo.content.Money;
import fil.coo.content.Text;

/**
 * @author Assia TRARI Lina RADI
 *
 */
public class Mainq10 {
	
	public static void main(String[] args) {
		City city=new City("city");
		int i;
		//we put 30 inhabitants in the city
		for(i=0;i<30;i++) {
			city.addInhabitant(new Inhabitant("hab"+i,city));
		}
		//the number of days for the simulation
		int nbD=Integer.parseInt(args[0]);
		//the number of inhabitants who send letter in one day
		int nbH=Integer.parseInt(args[1]);
		
		int n;
		int h;
		for (n=0;n<nbD;n++) {
			System.out.println("Day"+n);
			city.distributeLetters();
			for(h=0;h<nbH;h++) {
				
				Inhabitant sender =city.getRandomInhabitant();
				Inhabitant receiver =city.getRandomInhabitant();
				sender.sendLetter(randomletter(sender,receiver));
				
			}
		}
		
	}
	
	public static Letter<?> randomletter(Inhabitant s, Inhabitant r){
		Random ran = new Random();
		int i=ran.nextInt(4);
		switch(i) {
		case(0):
			return new SimpleLetter(s,r,new Text("hello !"));
		case(1):
			return new BillOfExchange(s,r,new Money(15));
		case(2):
			return new RegisteredLetter(new SimpleLetter(s,r,new Text("hello ! with a registered letter")));
		case(3):
			return new UrgentLetter(new BillOfExchange(s,r,new Money(15)));
		default :
			return null;
		}
		
	}

}
