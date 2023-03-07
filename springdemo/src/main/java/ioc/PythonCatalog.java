package ioc;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class PythonCatalog implements Catalog {

	@Override
	public List<String> getBooks() {
		return List.of("Python in Nutshell", "Basics of Python");
	}

	public PythonCatalog() {
		System.out.println("PythonCatalog()");
	}

}