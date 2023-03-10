package ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

//@SpringBootApplication
public class Test implements CommandLineRunner {
	@Autowired 
	private Catalog catalog;  // Field Injection 
	  
	public Test() {
		System.out.println("Test()");
		System.out.println("Catalog in constructor " + catalog);
	}

	@PostConstruct 
	public void postConstruct() {
		System.out.println("postConstruct()");
		System.out.println("Catalog in postConstruct " + catalog);
	}
	
	@PreDestroy 
	public void preDestory() {
		System.out.println("preDestory()");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Test.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (var book : catalog.getBooks())
			System.out.println(book);
	
	}

}
