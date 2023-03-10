package aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Test implements CommandLineRunner {
 
	@Autowired 
	private OrderService orders;
	
	@Autowired
	private CustomerService customer;
	
	public static void main(String[] args) {
		  SpringApplication.run(Test.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		  System.out.println(orders.getClass());
	      orders.placeOrder();
	      orders.cancelOrder(1);
	      System.out.println(orders.getStatus(1));
	      
	      customer.addCustomers();
	}
}
