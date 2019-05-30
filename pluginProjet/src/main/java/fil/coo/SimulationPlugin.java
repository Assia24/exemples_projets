/**
 * 
 */
package fil.coo;

import java.io.FilenameFilter;

import plugin.PluginFilter;
import plugin.SimplePluginObserver;

/**
 * @author trari
 *
 */
public class SimulationPlugin {
	
	public SimulationPlugin(){
		 FilenameFilter ff= new PluginFilter();
		 FileListener fl=new SimplePluginObserver();
		 FileChecker fc= new FileChecker(ff,"dossPlugin");
		 fc.addFileListener(fl);
	 }
	
	
	public static void main (String[] args){
		new SimulationPlugin();
		while(true);
		
	}


}
