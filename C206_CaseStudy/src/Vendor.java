
//Darren
public class Vendor {
	private String name;
	private int contactNo;
    private String address;
    private String vmenu;
    
	public Vendor(String name, int contactNo, String address, String vmenu) {
		this.name = name;
		this.contactNo = contactNo;
		this.address = address;
		this.vmenu = vmenu;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getVmenu() {
		return vmenu;
	}

	public void setVmenu(String vmenu) {
		this.vmenu = vmenu;
	}
    
	
    


}