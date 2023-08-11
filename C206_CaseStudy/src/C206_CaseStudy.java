import java.util.ArrayList;
//Zen yue
public class C206_CaseStudy {

    private static ArrayList<User> userList = new ArrayList<>();

    public static void main(String[] args) {
        int option = 0;
        boolean shouldContinue = true;
        

        User newUser = new User("John", "password1", "John Doe", "91234567");
        userList.add(newUser);

        while (shouldContinue) {
            displayMainMenu();
            option = Helper.readInt("Enter an option > ");

            if (option == 1) {
                handleParentGuardian();
            } else if (option == 2) {
                handleAdministrator();
            } else if (option == 3) {
                System.out.println("Exiting School Lunch Box System. Goodbye!");
                shouldContinue = false;
            } else {
                System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    private static void displayMainMenu() {
        Helper.line(40, "-");
        System.out.println("SCHOOL LUNCH BOX SYSTEM");
        Helper.line(40, "-");
        System.out.println("1. Parent/Guardian");
        System.out.println("2. Administrator");
        System.out.println("3. Quit");
        Helper.line(40, "-");
    }

    private static void handleParentGuardian() {
        int option = 0;
        boolean shouldContinue = true;

        while (shouldContinue) {
            displayParentGuardianMenu();
            option = Helper.readInt("Enter an option > ");

            if (option == 1) {
                addUser();
            } else if (option == 2) {
                System.out.println("Returning to the main menu.");
                shouldContinue = false;
            } else {
                System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }
      
    private static void displayParentGuardianMenu() {
        Helper.line(40, "-");
        System.out.println("PARENT/GUARDIAN");
        Helper.line(40, "-");
        System.out.println("1. Add User");
        System.out.println("2. Quit");
        Helper.line(40, "-");
    }

    private static void addUser() {
        String username = Helper.readString("Enter Username: ");

        if (isUsernameTaken(username)) {
            System.out.println("Username is already taken. Please choose a different username.");
            return;
        }

        String password = Helper.readString("Enter Password: ");
        String fullName = Helper.readString("Enter Full Name: ");
        String phoneNumber = Helper.readString("Enter Phone Number: ");

        User newUser = new User(username, password, fullName, phoneNumber);
        userList.add(newUser);
        System.out.println("User added successfully.");
    }

    private static boolean isUsernameTaken(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }


    private static void handleAdministrator() {
        int option = 0;
        boolean shouldContinue = true;

        while (shouldContinue) {
            displayAdministratorMenu();
            option = Helper.readInt("Enter an option > ");

            if (option == 1) {
                viewAllUsers();
            } else if (option == 2) {
                deleteUser();
            } else if (option == 3) {
                System.out.println("Returning to the main menu.");
                shouldContinue = false;
            } else {
                System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }
    
    private static void displayAdministratorMenu() {
        Helper.line(40, "-");
        System.out.println("ADMINISTRATOR");
        Helper.line(40, "-");
        System.out.println("1. View all users");
        System.out.println("2. Delete user");
        System.out.println("3. Quit");
        Helper.line(40, "-");
    }

    private static void viewAllUsers() {
        displayUserListHeader();
if (userList.isEmpty()) {
            System.out.println("There are no users");
        } else {
            for (User user : userList) {
                System.out.printf("%-15s %-20s %-15s%n", user.getUsername(), user.getFullName(), user.getPhoneNumber());
            }
        }
    }

    private static void deleteUser() {
        displayUserListHeader();

        if (userList.isEmpty()) {
            System.out.println("There are no users");
            return;
        }

        String usernameToDelete = Helper.readString("Enter username to delete: ");
        User userToDelete = findUserByUsername(usernameToDelete);

        if (userToDelete != null) {
            displayUserDetails(userToDelete);
            String confirm = Helper.readString("Confirm user deletion (yes/no): ").toLowerCase();
            if (confirm.equals("yes")) {
                userList.remove(userToDelete);
                System.out.println("User successfully deleted");
            } else {
                System.out.println("User deletion canceled.");
            }
        } else {
            System.out.println("No user found");
        }
    }

    private static void displayUserListHeader() {
        Helper.line(40, "-");
        System.out.printf("%-15s %-20s %-15s%n", "USERNAME", "FULLNAME", "PHONENUMBER");
        Helper.line(40, "-");
    }

    private static User findUserByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    private static void displayUserDetails(User user) {
        Helper.line(40, "-");
        System.out.println("USER DETAILS");
        Helper.line(40, "-");
        System.out.println("Username: " + user.getUsername());
        System.out.println("Full Name: " + user.getFullName());
        System.out.println("Phone Number: " + user.getPhoneNumber());
        Helper.line(40, "-");
    }

    public static String getMainMenuDisplay() {
        return "SCHOOL LUNCH BOX SYSTEM";
    }

    public static void addUser(ArrayList<User> userList, User newUser) {
        userList.add(newUser);
    }

    public static boolean authenticateUser(String username, String password, ArrayList<User> userList) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static User searchUser(String username, ArrayList<User> userList) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static void deleteUser(ArrayList<User> userList, User userToDelete) {
        userList.remove(userToDelete);
    }
}
