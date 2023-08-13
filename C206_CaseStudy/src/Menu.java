//Shuvo

public class Menu {
    private int menuID;
    private String menuItems;
    private int menuItemPrice;

    public Menu(int menuID, String menuItems, int menuItemPrice) {
        this.menuID = menuID;
        this.menuItems = menuItems;
        this.menuItemPrice = menuItemPrice;
    }

    public int getMenuID() {
        return menuID;
    }

    public void setMenuID(int menuID) {
        this.menuID = menuID;
    }
    public String getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(String menuItems) {
        this.menuItems = menuItems;
    }

    public int getMenuItemPrice() {
        return menuItemPrice;
    }

    public void setMenuItemPrice(int menuItemPrice) {
        this.menuItemPrice = menuItemPrice;
    }
}
