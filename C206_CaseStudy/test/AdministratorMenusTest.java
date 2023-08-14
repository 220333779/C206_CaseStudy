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
	private School S1;
	private School S2;
    private User u1;
    private User u2;
    
    private ArrayList<User> testUserList;
	 
	private ArrayList<School> schoolList;
	
	private ArrayList<Vendor> vendorList;
	
	public AdministratorMenusTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data
		testUserList = new ArrayList<User>();
        u1 = new User("John", "password1", "John Doe", "91234567");
        u2 = new User("Jane", "password2", "Jane Smith", "98765432");
    
		  
		schoolList= new ArrayList<School>();
		S1 = new School("1", "1", 1);
		S2 = new School("2", "2", 2);
		schoolList.add(S1);
		schoolList.add(S2);
		schoolList = new ArrayList<School>();
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
		assertEquals("Test that Vendor arraylist size is 2.", 2, vendorList.size());
		// Attempt to retrieve the Vendors 
		allVendor= AdministratorMenus.retrieveAllVendors(vendorList);
		testOutput = String.format("%-10s %-30d %-10s %-10s\n", "Sam", 12345678, "#05-476", "Chinese Food");
	    testOutput += String.format("%-10s %-30d %-10s %-10s\n", "John", 10002000, "#06-432", "Japanese Cuisine");
		// Test that the details are displayed correctly S
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
	//Joel
	@Test
	 public void testAddSchool() {
	  
	  assertNotNull("Check if there is valid School arraylist to add to", schoolList);
	  AdministratorMenus.addSchool(schoolList,S1);
	  assertEquals("Check that Camcorder arraylist size is 1", 1, schoolList.size());
	  assertSame("Check that School is added", S1, schoolList.get(0));
	  
	  
	  AdministratorMenus.addSchool(schoolList,S2);
	  assertEquals("Check that Camcorder arraylist size is 2", 2, schoolList.size());
	  assertSame("Check that Camcorder is added", S2, schoolList.get(1));
	}
	 @Test
	 public void testRetrieveAllSchools() {
	  // Test if Item list is not null but empty -boundary
	  assertNotNull("Test if there is valid Camcorder arraylist to retrieve item", schoolList);
	  
	  //test if the list of camcorders retrieved from the SourceCentre is empty - boundary
	  String allSchools= AdministratorMenus.retrieveAllSchools(schoolList);
	  String testOutput = "";
	  assertEquals("Check that ViewAllCamcorderlist", testOutput, allSchools);
	  
	  //Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
	  AdministratorMenus.addSchool(schoolList, S1);
	  AdministratorMenus.addSchool(schoolList, S2);
	  assertEquals("Test that Camcorder arraylist size is 2", 2, schoolList.size());
	  
	  //test if the expected output string same as the list of camcorders retrieved from the SourceCentre 
	  allSchools= AdministratorMenus.retrieveAllSchools(schoolList);
	  testOutput = String.format("%-10s %-30s %-10s\n", "1", "1", 1);
	  testOutput += String.format("%-10s %-30s %-10s\n", "2", "2", 2);
	 
	  assertEquals("Test that ViewAllCamcorderlist", testOutput, allSchools);
	  
	 }
	 @Test
	     public void testDeleteSchool() {
	         // Ensure both schools are initially in the list
	   AdministratorMenus.addSchool(schoolList, S1);
	   AdministratorMenus.addSchool(schoolList, S2);
	         assertEquals("Check initial size of schoolList", 2, schoolList.size());
	         
	         // Delete the first school (S1)
	         boolean isDeleted = AdministratorMenus.deleteSchool(schoolList, S1.getSchoolId());
	         assertTrue("Check if the school was successfully deleted", isDeleted);
	         assertEquals("Check that schoolList size is reduced by 1", 1, schoolList.size());
	         
	         // Verify that the remaining school is S2
	         assertEquals("Check if the correct school remains", S2, schoolList.get(0));
	     }
	 //Zen Yue
	 @Test
	    public void testAddUser() {
	        // Test adding users to the user list
	        assertNotNull("Test if there is valid user arraylist to add to", testUserList);
	        
	        testUserList.add(u1);
	        assertEquals("Test that the user arraylist size is 1.", 1, testUserList.size());
	        assertSame("Test that the user is added at the first position.", u1, testUserList.get(0));

	        testUserList.add(u2);
	        assertEquals("Test that the user arraylist size is now 2.", 2, testUserList.size());
	        assertSame("Test that the user is added at the end of the list.", u2, testUserList.get(1));
	    }

	    @Test
	    public void testViewUser() {
	        // Test viewing users in the user list
	        testUserList.add(u1);
	        testUserList.add(u2);

	        assertEquals("Test that the user arraylist size is now 2.", 2, testUserList.size());
	        assertTrue("Test that the size of the user arraylist is 2.", testUserList.size() == 2);
	    }

	    @Test
	    public void testDeleteUser() {
	        // Test deleting a user from the user list
	        testUserList.add(u1);
	        testUserList.add(u2);

	        assertEquals("Test that the user arraylist size is now 2.", 2, testUserList.size());
	        assertSame("Test that the user is added at the end of the list.", u2, testUserList.get(1));

	        assertNotNull("Test if there is valid user arraylist to delete from", testUserList);
	        testUserList.remove(u1);
	        assertEquals("Test that the user arraylist size is 1 after deleting a user.", 1, testUserList.size());
	    }
	 
	

	@After
	public void tearDown() throws Exception {
		u1 = null;
		u2 = null;
		v1 = null;
		v2 = null;
		v3 = null;
		vendorList = null;
		testUserList = null;
	}
	}
