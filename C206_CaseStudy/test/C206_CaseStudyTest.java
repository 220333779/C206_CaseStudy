import static org.junit.Assert.*;
//Zen Yue
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	    private ArrayList<User> userList;
	    
	    @Before
	    public void setUp() throws Exception {
	        userList = new ArrayList<User>();
	        User newUser = new User("John", "password1", "John Doe", "91234567");
	        userList.add(newUser);
	    }

	    @Test
	    public void testUserListNotEmpty() {
	        assertNotNull("Check if user list is not null", userList);
	        assertEquals("Check if user list size is 1", 1, userList.size());
	    }

	    @Test
	    public void testMainMenuDisplay() {
	        String expectedOutput = "SCHOOL LUNCH BOX SYSTEM";
	        assertEquals("Check if main menu display matches", expectedOutput, C206_CaseStudy.getMainMenuDisplay());
	    }

	    @Test
	    public void testAddUser() {
	        // Test if a new user can be added to the user list
	        User newUser = new User("Jane", "password2", "Jane Smith", "98765432");
	        C206_CaseStudy.addUser(userList, newUser);
	        assertEquals("Check if user list size is 2 after adding a new user", 2, userList.size());
	        assertSame("Check if the new user is added", newUser, userList.get(1));
	    }

	    @Test
	    public void testAuthenticateUser() {
	        // Test if user authentication works with valid credentials
	        assertTrue("Check if authentication works for valid user", C206_CaseStudy.authenticateUser("John", "password1", userList));
	        
	        // Test if user authentication fails with invalid credentials
	        assertFalse("Check if authentication fails for invalid user", C206_CaseStudy.authenticateUser("Jane", "password2", userList));
	    }

	    @Test
	    public void testSearchUser() {
	        // Test if a user can be found by their username
	        User user = C206_CaseStudy.searchUser("John", userList);
	        assertNotNull("Check if user is found by username", user);
	        assertEquals("Check if the found user's username matches", "John", user.getUsername());
	    }

	    @Test
	    public void testDeleteUser() {
	        // Test if a user can be deleted from the user list
	        User userToDelete = userList.get(0);
	        C206_CaseStudy.deleteUser(userList, userToDelete);
	        assertEquals("Check if user list size is 0 after deleting the user", 0, userList.size());
	    }


	    @After
	    public void tearDown() throws Exception {
	        userList = null;
	    }
	}
