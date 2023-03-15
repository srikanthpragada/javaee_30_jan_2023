package springmvc.model;

public class DiscountModel {
	private int amount, rate;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	// Read-only property - discount 
	public int getDiscount() {
		return amount * rate / 100;
	}
}
