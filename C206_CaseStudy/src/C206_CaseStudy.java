import java.util.ArrayList;
//Zen yue
public class C206_CaseStudy {

    private static ArrayList<User> userList = new ArrayList<>();

    public static void main(String[] args) {
        int option = 0;
        boolean shouldContinue = true;
        

        User newUser = new User("John", "password1", "John Doe", "91234567");
        userList.add(newUser);

        while (option != 3) {
            displayMainMenu();
            option = Helper.readInt("Enter an option > ");

            if (option == 1) {
                displayParentGuardianMenu();
            } else if (option == 2) {
                AdministratorMenus.Adminmenu();
            } else if (option == 3) {
                System.out.println("Exiting School Lunch Box System. Goodbye!");
                shouldContinue = false;
            } else {
                System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    
   

    
    
   
    

    