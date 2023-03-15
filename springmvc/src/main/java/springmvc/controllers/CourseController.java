package springmvc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springmvc.model.Course;

@Controller
public class CourseController {

	@GetMapping("/courses")
	public String getCourses(Model model) {
		var courses = List.of(new Course("Python", 6000, 30),
				              new Course("React", 15, 3000),
				              new Course("Spring Boot", 15, 4000));
		model.addAttribute("courses", courses);
		return "courses";

	}

}
