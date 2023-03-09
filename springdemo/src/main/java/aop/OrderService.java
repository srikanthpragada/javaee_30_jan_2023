package aop;

import org.springframework.stereotype.Component;

@Component
public class OrderService {
	  public void placeOrder() {
		  System.out.println("Placing an order");
	  }
	  
	  public void cancelOrder(int id) {
		  System.out.println("Cancelling an order with id " + id);
		  // throw new ArithmeticException();
	  }
	  
	  public String getStatus(int id) {
		  return "Delivered";
	  }
}
