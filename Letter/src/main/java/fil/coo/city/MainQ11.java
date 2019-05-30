package fil.coo.city;

import java.util.ArrayList;
import java.util.List;

import fil.coo.Letter.FoolLetter;
import fil.coo.content.FoolText;

/**
 * @author assia trari lina radi
 *
 */
public class MainQ11 {
	
	public static void main(String[] args) {
	
		City city=new City("city");
		int i;
		//we put 30 inhabitants in the city, add give them 3 euros.
		for(i=0;i<30;i++) {
			Inhabitant inhab=new Inhabitant("hab"+i,city);
			inhab.debitAccount(3);
			city.addInhabitant(inhab);
		}
		List<Inhabitant> li = new ArrayList<Inhabitant>();
		for(i=0;i<4;i++)
			li.add(city.getRandomInhabitant());
		FoolText ft=new FoolText(li);
		
		Inhabitant sender=city.getRandomInhabitant();
		Inhabitant receiver=city.getRandomInhabitant();
		FoolLetter fletter=new FoolLetter(sender,receiver,ft,15);
		System.out.println("Jour 1");
		sender.sendLetter(fletter);
		//nb days
		int d=2;
		while(city.getMailBox().size()>0) {
			System.out.println("----------------------------------------");
			System.out.println("Jour "+d);
			city.distributeLetters();
			d++;
		}
		Inhabitant riche=getRiche(city);
		
		System.out.println("\n ### The richest inhabitant is "+riche.getName()+" he has "+riche.getSold()+" euros.");
	

	}
	private static Inhabitant getRiche(City city) {
		Inhabitant riche= new Inhabitant("toto",null);
		for(Inhabitant i : city.getInhabitants()) {
			if (i.getSold()>riche.getSold())
				riche =i;
		}
		return riche;
	}
}
