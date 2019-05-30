package fil.coo;

import java.io.File;

public class MyCFilenameFilter implements java.io.FilenameFilter{

	
	@Override
	public boolean accept(File dir, String name) {
		if (name.charAt(0)=='C')
			return true;
		else
			return false;
			
	}

}
