package ioc;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary
@Scope(scopeName = "prototype")
public class JavaCatalog implements Catalog {

	@Override
	public List<String> getBooks() {
		 return  List.of("Java Complete Reference", "Spring Boot Handbook");
	}

	public JavaCatalog() {
		System.out.println("JavaCatalog()");
	}

}
