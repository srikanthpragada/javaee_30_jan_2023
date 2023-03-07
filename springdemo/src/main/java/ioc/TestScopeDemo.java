package ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@SpringBootApplication
public class TestScopeDemo implements CommandLineRunner {
	@Autowired 
	private Catalog catalog;  // Field Injection
	
	@Autowired 
	private Catalog anotherCatalog;  // Field Injection 
	  
	@PostConstruct 
	public void postConstruct() {
		System.out.println("postConstruct()");
		System.out.println("Catalog in postConstruct " + catalog);
		System.out.println("AnotherCatalog in postConstruct " + anotherCatalog);
	}
 
	
	public static void main(String[] args) {
		SpringApplication.run(TestScopeDemo.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (var book : catalog.getBooks())
			System.out.println(book);
	
	}

}
