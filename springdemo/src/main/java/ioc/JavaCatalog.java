package ioc;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class JavaCatalog implements Catalog {

	@Override
	public List<String> getBooks() {
		 return  List.of("Java Complete Reference", "Spring Boot Handbook");
	}
	

}
