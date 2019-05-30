/**
 * 
 */
package fil.coo;

import static org.junit.Assert.*;

import java.io.FilenameFilter;

import org.junit.Before;
import org.junit.Test;

/**
 * @author trari
 *
 */
public class FileCheckerTest {
	
	protected FileChecker fc;
	protected FilenameFilter ff;
	protected String pathname;
	protected FileListener fl1;
	protected FileListener fl2;
	
	@Before
	public void init(){
		this.fl1=new MockFileListener();
		this.fl2=new MockFileListener();
		this.pathname="doss";
		this.ff = new MyCFilenameFilter();
		this.fc=new FileChecker(this.ff,this.pathname);
		
	}

	/**
	 * Test method for {@link fil.coo.FileChecker#FileChecker(java.io.FilenameFilter, java.lang.String)}.
	 */
	@Test
	public void testFileChecker() {
		assertNotNull(this.fc);
	}

	/**
	 * Test method for {@link fil.coo.FileChecker#addFileListener(fil.coo.FileListener)}.
	 */
	@Test
	public void testAddFileListener() {
		assertFalse(this.fc.getListeners().contains(this.fl1));
		this.fc.addFileListener(this.fl1);
		assertTrue(this.fc.getListeners().contains(this.fl1));
	}

	/**
	 * Test method for {@link fil.coo.FileChecker#removeFileListener(fil.coo.FileListener)}.
	 */
	@Test
	public void testRemoveFileListener() {
		this.fc.addFileListener(this.fl1);
		assertTrue(this.fc.getListeners().contains(this.fl1));
		this.fc.removeFileListener(this.fl1);
		assertFalse(this.fc.getListeners().contains(this.fl1));
	}

	/**
	 * Test method for {@link fil.coo.FileChecker#fireFileAdded(java.lang.String)}.
	 */
	@Test
	public void testFireFileAdded() {
		this.fc.addFileListener(this.fl1);
		assertFalse(((MockFileListener)this.fl1).fileAddedCall);
		this.fc.fireFileAdded(pathname);
		assertTrue(((MockFileListener)this.fl1).fileAddedCall);
	}



}
