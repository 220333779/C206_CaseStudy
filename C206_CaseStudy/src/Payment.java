// Yu Bin
public class Payment {
	private String paymentID;
	private String name;
	private String schName;
	private double totalAmt;

	public Payment(String paymentID, String name, String schName, double totalAmt) { // TODO Auto-generated constructor
																						// stub
		this.paymentID = paymentID;
		this.name = name;
		this.schName = schName;
		this.totalAmt = totalAmt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchName() {
		return schName;
	}

	public void setSchName(String schName) {
		this.schName = schName;
	}

	public String getPaymentID() {
		return paymentID;
	}

	public double getTotalAmt() {
		return totalAmt;
	}

}