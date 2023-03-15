package springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import springmvc.model.DiscountModel;

@Controller
public class DiscountController {

	@GetMapping("/discount")
	public String discountForm() {
		return "discount";
	}

	@PostMapping("/discount")
	public String discountProcess(Model model, DiscountModel input) {
		// calculate discount
		model.addAttribute("result", input.getDiscount());
		return "discount";
	}
}
