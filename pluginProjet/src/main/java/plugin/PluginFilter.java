package plugin;

import java.io.File;
import java.io.FilenameFilter;

import fil.coo.MyClassFilenameFilter;

public class PluginFilter extends MyClassFilenameFilter{

	@Override
	public boolean accept(File dir, String name) {
		try {
			return (super.accept(dir, name)&&implementsPlugin(name)&&hasConstructorWithoutParameter(name));
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	private boolean implementsPlugin(String name) throws ClassNotFoundException {
		String className=name.replace(".class", "");
		Class<?> c = Class.forName("plugin."+className);
		Class<?> p = Class.forName("plugin.Plugin");
		return (p.isAssignableFrom(c));
	}
	
	private boolean hasConstructorWithoutParameter(String name) throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		String className=name.replace(".class", "");
		Class<?> c = Class.forName("plugin."+className);
		return (c.getConstructor()!=null);
	}

}
