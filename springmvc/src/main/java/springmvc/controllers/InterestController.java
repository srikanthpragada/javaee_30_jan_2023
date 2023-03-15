package springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InterestController {

	@GetMapping("/interest")
	public String interestForm() {
		return "interest";
	}

	@PostMapping("/interest")
	public String interestProcess(Model model, String amount) {
		// calculate interest
		var interest = Integer.parseInt(amount) * 8 / 100;
		model.addAttribute("interest", interest);
		return "interest";
	}
}
