/**
 * 
 */
package fil.coo.content;

/**
 * @author radi trari
 *
 */
public class Text implements Content {
	String msg;

	public Text(String msg) {
		this.msg=msg;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void addMsg(String msg) {
		this.msg += msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
	

}
