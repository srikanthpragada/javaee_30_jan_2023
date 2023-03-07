package ioc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class TestConstructorInjection implements CommandLineRunner {
	private Catalog catalog;  

	// Constructor based injection
	public TestConstructorInjection(Catalog catalog) {
		System.out.println("TestConstructorInjection()");
		this.catalog = catalog;
	}

	public static void main(String[] args) {
		SpringApplication.run(TestConstructorInjection.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (var book : catalog.getBooks())
			System.out.println(book);

	}

}
