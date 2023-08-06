
public class Order{

	private int OrderId;
	
	public Order(String assetTag, String description, int OrderId) {
		//super(assetTag, description);
		this.OrderId=OrderId;
	}

	public int getOrder() {
		return OrderId;
	}
	
}
