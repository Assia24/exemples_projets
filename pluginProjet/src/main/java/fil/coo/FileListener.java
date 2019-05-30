package fil.coo;

import java.util.EventListener;

public interface FileListener extends EventListener{
	
	public void fileAdded(FileEvent fe);
	public void fileRemoved(FileEvent fe);

}
