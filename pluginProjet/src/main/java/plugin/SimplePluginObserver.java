/**
 * 
 */
package plugin;

import fil.coo.FileEvent;
import fil.coo.FileListener;

/**
 * @author trari
 *
 */
public class SimplePluginObserver implements FileListener{

	@Override
	public void fileAdded(FileEvent fe) {
		System.out.println("nouveau plugin "+fe.getEventFileName()+" ajouté détecté");
		
	}

	@Override
	public void fileRemoved(FileEvent fe) {
		System.out.println("plugin "+fe.getEventFileName()+" supprimé détecté");
		
	}

}
