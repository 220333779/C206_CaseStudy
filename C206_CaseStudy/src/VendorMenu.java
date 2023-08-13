import java.util.ArrayList;
//Shuvo

public class VendorMenu {

    public static void main(String[] args) {
        ArrayList<Menu> menuList = new ArrayList<Menu>();
        menuList.add(new Menu(1, "Bento Set", 5));
        menuList.add(new Menu(2, "Maggi Mee", 3));

        int option = 0;

        while (option != 4) {

            VendorMenu.menu();
            option = Helper.readInt("Enter an option > ");

            if (option == 1) {
                // View all Menus
                VendorMenu.viewAllMenus(menuList);
            } else if (option == 2) {
                Menu m1 = inputMenu();
                VendorMenu.addMenu(menuList, m1);

            } else if (option == 3) {
                // Delete Menu
                VendorMenu.viewAllMenus(menuList);
                int menuID = Helper.readInt("Enter Menu ID > ");
                VendorMenu.deleteMenu(menuList, menuID);

            } else if (option == 4) {
                System.out.println("Bye!");
            } else {
                System.out.println("Invalid option");
            }

        }

    }

    private static Menu inputMenu() {
        int menuID = Helper.readInt("Enter Menu ID > ");
        String menuItem = Helper.readString("Enter Menu Item > ");
        int menuItemPrice = Helper.readInt("Enter Menu Item Price > ");

        Menu m = new Menu(menuID, menuItem, menuItemPrice);
        return m;
    }

    public static void viewAllMenus(ArrayList<Menu> menuList) {
        setHeader("VENDOR MENU LIST");
        String output = String.format("%-5s %-20s %-10s\n", "ID", "MENU NAME", "PRICE");
        output += retrieveAllMenus(menuList);
        System.out.println(output);
    }

    public static void setHeader(String header) {
        System.out.println(header);
    }

    public static String retrieveAllMenus(ArrayList<Menu> menuList) {
        String output = "";
        for (Menu menu : menuList) {
            output += String.format("%-5d %-20s %-10d\n", menu.getMenuID(), menu.getMenuItems(), menu.getMenuItemPrice());
        }
        return output;
    }

    public static void addMenu(ArrayList<Menu> menuList, Menu m) {
        for (Menu menu : menuList) {
            if (menu.getMenuItems().equals(m.getMenuItems())) {
                System.out.println("Menu with the same menu items already exists! Try again! :)");
                return;
            }
        }

        Menu existingMenu = getMenuById(menuList, m.getMenuID());
        if (existingMenu != null || m.getMenuID() == 0) {
            System.out.println("Invalid Menu ID or Duplicate ID! Try again! :)");
            return;
        }
        menuList.add(m);
    }

    public static void deleteMenu(ArrayList<Menu> menuList, int menuID) {
        Menu menuToDelete = getMenuById(menuList, menuID);
        if (menuToDelete != null) {
            menuList.remove(menuToDelete);
            System.out.println("Menu deleted successfully!");
        } else {
            System.out.println("Menu with the specified ID not found!");
        }
    }

    private static Menu getMenuById(ArrayList<Menu> menuList, int menuID) {
        for (Menu menu : menuList) {
            if (menu.getMenuID() == menuID) {
                return menu;
            }
        }
        return null;
    }

    public static void menu() {
        VendorMenu.setHeader("VENDOR MENU LIST");
        System.out.println("1. Display Menu");
        System.out.println("2. Add Menu");
        System.out.println("3. Delete Menu");
        System.out.println("4. Quit");
        Helper.line(80, "-");
    }
}
