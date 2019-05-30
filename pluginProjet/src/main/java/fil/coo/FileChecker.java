package fil.coo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.Timer;


public class FileChecker implements ActionListener{
	
	protected String pathname;
	protected FilenameFilter ff;
	protected ArrayList<FileListener> listeners;
	protected List<String> files;
	
	
	public FileChecker(FilenameFilter ff,String pathname){
		this.listeners=new ArrayList<FileListener>();
		this.ff=ff;
		this.pathname=pathname;
		this.files = new ArrayList<>();
		Timer timer = new Timer(1000, null);
		ActionListener al=this;
		timer.addActionListener(al);
		timer.start();
	}
	
	public synchronized void addFileListener(FileListener f){
		this.listeners.add(f);
	}
	
	public void removeFileListener(FileListener f){
		this.listeners.remove(f);
	}
	public void fireFileAdded(String fileName){
		
		@SuppressWarnings("unchecked")
		ArrayList<FileListener> flclone= (ArrayList<FileListener>)listeners.clone();
		if(flclone.size()==0){
			return;
		}
		FileEvent fevent =new FileEvent(fileName);
		for (FileListener listener : flclone){
			listener.fileAdded(fevent);
		}
		
	}
	
	public void fireFileRemoved(String fileName) {
		ArrayList<FileListener> flclone= (ArrayList<FileListener>)listeners.clone();
		if(flclone.size()==0){
			return;
		}
		FileEvent fevent =new FileEvent(fileName);
		for (FileListener listener : flclone){
			listener.fileRemoved(fevent);
		}
	}


	@Override
	public synchronized void actionPerformed(ActionEvent e) {
		int i=0;
		String[] s = new File(this.pathname).list(ff);
		for (i=0;i<s.length;i++){
			if (!this.files.contains(s[i])){
					fireFileAdded(s[i]);
					files.add(s[i]);
			}
		}
		ArrayList<String> repList = new ArrayList<String>(Arrays.asList(s));
		for (i=0;i<this.files.size();i++){
			if (!repList.contains(this.files.get(i))){
					fireFileRemoved(this.files.get(i));
					files.remove(i);
			}
		}
	}

	public String getPathname() {
		return pathname;
	}

	public FilenameFilter getFf() {
		return ff;
	}

	public ArrayList<FileListener> getListeners() {
		return listeners;
	}

	public List<String> getFiles() {
		return files;
	}
	
	
	
}
