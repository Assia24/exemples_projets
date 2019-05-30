package fil.coo;

public class MockFileListener implements FileListener {
	public boolean fileAddedCall = false;
	public boolean fileRemovedCall =false;
	public MockFileListener(){
		;
	}

	@Override
	public void fileAdded(FileEvent fe) {
		this.fileAddedCall=true;
		System.out.println("fileAdded prints : a file is added");
	}

	@Override
	public void fileRemoved(FileEvent fe) {
		this.fileRemovedCall=true;
		System.out.println("fileRemoved prints : a file is removed");
		
	}

}
