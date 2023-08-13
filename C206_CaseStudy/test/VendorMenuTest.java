//Shuvo

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendorMenuTest {

	private Menu m1;
	private Menu m2;
	private ArrayList<Menu> menuList;

	public VendorMenuTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
	    m1 = new Menu(1, "Bento Set", 5);
	    m2 = new Menu(2, "Maggi Mee", 3);
	    menuList = new ArrayList<Menu>();
	  }
		

	@After
	public void tearDown() throws Exception {
		m1 = null;
		m2 = null;
		menuList = null;
	}

	@Test
	public void testAddMenu() {
		assertNotNull("Test if there is valid Menu arraylist to view", menuList);
		assertEquals("Test that the Menu arraylist is empty.", 0, menuList.size());

		// Given an empty list, after adding 1 item, the size of the list is 1
		VendorMenu.addMenu(menuList, m1);
		assertEquals("Test that the menu arraylist size is 1.", 1, menuList.size());

		// Add another menu
		VendorMenu.addMenu(menuList, m2);
		assertEquals("Test that menu arraylist size is now 2.", 2, menuList.size());

		// The item just added is the same as the last item added in the list
		assertSame("Test that menu is added to the end of the list.", m2, menuList.get(1));

		// Add an item that already exists in the list
		VendorMenu.addMenu(menuList, m2);
		assertEquals("Test that the menu arrayList size is unchanged.", 2, menuList.size());
	}

	@Test
	// Retrieving menus from menuList
	public void testRetrieveAllMenus() {
		assertNotNull("Test if there is a valid Menu arraylist to retrieve from", menuList);
	    VendorMenu.addMenu(menuList, m1);
		VendorMenu.addMenu(menuList, m2);

		String output = VendorMenu.retrieveAllMenus(menuList);

		// Expected output based on the sample menus and menuList contents
		String expectedOutput = "MENU LIST                                                \n" +
				"No.   MENU NAME           MENU ITEMS                                  PRICE     \n" +
				"1     RiceDelight         chickenRice , porkrice , NasiLemak         10         \n" +
				"2     NoodlesDelight      MeeGoReng , KoreanRamen , MeeSoto          8          \n";

		// Trim both expected and actual output strings before comparison
		expectedOutput = expectedOutput.trim();
		output = output.trim();

		assertEquals("Test if the retrieveAllMenus method returns the expected output",
		        expectedOutput.replaceAll("\\s+", ""), // Remove all whitespace
		        output.replaceAll("\\s+", ""));         // Remove all whitespace
	}
	@Test
	public void testDeleteMenu() {
		assertNotNull("Test if there is valid Menu arraylist to delete from", menuList);
		VendorMenu.addMenu(menuList, m1);
		VendorMenu.addMenu(menuList, m2);
		assertEquals("Test that the menu arraylist size is 2.", 2, menuList.size());

		// Test case 1
		// Test that there is an existing menu inside the menu list to delete from
		VendorMenu.deleteMenu(menuList, 1);
		assertEquals("Test that the menu arraylist size is 1.", 1, menuList.size());

		// Test case 2
		// Delete non-existent menu
		VendorMenu.deleteMenu(menuList, 3);
		assertEquals("Test that menuList size is unchanged after trying to delete non-existent menu",
				1, menuList.size());

		// Test case 3
		// Delete last menu in the list
		assertEquals("Test that the menu arraylist size is 1.", 1, menuList.size());
		VendorMenu.deleteMenu(menuList, 2);
		assertEquals("Test that the menu arraylist size is 0.", 0, menuList.size());
	}
}

