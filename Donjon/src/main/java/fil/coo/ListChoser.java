package fil.coo;

import java.util.*;

import fil.coo.scanner.ScannerInt;
/**
* The ListChoser program defines a generate method that provide for the
* player to chose between a list of diffent types , such as:
* list of Actions ,list of Monsters, list of Items and a list of Directions.
* @author Lina RADI et Assia Trari
*
*/
public class ListChoser {
	public <T> T chose(String s, List<T> l){
		System.out.println(s);
		System.out.println("( Enter the index of the element you want to chose. )");
		for (int i=0; i< l.size();i++){
			System.out.println(i+1 +" : "+l.get(i).toString());
		}
		int i =ScannerInt.readInt(l.size()+1);
		if (i==0){
		    return null;
		}
		return l.get(i-1);
		
	}

}
