package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.dto.Engineer;
import net.skhu.dto.Role;
import net.skhu.mapper.EngineerMapper;
import net.skhu.mapper.RoleMapper;

@Controller
@RequestMapping("engineer")
public class EngineerController {
	@Autowired
	EngineerMapper engineerMapper;
	@Autowired
	RoleMapper roleMapper;

	@GetMapping("list")
	public String list(Model model) {
		List<Engineer> engineers = engineerMapper.findAll();
		model.addAttribute("engineers", engineers);
		return "engineer/list";
	}

	@GetMapping("create")
	public String create(Model model) {
		Engineer engineer = new Engineer();
		List<Role> roles = roleMapper.findAll();
		model.addAttribute("engineer", engineer);
		model.addAttribute("roles", roles);
		return "engineer/edit";
	}

	@PostMapping("create")
	public String create(Model model, Engineer engineer) {
		engineerMapper.insert(engineer);
		return "redirect:list";
	}

	@GetMapping("edit")
	public String edit(Model model, int id) {
		Engineer engineer = engineerMapper.findOne(id);
		List<Role> roles = roleMapper.findAll();
		model.addAttribute("engineer", engineer);
		model.addAttribute("roles", roles);
		return "engineer/edit";
	}

	@PostMapping("edit")
	public String edit(Model model, Engineer engineer) {
		engineerMapper.update(engineer);
		return "redirect:list";
	}

	@GetMapping("delete")
	public String delete(Model model, int id) {
		engineerMapper.delete(id);
		return "redirect:list";
	}
}
