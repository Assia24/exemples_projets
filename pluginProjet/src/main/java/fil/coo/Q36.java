/**
 * 
 */
package fil.coo;

import java.io.FilenameFilter;

/**
 * @author trari
 *
 */
public class Q36 {
	 public Q36(){
		 FilenameFilter ff= new MyClassFilenameFilter();
		 FileListener fl=new FileListenerQ35();
		 FileChecker fc= new FileChecker(ff,"doss");
		 fc.addFileListener(fl);
	 }
	
	
	public static void main (String[] args){
		new Q36();
		while(true);
		
	}

}
