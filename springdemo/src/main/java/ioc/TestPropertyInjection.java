package ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class TestPropertyInjection implements CommandLineRunner {
	private Catalog catalog;  
	
	public TestPropertyInjection() {
		System.out.println("TestPropertyInjection()");
	}

	public Catalog getCatalog() {
		return catalog;
	}
 
	@Autowired   // setter injection 
	public void setCatalog(Catalog catalog) {
		System.out.println("setCatalog()");
		this.catalog = catalog;
	}

	public static void main(String[] args) {
		SpringApplication.run(TestPropertyInjection.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (var book : catalog.getBooks())
			System.out.println(book);
	 
	}

}
