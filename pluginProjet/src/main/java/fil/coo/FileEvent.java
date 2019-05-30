package fil.coo;

public class FileEvent {
	
	protected String eventFileName;
	
	public FileEvent(String eventFileName){
		this.eventFileName=eventFileName;
	}

	public String getEventFileName() {
		return eventFileName;
	}

	public String getLabel() {
		String label=eventFileName.replaceAll(".class", "");
		return label;
	}
	
	
	

}
