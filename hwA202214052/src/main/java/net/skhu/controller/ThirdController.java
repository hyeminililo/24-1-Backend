package net.skhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.dto.Student;

@Controller
@RequestMapping("third")
public class ThirdController {
	@GetMapping("test1")
	public String index(Model model) {

		Student student = new Student();
		student.setId(12232);
		student.setEmail("ng041iu93");
		student.setStudentName("남궁혜민");
		student.setStudentNumber("202214052");
		model.addAttribute("student", student);
		return "third/test1";
	}
}