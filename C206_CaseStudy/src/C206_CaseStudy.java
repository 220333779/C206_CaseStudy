import java.util.ArrayList;

//Zen yue
public class C206_CaseStudy {

	private static ArrayList<User> userList = new ArrayList<>();

	public static void main(String[] args) {
		ArrayList<Order> orderList = new ArrayList<Order>();
		ArrayList<Payment> paymentList = new ArrayList<Payment>();
		orderList.add(new Order("10/8/2023", "Bento Set", 10));
		orderList.add(new Order("14/8/2023", "Maggi Mee", 20));
		Payment payment1 = new Payment("PM1", "John Stones", "Jurong Secondary School", 1000.00);
		paymentList.add(payment1);
		ArrayList<School> schoolList = new ArrayList<School>();
		ArrayList<Vendor> vendorList = new ArrayList<Vendor>();
		ArrayList<Menu> menuList = new ArrayList<Menu>();
        menuList.add(new Menu(1, "Bento Set", 5));
        menuList.add(new Menu(2, "Maggi Mee", 3));

		School school1 = new School("School 1", "Jurong Secondary School", 1);
		schoolList.add(school1);
		int option = 0;
		

		User newUser = new User("John", "password1", "John Doe", "91234567");
		userList.add(newUser);

		displayMainMenu();
		option = Helper.readInt("Enter an option > ");

		while (option != 4) {
			if (option == 1) {
				while (option != 7) {
					ParentGuardianMenu.menu();
					option = Helper.readInt("Enter an option > ");

					if (option == 1) {
						// View all Orders
						ParentGuardianMenu.viewAllOrder(orderList);
					} else if (option == 2) {
						Order o1 = inputOrder();
						ParentGuardianMenu.addOrder(orderList, o1);

					} else if (option == 3) {
						// Loan item
						ParentGuardianMenu.viewAllOrder(orderList);
						int orderID = Helper.readInt("Enter order ID > ");
						ParentGuardianMenu.deleteOrder(orderList, orderID);

					} else if (option == 4) {
						viewAllPayments(paymentList); // Removed "ParentMenu." for the same reason
					} else if (option == 5) {
						addPayment(paymentList); // Removed "ParentMenu."
						System.out.println("Payment added");
					} else if (option == 6) {
						String paymentIdToDelete = Helper.readString("Enter Payment ID to delete: ");
						deletePayment(paymentList, paymentIdToDelete); // Changed method name
					} else if (option == 7) {
						System.out.println("Bye!");
					} else {
						System.out.println("Invalid option");

					}

				}
			}
			if (option == 2) {
				while (option != 7) {
					AdministratorMenus.Adminmenu();
					option = Helper.readInt("Enter an option > ");

					if (option == 1) {
						// View all Schools
						AdministratorMenus.viewAllSchools(schoolList);
					} else if (option == 2) {
						School sch = InputSchool();
						AdministratorMenus.addSchool(schoolList, sch);
						System.out.println("School added");
					} else if (option == 3) {
						int schoolIdToDelete = Helper.readInt("Enter School ID to delete: ");
						AdministratorMenus.deleteSchool(schoolList, schoolIdToDelete);
					} else if (option == 4) {
						AdministratorMenus.viewAllVendor(vendorList);
					} else if (option == 5) {
						Vendor v = inputVendor();
						AdministratorMenus.addVendor(vendorList, v);
						System.out.println("Vendor Added");
					} else if (option == 6) {
						int vendorContactToDelete = Helper.readInt("Enter Vendor Contact Number to delete: ");
						AdministratorMenus.deleteExistingVendor(vendorList, vendorContactToDelete);
					} else if (option == 7) {
						System.out.println("Quit");
					} else {
						System.out.println("Invalid Option");
					}
				}

			}
			if (option == 3) {
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
				
			}
			if (option == 4) {
				System.out.println("Exiting School Lunch Box System. Goodbye!");

			} else {
				System.out.println("Invalid option. Please choose a valid option.");
			}
		}
	

	private static Order inputOrder() {
		String category = Helper.readString("Enter due date > ");
		String description = Helper.readString("Enter description > ");
		int oID = Helper.readInt("Enter order ID > ");

		Order oo = new Order(category, description, oID);
		return oo;
	}

	public static void viewAllOrder(ArrayList<Order> orderList) {
		setHeader("ORDER LIST");
		String output = String.format("%-5s %-20s %-10s %-10s\n", "No.", "DESCRIPTION", "DUE DATE", "ORDER ID");
		output += retrieveAllOrder(orderList);
		System.out.println(output);
	}

	public static String retrieveAllOrder(ArrayList<Order> orderList) {
		String output = "";
		int count = 1;
		for (Order order : orderList) {
			output += String.format("%-5d %-20s %-10s %-10d\n", count, order.getDescription(), order.getdueDate(),
					order.getoID());
			count++;
		}
		return output;
	}

	public static void addOrder(ArrayList<Order> orderList, Order newOrder) {
		int newOrderId = newOrder.getoID();
		String newOrderDescription = newOrder.getDescription();

		if (newOrderId == 0 || newOrderDescription.isEmpty()) {
			System.out.println("Empty Description/Invalid ID is entered! Try again! :)");
			return;
		}

		for (Order existingOrder : orderList) {
			if (existingOrder.getoID() == newOrderId) {
				System.out.println("Duplicate Order ID! Try again! :)");
				return;
			}
		}

		orderList.add(newOrder);
		System.out.println("Added to basket!\n");
	}

	public static void deleteOrder(ArrayList<Order> orderList, int orderId) {
		Order orderToDelete = null;
		for (Order order : orderList) {
			if (order.getoID() == orderId) {
				orderToDelete = order;
				break;
			}
		}

		if (orderToDelete != null) {
			orderList.remove(orderToDelete);
			System.out.println("Order deleted successfully!");
		} else {
			System.out.println("Order with the specified ID not found!");
		}
	}

	// Yu Bin
	public static String retrieveAllPayments(ArrayList<Payment> paymentList) {
		String output = "";
		// write your code here
		for (int i = 0; i < paymentList.size(); i++) {
			output += String.format("%-10s %-20s %-30s %-10.2f \n", paymentList.get(i).getPaymentID(),
					paymentList.get(i).getName(), paymentList.get(i).getSchName(), paymentList.get(i).getTotalAmt());
		}
		return output;
	}

	public static void viewAllPayments(ArrayList<Payment> paymentList) {
		setHeader("PAYMENT LIST");
		String output = String.format("%-10s %-20s %-30s %-10s \n", "Payment ID", "Parent Name", "School Name",
				"Payment Amount");
		output += retrieveAllPayments(paymentList);
		System.out.println(output);
	}

	public static void addPayment(ArrayList<Payment> paymentList) {
		// Read the input for the new payment
		String paymentId = Helper.readString("Enter Payment ID: ");
		String name = Helper.readString("Enter Parent Name: ");
		String schName = Helper.readString("Enter School Name: ");
		double totalAmt = Helper.readDouble("Enter Total Payment: "); // Changed to readDouble

		// Create a new Payment object
		Payment newPayment = new Payment(paymentId, name, schName, totalAmt);
		paymentList.add(newPayment); // Moved inside the method
		System.out.println("Payment added successfully.");
	}

	public static void deletePayment(ArrayList<Payment> paymentList, String paymentIdToDelete) {
		Payment paymentToDelete = null; // Changed variable name to follow naming convention

		// Find the payment with the specified payment ID
		for (Payment payment : paymentList) {
			if (payment.getPaymentID().equals(paymentIdToDelete)) {
				paymentToDelete = payment;
				break;
			}
		}

		// If the payment is found, remove it from the list
		if (paymentToDelete != null) {
			paymentList.remove(paymentToDelete);
			System.out.println("Payment deleted successfully.");
		} else {
			System.out.println("Payment with the specified ID not found.");
		}
	}

	public static String retrieveAllSchools(ArrayList<School> schoolList) {
		String output = "";
		// write your code here
		for (int i = 0; i < schoolList.size(); i++) {
			output += String.format("%-10d %-30s %-10s\n", schoolList.get(i).getSchoolId(),
					schoolList.get(i).getSchoolName(), schoolList.get(i).getSchoolTag());
		}
		return output;
	}

	public static void viewAllSchools(ArrayList<School> schoolList) {
		setHeader("SCHOOL LIST");
		String output = String.format("%-10s %-30s %-10s\n", "SchoolID", "SchoolName", "SchoolTag");
		output += retrieveAllSchools(schoolList);
		System.out.println(output);
	}

	public static School InputSchool() {
		// Read the input for the new school
		String schoolTag = Helper.readString("Enter School Tag: ");
		String schoolName = Helper.readString("Enter School Name: ");
		int schoolId = Helper.readInt("Enter School ID: ");

		// Create a new School object
		School newSchool = new School(schoolTag, schoolName, schoolId);
		return newSchool;
	}

	//
	public static void addSchool(ArrayList<School> schoolList, School newSchool) {
		// Read the input for the new school
		String newschooltag = newSchool.getSchoolTag();
		for (int i = 0; i < schoolList.size(); i++) {
			String existingSchoolTag = schoolList.get(i).getSchoolTag();
			if (existingSchoolTag.equalsIgnoreCase(newschooltag)) {
				System.out.println("School with the same tag already exists.");
				return;
			}
		}

		// Add the new school to the list
		schoolList.add(newSchool);
		System.out.println("School added successfully.");
	}

	public static boolean deleteSchool(ArrayList<School> schoolList, int schoolIdToDelete) {
		School schoolToDelete = null;

		// Find the school with the specified school ID
		for (School school : schoolList) {
			if (school.getSchoolId() == schoolIdToDelete) {
				schoolToDelete = school;
				break;
			}
		}

		// If the school is found, remove it from the list
		if (schoolToDelete != null) {
			schoolList.remove(schoolToDelete);
			System.out.println("School deleted successfully.");
			return true; // Return true to indicate successful deletion
		} else {
			System.out.println("School with the specified ID not found.");
			return false; // Return false to indicate school not found
		}
	}

//Darren    
	public static Vendor inputVendor() {
		String name = Helper.readString("Enter vendor name > ");
		int contactNo = Helper.readInt("Enter vendor contact number > ");
		String address = Helper.readString("Enter vendor address > ");
		String vmenu = Helper.readString("Enter vendor menu > ");

		Vendor v = new Vendor(name, contactNo, address, vmenu);
		return v;
	}

	public static void addVendor(ArrayList<Vendor> vendorList, Vendor v) {

		String newVendor = v.getName();
		for (int i = 0; i < vendorList.size(); i++) {
			String vendor = vendorList.get(i).getName();
			if (vendor.equalsIgnoreCase(newVendor))
				return;
		}
		if ((v.getContactNo() == 0) || (v.getAddress().isEmpty()) || (v.getVmenu().isEmpty())) {
			return;
		}

		vendorList.add(v);
	}

	public static void viewAllVendor(ArrayList<Vendor> vendorList) {
		setHeader("VENDOR LIST");
		String voutput = String.format("%-10s %-30s %-10s %-10s \n", "NAME", "ContactNumber", "Address", "Menu");
		voutput += retrieveAllVendors(vendorList);
		System.out.println(voutput);
	}

	public static String retrieveAllVendors(ArrayList<Vendor> vendorList) {
		String voutput = "";
		// write your code here
		for (int i = 0; i < vendorList.size(); i++) {
			voutput += String.format("%-10s %-30d %-10s %-10s\n", vendorList.get(i).getName(),
					vendorList.get(i).getContactNo(), vendorList.get(i).getAddress(), vendorList.get(i).getVmenu());

		}
		return voutput;
	}

	public static void deleteExistingVendor(ArrayList<Vendor> vendorList, int vendorContactToDelete) {
		Vendor vendorToDelete = null;

		// Find the vendor with the specified vendor contactNo
		for (Vendor vendor : vendorList) {
			if (vendor.getContactNo() == vendorContactToDelete) {
				vendorToDelete = vendor;
				break;
			}
		}

		// If the school is found, remove it from the list
		if (vendorToDelete != null) {
			vendorList.remove(vendorToDelete);
			System.out.println("Vendor deleted successfully.");
		} else {
			System.out.println("Vendor with the specified Contact Number not found.");
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
        String output = "";
        output += retrieveAllMenus(menuList);
        System.out.println(output);
    }

    public static String retrieveAllMenus(ArrayList<Menu> menuList) {
    	
    	if (menuList.isEmpty()) {
            return "No menus available.";
        }

        String format = "%-10s %-30s %-10s%n";
        String output = String.format(format, "ID", "MENU ITEMS", "PRICE");
        

        for (Menu menu : menuList) {
            output += String.format(format, menu.getMenuID(), menu.getMenuItems(), menu.getMenuItemPrice());
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

	public static void setHeader(String header) {
		System.out.println(header);
	}

	public static void displayMainMenu() {
		System.out.println("Login Menu");
		System.out.println("1. Parent");
		System.out.println("2. Administrator");
		System.out.println("3. Vendor");
		System.out.println("4. Quit");
	}
}
