package springmvc.controllers;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@GetMapping("/hello")
	@ResponseBody  // makes return value the response 
	public String sayHello() {
		return "Hello!!!";
	}

	@GetMapping("/wish")
	@ResponseBody
	public String wishUser(String name) {
		return "Hello " + name;
	}
	
	@GetMapping("/greet")
	public String greetUser(Model model, String name) {
		var hours = LocalTime.now().getHour();
		String message = "Good Evening";
		if (hours < 12)
			 message = "Good Morning";
		else
			if(hours < 17)
				message = "Good Afternoon";
		
		model.addAttribute("message", message);	
		model.addAttribute("name", name);
		
		return "greet";    //  src/main/webapp/greet.jsp
	}
	
}
