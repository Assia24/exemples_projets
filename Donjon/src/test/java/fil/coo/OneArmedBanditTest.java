package fil.coo;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Before;
import org.junit.Test;

import fil.coo.Room;
import fil.coo.character.Player;
import fil.coo.item.GoldPurse;
import fil.coo.item.HealthPotion;
import fil.coo.item.Item;
import fil.coo.item.OneArmedBandit;
import fil.coo.item.StrengthPotion;

public class OneArmedBanditTest {
	
	OneArmedBandit oab;
	protected List<Item> itemsForOneArmeBandit;
	protected Player p;
	protected Player poor;
	protected Room r;

	
	@Before
	public void init(){
		this.itemsForOneArmeBandit=new ArrayList<Item>();
		this.itemsForOneArmeBandit.add(new StrengthPotion(5));
		this.itemsForOneArmeBandit.add(new HealthPotion(15));
		//on fait attention de ne pas mettre de goldpuse pour pouvoir tester use()
		this.oab=new OneArmedBandit(itemsForOneArmeBandit, 15);
		this.p=new Player("titi",50,50,50);
		this.poor=new Player("titi",1,1,1);
		this.r=new Room();
	}

	@Test
	public void testOneArmedBandit() {
		assertNotNull(this.oab);
	}

	@Test
	public void testUseWhenPlayerDoesNotHaveEnoughtMoney() {
		assertEquals(1,poor.getGold());
		oab.use(poor, r);
		assertEquals(1,poor.getGold());
	}
	
	@Test
	public void testUseWhenPlayerHaveEnoughtMoney() {
		assertEquals(50,p.getGold());
		oab.use(p, r);
		assertEquals(35,p.getGold());
	}

	@Test
	public void testGetPrice() {
		assertEquals(15,this.oab.getPrice());
	}

}
