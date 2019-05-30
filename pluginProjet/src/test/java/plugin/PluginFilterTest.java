/**
 * 
 */
package plugin;

import static org.junit.Assert.*;
import java.io.File;
import plugin.MockPlugin;
import org.junit.Before;
import org.junit.Test;

/**
 * @author assia
 *
 */
public class PluginFilterTest {
	
	protected Object o;
	protected FakePluginWithParamInConstructor fpwpc;
	protected Plugin p;
	protected PluginFilter pf;
	
	@Before
	public void init() {
		this.o = new Object();
		this.p= new plugin.MockPlugin();
		this.fpwpc=new FakePluginWithParamInConstructor(new Object());
		this.pf=new PluginFilter();
	}
	
	@Test
	public void constructTest() {
		assertNotNull(this.pf);
	}
	@Test
	public void acceptAPluginTest() {
		assertTrue(pf.accept(null,"MockPlugin.class"));
	}

	/**
	 * Test method for {@link plugin.PluginFilter#accept(java.io.File, java.lang.String)}.
	 */
	@Test
	public void testAcceptReturnFalseWhenTheClassDoesNotImplementPlugin() {
		assertFalse(pf.accept(new File("."), "Object"));
	}
	
	@Test
	public void testAcceptReturnFalseWhenTheClassImplementsPluginButHasParamInConstructor() {
		assertFalse(pf.accept(new File("."), "FakePluginWithParamInConstructor"));
	}
	
	private class FakePluginWithParamInConstructor extends MockPlugin{
		public FakePluginWithParamInConstructor(Object o) {
			;
		}
	}

}
