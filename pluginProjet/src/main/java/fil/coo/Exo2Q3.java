package fil.coo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Exo2Q3 {
	
	private String repName;

	public Exo2Q3(String repName){
		this.repName=repName;
		
	}
	
	public List<String> beginByC(){
		int i;
		List<String> l = new ArrayList<String>();
		String[] s = new File(this.repName).list(new MyCFilenameFilter());
		for (i=0;i<s.length;i++){
		
			l.add(s[i]);
		}
		return l;
		
	}
	
	public List<String> endWithClass(){
		int i;
		List<String> l = new ArrayList<String>();
		String[] s = new File(this.repName).list(new MyClassFilenameFilter());
		for (i=0;i<s.length;i++)
			l.add(s[i]);
		return l;
		
	}
}
