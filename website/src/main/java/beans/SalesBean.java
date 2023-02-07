package beans;

public class SalesBean {
	private int price, qty;

	// property - price
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	// property - amount
	public int getAmount() {
		int amount = price * qty;
		int discount = amount * 20 / 100;
		return amount - discount;
	}

	 
}
