/**
 * 
 */
package fil.coo;

/**
 * @author trari
 *
 */
public class FileListenerQ35 implements FileListener{

	@Override
	public void fileAdded(FileEvent fe) {
		System.out.println("nouveau .class : "+fe.getEventFileName()+" détecté");
		
	}

	@Override
	public void fileRemoved(FileEvent fe) {
		System.out.println("suppression d'un .class : "+ fe.getEventFileName()+" détecté");
		
	}
	
	

}
