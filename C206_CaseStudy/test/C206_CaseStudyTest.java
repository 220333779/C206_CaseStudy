import static org.junit.Assert.*;
//Zen Yue
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private User u1;
	private User u2;
	private ArrayList<User> userList;

	@Before
	public void setUp() throws Exception {
		userList = new ArrayList<User>();
		u1 = new User("John", "password1", "John Doe", 91234567);
		u2 = new User("Jane", "password2", "Jane Smith", 98765432);
	}

	@Test
	public void testAddUser() {
		// User list is not null and it is empty
		assertNotNull("Test if there is valid User arrayList to add to", userList);
		assertEquals("Test that the User arrayList is empty.", 0, userList.size());
		// Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addUser(userList, u1);
		assertEquals("Test that the User ArrayList size is 1.", 1, userList.size());

		// Add an item
		C206_CaseStudy.addUser(userList, u2);
		assertEquals("Test that the User arraylist size is now 2.", 2, userList.size());
		// The item just added is as same as the last item in the list
		assertSame("Test that User is added to the end of the list.", u2, userList.get(1));

		// Add an item that already exists in the list
		C206_CaseStudy.addUser(userList, u2);
		assertEquals("Test that the User arraylist size is unchange.", 2, userList.size());

		// Add an item that has missing detail
		User u_missing = new User("Ben", "", "Ben Tan", 92478456);
		C206_CaseStudy.addUser(userList, u_missing);
		assertEquals("Test that the User arraylist size is unchange.", 2, userList.size());
	}
	@Test
	public void testRetrieveAllUser() {
		//Test Case 1
		// Test if Item list is not null and empty
		assertNotNull("Test if there is valid User arraylist to add to", userList);
		assertEquals("Test that the User arraylist is empty.", 0, userList.size());
		// Attempt to retrieve the Vendors 
		String allUser= C206_CaseStudy.retrieveAllUser(userList);
		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allUser);
		
		//Test Case 2
		C206_CaseStudy.addUser(userList, u1);
		C206_CaseStudy.addUser(userList, u2);
		// Test that the list is not empty
		assertEquals("Test that User arraylist size is 2.", 2, userList.size());
		// Attempt to retrieve the Vendors 
		allUser= C206_CaseStudy.retrieveAllUser(userList);
		testOutput = String.format("%-10s %-20s %-10s %-10d\n", "John", "password1", "John Doe", 91234567);
	    testOutput += String.format("%-10s %-20s %-10s %-10d\n", "Jane", "password2", "Jane Smith", 98765432);
		// Test that the details are displayed correctly S
		assertEquals("Test that the display is correct.", testOutput, allUser);
		}
	@Test
	public void testDeleteUser() {
		//Test case 1
		//Delete an existing Vendor
		assertNotNull("Test if there is valid User arraylist to delete from", userList);
		C206_CaseStudy.addUser(userList, u1);
		C206_CaseStudy.addUser(userList, u2);
		assertEquals("Test that the User arraylist size is 2.", 2, userList.size());
		//Given a vendor list with 2 item, after deleting the item, the size of the list is 1.
		C206_CaseStudy.deleteUser(userList, 91234567);
		assertEquals("Test that the User arraylist size is 1.", 1, userList.size());
		
		//Test case 2
		//Delete non-existent vendor
		C206_CaseStudy.deleteUser(userList, 77777777);
		//Test that you cannot delete a vendor that does not exist
		assertEquals("Test that userList size is empty after trying to delete non-existent user"
				, 1, userList.size());
		//Test case 3
		//Delete last vendor in the list
		assertEquals("Test that the User arraylist size is 1.", 1, userList.size());
		//Given a vendor list with 1 item, after deleting the item, the size of the list is empty.
		AdministratorMenus.deleteUser(userList, 98765432);
		assertEquals("Test that the User arraylist size is 0.", 0, userList.size());
		
		
	}

	@After
	public void tearDown() throws Exception {
		userList = null;
	}
}
