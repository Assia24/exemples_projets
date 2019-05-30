package fil.coo;

import java.io.File;

public class MyClassFilenameFilter implements java.io.FilenameFilter{

	
	@Override
	public boolean accept(File dir, String name) {
		if (name.endsWith(".class"))
			return true;
		else
			return false;
			
	}

}
