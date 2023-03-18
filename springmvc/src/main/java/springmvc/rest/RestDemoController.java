package springmvc.rest;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springmvc.model.Course;

@RestController
public class RestDemoController {

	@GetMapping("/rest/hello")
	public String sayHello() {
		return "Hello from REST API";
	}

	@GetMapping("/rest/courses")
	public List<Course> getCourses(Model model) {
		var courses = List.of(new Course("Python", 6000, 30), new Course("React", 15, 3000),
				new Course("Spring Boot", 15, 4000));
		return courses;
	}

}
