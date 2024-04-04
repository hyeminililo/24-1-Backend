package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.dto.Department;
import net.skhu.dto.Student;
import net.skhu.mapper.DepartmentMapper;
import net.skhu.mapper.StudentMapper;

@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    StudentMapper studentMapper;

    @Autowired
    DepartmentMapper departmentMapper;

    // 학생 목록 페이지로 이동
    @GetMapping("list")
    public String list(Model model) {
        List<Student> students = studentMapper.findAll();
        model.addAttribute("students", students);
        return "student/list";
    }

    // 학생 생성 페이지로 이동
    @GetMapping("create")
    public String create(Model model) { 
        Student student = new Student(); // 빈 학생 객체 생성
        List<Department> departments = departmentMapper.findAll(); // 모든 학과 정보 가져오기
        model.addAttribute("student", student);
        model.addAttribute("departments", departments);
        return "student/edit"; // 학생 생성/수정 페이지 사용
    }

    // 학생 생성 처리
    @PostMapping("create")
    public String create(Model model, Student student) {
        studentMapper.insert(student);
        return "redirect:list"; // 학생 목록 페이지로 리다이렉트
    }

    // 학생 수정 페이지로 이동
    @GetMapping("edit")
    public String edit(Model model, int id) {
        Student student = studentMapper.findOne(id); // 수정할 학생 정보 가져오기
        List<Department> departments = departmentMapper.findAll(); // 모든 학과 정보 가져오기
        model.addAttribute("student", student);
        model.addAttribute("departments", departments);
        return "student/edit"; // 학생 생성/수정 페이지 사용
    }

    // 학생 수정 처리
    @PostMapping("edit")
    public String edit(Model model, Student student) {
        studentMapper.update(student);
        return "redirect:list"; // 학생 목록 페이지로 리다이렉트
    }

    // 학생 삭제 처리
    @GetMapping("delete")
    public String delete(Model model, int id) {
        studentMapper.delete(id);
        return "redirect:list"; // 학생 목록 페이지로 리다이렉트
    }
}
