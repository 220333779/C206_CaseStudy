import static org.junit.Assert.*;
//Darren

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AdministratorMenusTest {
	private Vendor v1;
	private Vendor v2;
	private Vendor v3;
	
	
	private ArrayList<Vendor> vendorList;
	
	public AdministratorMenusTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		v1 = new Vendor("Sam", 12345678, "#05-476", "Chinese Food");
		v2 = new Vendor("John", 10002000, "#06-432", "Japanese Cuisine");
		v3 = new Vendor("Alex", 33332222, "#07-856", "Malay Specialty");
		
		vendorList = new ArrayList<Vendor>();
	}
	public void testAddVendor() {
		// Item list is not null and it is empty
		assertNotNull("Test if there is valid Vendor arrayList to add to", vendorList);
		assertEquals("Test that the Vendor arrayList is empty.", 0, vendorList.size());
		//Given an empty list, after adding 1 item, the size of the list is 1
		AdministratorMenus.addVendor(vendorList, v1);
		assertEquals("Test that the Vendor ArrayList size is 1.", 1, vendorList.size());
		
		// Add an item
		AdministratorMenus.addVendor(vendorList, v2);
		assertEquals("Test that the Vendor arraylist size is now 2.", 2, vendorList.size());
		//The item just added is as same as the last item in the list
		assertSame("Test that Vendor is added to the end of the list.", v2, vendorList.get(1));
		
		// Add an item that already exists in the list
		AdministratorMenus.addVendor(vendorList, v2);
		assertEquals("Test that the Vendor arraylist size is unchange.", 2, vendorList.size());
		
		// Add an item that has missing detail
		Vendor v_missing = new Vendor("Sam", 0, "#05-489", "Western Food");
		AdministratorMenus.addVendor(vendorList, v_missing);
		assertEquals("Test that the Vendor arraylist size is unchange.", 2, vendorList.size());
	}
	@Test
	public void testRetrieveAllVendor() {
		//Test Case 1
		// Test if Item list is not null and empty
		assertNotNull("Test if there is valid Vendor arraylist to add to", vendorList);
		assertEquals("Test that the Vendor arraylist is empty.", 0, vendorList.size());
		// Attempt to retrieve the Vendors 
		String allVendor= AdministratorMenus.retrieveAllVendors(vendorList);
		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allVendor);
		
		//Test Case 2
		AdministratorMenus.addVendor(vendorList, v1);
		AdministratorMenus.addVendor(vendorList, v2);
		// Test that the list is not empty
		assertEquals("Test that Camcorder arraylist size is 2.", 2, vendorList.size());
		// Attempt to retrieve the Vendors 
		allVendor= AdministratorMenus.retrieveAllVendors(vendorList);
		testOutput = String.format("%-10s %-30d %-10s %-10s\n", "Sam", 12345678, "#05-476", "Chinese Food");
	    testOutput += String.format("%-10s %-30d %-10s %-10s\n", "John", 10002000, "#06-432", "Japanese Cuisine");
		// Test that the details are displayed correctly 
		assertEquals("Test that the display is correct.", testOutput, allVendor);
	}
	
	@Test
	public void testDeleteExistingVendor() {
		//Test case 1
		//Delete an existing Vendor
		assertNotNull("Test if there is valid Vendor arraylist to delete from", vendorList);
		AdministratorMenus.addVendor(vendorList, v1);
		AdministratorMenus.addVendor(vendorList, v2);
		assertEquals("Test that the Vendor arraylist size is 2.", 2, vendorList.size());
		//Given a vendor list with 2 item, after deleting the item, the size of the list is 1.
		AdministratorMenus.deleteExistingVendor(vendorList, 12345678);
		assertEquals("Test that the Vendor arraylist size is 1.", 1, vendorList.size());
		
		//Test case 2
		//Delete non-existent vendor
		AdministratorMenus.deleteExistingVendor(vendorList, 77777777);
		//Test that you cannot delete a vendor that does not exist
		assertEquals("Test that vendorList size is empty after trying to delete non-existent vendor"
				, 1, vendorList.size());
		//Test case 3
		//Delete last vendor in the list
		assertEquals("Test that the Vendor arraylist size is 1.", 1, vendorList.size());
		//Given a vendor list with 1 item, after deleting the item, the size of the list is empty.
		AdministratorMenus.deleteExistingVendor(vendorList, 10002000);
		assertEquals("Test that the Vendor arraylist size is 0.", 0, vendorList.size());
		
		
	}
	

	@After
	public void tearDown() throws Exception {
		v1 = null;
		v2 = null;
		v3 = null;
		vendorList = null;
	}
	}
