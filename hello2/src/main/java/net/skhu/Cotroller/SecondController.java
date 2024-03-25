package net.skhu.Cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.dto.Product;

@Controller
@RequestMapping("second")
public class SecondController {

	@GetMapping("test1")
	public String test1(Model model) {
		model.addAttribute("message", "안녕하세요");
		return "second/test1";
	}
	
	@GetMapping("test2")
	public String test2(Model model) {
		Product pr = new Product("맥주",2200);
		model.addAttribute("product",pr);
		return "second/test2";
	}
}
