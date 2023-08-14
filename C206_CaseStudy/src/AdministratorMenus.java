
import java.util.ArrayList;

//Joel

public class AdministratorMenus {
	
	
    public static final int OPTION_QUIT = 7;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<School> schoolList = new ArrayList<School>();
		ArrayList<Vendor> vendorList = new ArrayList<Vendor>();

        School school1 = new School("School 1", "Jurong Secondary School", 1);
        schoolList.add(school1);

        int option = 0;

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
            } else {
            	System.out.println("Quit");
            }
        }
    }

	        
	    public static String retrieveAllSchools(ArrayList<School> schoolList) {
	        String output = "";
	        // write your code here
	        for (int i = 0; i < schoolList.size(); i++) {
	            output += String.format("%-10d %-30s %-10s\n", 
	                schoolList.get(i).getSchoolId(),
	                schoolList.get(i).getSchoolName(), 
	                schoolList.get(i).getSchoolTag());
	        }
	        return output;
	    }

	    public static void viewAllSchools(ArrayList<School> schoolList) {
	        AdministratorMenus.setHeader("SCHOOL LIST");
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
	    public static void addSchool(ArrayList<School> schoolList,School newSchool) {
	            // Read the input for the new school
	    	String newschooltag = newSchool.getSchoolTag();
	        for (int i = 0; i < schoolList.size(); i++) {
	            String existingSchoolTag = schoolList.get(i).getSchoolTag();
	            if (existingSchoolTag.equalsIgnoreCase(newschooltag) ) {
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
		for(int i = 0; i < vendorList.size(); i++) {
			String vendor = vendorList.get(i).getName();
			if (vendor.equalsIgnoreCase(newVendor) )
				return;
		}
		if ((v.getContactNo() == 0) || (v.getAddress().isEmpty()) || (v.getVmenu().isEmpty()) ) {
			return;
		}
		
		vendorList.add(v);
	}
    public static void viewAllVendor(ArrayList<Vendor> vendorList) {
		AdministratorMenus.setHeader("VENDOR LIST");
		String voutput = String.format("%-10s %-30s %-10s %-10s \n", "NAME", "ContactNumber",
				"Address", "Menu");
		voutput += retrieveAllVendors(vendorList);
		System.out.println(voutput);
	}
    public static String retrieveAllVendors(ArrayList<Vendor> vendorList) {
        String voutput = "";
        // write your code here
        for (int i = 0; i < vendorList.size(); i++) {
            voutput += String.format("%-10s %-30d %-10s %-10s\n", 
                vendorList.get(i).getName(),
                vendorList.get(i).getContactNo(), 
                vendorList.get(i).getAddress(),
            	vendorList.get(i).getVmenu());
            
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
    
		

    public static void Adminmenu() {
        AdministratorMenus.setHeader("ADMIN SYSTEM");
        System.out.println("1. Display Schools");
        System.out.println("2. Add School");
        System.out.println("3. Delete School");
        System.out.println("4. Display Vendor List");
		System.out.println("5. Add a Vendor");
		System.out.println("6. Delete existing Vendor From System");
        System.out.println("7. Add User");
        System.out.println("8. Delete User from User List");
        System.out.println("9. View All Users");
        System.out.println("10. Quit");
        Helper.line(80, "-");
    }

    private static void setHeader(String header) {
        Helper.line(80, "-");
        System.out.println(header);
        Helper.line(80, "-");
    }

{
		

	}


}